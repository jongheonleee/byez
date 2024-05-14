package com.neo.byez.service;

import com.neo.byez.dao.UserDaoImpl;
import com.neo.byez.dao.UserInfoHistDaoImpl;
import com.neo.byez.domain.UserDto;
import com.neo.byez.domain.UserInfoHistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {
    // 인증메일에 포함되는 내용들 상수로 관리
    private final String subject = "[EZBY 인증메일 입니다.]";
    private final String title = "<h1>EZBY 메일인증</h1>";
    private final String content = "<br>EZBY를 찾아주셔서 감사합니다!"
            + "<br>인증번호는 다음과 같습니다.<br>";
    private final String senderName = "EZBY";
    private final String senderEmail = "parksuuuun@gmail.com";

    private UserDaoImpl userDao;
    private MailService mailService;
    private BCryptPasswordEncoder passwordEncoder;
    private UserInfoHistDaoImpl userInfoHistDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao, MailService mailService, BCryptPasswordEncoder passwordEncoder,
                           UserInfoHistDaoImpl userInfoHistDao) {
        this.userDao = userDao;
        this.mailService = mailService;
        this.passwordEncoder = passwordEncoder;
        this.userInfoHistDao = userInfoHistDao;
    }

    // 현재 시간을 반환하는 getCurrentTime() 메서드
    @Override
    public Timestamp getCurrentTime() throws Exception {
        return userDao.selectNow();
    }

    // 1. 로그인 - SELECT (=READ; 조회 기능)
    // 1.1. 로그인창에서 아이디, 비밀번호를 입력 받음.
    // 1.1.1. 입력받은 아이디(PK)를 통해 고객 정보를 조회함.
    // 1.1.2. 고객정보를 userDto 에 담아서 반환함.
    // 1.1.3. LoginController 에서 id, pwd 일치여부 확인함.
    @Override
    public UserDto getCustLoginInfo(String id) {
        // 1.1.3.1. 아이디 조회 성공 -> 매개변수로 받은 아이디로 조회한 고객 정보를 userDto 에 저장
        // 1.1.3.2. 예외 발생 시 예외 처리
        try {
            return userDao.selectUser(id);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean checkExistOfId(String id) {
        try {
            if (userDao.selectUser(id) != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 1.2. 로그인 시 최근 로그인 일시 업데이트
    @Override
    public int updateRecentLoginHist(String id) throws Exception {
        return userDao.updateRecentLoginDatetime(id);
    }

    // 1.3. 아이디 찾기
    @Override
    public UserDto findUserId(UserDto userDto) {
        // 1.3.1. 매개변수로 이메일 정보가 저장된 userDto 객체 받음.

        // 1.3.2. 이메일로 아이디 조회 가능한 경우 userDto 에 아이디 저장
        try {
            String id = userDao.selectUserId(userDto).getId();
            userDto.setId(id);
        }
        // 1.3.3. 이메일로 아이디 조회 불가능한 경우 예외 처리
        catch (Exception e) {
            userDto = null;
        }
        // 1.3.2.1. 아이디 조회 성공 -> 특정 고객의 아이디가 저장되어 있는 userDto 반환
        // 1.3.3.1. 아이디 조회 실패 -> userDto = null
        return userDto;
    }

    // 암호화 전후 비밀번호 비교
    @Override
    public boolean checkPwdMatch(String id, String pwd) {

        // id로 조회한 비밀번호 (암호화하여 저장되어 있음)
        String encodedPwd;
        try {
            encodedPwd = userDao.selectUser(id).getPwd();
            // 비밀번호 비교 결과: True/False
            return authenticatePwd(pwd, encodedPwd);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 1.4. 비밀번호 찾기
    // 1.4.1. 새로운 비밀번호로 변경
    // 1.4.2. 비밀번호 변경이력 저장
    @Override
    public boolean modifyUserPwd(String id, String pwd) throws Exception {
        // 비밀번호 변경 코드 : CHG0001
        String chg_code = "CHG0001";
        // 변경 전 비밀번호
        String bef_info = "";

        // 비밀번호 변경 성공여부
        // 비밀번호 변경 성공 시 true 반환
        // 비밀번호 변경 실패 시 false 반환
        boolean pwdUpdateSuccess = false;

        // 가입회원인지 확인 후 비밀번호 변경 시도
        // 가입회원이 아닌 경우 비밀번호 변경 실패
//        if (getCustLoginInfo(id) != null) {
        if (checkExistOfId(id)) {
            bef_info = getCustLoginInfo(id).getPwd();
            try {
                userDao.updateUserPwd(id, pwd);
                pwdUpdateSuccess = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            pwdUpdateSuccess = false;
        }

        // 변경 후 비밀번호
        String af_info = pwd;
        UserInfoHistDto userInfoHistDto = new UserInfoHistDto(id, chg_code, bef_info, af_info, id, id);

        // 변경이력 추가 성공여부
        // 변경이력 추가 성공 시 true 반환
        // 변경이력 추가 실패 시 false 반환
        boolean historyInsertSuccess = false;
        try {
            if (pwdUpdateSuccess) {
                userInfoHistDao.insertUserInfoHist(userInfoHistDto);
                historyInsertSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pwdUpdateSuccess && historyInsertSuccess;
    }

    // 2. 회원가입
    // 2.1. 회원가입 시 추가된 새로운 데이터 전체 추가
    // 2.2. 회원가입 시 본인 인증(by 이메일)
    @Override
    public int saveCustJoinInfo(UserDto userDto) {
        // 2.3. 중복 아이디 체크
        // 2.3.1. 중복된 아이디가 없으면 null 로 들어오니까 1 반환 (DB에 고객 정보 저장)
        // 2.3.2. 중복된 아이디가 있으면 0 반환
        try {
            if (userDao.selectUser(userDto.getId()) == null){
                userDao.insertUser(userDto);
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 3. 이메일 인증
    // 3.1. 매 인증 시 랜덤 문자 및 숫자로 구성된 인증코드 업데이트
    // 3.1.1. 본인인증 시 부여된 인증코드 업데이트
    @Override
    public int saveCustMailKey(UserDto userDto) throws Exception {
        return userDao.updateMailKey(userDto);
    }

    // 4. 회원정보 변경
    // 4.1. 이메일 변경
    // 4.1.1. 이메일 인증 후 이메일 주소 변경
    // 4.1.2. 이메일 변경이력 저장
    @Override
    public boolean modifyUserEmail(String id, String email) {

        // 이메일 변경 코드 : CHG0002
        String chg_code = "CHG0002";
        // 변경 전 이메일 확인
        String bef_info = "";

        // 이메일 변경 성공 여부
        // 이메일 변경 성공 시 true 반환
        // 이메일 변경 실패 시 false 반환
        boolean emailUpdateSuccess = false;

        // 우선 가입회원인지 확인 후 이메일 변경 시도
        // 가입회원이 아닌 경우 이메일 변경 실패
        if (getCustLoginInfo(id) != null) {
            bef_info = getCustLoginInfo(id).getEmail();
            try {
                userDao.updateUserEmail(id, email);
                emailUpdateSuccess = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            emailUpdateSuccess = false;
        }

        // 변경 후 이메일
        String af_info = email;
        UserInfoHistDto userInfoHistDto = new UserInfoHistDto(id, chg_code, bef_info, af_info, id, id);

        // 변경이력 추가 성공 여부
        // 변경이력 추가 성공 시 true 반환
        // 변경이력 추가 실패 시 false 반환
        boolean historyInsertSuccess = false;
        try {
            if (emailUpdateSuccess) {
                userInfoHistDao.insertUserInfoHist(userInfoHistDto);
                historyInsertSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 이메일 변경 성공 및 변경 이력 추가 성공 시 true 반환
        return emailUpdateSuccess && historyInsertSuccess;
    }

    // 5. 회원탈퇴
    // 5.1. 회원탈퇴 시 가입상태(join_state) Y -> N 으로 업데이트
    @Override
    public int changeToWithdrawalState(String id) throws Exception {
        return userDao.updateUserState(id);
    }

    // *** 암호화 전후 비밀번호 비교
    // 암호화 전 비밀번호(rawPwd)와 암호화 후 비밀번호(encodedPwd)
    // 일치 시 true
    // 불일치 시 false
    public boolean authenticatePwd(String rawPwd, String encodedPwd) {
        return passwordEncoder.matches(rawPwd, encodedPwd);
    }
}

