package com.neo.byez.dao;

import com.neo.byez.domain.UserDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

// 이거 Junit5 로 어떻게 전환하는지 다시 확인해봐야 할 듯, 없애니까 테스트가 안돌아감.
@RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class UserDaoImplTest{
    @Autowired UserDaoImpl userDao;

    // @Before : 각각의 @Test 전 실행됨.
    // 각 테스트 실행 전 DB table 에 30개의 더미데이터 insert
    @Before
    public void reset() throws Exception {
        for (int i = 1; i <= 30; i++) {
            UserDto testDto = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(testDto);
        }
    }

//    @Test
    public void addData() throws Exception {
        for (int i = 1; i <= 50; i++) {
            UserDto testDto = new UserDto("user" + i, "password" + i + "!@#", "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(testDto);
        }
    }

    // @After : 각각의 @Test 후 실행됨.
    // 각 테스트 실행 후 DB table 내 데이터 delete
    @After
    public void cleanDB() throws Exception {
        userDao.deleteAllTestUser();
    }

    // 1. 초기 테스트
    // 1.1. 테스트하는 클래스의 주입 상태 확인

    // 2. 보조 기능 테스트
    // 2.1. 테스트용으로 사용할 메서드(insert, delete, deleteAll) 기능 확인

    // 3. 핵심 기능 테스트

    // 3.1. 고객수 조회
    // 3.1.1. 회원가입한 고객 수
    // 3.1.2. 탈퇴회원 제외한 현재 가입 상태의 고객 수

    // 3.2. 아이디, 비밀번호 조회
    // 3.2.1. 가입한 회원 ID, PWD 조회
    // 3.2.2. 탈퇴회원 ID, PWD 조회

    // 3.3. 비밀번호 변경
    // 3.3.1. 가입한 회원 PWD 변경 성공
    // 3.3.2. 탈퇴회원 PWD 변경 실패
    // 3.3.3. 비회원 PWD 변경 실패

    // 3.4. 이메일 변경
    // 3.4.1. 가입한 회원 이메일 변경 성공
    // 3.4.2. 탈퇴회원 이메일 변경 실패
    // 3.4.3. 비회원 이메일 변경 실패

    // UserDaoImpl 주입 상태 확인
    @Test
    public void userDao_주입상태_확인_테스트() throws Exception {
        assertNotNull(userDao);
    }

    // 테스트용 INSERT 문 기능 확인
    // 1. 고객 관련 데이터가 각 컬럼으로 추가되는지 확인
    // 2. PK인 ID 중복 추가 불가능한지 확인
    // 3. NOT NULL 에 해당하는 컬럼에 null 추가 불가능한지 확인

    @Test
    // 고객 관련 데이터가 각 컬럼으로 추가되는지 확인
    public void 고객정보_추가_테스트_메서드_기능_확인() throws Exception {
        // given
        int expectedCnt = 1; // insert 성공 시 1개의 row 생성되므로 insertUser() 실행 시 예상 결과 = 1
        int actualCnt;       // insert 성공 여부에 대한 실제 결과
        int preTotalCnt = userDao.countUser(); // insert 전(pre) - 전체 row 갯수
        int postTotalCnt;    // insert 후(post) - 전체 row 갯수

        // do
        // 30개의 더미데이터 insert
        for (int i = 1; i <= 30; i++) {
            UserDto testDto = new UserDto("userID" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test@example.com", "user" + i, "user" + i);
            actualCnt = userDao.insertUser(testDto);

            // then
            assertEquals(expectedCnt, actualCnt);
        }

        postTotalCnt = userDao.countUser();
        // insert 전후 row 갯수 비교
        // 30개 추가했으므로 insert 전보다 30개 더 많음
        assertEquals(preTotalCnt + 30, postTotalCnt);
    }

    // 테스트용 DELETE 문 기능 확인
    // 1. 특정 아이디를 보유한 고객 정보를 삭제 가능한지 확인
    // 2. 전체 고객 정보를 한꺼번에 삭제 가능한지 확인

    @Test
    // 특정 아이디를 보유한 고객 정보를 삭제 가능한지 확인
    public void 고객정보_삭제_테스트_메서드_기능_확인() throws Exception {
        // given
        String id = userDao.selectUser("user1").getId();
        int expectedCnt = 1;

        // 삭제 전 전체 row 수
        int preTotalCnt = userDao.countUser();
        // 더미데이터로 30개 insert 해두었기 때문에 삭제 전 전체 row 수는 30으로 예상
        assertTrue(preTotalCnt == 30);

        // do : 고객 테이블에 존재하는 아이디로 식별한 경우 1 반환
        for(int i = 0; i < 10; i++) {
            int actualCnt = userDao.deleteTestUser(id + i);

            // then : 결과값 = 1
            // 특정 아이디로 식별한 고객의 정보 삭제됨을 확인함.
            assertEquals(expectedCnt, actualCnt);
        }

        // 삭제 후 전체 row 수
        // 10개 삭제 후 row 수 10 감소
        int postTotalCnt = userDao.countUser();
        assertEquals(preTotalCnt-10, postTotalCnt);
    }

    @Test
    // 전체 고객 정보를 한꺼번에 삭제 가능한지 확인
    public void 전체고객_삭제_테스트_메서드_기능_확인() throws Exception {
        // given

        // @Before 통해 더미데이터로 30개 insert 해두었기 때문에
        // 현재 고객 테이블에 존재하는 전체 row 수 = 30

        // 1. 전체 row 삭제 시 결과값 30으로 반환 예상됨.
        int preTotalCnt = 30;
        // 2. 전체 row 삭제 시 row 갯수 카운트 결과 0으로 예상됨.
        int postTotalCnt = 0;

        // 전체삭제 실행 성공 시 전체 30개의 row 모두 삭제했으므로 30 반환 예상
        int expectedCnt = 30;

        // do
        // 실제 전체 row 삭제 성공 시 1 반환하는지 확인
        int actualCnt = userDao.deleteAllTestUser();
        assertEquals(expectedCnt, actualCnt);

        // then : 결과값
        // 고객 테이블 내 전체 row 삭제되어 postTotalCnt 는 0 반환 (preTotalCnt 는 삭제 전이므로 30 반환)
        postTotalCnt = userDao.countUser();
        assertEquals(preTotalCnt-30, postTotalCnt);
    }

    @Test
    // 삭제하려는 고객 정보가 테이블 내 존재하지 않는 경우
    public void 삭제할_고객_정보_없는_경우_테스트() throws Exception {
        // given
        int expectedCnt = 0;
        int actualCnt;

        // delete 실행 전 전체 고객 수
        int preTotalCnt = userDao.countUser();

        // 회원가입되지 않은 고객 아이디로 고객 정보 조회 시 null 반환됨.
        String id = "non_member";
        UserDto testDto = userDao.selectUser(id);
        assertNull(testDto);

        // delete 실행 후 반환되는 결과값
        actualCnt = userDao.deleteTestUser(id);
        assertEquals(expectedCnt, actualCnt);
        // delete 실행 후 전체 고객 수
        int postTotalCnt = userDao.countUser();
        assertEquals(preTotalCnt, postTotalCnt);
    }

    @Test
    // 회원가입한 총 고객의 수 계산 결과 확인
    public void 회원가입한_총_고객_수_테스트() throws Exception {
        // given

        // insert 실행 전 전체 고객 수 조회 결과
        int preTotalCnt = userDao.countUser();

        // insert 실행 성공 시 1 반환 예정
        int expectedCnt = 1;
        int actualCnt;

        // do & then

        // @Before 붙은 메서드를 통해 추가한 30개의 row 에 20개의 새로운 row 추가
        for(int i = 31; i <= 50; i++) {
            UserDto testDto = new UserDto("userId" + i, "password" + i, "name" + i, 999999, 1, "M", 10123456, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            // insert 성공 시 1 반환할 것으로 예상한 결과와 실제 실행 결과 비교
            actualCnt = userDao.insertUser(testDto);
            assertEquals(expectedCnt, actualCnt);
        }

        // insert 실행 후 전체 고객 수 조회 결과
        int postTotalCnt = userDao.countUser();
        // 20개의 row 추가 전/후 결과 비교
        assertEquals(preTotalCnt+20, postTotalCnt);
    }

    @Test
    // 가입상태가 Y 인 고객(탈퇴고객 제외)의 수 계산 결과 확인
    public void 가입상태의_고객_수_테스트() throws Exception {
        // given
        // 탈퇴처리 전
        // @Before 통해 30개의 더미데이터 보관 중인 상태

        // updateUserState 실행 성공 시 1 반환 예정
        int expectedCnt = 1;
        // 탈퇴 처리 전 전체 row 수 (초기값)
        int preTotalCnt = userDao.countUser();
        // 탈퇴 처리 전 가입상태의 고객 수
        int preActiveCnt = userDao.countActiveUser();

        // do
        // updateUserState 실행 결과
        int actualCnt;
        for(int i = 1; i <= 5; i++) {
            actualCnt = userDao.updateUserState("user"+i);
            assertEquals(expectedCnt, actualCnt);
        }

        // then
        // 5명의 고객 탈퇴 처리 후 가입상태의 고객 수
        int postActiveCnt = userDao.countActiveUser();
        assertEquals(preActiveCnt-5, postActiveCnt);

        // 탈퇴처리 후 전체 row 수
        int postTotalCnt = userDao.countUser();

        // then
        // 전체 row 수는 변화 없으나, 가입상태 회원의 수는 탈퇴처리된 수만큼 감소
        assertEquals(preTotalCnt, postTotalCnt);
        assertEquals(postTotalCnt-5, postActiveCnt);
    }

    @Test
    // 가입상태인 고객을 전부 조회하고, 각 컬럼 값을 조회할 수 있는지 확인
    public void 가입상태의_전체_고객_조회_테스트() throws Exception {
        // given
        // 가입상태 여부
        List<String> preStateList = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            String preState = userDao.selectUser("user"+i).getJoin_state();
            preStateList.add(preState);
        }
        // 탈퇴 처리 전 가입상태의 고객 수 확인
        int preTotalActiveCnt = userDao.countActiveUser();

        // do
        // 5명의 고객 탈퇴 처리
        for(int i = 1; i <= 5; i++) {
            userDao.updateUserState("user"+i);
        }

        // 탈퇴처리 시도한 고객 수
        int withdrawalCnt = preStateList.size();

        // then
        // 탈퇴 처리 후 가입상태의 고객 수 확인
        int postTotalActiveCnt = userDao.countActiveUser();

        assertEquals(preTotalActiveCnt-withdrawalCnt, postTotalActiveCnt);
    }

    // selectUser()
    // 1. 특정 고객 아이디로 조회 시 해당 고객의 정보들 조회 가능
    // 2. 가입하지 않은 아이디로 조회 시 조회 불가능
    // 3. 비회원(탈퇴회원) 아이디로 조회 시 조회 불가능
    @Test
    // 특정 고객 아이디로 조회 시 해당 고객의 정보들 조회 가능
    public void 회원_아이디_조회_테스트() throws Exception {
        // given (when)
        // 임의의 고객 정보 생성 및 추가
        UserDto testDto = new UserDto("newId", "newPwd", "newName", 900101, 2, "F", 1234567891, 1234567890 , "newTest@example.com", "newId", "newId");
        userDao.insertUser(testDto);

        // id 통해서 DB에 제대로 추가되었는지 확인
        String id = testDto.getId();
        assertNotNull(userDao.selectUser(id));

        String expectedPwd = testDto.getPwd();
        String expectedName = testDto.getName();

        // do
        // 특정 고객의 아이디로 비밀번호 및 이름 조회
        String actualPwd = userDao.selectUser(id).getPwd();
        String actualName = userDao.selectUser(id).getName();

        // then
        assertEquals(expectedPwd, actualPwd);
        assertEquals(expectedName, actualName);
    }

    @Test
    // 가입하지 않은 아이디로 조회 시 조회 불가능
    public void 비회원_아이디_조회_테스트() throws Exception {
        // 임의의 비회원 아이디: nonMemeber 생성
        String id = "nonMember";

        // 해당 비회원 조회 시 조회 불가함을 확인
        UserDto testDto = userDao.selectUser(id);
        assertNull(testDto);
    }

    @Test
    // 비회원(탈퇴회원) 아이디로 조회 시 조회 불가능
    public void 탈퇴회원_아이디_조회_테스트() throws Exception {
        // 1. 임의의 고객 아이디: user1
        String id = "user1";

        // 2. 고객 현 가입상태 Y 임을 확인
        UserDto testDto1 = userDao.selectUser(id);
        assertNotNull(testDto1);

        // 3. 해당 고객 탈퇴시키기 전 전체 가입상태 고객 수 확인
        int preWithdrawalCnt = userDao.countActiveUser();

        // 4. 동일 고객 탈퇴 처리 후 해당 고객 조회 불가한지 확인
        userDao.updateUserState(id);
        UserDto testDto2 = userDao.selectUser(id);
        assertNull(testDto2);

        // 5. 고객 탈퇴시킨 후 전체 가입상태 고객 수 감소여부 확인
        int postWithdrawalCnt = userDao.countActiveUser();
        assertEquals(preWithdrawalCnt-1, postWithdrawalCnt);
    }

    // updateRecentLoginDatetime()
    // 최근 로그인 일자 업데이트 가능 여부
    @Test
    public void 최근_로그인_기록_업데이트_테스트() throws Exception {
        // given
        // 임의의 고객 id: user1 생성
        String id = "user1";

        // id로 존재하는 고객인지 조회 결과 확인
        UserDto testDto = userDao.selectUser(id);
        assertNotNull(testDto);

        // 최근 로그인 기록 업데이트 성공 시 1 반환
        int expectedCnt = 1;

        // do
        // 최근 로그인 일시 업데이트 성공 시 1 반환 확인
        int actualCnt = userDao.updateRecentLoginDatetime(id);
        assertEquals(expectedCnt, actualCnt);

        // DB에 저장된 시간
        Timestamp millisOfDB = userDao.selectUser(id).getRecent_login();
        // 현재 시간
        Timestamp millisOfServer = userDao.selectNow();

        // DB 에 저장된 시간과 현재 시간을 비교
        // 시간을 millisecond 으로 변환하여 계산
        long difference = (millisOfServer.getTime() - millisOfDB.getTime());

        // 오차 허용 범위 30초 미만으로 설정하여 확인
        boolean checkDiffOfDateTime;

        // 오차 허용 범위 IN : true
        // 오차 허용 범위 OUT : false
        if (difference < 30000) { checkDiffOfDateTime = true; }
        else { checkDiffOfDateTime = false; }

        assertTrue(checkDiffOfDateTime);
    }

    @Test
    public void 비회원_로그인_기록_업데이트_테스트() throws Exception {
        // given
        // 로그인 기록 업데이트 실패 시 0 반환
        int expectedCnt = 0;

        // 가입하지 않은 비회원
        String id1 = "non_member";
        assertNull(userDao.selectUser(id1));

        // 회원 탈퇴
        String id2 = "user2";
        assertNotNull(userDao.selectUser(id2));
        userDao.updateUserState(id2);
        // 탈퇴 처리 성공여부 확인
        assertNull(userDao.selectUser(id2));

        // do
        int actualCnt1 = userDao.updateRecentLoginDatetime(id1);
        int actualCnt2 = userDao.updateRecentLoginDatetime(id2);

        // then
        assertEquals(expectedCnt, actualCnt1);
        assertEquals(expectedCnt, actualCnt2);
    }

    // updateUserPwd()
    // 1. 회원 비밀번호 변경 가능
    // 2. 비회원(가입이력 없는) 비밀번호 변경 불가능
    // 3. 탈퇴 회원 비밀번호 변경 불가능
    @Test
    public void 회원_PWD_변경_테스트() throws Exception {
        // given (when)
        String id = "user1";
        String email = "test1@example.com";
        assertNotNull(userDao.selectUser(id));
        assertEquals(userDao.selectUser(id).getEmail(), email);

        String beforePwd = userDao.selectUser(id).getPwd();
        String afterPwd = "modifiedPassword1";

        // 비밀번호 변경 처리 성공 시 1 반환
        int expectedCnt = 1;

        // do
        int actualCnt = userDao.updateUserPwd(id, afterPwd);
        // 변경된 비밀번호 반환
        String modifiedPwd = userDao.selectUser(id).getPwd();

        // then
        assertEquals(expectedCnt, actualCnt);
        assertTrue(!beforePwd.equals(modifiedPwd));
        assertEquals(afterPwd, modifiedPwd);
    }

    @Test
    public void 비회원_PWD_변경_불가_테스트() throws Exception {
        // given (when)
        // 회원이 아님을 확인
        String id = "non_member";
        String email = "nonMemeber@example.com";
        assertNull(userDao.selectUser(id));

        // 변경하려는 비밀번호 선언 및 초기화
        String pwd = "modifiedPassword";
        // 변경 실패 시 0 반환
        int expectedCnt = 0;

        // do
        int actualCnt = userDao.updateUserPwd(id, pwd);

        // then
        assertEquals(expectedCnt, actualCnt);
    }

    @Test
    public void 탈퇴회원_PWD_변경불가_테스트() throws Exception {
        // given (when)
        // 기존에 가입 상태였던 고객임을 확인
        String id = "user1";
        String email = "test1@example.com";
        assertNotNull(userDao.selectUser(id));
        assertEquals(userDao.selectUser(id).getEmail(), email);

        // 변경하려는 비밀번호 선언 및 초기화
        String pwd = "modifiedPassword1";

        // 비밀번호 변경 실패 시 0 반환
        int expectedCnt = 0;

        // 회원 탈퇴
        // 고객 정보 조회 안됨을 확인
        userDao.updateUserState(id);
        assertNull(userDao.selectUser(id));

        // do & then
        // 비밀번호 변경 시도 및 실패여부 확인
        int actualCnt = userDao.updateUserPwd(id, pwd);
        assertEquals(expectedCnt, actualCnt);
    }

    // 비밀번호 입력 시 발생 가능한 error 확인
    // 1. 특수문자 사용 가능 -> cf. 비밀번호 암호화 시 특정 특수문자만 암호화 처리 가능하여 회원가입 구현 시 재확인 필요
    // 2. 한글 사용 가능
    // 3. 영문 대문자 사용 가능
    @Test
    public void PWD_특수문자_사용가능_여부_테스트() throws Exception {
        // given (when)
        // 가입된 고객임을 확인
        String id = "user1";
        String email = "test1@example.com";
        assertNotNull(userDao.selectUser(id));
        assertEquals(userDao.selectUser(id).getEmail(), email);

        // 변경하려는 특수문자 조합 비밀번호 선언 및 초기화
        String pwd = "modifiedpassword!~@";

        // 특수문자 조합 비밀번호 변경 성공 시 1 반환
        int expectedCnt = 1;

        // do
        int actualCnt = userDao.updateUserPwd(id, pwd);
        String modifiedPwd = userDao.selectUser(id).getPwd();

        // then
        assertEquals(expectedCnt, actualCnt);
        assertEquals(pwd, modifiedPwd);
    }

    @Test
    public void PWD_한글_사용가능_여부_테스트() throws Exception {
        // given (when)
        // 가입된 고객임을 확인
        String id = "user1";
        String email = "test1@example.com";
        assertNotNull(userDao.selectUser(id));
        assertEquals(userDao.selectUser(id).getEmail(), email);

        // 변경하려는 한글 조합 비밀번호 선언 및 초기화
        String pwd = "변경된비밀번호";

        // 비밀번호 변경 성공 시 1 반환
        int expectedCnt = 1;

        // do
        int actualCnt = userDao.updateUserPwd(id, pwd);
        String modifiedPwd = userDao.selectUser(id).getPwd();

        // then
        assertEquals(expectedCnt, actualCnt);
        assertEquals(pwd, modifiedPwd);
    }

    @Test
    public void PWD_영문_대문자_사용가능_여부_테스트() throws Exception {
        // given (when)
        // 가입된 고객임을 확인
        String id = "user1";
        String email = "test1@example.com";
        assertNotNull(userDao.selectUser(id));
        assertEquals(userDao.selectUser(id).getEmail(), email);

        // 변경하려는 영문 대문자 조합 비밀번호 선언 및 초기화
        String pwd = "ModifiedPWD1";

        // 비밀번호 변경 성공 시 1 반환
        int expectedCnt = 1;

        // do
        int actualCnt = userDao.updateUserPwd(id, pwd);
        String modifiedPwd = userDao.selectUser(id).getPwd();

        // then
        assertEquals(expectedCnt, actualCnt);
        assertEquals(pwd, modifiedPwd);
    }

    @Test
    public void 회원_탈퇴여부_확인_테스트() throws Exception {
        // given (when)
        // 기존에 가입된 회원임을 확인
        String id = "user1";
        assertNotNull(userDao.selectUser(id));

        // 탈퇴 처리 성공 시 1 반환
        int expectedCnt = 1;

        // do & then
        // 탈퇴 처리
        int actualCnt = userDao.updateUserState(id);
        // 탈퇴 후 회원 조회 안됨
        assertNull(userDao.selectUser(id));
        assertEquals(expectedCnt, actualCnt);
    }

    // 이메일 인증
    // 1. 회원 이메일 인증 가능함을 확인
    // 2. 비회원 이메일 인증 불가능함을 확인
    @Test
    public void 이름과_이메일로_아이디_조회_테스트() throws Exception {
        UserDto testDto = new UserDto();
        testDto.setName("name1");
        testDto.setEmail("test1@example.com");

        String expectedId = "user1";

        // 회원 조회 가능
        UserDto testDto2 = userDao.selectUserId(testDto);
        assertNotNull(testDto2);

        String actualId = testDto2.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    public void 잘못된_이름_및_이메일_회원_인증_불가_테스트() throws Exception {
        // given
        UserDto testDto = new UserDto();
        testDto.setName("non-member");
        testDto.setEmail("wrong@example.com");
        testDto.setMail_key("validationCode");

        int expectedCnt = 0;

        // 비회원임을 확인
        UserDto testDto2 = userDao.selectUser(testDto.getId());
        assertNull(testDto2);

        // do
        int actualCnt = userDao.updateMailKey(testDto);

        // then
        assertEquals(expectedCnt, actualCnt);
    }

    @Test
    public void 고객_정보_추가_성공_테스트() throws Exception {
        // given
        // testDto 선언 및 새로운 고객 정보로 초기화
        // insert 성공하면 1 반환 예정
        UserDto testDto= new UserDto("newId", "newPwd", "newName", 999999, 1, "F", 12345678, 1012345678, "test@example.com", "newId", "newId");
        int expectedCnt = 1;

        // do
        // 새로운 고객 정보를 DB에 추가 시도
        int actualCnt = userDao.insertUser(testDto);

        // then
        assertEquals(expectedCnt, actualCnt);
    }

    @Test
    public void 회원가입_후_고객_수_증가_성공_테스트() throws Exception {
        // given
        // 현재까지 회원가입자 수
        int preUserNum = userDao.countUser();
        // 현재까지 가입상태의 고객 수
        int preActiveUserNum = userDao.countActiveUser();
        int expectedCnt = 1;

        // do
        // 1명 추가 회원가입 시 총 가입자 수(=전체 row 수) 및 가입자 수 1 증가
        UserDto testDto= new UserDto("newId", "newPwd", "newName", 999999, 1, "F", 12345678, 1012345678, "test@example.com", "newId", "newId");
        int actualCnt = userDao.insertUser(testDto);
        int postUserNum = userDao.countUser();
        int postActiveUserNum = userDao.countActiveUser();

        // then
        assertEquals(preUserNum+1, postUserNum);
        assertEquals(preActiveUserNum+1, postActiveUserNum);
        assertEquals(expectedCnt, actualCnt);
    }

    @Test
    // NOT NULL 에 해당하는 컬럼에 NULL 추가 불가능함을 확인
    public void NOT_NULL_제약조건_위반_테스트() throws Exception {
        // given
        // 고객 데이터 추가 시, 필수 입력(NOT NULL) 항목 누락하여 insert 한 경우
        String nullPwd = null;
        String nullName = null;
        String nullReg_id = null;
        String nullUp_id = null;

        UserDto testDto = new UserDto("testId", nullPwd, nullName, 999999, 9999999, "M", 12345678, 1012345678, "testEmail@naver.com", nullReg_id, nullUp_id);

        // 초기 전체 row 수 확인
        int preTotalRowCnt = userDao.countUser();

        // do & then
        // 제약조건(NOT NULL) 위반에 대한 예외 던짐
        DataIntegrityViolationException e = Assertions.assertThrows(DataIntegrityViolationException.class, () -> userDao.insertUser(testDto));

        // NOT NULL 에 해당하는 컬럼에 NULL 추가 불가능
        // insert 실행 후 예상되는 전체 row 수는 실행전과 동일할 것으로 예상
        int postTotalRowCnt = userDao.countUser();

        // NOT NULL 에 해당하는 컬럼에 NULL 값 insert 전/후 동일한 결과 나옴을 확인
        assertEquals(preTotalRowCnt, postTotalRowCnt);
    }

    // PK인 ID 중복 추가 불가능한지 확인
    @Test
    public void 중복_아이디_추가_불가능_테스트() throws Exception {
        // given
        String id1 = "duplicatedId";
        UserDto testDto1 = new UserDto(id1, "password1", "name1", 999999, 1, "F", 12345678, 1012345678, "test@example.com", id1, id1);

        // insert 성공 시 1 반환될 것으로 예상
        int expectedSuccessCnt = 1;
        int actualSuccessCnt;

        // 중복된 id 추가 전/후 전체 row 수
        int preTotalCnt = userDao.countUser();
        int postTotalCnt1; // insert 성공 후
        int postTotalCnt2; // insert 실패 후

        // 중복되지 않는 id를 사용하는 새로운 고객에 대한 정보 추가 : insertUser
        actualSuccessCnt = userDao.insertUser(testDto1);
        assertEquals(expectedSuccessCnt, actualSuccessCnt);

        // insert 성공 전/후 전체 row 수 비교
        postTotalCnt1 = userDao.countUser();
        assertEquals(preTotalCnt+1, postTotalCnt1); // 성공하면 row 1개 추가됨.

        // 중복된 ID 값을 가진 새로운 User 객체 생성
        String id2 = "duplicatedId";
        UserDto testDto2 = new UserDto(id2, "password2", "name2", 999999, 1, "M", 12345678, 1012345678, "test@example.com", "user2", "user2");

        // do & then

        // 중복된 id 값을 가진 고객에 대한 정보 추가
        // 1. 추가하려는 아이디가 존재하는지 미리 조회함. -> 존재하면 Not Null
        assertNotNull(userDao.selectUser(id2));

        // 2. 동일한 id 값을 가진 고객 정보 추가하려고 하나, 중복 PK 임에 따라 추가될 수 없어 예외 발생함.
        // 동일한 id 값을 가진 고객에 대한 정보 추가 시, 중복 PK 값 추가이기 때문에 insert 문 실행 불가하여 DuplicateKeyException 예외 던짐.
        Assertions.assertThrows(DuplicateKeyException.class, () -> userDao.insertUser(testDto2));

        // 중복된 id 값 추가 시도 이후의 전체 row 수
        postTotalCnt2 = userDao.countUser();

        // 중복된 id 값을 가진 경우, row 추가 불가능
        // insert 성공했을 때의 전체 row 수와 insert 실패했을 때 전체 row 수가 동일
        assertEquals(postTotalCnt1, postTotalCnt2);
    }


    // 3.4. 이메일 변경
    // 3.4.1. 가입한 회원 이메일 변경 성공
    @Test
    public void 가입회원_이메일_변경_성공() throws Exception {
        // 가입 회원 아이디
        String id = "user1";
        // 변경하려는 이메일 주소
        String email = "modified1@example.com";

        // 이메일 변경 성공 시 1 반환
        int expectedCnt = 1;
        int actualCnt = userDao.updateUserEmail(id, email);
        assertEquals(expectedCnt, actualCnt);

        // DB에 저장된 변경된 이메일이 변경하려던 이메일 주소와 동일한지 확인
        String modifiedEmail = userDao.selectUser(id).getEmail();
        assertEquals(email, modifiedEmail);
    }

    // 3.4.2. 탈퇴회원 이메일 변경 실패
    @Test
    public void 탈퇴회원_이메일_변경_실패_테스트() throws Exception {
        // 가입회원 탈퇴 처리
        // 탈퇴처리 성공 시 1 반환
        String id = "user1";
        String email = userDao.selectUser(id).getEmail();
        assertEquals(userDao.updateUserState(id), 1);

        // 이메일 변경 실패 시 0 반환
        int expectedCnt = 0;
        int actualCnt = userDao.updateUserEmail(id, email);
        assertEquals(expectedCnt, actualCnt);
    }

    // 3.4.3. 비회원 이메일 변경 실패
    @Test
    public void 비회원_이메일_변경_불가_테스트() throws Exception {
        // 비회원 확인
        // 비회원은 id 조회 되지 않음에 따라 이메일 변경 불가
        String id = "nonMember";
        assertNull(userDao.selectUser(id));
//        assertNull(userDao.selectUser(id).getEmail());
        Assertions.assertThrows(NullPointerException.class, () -> userDao.selectUser(id).getEmail());
    }
}