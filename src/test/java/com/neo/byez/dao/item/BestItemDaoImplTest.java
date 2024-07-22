package com.neo.byez.dao.item;

import com.neo.byez.domain.item.ItemDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class BestItemDaoImplTest {
    @Autowired
    ItemDaoImpl itemDao;

    @Autowired
    ItemStateDaoImpl itemStateDao;

    @Autowired
    ItemDetailDaoImpl itemDetailDao;

    @Autowired
    ItemBestDaoImpl itemBestDao;
    private DatabaseMetaData ds;

    @BeforeEach
    public void init() throws Exception {
        // 각 테스트가 종료된 이후 목업 데이터 추가
        clearDB();
    }

    @AfterEach
    public void clear() throws Exception  {
        // 현재 사용하는 영역의 테이블 모두 비움
        clearDB();
    }

    @DisplayName("테스트 코드 환경 확인")
    @Test
    public void check() {
        assertNotNull(itemDao);
    }

    private void clearDB() throws Exception {
        clearItem();
    }


    private void clearItem() throws Exception {
        Connection conn = ds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ITEM");
        pstmt.executeUpdate();
    }

    private ItemDto createItem(int i) {
        String num = String.valueOf(i);
        String name = "item" + String.valueOf(i);
        String itemType = "item-type" + String.valueOf(i);
        String custType = "cust-type" + String.valueOf(i);
        int price = i * 10000;
        int discPrice = i * 7000;
        String mainImg = "...";
        int reviewCnt = i * 500;
        double reviewRate = 3.5;
        int likeCnt = i * 50;
        String col = "#1234";

        return new ItemDto(num, name, itemType, custType, price,
                discPrice, mainImg, reviewCnt, reviewRate, likeCnt, col,
                null, "manager1", null, "manager1");
    }

    private void insertData(int n) throws Exception {
        clearDB();
        insertItem(n);
    }



    private void insertItem(int n) throws Exception {
        Connection conn = ds.getConnection();

        String sql = "INSERT INTO ITEM(num, name, price, disc_price, main_img,"
                + "review_cnt, like_cnt, review_rate, col, reg_date,"
                + "reg_id, up_date, up_id, item_type, cust_type)"
                + "VALUES(?, ?, ?, ?, ?,"
                + " ?, ?, ?, '#123123', now(),"
                + " 'm1', now(), 'm1', ?, ?)";

        conn.setAutoCommit(false);
        PreparedStatement pstmt = conn.prepareStatement(sql);

        for (int i=1; i<=n; i++) {
            ItemDto item = createItem(i);
            // num, name, price, disc_price, main_img, review_cnt, like_cnt, review_rate, item_type, cust_type
            pstmt.setString(1, item.getNum());
            pstmt.setString(2, item.getName());
            pstmt.setInt(3, item.getPrice());
            pstmt.setInt(4, item.getPrice());
            pstmt.setString(5, item.getMain_img());
            pstmt.setInt(6, item.getReview_cnt());
            pstmt.setInt(7, item.getLike_cnt());
            pstmt.setDouble(8, item.getReview_rate());
            pstmt.setString(9, item.getItem_type());
            pstmt.setString(10, item.getCust_type());
            pstmt.addBatch();
            pstmt.clearParameters();
        }

        pstmt.executeBatch();
        conn.commit();
    }

    // 핵심 기능 테스트
    // 베스트 아이템 선택
    // 성공 -> 원하는 정렬기준대로 아이템이 선택, 정렬됨.
    // 실패 -> 다른 기준대로 아이템이 정렬됨.
    // 예외

    @DisplayName("1-1. 등록 성공 - 수량 증가")
    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
    @ValueSource(ints = {1, 10, 25, 50, 100})
    public void 등록1(int n) throws Exception {
        // given : 상품 n개 생성
        // when : n개 등록
        // then : 로우수 1, 카운트 n, 내용 비교
        List<ItemDto> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            ItemDto dto = createItem(i);
            list.add(dto);
            assertEquals(1, itemDao.insert(dto));
        }
        assertEquals(n, itemDao.count());

        // 내용 비교
        List<ItemDto> selectedList = itemDao.selectAll(100,2);
        for (ItemDto dto : selectedList) {
            assertEquals(true, list.contains(dto));
        }

    }



}