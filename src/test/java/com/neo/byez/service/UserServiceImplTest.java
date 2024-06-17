package com.neo.byez.service;

import com.neo.byez.dao.user.UserDaoImpl;
import com.neo.byez.dao.user.UserInfoHistDaoImpl;
import com.neo.byez.domain.user.TempKey;
import com.neo.byez.domain.user.UserDto;
import com.neo.byez.domain.user.UserInfoHistDto;
import com.neo.byez.service.user.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserServiceImplTest {
    @Autowired DataSource ds;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserDaoImpl userDao;
    @Autowired
    UserInfoHistDaoImpl userInfoHistDao;

    // @Before : 각각의 @Test 전 실행됨.
    @Before
    public void reset() throws Exception {
        cleanDB();

        for (int i = 1; i <= 30; i++) {
            UserDto testDto = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(testDto);
        }
    }

    // @After : 각각의 @Test 후 실행됨.
    @After
    public void cleanDB() throws Exception {
        userInfoHistDao.deleteAllUserInfoHist();
        userDao.deleteAllTestUser();
    }

    public void addData() throws Exception {
        for (int i = 31; i <= 50; i++) {
            UserDto testDto = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(testDto);
        }
    }

    // 1. 초기 테스트
    @Test
    public void userService_주입상태_확인_테스트() {
        assertNotNull(userService);
    }

    // 2. 핵심 기능 테스트

    // getCustLoginInfo() 테스트
    // 가입한 고객 정보 조회 가능 여부 확인
    @Test
    public void 회원정보_조회_테스트() throws Exception {
        // given (when)
        String id = "user1";
        String expectedPwd = "password1";
        String expectedName = "name1";

        // do
        String pwd = userService.getCustLoginInfo(id).getPwd();
        String name = userService.getCustLoginInfo(id).getName();

        // then
        // 회원 정보 조회 가능함을 확인
        assertNotNull(userService.getCustLoginInfo(id));
        // 비밀번호, 이름 일치여부 확인
        assertEquals(expectedPwd, pwd);
        assertEquals(expectedName, name);
    }

    // 가입하지 않은 비회원 고객 정보 조회 불가능 여부 확인
    @Test
    public void 비회원정보_조회_테스트() throws Exception {
        // given
        // 회원인 경우
        String id1 = "user1";
        // 비회원인 경우
        String id2 = "non_member";

        // do
        // 각 아이디로 고객정보 저장된 객체 생성
        UserDto dto1 = userService.getCustLoginInfo(id1);

        // then
        // 조회 가능여부 확인
        assertNotNull(dto1);
        assertNull(userService.getCustLoginInfo(id2));
    }

    // 탈퇴한 고객 정보 조회 불가능 여부 확인
    @Test
    public void 탈퇴회원_조회_테스트() throws Exception {
        // given (when)
        String id = "user1";
        assertNotNull(userService.getCustLoginInfo(id));

        // do
        assertTrue(userService.changeWithdrawalState(id));

        // then
        assertNull(userService.getCustLoginInfo(id));
    }

    // updateRecentLoginDateTime() 테스트
    // 1. 가입된 고객의 최근 로그인 일시 업데이트 가능 여부 확인
    @Test
    public void 최근_로그인_일시_업데이트_테스트() throws Exception {
        // given (when)
        String id = "user1";
        assertNotNull(userService.getCustLoginInfo(id));

        int expectedCnt = 1;

        // do
        int actualCnt = userService.updateRecentLoginHist(id);

        // then
        assertEquals(expectedCnt, actualCnt);
    }

    // 2. 로그인 처리 시 DB에 저장된 로그인 일시와 현 시점의 일시 동일한지 확인
    // => millis 오차범위 설정 필요 (ex. 30sec = 3000ms)
    @Test
    public void 최근_로그인_일시_오차범위_테스트() throws Exception {
        // 기존 @Before 로부터 생성된 30명의 고객 데이터 이외에 20명에 대한 데이터 추가 생성
        addData();

        // 특정 고객의 아이디를 조회하여 존재하는 회원인지 확인
        // 첫번째 로그인인 경우 해당 컬럼 NULL
        String id = "user31";
        userService.getCustLoginInfo(id);
        assertNull(userService.getCustLoginInfo(id).getRecent_login());

        // 최근 로그인 일시 업데이트 성공 시 1 반환
        int expectedCnt = 1;

        // 최근 로그인 일시 업데이트
        int actualCnt = userService.updateRecentLoginHist(id);
        assertEquals(expectedCnt, actualCnt);
        // recent_login 컬럼 내 user31 고객의 로그인 일시 저장 여부 확인
        assertNotNull(userService.getCustLoginInfo(id).getRecent_login());

        // user31 고객의 DB에 저장된 recent_login 컬럼 값
        Timestamp millisOfDB = userService.getCustLoginInfo(id).getRecent_login();
        // 현재 시간
        Timestamp millisOfServer = userService.getCurrentTime();

        // DB에 저장된 시간과 현재 시간을 milliseconds 으로 변환하여 오차 비교
        long difference = millisOfServer.getTime() - millisOfDB.getTime();

        // 오차 범위 30초로 지정하여 결과 확인
        boolean checkDiffOfDateTime;

        if (difference < 30000) { checkDiffOfDateTime = true; }
        else { checkDiffOfDateTime = false; }

        assertTrue(checkDiffOfDateTime);
    }

    // modifyUserPwd() 테스트
    // 1. 가입된 고객의 비밀번호 변경 가능 여부 확인
    @Test
    public void 회원_비밀번호_변경_테스트() throws Exception {
        // given (when)
        String id = "user1";
        String email = "test1@example.com";
        assertNotNull(userService.getCustLoginInfo(id));
        assertEquals(userService.getCustLoginInfo(id).getEmail(), email);

        String pwd = "modifiedPassword@~!";

        // do & then
        assertTrue(userService.modifyUserPwd(id, pwd));

        String actualPwd = userService.getCustLoginInfo(id).getPwd();
        assertEquals(pwd, actualPwd);
    }

    // 2. 미가입 고객의 비밀번호 변경 불가능 여부 확인
    @Test
    public void 비회원_비밀번호_변경_테스트() throws Exception {
        // given (when)
        String id = "non_member";

        // do & then
        // 비회원은 아이디 존재하지 않음에 따라 null 로 예외 처리됨.
        assertNull(userService.getCustLoginInfo(id));
    }

    // 3. 탈퇴 고객의 비밀번호 변경 불가능 여부 확인
    @Test
    public void 회원탈퇴_후_상태변경_테스트() throws Exception {
        // given (when)
        String id = "user1";
        assertNotNull(userService.getCustLoginInfo(id));

        // do
//        int expectedCnt = 1;
//        int actualCnt = userService.changeToWithdrawalState(id);

        // then
//        assertEquals(expectedCnt, actualCnt);
        assertNull(userService.getCustLoginInfo(id));
    }

    // findUserId() 테스트
    // 1. 이름, 이메일로 아이디 조회 가능한 경우
    @Test
    public void 아이디_찾기_성공_테스트() throws Exception {
        // 미리 찾으려는 아이디의 존재여부 확인함.
        String id = "user1";
        assertNotNull(userService.getCustLoginInfo(id));

        // 아이디 찾기 시 필요한 고객 정보 (2가지)
        String name = userService.getCustLoginInfo(id).getName();
        String email = userService.getCustLoginInfo(id).getEmail();
        assertEquals(name, "name1");
        assertEquals(email, "test1@example.com");

        // 이름과 이메일이 저장된 새로운 dto 선언 및 초기화
        UserDto testDto1 = new UserDto();
        testDto1.setName(name);
        testDto1.setEmail(email);

        // 이름과 이메일이 저장된 새로운 dto 를 통해 고객 정보 식별
        UserDto testDto2 = userService.findUserId(testDto1);
        assertNotNull(testDto2);
        assertEquals(id, testDto2.getId());
    }

    // 2. 탈퇴한 고객의 이름 or 이메일 입력 시 예외처리
    @Test
    public void 탈퇴한_고객_아이디_찾기_실패_테스트() throws Exception {
        // given
        // 고객의 아이디, 이름, 이메일을 변수로 선언 및 초기화하고 조회 가능 여부 확인
        String id = "user1";
        assertNotNull(userService.getCustLoginInfo(id));

        String name = "name1";
        String email = "test1@example.com";
        assertEquals(name, userService.getCustLoginInfo(id).getName());
        assertEquals(email, userService.getCustLoginInfo(id).getEmail());

        // do & then
        // 탈퇴처리
        userService.changeWithdrawalState(id);

        // 탈퇴 고객 회원조회 불가함을 확인
        assertNull(userService.getCustLoginInfo(id));

        // 탈퇴 고객 아이디 찾기 불가하여 null 로 예외 처리됨
        UserDto testDto = new UserDto();
        testDto.setName(name);
        testDto.setEmail(email);
        assertNull(userService.findUserId(testDto));
    }

    // 3. 존재하지 않는 이름 or 이메일 입력 시 예외처리
    @Test
    public void 비회원_아이디_찾기_실패_테스트() throws Exception {
        // 임의의 비회원 아이디 생성
        String id = "nonMember";
        // 존재하지 않는 고객임을 확인
        assertNull(userService.getCustLoginInfo(id));

        // 동명이인의 고객 존재하나 이메일이 다른 경우
        String name = "user1";
        String email = "non_member@example.com";

        // 존재하지 않는 고객임에 따라 아이디 찾기 불가하여 NotFoundException 발생함을 확인
        UserDto testDto = new UserDto();
        testDto.setName(name);
        testDto.setEmail(email);
        assertNull(userService.findUserId(testDto));
    }

    // inputCustMailKey() 테스트
    // 1. 인증번호 업데이트 성공
    // 1.1. 올바른 이메일 입력 시 해당 아이디 조회하여 인증번호 저장
    @Test
    public void 가입고객_인증번호_업데이트_성공() throws Exception {
        // 테스트용 임의의 고객 정보가 담길 testDto 객체 생성
        UserDto testDto = new UserDto();

        // 가입상태의 고객임을 확인
        String id = "user1";
        assertNotNull(userService.getCustLoginInfo(id));

        // 해당 고객 이메일 존재함을 확인
        String email = userService.getCustLoginInfo(id).getEmail();
        assertNotNull(email);

        // 고객이 입력한 이메일 일치 여부 확인하고 testDto 객체에 이메일 저장
        String inputEmail = "test1@example.com";
        assertEquals(inputEmail, email);
        testDto.setEmail(inputEmail);

        // 고객이 입력한 이메일로 아이디 조회한 결과 확인
        String foundId = userService.findUserId(testDto).getId();
        assertEquals(id, foundId);
        testDto.setId(foundId);

        // 임의의 6자리 인증번호 생성하고 해당 고객 컬럼에 인증번호 저장
        String mail_key = new TempKey().getKey(6, false);
        testDto.setMail_key(mail_key);

        // 이메일, 아이디, 인증번호가 포함된 객체를 통해 특정 회원 컬럼에 인증번호 업데이트
        userService.saveCustMailKey(testDto);
        // findId 메서드로 찾은 아이디를 가진 고객에게 생성된 인증번호가 제대로 저장되었는지 확인
        assertEquals(userService.getCustLoginInfo(foundId).getMail_key(), mail_key);
    }

    // 2. 인증번호 업데이트 실패
    // 2.1. 잘못된 이메일 입력 시 아이디 조회 실패하여 인증번호 업데이트 절차 진행 불가
    @Test
    public void 잘못된_이메일_입력시_인증번호_업데이트_실패() {
        // 필요한 고객 정보를 담기 위한 testDto
        UserDto testDto = new UserDto();

        String inputEmail = "wrongEmail";
        testDto.setEmail(inputEmail);
        // 잘못된 이메일 입력 시 NotFoundException 예외 던짐을 확인
        assertNull(userService.findUserId(testDto));
    }

    // 2.2. 탈퇴회원 이메일 입력 시 아이디 조회 실패하여 인증번호 업데이트 절차 진행 불가
    @Test
    public void 탈퇴회원_이메일_입력시_인증번호_업데이트_실패() throws Exception {
        // 필요한 고객 정보를 담기 위한 testDto
        UserDto testDto = new UserDto();

        // 가입된 고객이며 이메일 저장되어 있음을 확인
        String id = "user1";
        assertNotNull(userService.getCustLoginInfo(id));
        String email = "test1@example.com";
        assertNotNull(userService.getCustLoginInfo(id).getEmail());
        testDto.setEmail(email);

        // 탈퇴 처리 및 탈퇴회원 조회 가능 여부 확인
        userService.changeWithdrawalState(id);
        assertNull(userService.getCustLoginInfo(id));
        // 탈퇴회원 이메일 입력 시 아이디 조회 실패하여 인증번호 업데이트 절차 진행 불가
        assertNull(userService.findUserId(testDto));
    }

    // saveCustJoinInfo() 테스트
    // 1. 새로운 고객 회원가입 가능 여부 확인
    @Test
    public void 회원가입_성공_테스트() throws Exception {
        // given
        UserDto testDto = new UserDto("newId", "newPwd", "newName", 999999, 2, "F", 12345678, 1012345678, "test@example.com", "newId", "newId");
        // 중복된 아이디 없으면 아이디 조회 안되므로 dto 값 null 반환하도록 예외처리됨.
        assertNull(userService.getCustLoginInfo(testDto.getId()));
        int expectedCnt = 1;

        // do
        int actualCnt = userService.saveCustJoinInfo(testDto);

        // then
        assertEquals(expectedCnt, actualCnt);
        assertNotNull(userService.getCustLoginInfo(testDto.getId()));
    }

    @Test
    public void 중복_아이디_회원가입_실패_테스트() throws Exception {
        // given
        // 중복된 아이디가 저장된 testDto
        UserDto testDto = new UserDto("user1", "newPwd", "newName", 999999, 2, "F", 12345678, 1012345678, "test@example.com", "test1", "test1");
        // 추가하고자 하는 아이디가 존재하는지 확인
        assertNotNull(userService.getCustLoginInfo(testDto.getId()));
        // 고객정보 추가 실패 시 0 반환
        int expectedCnt = 0;

        // do
        int actualCnt = userService.saveCustJoinInfo(testDto);

        // then
        assertEquals(expectedCnt, actualCnt);
    }

    @Test
    public void 회원_이메일_변경이력_저장_성공_테스트() throws Exception {
        userInfoHistDao.deleteAllUserInfoHist();

        // 정보 변경이력 저장하고자 하는 고객 : user1
        String id = "user1";
        // 가입된 고객인지 확인
        assertNotNull(userService.getCustLoginInfo(id));

        // 변경 전 이메일 조회 결과 : bef_info
        String bef_info = userService.getCustLoginInfo(id).getEmail();
        // 변경 후 이메일: modified@example.com
        String af_info = "modified@example.com";
        // 이메일 변경에 대한 코드: CHG0002
        String chg_code = "CHG0002";

        // 변경이력 유무 확인
        List<UserInfoHistDto> testList1 = userInfoHistDao.selectUserInfoHist(id);
        assertEquals(0, testList1.size());

        // ID 및 변경하려는 Email을 매개변수로 넣었을 때 제대로 이메일 변경 및 변경이력 저장되었는지 확인
        // 성공 시 true 반환
        boolean emailUpdateSuccess = userService.modifyUserEmail(id, af_info);
        assertTrue(emailUpdateSuccess);

        // 변경이력 추가여부 확인
        List<UserInfoHistDto> testList2 = userInfoHistDao.selectUserInfoHist(id);
        assertEquals(1, testList2.size());

        // 변경 후 이메일 주소가 현재 DB에 저장된 이메일 주소와 동일한지 확인
        String dbEmail = userService.getCustLoginInfo(id).getEmail();
        assertEquals(af_info, dbEmail);
    }

    @Test
    public void 비회원_이메일_변경_실패_테스트() throws Exception {
        // 존재하지 않는 고객임을 확인
        String id = "nonMember";
        assertNull(userService.getCustLoginInfo(id));

        // 변경하려는 이메일 주소
        String modifiedEmail = "modified@example.com";

        // 비회원인 경우, 이메일 변경 시도 시 false 반환
        assertFalse(userService.modifyUserPwd(id, modifiedEmail));
    }

    @Test
    public void 탈퇴회원_이메일_변경_실패_테스트() throws Exception {
        // 기존 가입 고객임을 확인
        String id = "user1";
        assertNotNull(userService.getCustLoginInfo(id));

        // 해당 고객 회원탈퇴 처리
        // 탈퇴 처리 성공 시 1 반환
//        int expectedCnt = 1;
//        int actualCnt = userService.changeToWithdrawalState(id);
//        assertEquals(expectedCnt, actualCnt);

        // 변경할 이메일
        String email = "modified@example.com";

        // 탈퇴회원 이메일 변경 시도 실패 시 false 반환
        assertFalse(userService.modifyUserEmail(id, email));
    }

}
