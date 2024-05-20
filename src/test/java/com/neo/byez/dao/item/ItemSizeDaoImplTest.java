package com.neo.byez.dao.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.neo.byez.dao.UserDaoImpl;
import com.neo.byez.domain.UserDto;
import com.neo.byez.domain.item.BasketDto;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.ItemDetailDto;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.ItemOptDto;
import com.neo.byez.domain.item.ItemPriceDto;
import com.neo.byez.domain.item.ItemStateDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class ItemSizeDaoImplTest {

    @Autowired
    private ItemDaoImpl itemDao;

    @Autowired
    private ItemSizeDaoImpl itemSizeDao;

    @Before
    public void 테스트환경() throws Exception {
        assertNotNull(itemDao);
        assertNotNull(itemSizeDao);
    }

    @BeforeEach
    public void 초기화() throws Exception {
        itemSizeDao.deleteAll();
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
            ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL", null, null, null, null);
            assertEquals(1, itemSizeDao.insert(itemSizeDto));
        }
        assertEquals(1, itemSizeDao.count("1"));


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
            ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL", null, null, null, null);
            assertEquals(1, itemSizeDao.insert(itemSizeDto));
        }

        assertEquals(n, itemSizeDao.countAll());
        assertEquals(1, itemSizeDao.count("1"));
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
            ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL", null, null, null, null);
            assertEquals(1, itemSizeDao.insert(itemSizeDto));
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
            ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL", null, null, null, null);
            assertEquals(1, itemSizeDao.insert(itemSizeDto));
            ItemOptDto selectedDto = itemSizeDao.select(itemSizeDto.getNum()).get(0);
            assertEquals(itemSizeDto, selectedDto);
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
                ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL"+j, null, null, null, null);
                assertEquals(1, itemSizeDao.insert(itemSizeDto));
                list.add(itemSizeDto);
            }


            List<ItemOptDto> selectedDtos = itemSizeDao.select(itemDto.getNum());
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
                ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL"+j, null, null, null, null);
                assertEquals(1, itemSizeDao.insert(itemSizeDto));
                list.add(itemSizeDto);
            }
        }

        assertEquals(5*n, itemSizeDao.selectAll().size());
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
                ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL"+j, null, null, null, null);
                assertEquals(1, itemSizeDao.insert(itemSizeDto));
                list.add(itemSizeDto);
            }

            // 사이즈 변경
            ItemOptDto first = list.stream().findFirst().get();

            // 사이즈 변경 등록
            first.setNew_code("new size");
            assertEquals(1, itemSizeDao.update(first));
            first.setCode("new size");
            List<ItemOptDto> selectedDtos = itemSizeDao.select(itemDto.getNum());
            for (ItemOptDto selectedDto : selectedDtos) {
                assertTrue(list.contains(selectedDto));
            }

        }

        assertEquals(5*n, itemSizeDao.selectAll().size());
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
                ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL"+j, null, null, null, null);
                assertEquals(1, itemSizeDao.insert(itemSizeDto));
                list.add(itemSizeDto);
            }

            for (ItemOptDto itemSizeDto : list) {
                assertEquals(1, itemSizeDao.delete(itemSizeDto));
            }

            assertEquals(0, itemSizeDao.count(itemDto.getNum()));
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
                ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL"+j, null, null, null, null);
                assertEquals(1, itemSizeDao.insert(itemSizeDto));
                list.add(itemSizeDto);
            }

            assertEquals(5, itemSizeDao.deleteAll());
            assertEquals(0, itemSizeDao.countAll());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void deleteAllSize(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            List<ItemOptDto> list = new ArrayList<>();
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 사이즈 등록
            for (int j=1; j<=5; j++) {
                ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL"+j, null, null, null, null);
                assertEquals(1, itemSizeDao.insert(itemSizeDto));
                list.add(itemSizeDto);
            }

            assertEquals(5, itemSizeDao.deleteAllSize(itemDto.getNum()));
            assertEquals(0, itemSizeDao.count(itemDto.getNum()));
        }
    }
}