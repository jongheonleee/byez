package com.neo.byez.dao.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.neo.byez.dao.UserDaoImpl;
import com.neo.byez.domain.UserDto;
import com.neo.byez.domain.item.BasketDto;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.Category;
import com.neo.byez.domain.item.ItemDetailDto;
import com.neo.byez.domain.item.ItemDetailPageDto;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.ItemOptDto;
import com.neo.byez.domain.item.ItemPriceDto;
import com.neo.byez.domain.item.ItemStateDto;
import com.neo.byez.domain.item.SearchCondition;
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
class ItemDaoImplSelectTest {

    @Autowired
    ItemDaoImpl itemDao;

    @Autowired
    ItemStateDaoImpl itemStateDao;

    @Autowired
    ItemDetailDaoImpl itemDetailDao;

    @Autowired
    ItemPriceDaoImpl itemPriceDao;

    @Autowired
    ItemColorDaoImpl itemColorDao;

    @Autowired
    ItemSizeDaoImpl itemSizeDao;

    @Before
    public void 테스트환경() throws Exception {
        assertNotNull(itemDao);
        assertNotNull(itemStateDao);
        assertNotNull(itemDetailDao);
        assertNotNull(itemPriceDao);
        assertNotNull(itemColorDao);
        assertNotNull(itemSizeDao);
    }

    @BeforeEach
    public void 초기화() throws Exception {
        itemSizeDao.deleteAll();
        itemColorDao.deleteAll();
        itemPriceDao.deleteAll();
        itemDetailDao.deleteAll();
        itemStateDao.deleteAll();
        itemDao.deleteAll();

        // 상품 50개 등록
        for (int i=1; i<=50; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "010101" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "black,white,yellow,red,blue",
                    null, "manager1", null, "manager1");
            assertEquals(1, itemDao.insert(itemDto));

            // 상품 상태
            ItemStateDto itemStateDto = new ItemStateDto(String.valueOf(i), 10, 10, 10, "판매중", null, "manager", null, "SLA1");
            assertEquals(1, itemStateDao.insert(itemStateDto));

            // 상품 상세 등록
            ItemDetailDto itemDetailDto = new ItemDetailDto(String.valueOf(i), "detail name", "comt", "detail_img", 100000, "rel date", "gr date", "mfg corp", "mfg name", "mfg date", "model", "origin", "matr", "caut", "reg_date", "reg_id", "up_date", "up_id");
            assertEquals(1, itemDetailDao.insert(itemDetailDto));

            // 상품 가격
            ItemPriceDto itemPriceDto = new ItemPriceDto(String.valueOf(i), 7, 0.3, null, null, "...", null, "manager", null, "manager");
            assertEquals(1, itemPriceDao.insert(itemPriceDto));

            // 상품 색상
            // 상품 사이즈
            for (int j=1; j<=5; j++) {
                ItemOptDto itemSizeDto = new ItemOptDto(itemDto.getNum(), "XL"+j, null, null, null, null);
                assertEquals(1, itemSizeDao.insert(itemSizeDto));

                ItemOptDto itemColorDto = new ItemOptDto(itemDto.getNum(), "COL1" + j, null, null, null, null);
                assertEquals(1, itemColorDao.insert(itemColorDto));
            }

        }
    }


    @Test
    void selectAll() throws Exception {
        List<ItemDto> result = itemDao.selectAll(1, 12);
        assertEquals(12, result.size());
        result.stream().forEach(System.out::println);
    }

    @Test
    void selectBySearchCondition() throws Exception {
        // NT
        SearchCondition sc = new SearchCondition();
        sc.setOption("NT");
        sc.setNameKeyword("item1");
        sc.setTypeKeyword("0101");

        List<ItemDto> result = itemDao.selectBySearchCondition(sc);
        result.stream().forEach(System.out::println);
    }

    @Test
    void selectBySearchCondition2() throws Exception {
        // NC
        SearchCondition sc = new SearchCondition();
        sc.setOption("NC");
        sc.setNameKeyword("item");
        sc.setCustKeyword("cust-type5");

        List<ItemDto> result = itemDao.selectBySearchCondition(sc);
        result.stream().forEach(System.out::println);
    }


    @Test
    void selectBySearchCondition3() throws Exception {
        // TC
        SearchCondition sc = new SearchCondition();
        sc.setOption("TC");
        sc.setTypeKeyword("01015");
        sc.setCustKeyword("cust-type5");

        List<ItemDto> result = itemDao.selectBySearchCondition(sc);
        result.stream().forEach(System.out::println);
    }


    @Test
    void selectBySearchCondition4() throws Exception {
        // A
        SearchCondition sc = new SearchCondition();
        sc.setOption("A");
        sc.setNameKeyword("item");
        sc.setTypeKeyword("0101");
        sc.setCustKeyword("cust-type5");

        List<ItemDto> result = itemDao.selectBySearchCondition(sc);
        result.stream().forEach(System.out::println);
    }

    @Test
    void selectDiscountItem() throws Exception {
        Category category = new Category();
        category.setItem_type("01010140");
//        List<ItemDto> result = itemDao.selectByCategory(category);
//        assertEquals(1, result.size());
//        result.stream().forEach(System.out::println);
    }

    @Test
    void selectDetailItem() throws Exception {
        ItemDetailPageDto itemDetailPageDto = itemDao.selectDetailItem("50");
        System.out.println(itemDetailPageDto);
    }
}