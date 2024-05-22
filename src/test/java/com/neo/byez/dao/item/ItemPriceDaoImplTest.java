package com.neo.byez.dao.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.neo.byez.domain.item.BasketDto;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.ItemDetailDto;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.ItemPriceDto;
import com.neo.byez.domain.item.ItemStateDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
class ItemPriceDaoImplTest {

    @Autowired
    private ItemDaoImpl itemDao;

    @Autowired
    private ItemPriceDaoImpl itemPriceDao;


    @Before
    public void 테스트환경() throws Exception {
        assertNotNull(itemDao);
        assertNotNull(itemPriceDao);
    }

    @BeforeEach
    public void 초기화() throws Exception {
        itemPriceDao.deleteAll();
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

            // 상품 가격 등록
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));
        }

        assertEquals(n, itemPriceDao.count());
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

            // 상품 가격 등록
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));

            // 상품 가격 조회
            ItemPriceDto selectedDto = itemPriceDao.select(itemPriceDto.getNum());
            assertEquals(itemPriceDto, selectedDto);

        }

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void selectAll(int n) throws Exception {
        List<ItemPriceDto> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 가격 등록
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));
            list.add(itemPriceDto);
        }

        List<ItemPriceDto> selectedDtos = itemPriceDao.selectAll();
        for (ItemPriceDto selectedDto : selectedDtos) {
            assertTrue(list.contains(selectedDto));
        }

        assertEquals(n, selectedDtos.size());
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

            // 상품 가격 등록
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));


        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void updateDiscRate(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 가격 등록
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));

            // 상품 가격 할인율 변경
            itemPriceDto.setDisc_rate(0.5);
            assertEquals(1, itemPriceDao.updateDiscRate(itemPriceDto));

            // 넣은 내용과 조회한 내용 비교
            ItemPriceDto selectedDto = itemPriceDao.select(itemPriceDto.getNum());
            assertEquals(itemPriceDto, selectedDto);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void increasePeriod(int n) throws Exception  {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 가격 등록
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));

            // 상품 가격 할인율 변경
            int period = 5;
            itemPriceDto.setPeriod(period);
            assertEquals(1, itemPriceDao.increasePeriod(itemPriceDto));

            // 넣은 내용과 조회한 내용 비교
            ItemPriceDto selectedDto = itemPriceDao.select(itemPriceDto.getNum());
            System.out.println(selectedDto);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void decreasePeriod(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 가격 등록
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));

            // 상품 가격 할인율 변경
            int period = 7;
            itemPriceDto.setPeriod(period);
            assertEquals(1, itemPriceDao.decreasePeriod(itemPriceDto));

            // 넣은 내용과 조회한 내용 비교
            ItemPriceDto selectedDto = itemPriceDao.select(itemPriceDto.getNum());
            System.out.println(selectedDto);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void delete(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 가격 등록
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));

            assertEquals(1, itemPriceDao.delete(itemPriceDto.getNum()));
        }

        assertEquals(0, itemPriceDao.count());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void deleteAll(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 가격 등록
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));
        }

        assertEquals(n, itemPriceDao.deleteAll());
        assertEquals(0, itemPriceDao.count());
    }
}