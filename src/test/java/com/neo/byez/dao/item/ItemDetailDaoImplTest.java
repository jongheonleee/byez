package com.neo.byez.dao.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.neo.byez.domain.item.BasketDto;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.ItemDetailDto;
import com.neo.byez.domain.item.ItemDto;
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
class ItemDetailDaoImplTest {

    @Autowired
    private ItemDaoImpl itemDao;

    @Autowired
    private ItemDetailDaoImpl itemDetailDao;


    @Before
    public void 테스트환경() throws Exception {
        assertNotNull(itemDao);
        assertNotNull(itemDetailDao);
    }

    @BeforeEach
    public void 초기화() throws Exception {
        itemDetailDao.deleteAll();
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

            // 상품 상세 등록
            ItemDetailDto itemDetailDto = new ItemDetailDto(String.valueOf(i), "detail name", "comt", "detail_img", 100000, "rel date", "gr date", "mfg corp", "mfg name", "mfg date", "model", "origin", "matr", "caut", "reg_date", "reg_id", "up_date", "up_id");
            assertEquals(1, itemDetailDao.insert(itemDetailDto));
        }

        assertEquals(n, itemDetailDao.count());

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void select(int n) throws Exception {
        List<ItemDetailDto> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상세 등록
            ItemDetailDto itemDetailDto = new ItemDetailDto(String.valueOf(i), "detail name", "comt", "detail_img", 100000, "rel date", "gr date", "mfg corp", "mfg name", "mfg date", "model", "origin", "matr", "caut", "reg_date", "reg_id", "up_date", "up_id");
            assertEquals(1, itemDetailDao.insert(itemDetailDto));
            list.add(itemDetailDto);
        }

        // 등록된 상품 상세 조회 및 비교
        for (ItemDetailDto dto : list) {
            ItemDetailDto selectedDto = itemDetailDao.select(dto.getNum());
            assertEquals(dto, selectedDto);
        }

        // 카운트해서 개수 확인
        assertEquals(n, itemDetailDao.count());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void selectAll(int n) throws Exception {
        List<ItemDetailDto> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상세 등록
            ItemDetailDto itemDetailDto = new ItemDetailDto(String.valueOf(i), "detail name", "comt", "detail_img", 100000, "rel date", "gr date", "mfg corp", "mfg name", "mfg date", "model", "origin", "matr", "caut", "reg_date", "reg_id", "up_date", "up_id");
            assertEquals(1, itemDetailDao.insert(itemDetailDto));
            list.add(itemDetailDto);
        }

        // 등록된 상품 상세 모두 조회 및 비교
        List<ItemDetailDto> selectedDtos = itemDetailDao.selectAll();

        for (ItemDetailDto selectedDto : selectedDtos) {
            assertTrue(list.contains(selectedDto));
        }

        // 카운트해서 개수 확인
        assertEquals(itemDetailDao.count(), selectedDtos.size());
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

            // 상품 상세 등록
            ItemDetailDto itemDetailDto = new ItemDetailDto(String.valueOf(i), "detail name", "comt", "detail_img", 100000, "rel date", "gr date", "mfg corp", "mfg name", "mfg date", "model", "origin", "matr", "caut", "reg_date", "reg_id", "up_date", "up_id");
            assertEquals(1, itemDetailDao.insert(itemDetailDto));

            // 생성한 dto와 조회한 dto 비교
            ItemDetailDto selectedDto = itemDetailDao.select(itemDetailDto.getNum());
            assertEquals(itemDetailDto, selectedDto);
        }

        // 카운트 비교
        assertEquals(n, itemDetailDao.count());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void update(int n) throws Exception {
        for (int i=1; i<=n; i++) {
            // 상품
            ItemDto itemDto = new ItemDto(String.valueOf(i), "item" + String.valueOf(i), "item-type" + String.valueOf(i), "cust-type" + String.valueOf(i),
                    i * 10000, i * 7000, "...", i * 500, 3.5, i * 50, "#1234",
                    null, "manager1", null, "manager1");
            itemDao.insert(itemDto);

            // 상품 상세 등록
            ItemDetailDto itemDetailDto = new ItemDetailDto(String.valueOf(i), "detail name", "comt", "detail_img", 100000, "rel date", "gr date", "mfg corp", "mfg name", "mfg date", "model", "origin", "matr", "caut", "reg_date", "reg_id", "up_date", "up_id");
            assertEquals(1, itemDetailDao.insert(itemDetailDto));

            // 상품 상세 수정
            itemDetailDto.setDetail_img("new detail img");
            itemDetailDto.setDetail_name("new detail name");
            assertEquals(1, itemDetailDao.update(itemDetailDto));

            // 수정한 dto와 조회된 dto 비교
            ItemDetailDto selectedDto = itemDetailDao.select(itemDetailDto.getNum());
            assertEquals(itemDetailDto, selectedDto);
        }

        // 카운트 비교
        assertEquals(n, itemDetailDao.count());
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

            // 상품 상세 등록
            ItemDetailDto itemDetailDto = new ItemDetailDto(String.valueOf(i), "detail name", "comt", "detail_img", 100000, "rel date", "gr date", "mfg corp", "mfg name", "mfg date", "model", "origin", "matr", "caut", "reg_date", "reg_id", "up_date", "up_id");
            assertEquals(1, itemDetailDao.insert(itemDetailDto));

            // 상품 상세 삭제
            assertEquals(1, itemDetailDao.delete(itemDetailDto.getNum()));

        }

        // 카운트 비교
        assertEquals(0, itemDetailDao.count());
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

            // 상품 상세 등록
            ItemDetailDto itemDetailDto = new ItemDetailDto(String.valueOf(i), "detail name", "comt", "detail_img", 100000, "rel date", "gr date", "mfg corp", "mfg name", "mfg date", "model", "origin", "matr", "caut", "reg_date", "reg_id", "up_date", "up_id");
            assertEquals(1, itemDetailDao.insert(itemDetailDto));
        }

        // 상품 상세 모두 삭제
        assertEquals(n, itemDetailDao.deleteAll());

        // 카운트 비교
        assertEquals(0, itemDetailDao.count());
    }
}