package com.neo.byez.dao.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class ItemDaoImplTest {

    @Autowired
    ItemDao itemDao;


    @BeforeEach
    public void init() throws Exception {
        // 각 테스트가 종료된 이후 목업 데이터 추가
//        clearDB();
    }

    @AfterEach
    public void clear() throws Exception  {
        // 현재 사용하는 영역의 테이블 모두 비움
//        clearDB();
    }

    @DisplayName("테스트 코드 환경 확인")
    @Test
    public void check() {
        assertNotNull(itemDao);
    }

    // 핵심 기능 테스트
        // 카운트.
            // 성공 -> 수량 증가.
            // 실패 -> 상품이 없음.
            // 예외

        // 조회.
            // 성공 -> 수량 증가.
            // 실패 -> 없는 num., null.
            // 예외

        // 모두 조회.
            // 성공 -> 수량 증가.
            // 실패 -> 상품이 없음.
            // 예외

        // 등록.
            // 성공 -> 수량 증가.
            // 실패 ->
            // 예외 -> not null 위반., pk null., 중복 등록.

        // 수정.
            // 성공 -> 수량 증가.
            // 실패 -> 없는 num.
            // 예외 -> not null 위반.

        // 삭제
            // 성공 -> 수량 증가
            // 실패 -> 없는 num, null
            // 예외 ->


        // 모두 삭제
            // 성공 -> 수량 증가
            // 실패 -> 상품 없음
            // 예외
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 등록1(int n) throws Exception {
//        // given : 상품 n개 생성
//        // when : n개 등록
//        // then : 로우수 1, 카운트 n, 내용 비교
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//        }
//        assertEquals(n, dao.count());
//
//        // 내용 비교
//        List<ItemDto> selectedList = dao.selectAll();
//        for (ItemDto dto : selectedList) {
//            assertEquals(true, list.contains(dto));
//        }
//
//    }
//
//    @DisplayName("1-2. 등록 예외 - not null 위반")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 등록2(int n) throws Exception {
//        // given : 상품 n개 생성(not null 위반)
//        // when : n개 등록
//        // then : 예외 발생
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            dto.setName(null);
//            assertThrows(Exception.class,
//                    () -> {dao.insert(dto);});
//        }
//    }
//
//    @DisplayName("1-3. 등록 예외 - pk null")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 등록3(int n) throws Exception {
//        // given : 상품 n개 생성(pk null)
//        // when : n개 등록
//        // then : 예외 발생
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            dto.setNum(null);
//            assertThrows(Exception.class,
//                    () -> {dao.insert(dto);});
//        }
//    }
//
//    @DisplayName("1-4. 등록 예외 - 중복 등록")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 등록4(int n) throws Exception {
//        // given : 상품 n개 생성
//        // when : n개 여러번 등록
//        // then : 첫번째 로우수 1, 그 이후 예외
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//            assertThrows(Exception.class,
//                    () -> {dao.insert(dto);});
//        }
//
//        assertEquals(n, dao.count());
//
//        // 내용 비교
//        List<ItemDto> selectedList = dao.selectAll();
//        for (ItemDto dto : selectedList) {
//            assertEquals(true, list.contains(dto));
//        }
//    }
//
//    @DisplayName("1-5. 등록 예외 - 칼럼 제약 조건 위반(상품명 길이 초과)")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 등록5(int n) throws Exception {
//        // given : 상품 n개 생성
//        // when : n개 여러번 등록
//        // then : 첫번째 로우수 1, 그 이후 예외
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            dto.setName("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//            list.add(dto);
//            assertThrows(Exception.class,
//                    () -> {dao.insert(dto);});
//        }
//    }
//
//
//    @DisplayName("2-1. 조회 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 조회1(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : n개 모두 조회
//        // then : null 아님 확인, 내용 비교
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//            ItemDto selectedDto = dao.select(dto.getNum());
//            assertNotEquals(null, selectedDto);
//            assertEquals(dto, selectedDto);
//        }
//    }
//
//    @DisplayName("2-2. 조회 실패 - 없는 num")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 조회2(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 없는 num으로 조회
//        // then : null 확인
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//            dto.setNum("xxx");
//            ItemDto selectedDto = dao.select(dto.getNum());
//            assertEquals(null, selectedDto);
//        }
//    }
//
//
//    @DisplayName("2-3. 조회 실패 - pk null")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 조회3(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : num이 null로 조회
//        // then : null 확인
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//            dto.setNum(null);
//            ItemDto selectedDto = dao.select(dto.getNum());
//            assertEquals(null, selectedDto);
//        }
//    }
//
//    @DisplayName("3-1. 모두 조회 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두조회1(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 모두 조회
//        // then : 길이 비교 n, 내용 비교
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//        }
//
//        List<ItemDto> selectedList = dao.selectAll();
//        assertEquals(n, selectedList.size());
//        for (ItemDto dto : selectedList) {
//            assertEquals(true, list.contains(dto));
//        }
//    }
//
//    @DisplayName("3-2. 모두 조회 실패 - 상품 없음")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두조회2(int n) throws Exception {
//        // given :
//        // when : 모두 조회
//        // then : null 확인
//        List<ItemDto> selectedList = dao.selectAll();
//        assertEquals(0, selectedList.size());
//    }
//
//    @DisplayName("4-1. 카운트 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 카운트1(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 카운트
//        // then : n인지 확인
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//        }
//        assertEquals(n, dao.count());
//
//    }
//
//    @DisplayName("4-2. 카운트 실패 - 상품 없음")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 카운트2(int n) throws Exception {
//        // given :
//        // when : 카운트
//        // then : 0인지 확인
//        assertEquals(0, dao.count());
//    }
//
//    @DisplayName("5-1. 수정 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 수정1(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 각각 모두 수정
//        // then : 로우수 1, 내용 비교
//
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//        }
//
//        list.stream().forEach(dto -> {
//            dto.setName("new Name");
//            dto.setPrice(100);
//            dto.setDisc_price(100);
//        });
//
//
//        for (ItemDto dto : list) {
//            assertEquals(1, dao.update(dto));
//        }
//
//        List<ItemDto> selectedList = dao.selectAll();
//        for (ItemDto dto : selectedList) {
//            assertEquals(true, list.contains(dto));
//        }
//
//
//    }
//
//    @DisplayName("5-2. 수정 실패 - 없는 num")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 수정2(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 각각 모두 수정(없는 num)
//        // then : 로우수 0
//
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//        }
//
//        List<ItemDto> updateList = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            dto.setNum("xxx");
//            dto.setPrice(0);
//            dto.setDisc_price(0);
//            dto.setNum("new name");
//            updateList.add(dto);
//            assertEquals(0, dao.update(dto));
//        }
//
//        List<ItemDto> selectedList = dao.selectAll();
//        for (ItemDto dto : selectedList) {
//            assertEquals(false, updateList.contains(dto));
//        }
//    }
//
//    @DisplayName("5-3. 수정 예외 - not null 위반")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 수정3(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 각각 모두 수정(not null 위반)
//        // then : 로우수 0
//
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//        }
//
//        List<ItemDto> updateList = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            dto.setNum("xxx");
//            dto.setNum(null);
//            updateList.add(dto);
//            assertEquals(0, dao.update(dto));
//        }
//
//        List<ItemDto> selectedList = dao.selectAll();
//        for (ItemDto dto : selectedList) {
//            assertEquals(false, updateList.contains(dto));
//        }
//    }
//
//    @DisplayName("6-1. 삭제 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 삭제1(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 각각 모두 삭제
//        // then : 로우수 1, 카운트 0
//
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (ItemDto dto : list) {
//            assertEquals(1, dao.delete(dto));
//        }
//        assertEquals(0, dao.count());
//    }
//
//    @DisplayName("6-2. 삭제 실패 - 없는 num")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 삭제2(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 각각 모두 삭제(없는 num)
//        // then : 로우수 0
//
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//            dto.setNum("xxx");
//        }
//
//        for (ItemDto dto : list) {
//            assertEquals(0, dao.delete(dto));
//        }
//        assertEquals(n, dao.count());
//    }
//
//    @DisplayName("6-3. 삭제 실패 - num이 null")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 삭제3(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 각각 모두 삭제(num이 null)
//        // then : 로우수 0
//
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//            dto.setNum(null);
//        }
//
//        for (ItemDto dto : list) {
//            assertEquals(0, dao.delete(dto));
//        }
//        assertEquals(n, dao.count());
//    }
//
//    @DisplayName("7-1. 모두 삭제 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두삭제1(int n) throws Exception {
//        // given : 상품 n개 생성 및 등록
//        // when : 모두 삭제
//        // then : 로우수 n, 카운트 0
//
//        List<ItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            ItemDto dto = createItem(i);
//            list.add(dto);
//            assertEquals(1, dao.insert(dto));
//        }
//        assertEquals(n, dao.deleteAll());
//        assertEquals(0, dao.count());
//    }
//
//    @DisplayName("7-2. 모두 삭제 실패 - 상품 없음")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 모두삭제2(int n) throws Exception {
//        // given :
//        // when : 모두 삭제
//        // then : 로우수 0
//        assertEquals(0, dao.deleteAll());
//    }
//
//    @DisplayName("8-1. 카테고리 상품 조회 - 성공")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 카테고리_상품_조회(int n) throws Exception {
//        // given : 데이터 생성 및 저장, 카테고리 문자열 -> 카테고리 객체
//        // when : dao로 카테고리 상품 조회
//        // then : 길이 및 내용 비교
//        Category category = new Category("01");
//        List<ItemDto> selectedList = dao.selectItemType(category);
//        assertEquals(10, selectedList.size());
//
//    }
//
//    @DisplayName("8-2. 카테고리 상품 조회 - 실패")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 카테고리_상품_실패(int n) throws Exception {
//        // given : 데이터 생성 및 저장, 카테고리 문자열 -> 카테고리 객체
//        // when : dao로 카테고리 상품 조회
//        // then : 길이 및 내용 비교
//        Category category = new Category("xxx");
//        List<ItemDto> selectedList = dao.selectItemType(category);
//        assertNotEquals(10, selectedList.size());
//
//    }
//
//
//    @DisplayName("8-1. 카테고리 상품 조회 - 성공")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_상태_등록_성공(int n) throws Exception {
//        // given : 데이터 생성 및 저장, 카테고리 문자열 -> 카테고리 객체
//        // when : dao로 카테고리 상품 조회
//        // then : 길이 및 내용 비교
//        ItemStateDto dto = new ItemStateDto();
//        dto.setNum("1");
//        dto.setSales_qty(0);
//        dto.setView_cnt(0);
//        dto.setStock_qty(1000);
//        dto.setState_cede("SLA1");
//        assertEquals(1, dao.insertItemState(dto));
//
//    }
//
//    @DisplayName("8-2. 카테고리 상품 조회 - 실패")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_상태_등록_실패(int n) throws Exception {
//        // given : 데이터 생성 및 저장, 카테고리 문자열 -> 카테고리 객체
//        // when : dao로 카테고리 상품 조회
//        // then : 길이 및 내용 비교
//        Category category = new Category("xxx");
//        List<ItemDto> selectedList = dao.selectItemType(category);
//        assertNotEquals(10, selectedList.size());
//
//    }
//
//    @DisplayName("8-1. 카테고리 상품 조회 - 성공")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_가격_등록_성공(int n) throws Exception {
//        // given : 데이터 생성 및 저장, 카테고리 문자열 -> 카테고리 객체
//        // when : dao로 카테고리 상품 조회
//        // then : 길이 및 내용 비교
//        Category category = new Category("01");
//        List<ItemDto> selectedList = dao.selectItemType(category);
//        assertEquals(10, selectedList.size());
//
//    }
//
//    @DisplayName("8-2. 카테고리 상품 조회 - 실패")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_가격_등록_실패(int n) throws Exception {
//        // given : 데이터 생성 및 저장, 카테고리 문자열 -> 카테고리 객체
//        // when : dao로 카테고리 상품 조회
//        // then : 길이 및 내용 비교
//        Category category = new Category("xxx");
//        List<ItemDto> selectedList = dao.selectItemType(category);
//        assertNotEquals(10, selectedList.size());
//
//    }
//
//
//
//
//    private void clearDB() throws Exception {
//        clearItem();
//    }
//
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
//
//    private void insertData(int n) throws Exception {
//        clearDB();
//        insertItem(n);
//    }
//
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


}