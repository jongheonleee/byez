package com.neo.byez.service.user;

import com.neo.byez.domain.user.UserDto;

import java.sql.Timestamp;

public interface UserService {

    // 현재 시간을 반환하는 getCurrentTime() 메서드
    Timestamp getCurrentTime() throws Exception;

    // 1. 로그인 - SELECT (=READ; 조회 기능)
    // 1.1. 로그인 시 필요한 아이디, 비밀번호, 이름, 탈퇴여부에 대한 컬럼만 조회
    // 1.2. 로그인 시 최근 로그인 일시 업데이트
    // 1.3. 아이디 찾기 시 특정 고객의 아이디 반환
    // 1.4. 비밀번호 찾기 시 새로운 비밀번호로 변경
    UserDto getCustLoginInfo(String id) throws Exception;

    // 로그인 시 입력 받은 ID, PWD 활용하여
    // DB에 ID 존재하는지 확인
    // ID, PWD 일치여부 확인
    boolean checkExistOfId(String id);
    boolean checkPwdMatch(String id, String pwd);

    int updateRecentLoginHist(String id) throws Exception;
    UserDto findUserId(UserDto userDto) throws Exception;
    boolean modifyUserPwd(String id, String pwd) throws Exception;
//    int modifyUserPwd(String id, String email, String pwd) throws Exception;

    // SNS 계정(카카오) 연동 성공 시 닉네임 저장
    // 세션에 저장된 아이디로 카카오 계정 연동 여부 조회 시
    // 연동 안되어 있으면 카카오 닉네임 저장 및 연동여부 Y로 업데이트 함
    // 연동 되어 있으면 카카오 닉네임 및 연동여부 업데이트 안함
    boolean saveKakaoNickname(String id, String nickname);

    // SNS 계정(네이버) 연동 성공 시 닉네임 저장
    // 세션에 저장된 아이디로 네이버 계정 연동 여부 조회 시
    // 연동 안되어 있으면 네이버 닉네임 저장 및 연동여부 Y로 업데이트 함
    // 연동 되어 있으면 네이버 닉네임 및 연동여부 업데이트 안함
    boolean saveNaverNickname(String id, String nickname);

    // Kakao 간편 로그인
    String getCustIdBySnsNickname(String nickname);

    // 2. 회원가입
    // 2.1. 회원가입 시 추가된 새로운 데이터 전체 추가
    // 2.2. 회원가입 시 본인 인증(by 이메일)
    int saveCustJoinInfo(UserDto userDto) throws Exception;


    // 3. 이메일 인증
    // 3.1. 매 인증 시 랜덤 문자 및 숫자로 구성된 인증코드 업데이트
    // 3.1.1. 본인인증 시 부여된 인증코드 업데이트
    // 3.1.2. 본인인증(by 메일) 여부 업데이트
    int saveCustMailKey(UserDto userDto) throws Exception;
//    int changeCustMailAuthState(UserDto userDto) throws Exception;

    // 4. 회원정보 변경
    // 4.1. 이메일 변경
    // 4.1.1. 이메일 인증 후 이메일 주소 변경
    boolean modifyUserEmail(String id, String email);

//    // 4.2. 생년월일 변경
//    // 4.2.1. 생년월일 변경이력 저장
//    boolean modifyUserBefBirth(String id, Integer bef_birth);

    // 4.3. 휴대폰 번호 변경
    // 4.2.1. 휴대폰 번호 변경이력 저장
    boolean modifyUserMobileNum(String id, Integer mobile_num);

    // 전체 가입고객(탈퇴회원 포함)의 아이디 조회하여 아이디 중복여부 확인
    UserDto checkDuplicatedId(String id);

    // 4. 회원탈퇴
    // 4.1. 회원탈퇴 시 가입상태(join_state) Y -> N 으로 업데이트
    boolean changeWithdrawalState(String id) throws Exception;
}