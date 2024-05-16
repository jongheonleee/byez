package com.neo.byez.service.item;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class LikeItemServiceImpTest {

    @Autowired
    LikeItemService service;

    @Autowired
    DataSource ds;

    @BeforeEach
    public void init() throws Exception {
//        clearDB();
    }

    @AfterEach
    public void clear() throws Exception {
//        clearDB();
    }

    @DisplayName("테스트 코드 환경 확인")
    @Test
    public void check() {
        assertNotNull(ds);
        assertNotNull(service);
    }

    // 등록
        // 성공 -> 수량 늘리면서 테스트
        // 실패 ->
        // 예외 -> not null 제약 조건 위반, pk null, 존재하지 않는 유저, 존재하지 않는 상품 번호

    // 모두 조회
        // 성공 -> 수량 늘리면서 테스트
        // 실패 -> 존재하지 않는 유저, 존재하지 않는 상품 번호, id, num null
        // 예외 ->

    // 삭제
        // 성공 -> 수량 늘리면서 테스트
        // 실패 -> 존재하지 않는 유저, 존재하지 않는 상품 번호, pk null
        // 예외 ->

    // 모두 삭제
        // 성공 -> 수량 늘리면서 테스트
        // 실패 -> 존재하지 않는 유저, id null
        // 예외 ->

    // 수정
        // 성공 -> 수량 늘리면서 테스트
        // 실패 -> 존재하지 않는 유저, 존재하지 않는 상품 번호
        // 예외 -> not null 제약 조건 위반


//    @DisplayName("1-1. 등록 성공 - 수량 늘리면서 테스트")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 등록1(int n) throws Exception {
//        // given : n개 상품 생성
//        // when : 아이디가 1인 유저에 모두 좋아요 상품으로 등록
//        // then : 적용된 로우수 1, 카운트 했을 때 n, 내용비교
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        List<LikeItemDto> selectedList = service.getLikeItem(id);
//        assertEquals(list.size(), selectedList.size());
//        for (LikeItemDto dto : list) {
//            assertEquals(true, selectedList.contains(dto));
//        }
//    }
//
//    @DisplayName("1-2. 등록 예외 - not null 제약 조건 위반")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 등록2(int n) throws Exception {
//        // given : n개 상품 생성
//        // when : 아이디가 1인 유저에 모두 좋아요 상품으로 등록, 이때 dto에 null 처리
//        // then : 예외 발생
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setName(null);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto :list) {
//            assertThrows(Exception.class, () -> {
//                service.register(dto);
//            });
//        }
//    }
//
//    @DisplayName("1-3. 등록 예외 - id/num 가 존재하지 않음")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 등록3(int n) throws Exception {
//        // given : n개 상품 생성
//        // when : 존재하지 않는 유저에 모두 좋아요 상품으로 등록/ 유저 1에 존재하지 않는 상품 번호로 등록
//        // then : 예외 발생
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId("xxx");
//            dto.setNum("xxx");
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto :list) {
//            assertThrows(Exception.class, () -> {
//                service.register(dto);
//            });
//        }
//    }
//
//    @DisplayName("2-1. 삭제 성공 - 수량 늘리면서 테스트")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 삭제1(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : 각 제품 삭제 실행
//        // then : 적용된 로우수 1, 카운트 0
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        List<LikeItemDto> selectedList = service.getLikeItem(id);
//        for (LikeItemDto dto : selectedList) {
//            assertEquals(1, service.remove(dto));
//        }
//
//        selectedList = service.getLikeItem(id);
//        assertEquals(0, selectedList.size());
//
//
//    }
//
//    @DisplayName("2-2. 삭제 실패 - id/num 가 존재하지 않음")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 삭제2(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : 없는 유저 아이디로 삭제/ 없는 상품 번호로 삭제
//        // then : 적용된 로우수 0, 카운트 n
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        List<LikeItemDto> selectedList = service.getLikeItem(id);
//        for (LikeItemDto dto : selectedList) {
//            dto.setId("xxx");
//            dto.setNum("xxx");
//            assertEquals(0, service.remove(dto));
//        }
//
//        selectedList = service.getLikeItem(id);
//        assertEquals(n, selectedList.size());
//    }
//
//    @DisplayName("2-3. 삭제 실패 - id/num 가 null")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 삭제3(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : id/num 각각 null 처리하고 삭제
//        // then : 적용된 로우수 0, 카운트 n
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        List<LikeItemDto> selectedList = service.getLikeItem(id);
//        for (LikeItemDto dto : selectedList) {
//            dto.setId(null);
//            dto.setNum(null);
//            assertEquals(0, service.remove(dto));
//        }
//
//        selectedList = service.getLikeItem(id);
//        assertEquals(n, selectedList.size());
//    }
//
//    @DisplayName("3-1. 모두 삭제 성공 - 수량 늘리면서 테스트")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두삭제1(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : 모두 삭제 실행
//        // then : 적용된 로우수 n, 카운트 0
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        assertEquals(n, service.removeAll(id));
//        List<LikeItemDto> selectedList = service.getLikeItem(id);
//        assertEquals(0, selectedList.size());
//
//    }
//
//    @DisplayName("3-2. 모두 삭제 실패 - id/num 가 존재하지 않음")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두삭제2(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : id 존재하지 않는 값으로 처리하고 모두 삭제
//        // then : 적용된 로우수 0, 카운트 n
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        assertEquals(0, service.removeAll("xxx"));
//        List<LikeItemDto> selectedList = service.getLikeItem(id);
//        assertEquals(n, selectedList.size());
//    }
//
//    @DisplayName("3-3. 모두 삭제 실패 - id/num 가 null")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두삭제3(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : id null 처리하고 모두 삭제
//        // then : 적용된 로우수 0, 카운트 n
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        assertEquals(0, service.removeAll(null));
//        List<LikeItemDto> selectedList = service.getLikeItem(id);
//        assertEquals(n, selectedList.size());
//    }
//
//    @DisplayName("4-1. 모두 조회 성공 - 수량 늘리면서 테스트")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두조회1(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : 조회
//        // then : 리스트 길이 n, 내용 비교
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        List<LikeItemDto> selectedList = service.getLikeItem(id);
//        assertEquals(list.size(), selectedList.size());
//
//        for (LikeItemDto dto : list) {
//            assertEquals(true, selectedList.contains(dto));
//        }
//    }
//
//    @DisplayName("4-2. 모두 조회 실패 - id/num 가 존재하지 않음")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두조회2(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : id/num이 존재하지 않는 값으로 처리
//        // then : 리스트 길이 0
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        List<LikeItemDto> selectedList = service.getLikeItem("xxx");
//        assertEquals(0, selectedList.size());
//
//    }
//
//    @DisplayName("4-3. 모두 조회 실패 - id/num이 null")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두조회3(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : id/num이 null인 경우
//        // then : 리스트 길이 0
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//        }
//
//        List<LikeItemDto> selectedList = service.getLikeItem(null);
//        assertEquals(0, selectedList.size());
//    }
//
//    @DisplayName("5-1. 수정 성공 - 수량 늘리면서 테스트")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 수정1(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : 특정 필드값 변경, 수정
//        // then : 적용된 로우수 1, 내용 비교
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//            dto.setPrice(1000);
//            dto.setDisc_price(500);
//            assertEquals(1, service.modify(dto));
//        }
//
//        List<LikeItemDto> selectedList = service.getLikeItem(id);
//        for (LikeItemDto dto : list) {
//            assertEquals(true, selectedList.contains(dto));
//        }
//    }
//
//    @DisplayName("5-2. 수정 실패 - id/num이 존재하지 않음")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 수정2(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : id/num이 존재하지 않는 값으로 세팅, 수정
//        // then : 적용된 로우수 0
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//            dto.setPrice(1000);
//            dto.setDisc_price(500);
//            dto.setId("xxx");
//            dto.setNum("xxx");
//            assertEquals(0, service.modify(dto));
//        }
//
//    }
//
//    @DisplayName("5-2. 수정 실패 - not null 제약 조건 위반")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 수정3(int n) throws Exception {
//        // given : n개 상품 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : id/num이 null 값으로 처리, 수정
//        // then : 예외 발생
//
//        insertData(n);
//        String id = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, service.register(dto));
//            dto.setPrice(1000);
//            dto.setDisc_price(500);
//            dto.setId(null);
//            dto.setNum(null);
//            assertEquals(0, service.modify(dto));
//        }
//    }
//
//
//
//    private void clearDB() throws Exception {
//        clearLikeItem();
//        clearItem();
//        clearCust();
//    }
//
//    private void clearCust() throws Exception {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM CUST");
//        pstmt.executeUpdate();
//    }
//
//    private void clearLikeItem() throws Exception {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ITEM_LIKE");
//        pstmt.executeUpdate();
//    }
//
//    private void clearItem() throws Exception {
//        Connection conn = ds.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ITEM");
//        pstmt.executeUpdate();
//    }
//
//    private ItemDto createItem(int i) {
//        String num = String.valueOf(i);
//        String name = "item" + String.valueOf(i);
//        String itemType = "item-type" + String.valueOf(i);
//        String custType = "cust-type" + String.valueOf(i);
//        int price = i * 10000;
//        int discPrice = i * 7000;
//        String mainImg = "...";
//        int reviewCnt = i * 500;
//        double reviewRate = 3.5;
//        int likeCnt = i * 50;
//        String col = "#1234";
//
//        return new ItemDto(num, name, itemType, custType, price,
//                discPrice, mainImg, reviewCnt, reviewRate, likeCnt, col,
//                null, "manager1", null, "manager1");
//    }
//
//    private UserDto createUser(int i) {
//        return new UserDto(String.valueOf(i), "1234", "cust"+i, 1, i, (i % 2 == 0 ? "M" : "W"),
//                "070-2345-5678", "010-2345-5678", "asdfgh12@gmail.com", "kakao", "1234-2345-2345",
//                new Date(), null, "Y", new Date(), "...", new Date(), "manager1", new Date(), "manager1");
//    }
//
//    private void insertData(int n) throws Exception {
//        clearDB();
//        insertItem(n);
//        insertCust(1);
//    }
//
//    private void insertCust(int n) throws Exception {
//        Connection conn = ds.getConnection();
//        String sql = "INSERT INTO CUST(id, pwd, name, bef_birth, af_birth, "
//                + "sex, tel_num, mobile_num, email, card_corp,"
//                + "card_num, join_date, quit_date, join_state, recent_login,"
//                + " remark, reg_date, reg_id, up_date, up_id) "
//                + "VALUES(?, ?, ?, 123, '123',"
//                + " 'M', '070-...', '010-...', 'asdf1234@gmail.com', 'kakao',"
//                + " '1234-...', now(), now(), 'Y', now(),"
//                + " '블라블라', now(), 'm1', now(), 'm1')";
//
//        conn.setAutoCommit(false);
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//
//        for (int i=1; i<=n; i++) {
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
//
//    private void insertItem(int n) throws Exception {
//        Connection conn = ds.getConnection();
//
//        String sql = "INSERT INTO ITEM(num, name, price, disc_price, main_img,"
//                + "review_cnt, like_cnt, review_rate, col, reg_date,"
//                + "reg_id, up_date, up_id, item_type, cust_type)"
//                + "VALUES(?, ?, ?, ?, ?,"
//                + " ?, ?, ?, '#123123', now(),"
//                + " 'm1', now(), 'm1', ?, ?)";
//
//        conn.setAutoCommit(false);
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//
//        for (int i=1; i<=n; i++) {
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
//
//        pstmt.executeBatch();
//        conn.commit();
//    }
//
//    private LikeItemDto createLikeItem(int i) {
//        String id = String.valueOf(i);
//        String num = String.valueOf(i);
//        String name = "item" + String.valueOf(i);
//        String type = "type" + String.valueOf(i);
//        int price = i * 10000;
//        int discPrice = i * 7000;
//        String itemComt = "this item is ...";
//        String mainImg = "...";
//        int reviewCnt = i * 500;
//        int likeCnt = i * 50;
//        String stateCode = "SLA" + String.valueOf(i);
//        String comt = ".....";
//        Date regDate = null;
//        String regId = "manager";
//        Date upDate = null;
//        String upId = "manager";
//
//        return new LikeItemDto(id, num, name, type, price,
//                discPrice, itemComt, mainImg, reviewCnt, likeCnt,
//                stateCode, comt, regDate, regId, upDate, upId);
//    }
//
//



}