package com.neo.byez.dao.user;

import com.neo.byez.domain.user.UserDto;
import com.neo.byez.domain.user.UserInfoHistDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserInfoHistDaoImplTest {

    @Autowired
    UserInfoHistDaoImpl userInfoHistDao;
    @Autowired
    UserDaoImpl userDao;

    // 1. 초기테스트
    // 1.1. 테스트하는 클래스의 주입 상태 확인

    // 2. 보조 기능 테스트
    // 2.1. 테스트용으로 사용할 메서드(insert, delete) 기능 확인
    // 2.1.1. @Before 애너테이션으로 더미데이터 추가
    // 2.1.2. @After 애너테이션으로 더미데이터 전체 삭제

    // 3. 핵심 기능 테스트
    // 3.1. 변경이력 추가
    // 3.1.1. 변경이력 추가 전후 row 개수 확인
    // 3.1.2. 변경이력 추가 결과 확인

    // cust, cust_hist 테이블 내 모든 데이터 삭제 후
    // cust 테이블에 더미데이터 추가
    @Before
    public void addData() throws Exception {
        // clean DB
        userInfoHistDao.deleteAllUserInfoHist();
        userDao.deleteAllTestUser();

        // initialize DB
        for (int i = 1; i <= 50; i++) {
            UserDto testDto = new UserDto("user" + i, "password" + i + "!@#", "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(testDto);
        }
    }

    // 1. 초기테스트
    // 1.1. 테스트하는 클래스의 주입 상태 확인
    @Test
    public void userInfoHistDao_주입_상태_테스트() {
        assertNotNull(userInfoHistDao);
    }

    // 2. 보조 기능 테스트
    // 2.1. 테스트용으로 사용할 메서드(insert, delete) 기능 확인
    @Test
    public void 보조_기능_테스트() throws Exception {
        int expectedCnt = 30;
        int actualCnt = 0;

        // 30개의 더미데이터 추가 - 추가 성공 시 1 반환
        for(int i = 1; i <= 30; i++) {
            UserInfoHistDto testDto = new UserInfoHistDto("user"+i, "CHG0001", "변경 전 정보 "+i, "변경 후 정보 "+i, "user"+i, "user"+i);
            actualCnt += userInfoHistDao.insertUserInfoHist(testDto);
        }

        // 30개의 데이터 모두 추가 성공 시 30 반환
        assertEquals(expectedCnt, actualCnt);

        // DB 전체 데이터 삭제 - 성공 시 30 반환
        assertEquals(userInfoHistDao.deleteAllUserInfoHist(), 30);
        // DB 전체 데이터 조회 - 조회되는 데이터 없음(NULL)
        assertEquals(userInfoHistDao.selectAllUserInfoHist().size(), 0);
    }

    // 2.1.1. 더미데이터 추가
    public void initializeDB() throws Exception {
        // 총 20개의 더미데이터 추가
        for (int i = 1; i <= 10; i++) {
            // 비밀번호 변경에 대한 더미데이터 10개
            UserInfoHistDto testDto1 = new UserInfoHistDto("user"+i, "CHG0001", "password"+i+"!@#", "modified"+i+"!@#", "user"+i, "user"+i);
            userInfoHistDao.insertUserInfoHist(testDto1);
            // 이메일 변경에 대한 더미데이터 10개
            UserInfoHistDto testDto2 = new UserInfoHistDto("user"+i, "CHG0002", "test" + i + "@example.com", "modified" + i + "@example.com", "user"+i, "user"+i);
            userInfoHistDao.insertUserInfoHist(testDto2);
        }
    }

    // 2.1.2. 더미데이터 전체 삭제
    public void cleanDB() throws Exception {
        userInfoHistDao.deleteAllUserInfoHist();
    }

    @Test
    public void 변경이력_추가_전후_Row_수_테스트() throws Exception {
        // 더미데이터 추가 (10개)
        initializeDB();
        // 20개의 행이 제대로 추가되었는지 전체 row 수를 조회하는 select 문으로 확인
        int preTotalCnt = userInfoHistDao.selectAllUserInfoHist().size();
        assertEquals(preTotalCnt, 20);

        // 2개 추가
        UserInfoHistDto testDto1 = new UserInfoHistDto("user11", "CHG0001", "password11!@#", "modified11!@#", "user11", "user11");
        userInfoHistDao.insertUserInfoHist(testDto1);
        UserInfoHistDto testDto2 = new UserInfoHistDto("user11", "CHG0002", "test11@example.com", "modified11@example.com", "user11", "user11");
        userInfoHistDao.insertUserInfoHist(testDto2);

        // 2개의 행이 제대로 추가되었는지 전체 row 수를 조회하는 select 문으로 확인
        int postTotalCnt1 = userInfoHistDao.selectAllUserInfoHist().size();
        assertEquals(postTotalCnt1, 22);

        // 20개 추가
        for (int i = 12; i < 22; i++) {
            UserInfoHistDto testDto3 = new UserInfoHistDto("user"+i, "CHG0001", "password"+i+"!@#", "modified"+i+"!@#", "user"+i, "user"+i);
            userInfoHistDao.insertUserInfoHist(testDto3);
            UserInfoHistDto testDto4 = new UserInfoHistDto("user"+i, "CHG0002", "test" + i + "@example.com", "modified" + i + "@example.com", "user"+i, "user"+i);
            userInfoHistDao.insertUserInfoHist(testDto4);
        }

        // 20개의 행이 제대로 추가되었는지 전체 row 수를 조회하는 select 문으로 확인
        int postTotalCnt2 = userInfoHistDao.selectAllUserInfoHist().size();
        assertEquals(postTotalCnt2, 42);

        // 더미데이터 삭제
        cleanDB();
    }

    @Test
    public void 비밀번호_변경이력_추가결과_테스트() throws Exception {
        // user1 이라는 id를 가진 고객의 비밀번호를 변경한 이력 확인
        String id = "user1";
        // 변경하려는 비밀번호
        String pwd = "modified1!@#";
        // 비밀번호 변경 성공 시 1 반환
        int modifiedPwdCnt = userDao.updateUserPwd(id, pwd);
        assertEquals(1, modifiedPwdCnt);

        UserInfoHistDto testDto = new UserInfoHistDto(id, "CHG0001", "password1!@#", "modified1!@#", id, id);

        // 비밀번호 변경 성공 시 고객 정보 변경이력 추가
        // 변경이력 추가 성공 시 1 반환
        int expectedCnt = 1;
        int actualCnt = 0;
        if (modifiedPwdCnt == 1) {
            actualCnt = userInfoHistDao.insertUserInfoHist(testDto);
        }

        // 변경이력에 저장한 변경 후 비밀번호
        String expectedPwd = testDto.getAf_info();
        // DB에 저장되어 있는 변경 후 비밀번호
        String actualPwd = userDao.selectUser(id).getPwd();

        assertEquals(expectedCnt, actualCnt);
        assertEquals(expectedPwd, actualPwd);
    }

    @Test
    public void 이메일_변경이력_추가결과_테스트() throws Exception {
        // user2 이라는 id를 가진 고객의 이메일을 변경한 이력 확인
        String id = "user2";
        // 변경하려는 이메일
        String email = "modified2@example.com";
        // 이메일 변경 성공 시 1 반환
        int modifiedEmailCnt = userDao.updateUserEmail(id, email);
        assertEquals(modifiedEmailCnt, 1);

        UserInfoHistDto testDto = new UserInfoHistDto(id, "CHG0002", "user2@example.com", "modified2@example.com", id, id);

        // 이메일 변경 성공 시 고객 정보 변경 이력 추가
        // 변경이력 추가 성공 시 1 반환
        int expectedCnt = 1;
        int actualCnt = 0;
        if (modifiedEmailCnt == 1) {
            actualCnt = userInfoHistDao.insertUserInfoHist(testDto);
        }

        // 변경이력에 저장한 변경 후 이메일
        String expectedEmail = testDto.getAf_info();
        // DB에 저장된 변경 후 비밀번호
        String actualEmail = userDao.selectUser(id).getEmail();

        assertEquals(expectedCnt, actualCnt);
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void 이메일_변경이력_확인_테스트() throws Exception {
        String id = "user2";
        String email = "modified2@example.com";

        // 이메일 변경 성공 시 1 반환
        int updateEmailSuccessCnt = userDao.updateUserEmail(id, email);
        assertEquals(1, updateEmailSuccessCnt);

        // 이메일 변경이력 추가 성공 시 1 반환
        int expectedCnt = 1;
        UserInfoHistDto testDto = new UserInfoHistDto(id, "CHG0002", "user2@example.com", "modified2@example.com", id, id);
        int actualCnt = userInfoHistDao.insertUserInfoHist(testDto);
        assertEquals(expectedCnt, actualCnt);

        // 변경이력 조회 결과 이력 추가됨을 확인
        List<UserInfoHistDto> testList = userInfoHistDao.selectUserInfoHist(id);
        assertNotNull(testList);

        assertEquals(email, userDao.selectUser(id).getEmail());
    }
}