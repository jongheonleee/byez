package com.neo.byez.service.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.neo.byez.dao.item.ItemDaoImpl;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class ItemServiceImplTest {

    @Autowired
    ItemDaoImpl dao;

    @Autowired
    ItemServiceImpl service;

    @BeforeEach
    public void 초기_환경_비우기() throws Exception {
        dao.deleteAll();
    }

    @AfterEach
    public void 비우기() throws Exception  {
        dao.deleteAll();
    }

    @DisplayName("테스트 코드 환경 확인")
    @Test
    public void 테스트_환경_테스트() {
        assertNotNull(dao);
        assertNotNull(service);
    }

    // 핵심 기능 테스트
        // 상품 수량 카운트
            // 성공 - 수량 증가., 중간에 몇개 삭제하고 카운트.
            // 실패
            // 예외

        // 상품 모두 조회
            // 성공 - 수량 증가., 중간에 몇개 삭제하고 조회., 중간에 몇개 수정하고 조회.
            // 실패
            // 예외

        // 상품 단건 조회
            // 성공 - 수량 증가., 조회-삭제-조회., 조회-삭제-등록-조회., 조회-수정-조회.
            // 실패
            // 예외 - num이 없음., null임.

        // 상품 수정
            // 성공 - 수량 증가., 여러번 수정.
            // 실패 -
            // 예외 - num이 없는 값., null., not null 위반.

        // 상품 삭제
            // 성공 - 수량 증가., 같은 상품 여러번 삭제
            // 실패
            // 예외 - num이 없는 값., null.

        // 상품 모두 삭제
            // 성공 - 수량 증가
            // 실패
            // 예외
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_수량_카운트1(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 카운트
//        // then : n
//        insertItem(n);
//        assertEquals(n, service.getCount());
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @Test
//    public void 상품_수량_카운트2() throws Exception {
//        // given :
//        // when : 카운트
//        // then : 0
//        assertEquals(0, service.getCount());
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_모두_조회1(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 조회
//        // then : 길이 n, 내용 비교
//        List<ItemDto> createdList = insertItem(n);
//        List<ItemDto> selectedList = service.getAllItem();
//
//        assertEquals(n, selectedList.size());
//        assertEquals(createdList.size(), selectedList.size());
//
//        for (ItemDto dto : selectedList) {
//            assertTrue(createdList.contains(dto));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {2, 10, 25, 50, 100})
//    public void 상품_모두_조회2(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 중간에 n/2개 삭제하고 조회
//        // then : 길이 n-k
//        int k = n/2, t = 0;
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            service.remove(dto);
//            t++;
//            if (k == t) break;
//        }
//
//        List<ItemDto> selectedList = service.getAllItem();
//        assertEquals(n-k, selectedList.size());
//
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_모두_조회3(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 중간에 몇개 수정하고 조회
//        // then : 길이 n
//        int k = n/2, t = 1;
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setName("new name");
//            service.modify(dto);
//            t++;
//            if (k == t) break;
//        }
//
//        List<ItemDto> selectedList = service.getAllItem();
//        assertEquals(n, selectedList.size());
//        assertEquals(createdList.size(), selectedList.size());
//
//        for (ItemDto dto : selectedList) {
//            assertTrue(createdList.contains(dto));
//        }
//
//    }
//
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_단건_조회1(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 단건 조회
//        // then : 내용 비교
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            String num = dto.getNum();
//            ItemDto selectedDto = service.getItem(num);
//            assertEquals(dto, selectedDto);
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_단건_조회2(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 조회-삭제-조회
//        // then : 실패
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            assertEquals(dto, service.getItem(dto.getNum()));
//            assertTrue(service.remove(dto));
//            assertThrows(Exception.class, () -> service.getItem(dto.getNum()));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_단건_조회3(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 조회-삭제-등록-조회
//        // then : 성공
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            String num = dto.getNum();
//            assertEquals(dto, service.getItem(num));
//            assertTrue(service.remove(dto));
//            assertTrue(service.add(dto));
//            assertEquals(dto, service.getItem(num));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_단건_조회4(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 조회-수정-조회
//        // then : 성공
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            String num = dto.getNum();
//            assertEquals(dto, service.getItem(num));
//            dto.setName("new name");
//            assertTrue(service.modify(dto));
//            assertEquals(dto, service.getItem(num));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_단건_조회5(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : num이 없음
//        // then : 실패
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setNum("xxx");
//            assertThrows(Exception.class, () -> service.getItem(dto.getNum()));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_단건_조회6(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : num이 null임
//        // then : 실패
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setNum(null);
//            assertThrows(Exception.class, () -> service.getItem(dto.getNum()));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_수정1(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 수정
//        // then : 성공, 내용 비교
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setName("new name");
//            assertTrue(service.modify(dto));
//            assertEquals(dto, service.getItem(dto.getNum()));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_수정2(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 여러번 수정
//        // then : 성공
//
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setName("new name");
//            assertTrue(service.modify(dto));
//
//            dto.setPrice(1000);
//            assertTrue(service.modify(dto));
//
//            dto.setCol("new color");
//            assertTrue(service.modify(dto));
//
//            assertEquals(dto, service.getItem(dto.getNum()));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_수정3(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : num이 없는 값 수정
//        // then : 실패
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setNum("xxx");
//            dto.setName("new name");
//            assertThrows(Exception.class, () -> service.modify(dto));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_수정4(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : num이 null 수정
//        // then : 실패
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setNum(null);
//            dto.setName("new name");
//            assertThrows(Exception.class, () -> service.modify(dto));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_수정5(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : not null 위반 수정
//        // then : 실패
//
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setName(null);
//            assertThrows(Exception.class, () -> service.modify(dto));
//        }
//    }
//
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_삭제1(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 삭제
//        // then : 성공, 카운트 0, 조회 실패
//
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            assertTrue(service.remove(dto));
//        }
//
//        assertEquals(0, service.getCount());
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_삭제2(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 같은 상품 여러번 삭제
//        // then : 첫번째 성공 그이후 실패, 카운트 n-1, 조회 실패
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            assertTrue(service.remove(dto));
//            assertThrows(Exception.class, () -> service.remove(dto));
//        }
//
//        assertEquals(0, service.getCount());
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_삭제3(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 없는 num으로 삭제
//        // then : 예외, 카운트 n, 조회 성공
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setNum("xxx");
//            assertThrows(Exception.class, () -> service.remove(dto));
//        }
//    }
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_삭제4(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : null로 삭제
//        // then : 실패, 카운트 n, 조회 성공
//
//        List<ItemDto> createdList = insertItem(n);
//
//        for (ItemDto dto : createdList) {
//            dto.setNum(null);
//            assertThrows(Exception.class, () -> service.remove(dto));
//        }
//    }
//
//
//    @DisplayName("1-1. 등록 성공 - 수량 증가")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록할 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 10, 25, 50, 100})
//    public void 상품_모두_삭제1(int n) throws Exception {
//        // given : n개 더미 데이터 생성
//        // when : 모두 삭제
//        // then : 성공, 카운트 0
//        insertItem(n);
//        assertTrue(service.removeAll());
//        assertEquals(0, service.getCount());
//    }
//
//
//    private ItemDto 더미_데이터_생성(int i) {
//        String num = String.valueOf(i);
//        String name = "item" + i;
//        String itemType = "item-type" + i;
//        String custType = "cust-type" + i;
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
//    private List<ItemDto> insertItem(int amount) throws Exception {
//        List<ItemDto> list = new ArrayList<>();
//
//        for (int i=1; i<=amount; i++) {
//            ItemDto dto = 더미_데이터_생성(i);
//            dao.insert(dto);
//            list.add(dto);
//        }
//
//        return list;
//    }
//
//    private List<ItemDto> createList(int amount) throws Exception {
//        List<ItemDto> list = new ArrayList<>();
//
//        for (int i=1; i<=amount; i++) {
//            ItemDto dto = 더미_데이터_생성(i);
//            list.add(dto);
//        }
//
//        return list;
//    }



}