package com.neo.byez.dao.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.neo.byez.dao.user.UserDaoImpl;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.ItemStateDto;
import com.neo.byez.domain.user.UserDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;



@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class ItemStateDaoImplTest {
    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private ItemDaoImpl itemDao;

    @Autowired
    private ItemStateDaoImpl itemStateDao;


    @Before
    public void 테스트환경() throws Exception {
        assertNotNull(itemDao);
        assertNotNull(userDao);
        assertNotNull(itemStateDao);
    }

    @BeforeEach
    public void 초기화() throws Exception {
        itemStateDao.deleteAll();
        itemDao.deleteAll();
        userDao.deleteAllUser();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void count(int n) throws Exception {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            itemStateDao.insert(itemStateDto);
        }

        assertEquals(n, itemStateDao.count());

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void select(int n) throws Exception  {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            itemStateDao.insert(itemStateDto);

            // 상품 상태 조회
            ItemStateDto selectedDto = itemStateDao.select(itemStateDto.getNum());
            assertEquals(itemStateDto, selectedDto);
        }

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void selectAll(int n) throws Exception  {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        List<ItemStateDto> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            list.add(itemStateDto);
            itemStateDao.insert(itemStateDto);
        }

        List<ItemStateDto> selectedDtos = itemStateDao.selectAll();
        for (ItemStateDto selectedDto : selectedDtos) {
            assertTrue(list.contains(selectedDto));
        }

        assertEquals(n, selectedDtos.size());


    }


    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void insert(int n) throws Exception  {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            assertEquals(1, itemStateDao.insert(itemStateDto));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void increaseSalesQty(int n) throws Exception  {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            assertEquals(1, itemStateDao.insert(itemStateDto));

            // 상품 상태 조회
            ItemStateDto selectedDto = itemStateDao.select(itemStateDto.getNum());
            assertEquals(itemStateDto, selectedDto);

            // 상품 상태 업데이트 - 판매량 1 증가
            int cnt = 3;
            Map map = new HashMap();
            map.put("num", selectedDto.getNum());
            map.put("cnt", cnt);

            assertEquals(1, itemStateDao.increaseSalesQty(map));

            // 상품 조회, 수량 비교
            ItemStateDto updatedDto = itemStateDao.select(selectedDto.getNum());
            assertEquals(selectedDto.getSales_qty() + cnt, updatedDto.getSales_qty());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void increaseStockQty(int n) throws Exception  {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            assertEquals(1, itemStateDao.insert(itemStateDto));

            // 상품 상태 조회
            ItemStateDto selectedDto = itemStateDao.select(itemStateDto.getNum());
            assertEquals(itemStateDto, selectedDto);

            // 상품 상태 업데이트 - 재고량 1 증가
            int cnt = 3;
            Map map = new HashMap();
            map.put("num", selectedDto.getNum());
            map.put("cnt", cnt);

            assertEquals(1, itemStateDao.increaseStockQty(map));

            // 상품 조회, 재고량 비교
            ItemStateDto updatedDto = itemStateDao.select(selectedDto.getNum());
            assertEquals(selectedDto.getStock_qty() + cnt, updatedDto.getStock_qty());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void increaseViewCnt(int n) throws Exception  {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            assertEquals(1, itemStateDao.insert(itemStateDto));

            // 상품 상태 조회
            ItemStateDto selectedDto = itemStateDao.select(itemStateDto.getNum());
            assertEquals(itemStateDto, selectedDto);

            // 상품 상태 업데이트 - 조회수 1 증가

            assertEquals(1, itemStateDao.increaseViewCnt(selectedDto.getNum()));

            // 상품 조회, 조회수 비교
            ItemStateDto updatedDto = itemStateDao.select(selectedDto.getNum());
            assertEquals(selectedDto.getView_cnt()+1, updatedDto.getView_cnt());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void updateStateCode(int n) throws Exception  {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            assertEquals(1, itemStateDao.insert(itemStateDto));

            // 상품 상태 조회
            ItemStateDto selectedDto = itemStateDao.select(itemStateDto.getNum());
            assertEquals(itemStateDto, selectedDto);

            // 상품 상태 업데이트 - 조회수 1 증가
            Map map = new HashMap();
            map.put("num", selectedDto.getNum());
            map.put("state_code", "SLA1");
            assertEquals(1, itemStateDao.updateStateCode(map));

            // 상품 조회, 조회수 비교
            ItemStateDto updatedDto = itemStateDao.select(selectedDto.getNum());
            assertEquals("SLA1", updatedDto.getState_cede());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void delete(int n) throws Exception  {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        List<ItemStateDto> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            list.add(itemStateDto);
            itemStateDao.insert(itemStateDto);
        }

        for (ItemStateDto dto : list) {
            assertEquals(1, itemStateDao.delete(dto.getNum()));
        }

        assertEquals(0, itemStateDao.selectAll().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void deleteAll(int n) throws Exception {
        for (int i=1; i<=10; i++) {
            // 유저
            UserDto user = new UserDto(""+ i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

        }

        List<ItemStateDto> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상태 등록
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "SLA1", null, "manager", null, "SLA1");
            list.add(itemStateDto);
            itemStateDao.insert(itemStateDto);
        }

        assertEquals(n, itemStateDao.deleteAll());
    }
}