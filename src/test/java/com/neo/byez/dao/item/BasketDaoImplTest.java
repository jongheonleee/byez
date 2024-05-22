package com.neo.byez.dao.item;

import static org.junit.jupiter.api.Assertions.*;


import com.neo.byez.dao.user.UserDaoImpl;
import com.neo.byez.domain.item.BasketDto;
import com.neo.byez.domain.user.UserDto;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class BasketDaoImplTest {

    @Autowired
    private BasketDaoImpl basketDao;

    @Autowired
    private UserDaoImpl userDao;

    @Before
    public void 테스트환경() throws Exception {
        assertNotNull(basketDao);
        assertNotNull(userDao);
    }

    @BeforeEach
    public void 초기화() throws Exception {
        basketDao.deleteAll();
        userDao.deleteAllTestUser();
    }

    @Test
    void count() throws Exception {
        for (int i = 1; i <= 30; i++) {
            UserDto user = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

            BasketDto basket = new BasketDto();
            basket.setId(user.getId());

            basketDao.insert(basket);
        }

        assertEquals(30, basketDao.count());
    }

    @Test
    void select() throws Exception {
        for (int i = 1; i <= 30; i++) {
            UserDto user = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

            BasketDto basket = new BasketDto();
            basket.setId(user.getId());

            basketDao.insert(basket);
        }

        List<UserDto> users = userDao.selectUserAll();
        for (UserDto user : users) {
            assertNotNull(basketDao.select(user.getId()));
        }
    }

    @Test
    void selectAll() throws Exception {
        for (int i = 1; i <= 30; i++) {
            UserDto user = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

            BasketDto basket = new BasketDto();
            basket.setId(user.getId());

            basketDao.insert(basket);
        }

        List<BasketDto> baskets = basketDao.selectAll();
        assertEquals(30, baskets.size());
    }

    @Test
    void insert() throws Exception {
        for (int i = 1; i <= 30; i++) {
            UserDto user = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

            BasketDto basket = new BasketDto();
            basket.setId(user.getId());

            assertEquals(1, basketDao.insert(basket));
        }
    }

    @Test
    void delete() throws Exception {
        for (int i = 1; i <= 30; i++) {
            UserDto user = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

            BasketDto basket = new BasketDto();
            basket.setId(user.getId());

            assertEquals(1, basketDao.insert(basket));
            assertEquals(1, basketDao.delete(user.getId()));
        }

    }

    @Test
    void deleteAll() throws Exception {
        for (int i = 1; i <= 30; i++) {
            UserDto user = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

            BasketDto basket = new BasketDto();
            basket.setId(user.getId());

            assertEquals(1, basketDao.insert(basket));
        }

        assertEquals(30, basketDao.deleteAll());
    }
}