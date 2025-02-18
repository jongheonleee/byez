package com.neo.byez.dao.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.ItemOptDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class ItemColorDaoImplTest {

    @Autowired
    private ItemDaoImpl itemDao;

    @Autowired
    private ItemColorDaoImpl itemColorDao;


    @Before
    public void 테스트환경() throws Exception {
        assertNotNull(itemDao);
        assertNotNull(itemColorDao);
    }

    @BeforeEach
    public void 초기화() throws Exception {
        itemColorDao.deleteAll();
        itemDao.deleteAll();
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void count(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1", null, null, null, null);
            assertEquals(1, itemColorDao.insert(itemColorDto));
        }
        assertEquals(1, itemColorDao.count("1"));


    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void countAll(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1", null, null, null, null);
            assertEquals(1, itemColorDao.insert(itemColorDto));
        }

        assertEquals(n, itemColorDao.countAll());
        assertEquals(1, itemColorDao.count("1"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void insert(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1", null, null, null, null);
            assertEquals(1, itemColorDao.insert(itemColorDto));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void select(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1", null, null, null, null);
            assertEquals(1, itemColorDao.insert(itemColorDto));
            ItemOptDto selectedDto = itemColorDao.select(itemColorDto.getNum()).get(0);
            assertEquals(itemColorDto, selectedDto);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void select2(int n) throws Exception {
        List<ItemOptDto> list = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            for (int j=1; j<=5; j++) {
                ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1" + j, null, null, null, null);
                assertEquals(1, itemColorDao.insert(itemColorDto));
                list.add(itemColorDto);
            }


            List<ItemOptDto> selectedDtos = itemColorDao.select(itemDto.getNum());
            for (ItemOptDto selectedDto : selectedDtos) {
                assertTrue(list.contains(selectedDto));
            }


        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void selectAll(int n) throws Exception {
        List<ItemOptDto> list = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            for (int j=1; j<=5; j++) {
                ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1" + j, null, null, null, null);
                assertEquals(1, itemColorDao.insert(itemColorDto));
                list.add(itemColorDto);
            }
        }

        assertEquals(5*n, itemColorDao.selectAll().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void update(int n) throws Exception {
        List<ItemOptDto> list = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            for (int j=1; j<=5; j++) {
                ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1" + j, null, null, null, null);
                assertEquals(1, itemColorDao.insert(itemColorDto));
                list.add(itemColorDto);
            }

            // 사이즈 변경
            ItemOptDto first = list.stream().findFirst().get();

            // 사이즈 변경 등록
            first.setNew_code("COL99");
            assertEquals(1, itemColorDao.update(first));
            first.setCode("COL99");
            List<ItemOptDto> selectedDtos = itemColorDao.select(itemDto.getNum());
            for (ItemOptDto selectedDto : selectedDtos) {
                assertTrue(list.contains(selectedDto));
            }

        }

        assertEquals(5*n, itemColorDao.selectAll().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void delete(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            List<ItemOptDto> list = new ArrayList<>();
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            for (int j=1; j<=5; j++) {
                ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1" + j, null, null, null, null);
                assertEquals(1, itemColorDao.insert(itemColorDto));
                list.add(itemColorDto);
            }

            for (ItemOptDto itemSizeDto : list) {
                assertEquals(1, itemColorDao.delete(itemSizeDto));
            }

            assertEquals(0, itemColorDao.count(itemDto.getNum()));
        }

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void deleteAll(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            List<ItemOptDto> list = new ArrayList<>();
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            for (int j=1; j<=5; j++) {
                ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1" + j, null, null, null, null);
                assertEquals(1, itemColorDao.insert(itemColorDto));
                list.add(itemColorDto);
            }

            assertEquals(5, itemColorDao.deleteAll());
            assertEquals(0, itemColorDao.countAll());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void deleteAllColor(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            List<ItemOptDto> list = new ArrayList<>();
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            for (int j=1; j<=5; j++) {
                ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1" + j, null, null, null, null);
                assertEquals(1, itemColorDao.insert(itemColorDto));
                list.add(itemColorDto);
            }

            assertEquals(5, itemColorDao.deleteAllColor(itemDto.getNum()));
            assertEquals(0, itemColorDao.count(itemDto.getNum()));
        }
    }
}