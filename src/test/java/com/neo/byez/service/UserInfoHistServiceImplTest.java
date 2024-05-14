package com.neo.byez.service;

import com.neo.byez.dao.UserDaoImpl;
import com.neo.byez.dao.UserInfoHistDao;
import com.neo.byez.domain.UserDto;
import com.neo.byez.domain.UserInfoHistDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserInfoHistServiceImplTest {

    @Autowired UserInfoHistServiceImpl userInfoHistService;
    @Autowired UserInfoHistDao userInfoHistDao;
    @Autowired UserServiceImpl userService;
    @Autowired UserDaoImpl userDao;

    @Before
    public void reset() throws Exception {
        userInfoHistDao.deleteAllUserInfoHist();
        userDao.deleteAllTestUser();

        // initialize DB
        for (int i = 1; i <= 50; i++) {
            UserDto testDto = new UserDto("user" + i, "password" + i + "!@#", "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(testDto);
        }
    }

    @Test
    public void 객체_주입_확인_테스트() throws Exception {
        assertNotNull(userInfoHistService);
    }

    @Test
    public void 고객정보_변경이력_조회_테스트() throws Exception {
        // 특정 고객 아이디
        String id = "user1";
        // 변경할 이메일 주소
        String email = "modified@example.com";

        // 변경이력 비어있음을 확인
        List<UserInfoHistDto> testList1 = userInfoHistService.getCustChangedInfoHist();
        assertEquals(0, testList1.size());

        // 이메일 변경 성공 시 true 반환
        boolean updateEmailSuccess = userService.modifyUserEmail(id, email);
        assertTrue(updateEmailSuccess);

        // 이메일 변경이력 추가 성공 시 리스트에 추가됨을 확인
        List<UserInfoHistDto> testList2 = userInfoHistService.getCustChangedInfoHist();
        assertEquals(1, testList2.size());

        // 변경된 이메일 확인
        assertEquals(email, testList2.get(0).getAf_info());
    }

    @Test
    public void 고객정보_변경이력_저장_성공_테스트() throws Exception {
        String id = "user1";
        String bef_info = userService.getCustLoginInfo(id).getEmail();
        String af_info = " modified@example.com";

        UserInfoHistDto testDto = new UserInfoHistDto(id, "CHG0002", bef_info, af_info, id, id);
        boolean insertSuccessCnt = userInfoHistService.saveCustChangedInfo(testDto);
        assertTrue(insertSuccessCnt);
        assertEquals(1, userInfoHistService.getCustChangedInfoHist().size());
    }
}