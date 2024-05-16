//package com.neo.byez.common.util;
//
//import com.statuscode.dto.ItemDto;
//import com.statuscode.dto.UserDto;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.sql.DataSource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//public final class TestHelper {
//
//    private static final TestHelper singleton = new TestHelper();
//    private DataSource ds;
//
//    private TestHelper() {
//        this.ds = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test_table", "root", "12341234");
//    }
//
//    public static TestHelper getInstance() {
//        return singleton;
//    }
//
//
//    // 2. 보조 메서드
//
//    public synchronized void cleanDB() throws Exception {
//        // 💥 테이블을 지울때는 항상 자식부터 지워야함, 부모는 가장 나중에!!
//        cleanItemBasket();
//        cleanBasket();
//        cleanItemLike();
//        cleanItemBest();
//        cleanItemPrice();
//        cleanItemState();
//        cleanItem();
//        cleanCust();
//    }
//
//    private void cleanCust() throws SQLException {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM CUST");
//        pstmt.executeUpdate();
//    }
//
//    private void cleanItem() throws SQLException {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ITEM");
//        pstmt.executeUpdate();
//    }
//
//    private void cleanItemState() throws SQLException {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ITEM_STATE");
//        pstmt.executeUpdate();
//    }
//
//    private void cleanItemPrice() throws SQLException {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ITEM_PRICE");
//        pstmt.executeUpdate();
//    }
//
//    private void cleanItemBest() throws SQLException {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ITEM_BEST");
//        pstmt.executeUpdate();
//    }
//
//    private void cleanItemLike() throws SQLException {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ITEM_LIKE");
//        pstmt.executeUpdate();
//    }
//
//    private void cleanBasket() throws SQLException {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM BASKET");
//        pstmt.executeUpdate();
//    }
//
//    private void cleanItemBasket() throws SQLException {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ITEM_BASKET");
//        pstmt.executeUpdate();
//    }
//
//    public synchronized void insertData(int numberOfCust, int numberOfItem, int eachItemBasket) throws Exception {
//        // 💥 테이블을 넣을때는 항상 부모부터 넣어야함, 자식은 나중에
//        // 0. cust 채우기 ✅
//        insertDataOnCust(numberOfCust);
//        // 3. item 채우기 ✅
//        insertDataOnItem(numberOfItem);
//        // 4. item_state 채우기
//        insertDataOnItemState(numberOfItem);
//        // 5. item_price 채우기
//        // insertDataOnItemPrice(amount);
//        // 1. basket 채우기
//        insertDataOnBasket(numberOfCust);
//        // 2. item_basket 채우기
//        insertDataOnItemBasket(numberOfCust, eachItemBasket);
//        // 6. item_best 채우기
//        // insertDataOnItemBest(amount);
//        // 7. item_like 채우기
////         insertDataOnItemLike(amount);
//    }
//
//    private void insertDataOnCust(int amount) throws SQLException {
//        Connection conn = ds.getConnection();
//        String sql = "INSERT INTO CUST(id, pwd, name, bef_birth, af_birth, "
//                + "sex, tel_num, mobile_num, email, card_corp,"
//                + "card_num, join_date, quit_date, join_state, recent_login,"
//                + " remark, reg_date, reg_id, up_date, up_id) "
//                + "VALUES(?, ?, ?, 123, '123',"
//                + " 'M', '070-...', '010-...', 'asdf1234@gmail.com', 'kakao',"
//                + " '1234-...', now(), now(), 'Y', now(),"
//                + " '블라블라', now(), 'm1', now(), 'm1')";
//        conn.setAutoCommit(false);
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        for (int i=1; i<=amount; i++) {
//            UserDto user = createUser(i);
//            // id, pwd, name
//            pstmt.setString(1, user.getId());
//            pstmt.setString(2, user.getPwd());
//            pstmt.setString(3, user.getName());
//            pstmt.addBatch();
//            pstmt.clearParameters();
//        }
//        pstmt.executeBatch();
//        conn.commit();
//    }
//
//    public void insertDataOnBasket(int amount) throws SQLException {
//        Connection conn = ds.getConnection();
//        String sql = "INSERT INTO BASKET(id, reg_date, reg_id, up_date, up_id)"
//                + "VALUES(?, now(), 'manager1', now(), 'manager1')";
//        conn.setAutoCommit(false);
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        for (int i=1; i<=amount; i++) {
//            pstmt.setString(1, String.valueOf(i));
//            pstmt.addBatch();
//            pstmt.clearParameters();
//        }
//        pstmt.executeBatch();
//        conn.commit();
//    }
//
//    private void insertDataOnItemBasket(int numberOfCust, int eachItemBasket) throws SQLException {
//        Connection conn = ds.getConnection();
//        String sql = "INSERT INTO ITEM_BASKET(id, num, name, price,"
//                + " qty, opt1, opt2, opt3, coupon_chk,"
//                + " reg_date, reg_id, up_date, up_id)"
//                + "VALUES(?, ?, ?, ?,"
//                + " ?, ?, ?, ?, ?,"
//                + " now(), 'manager1', now(), 'manager1')";
//        conn.setAutoCommit(false);
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//
//        List<ItemDto> store = new ArrayList<>();
//        for (int itemNum = 1; itemNum <= eachItemBasket; itemNum++) {
//            ItemDto item = createItem(itemNum);
//            store.add(item);
//        }
//
//        for (int userId = 1; userId <= numberOfCust; userId++) {
//            for (ItemDto item : store) {
//                pstmt.setString(1, String.valueOf(userId));
//                pstmt.setString(2, item.getNum());
//                pstmt.setString(3, item.getName());
//                pstmt.setInt(4, item.getDisc_price());
//                pstmt.setInt(5, 1);
//                pstmt.setString(6, "L");
//                pstmt.setString(7, "COL1");
//                pstmt.setString(8, "...");
//                pstmt.setString(9, "Y");
//
//                pstmt.addBatch();
//                pstmt.clearParameters();
//            }
//        }
//
//        pstmt.executeBatch();
//        conn.commit();
//
//    }
//
//    private void insertDataOnItem(int amount) throws SQLException {
//        Connection conn = ds.getConnection();
//        String sql = "INSERT INTO ITEM(num, name, price, disc_price, main_img,"
//                + "review_cnt, like_cnt, review_rate, col, reg_date,"
//                + "reg_id, up_date, up_id, item_type, cust_type)"
//                + "VALUES(?, ?, ?, ?, ?,"
//                + " ?, ?, ?, '#123123', now(),"
//                + " 'm1', now(), 'm1', ?, ?)";
//        conn.setAutoCommit(false);
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        for (int i=1; i<=amount; i++) {
//            ItemDto item = createItem(i);
//            // num, name, price, disc_price, main_img, review_cnt, like_cnt, review_rate, item_type, cust_type
//            pstmt.setString(1, item.getNum());
//            pstmt.setString(2, item.getName());
//            pstmt.setInt(3, item.getPrice());
//            pstmt.setInt(4, item.getPrice());
//            pstmt.setString(5, item.getMain_img());
//            pstmt.setInt(6, item.getReview_cnt());
//            pstmt.setInt(7, item.getLike_cnt());
//            pstmt.setDouble(8, item.getReview_rate());
//            pstmt.setString(9, item.getItem_type());
//            pstmt.setString(10, item.getCust_type());
//            pstmt.addBatch();
//            pstmt.clearParameters();
//        }
//        pstmt.executeBatch();
//        conn.commit();
//    }
//
////    private void insertDataOnItemLike(int amount) {
////
////    }
////
////    private void insertDataOnItemBest(int amount) {
////
////    }
////
//    private void insertDataOnItemState(int amount) {
//
//    }
////
////    private void insertDataOnItemPrice(int amount) {
////
////    }
//
//
//
//    public ItemDto createItem(int i) {
//        // 남성 대분류/중분류/소분류
//            // 010101 : 남성 - 상의 - 맨투맨 스웨트 셔츠
//        return new ItemDto(String.valueOf(i), "item"+i, "010101", "M", i*5000,
//                i*5000, "...", i*35, 3.5, i*50, "#1234",
//                null, "manager1", null, "manager1");
//    }
//
//
//    public UserDto createUser(int i) {
//        return new UserDto(String.valueOf(i), "1234", "cust"+i, 1, i, (i % 2 == 0 ? "M" : "W"),
//                "070-2345-5678", "010-2345-5678", "asdfgh12@gmail.com", "kakao", "1234-2345-2345",
//                new Date(), null, "Y", new Date(), "...", new Date(), "manager1", new Date(), "manager1");
//    }
//}
