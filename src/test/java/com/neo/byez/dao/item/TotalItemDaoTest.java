package com.neo.byez.dao.item;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.neo.byez.dao.user.UserDaoImpl;
import com.neo.byez.domain.item.BasketDto;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.ItemDetailDto;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.ItemOptDto;
import com.neo.byez.domain.item.ItemPriceDto;
import com.neo.byez.domain.item.ItemStateDto;
import com.neo.byez.domain.user.UserDto;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
public class TotalItemDaoTest {

    @Autowired
    ItemDaoImpl itemDao;

    @Autowired
    UserDaoImpl userDao;

    @Autowired
    BasketDaoImpl basketDao;

    @Autowired
    BasketItemDaoImpl basketItemDao;

    @Autowired
    LikeItemDaoImpl likeItemDao;

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
        assertNotNull(userDao);
        assertNotNull(basketDao);
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
        BasketItemDto dto = new BasketItemDto();
        dto.setId("1");
        basketItemDao.deleteAll(dto);
        likeItemDao.deleteAll("1");
        basketDao.deleteAll();
        userDao.deleteAllUser();
        itemDao.deleteAll();
    }

    @ParameterizedTest
    @ValueSource(ints = {50})
    public void 데이터_주입(int n) throws Exception {
        // 유저 장바구니 등록
        for (int i = 1; i <= 1; i++) {
            UserDto user = new UserDto("" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);

            BasketDto basket = new BasketDto();
            basket.setId(user.getId());

            basketDao.insert(basket);
        }

        // 상품 50개 등록
        for (int i=1; i<=n; i++) {
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

}
