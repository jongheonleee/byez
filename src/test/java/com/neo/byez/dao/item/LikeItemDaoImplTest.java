package com.neo.byez.dao.item;


import static org.junit.jupiter.api.Assertions.*;

import com.neo.byez.dao.user.UserDaoImpl;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.LikeItemDto;
import com.neo.byez.domain.user.UserDto;
import java.util.Date;
import java.util.List;

import com.neo.byez.domain.user.UserDto;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class LikeItemDaoImplTest {


    @Autowired
    UserDaoImpl userDao;

    @Autowired
    ItemDaoImpl itemDao;

    @Autowired
    LikeItemDaoImpl likeDao;


    @Before
    public void 주입_테스트() {
        assertNotNull(userDao);
        assertNotNull(itemDao);
        assertNotNull(likeDao);
    }

    @BeforeEach
    public void init() throws Exception {
        // 각 테스트가 종료된 이후 목업 데이터 추가
    }

    @Test
    public void 더미_데이터_생성() throws Exception {
        // 페이징 처리 확인
            // 유저 1명, 상품 200개, 좋아요 상품 200개
            // 페이징 < 1 2 ... 10 >
            // 마지막 17

        // 데이터 비우기
        List<UserDto> users = userDao.selectUserAll();
        for (UserDto user : users) {
            likeDao.deleteAll(user.getId());
        }

        userDao.deleteAllUser();
        itemDao.deleteAll();

        // 유저 1명 생성
        for (int i = 1; i <= 1; i++) {
            UserDto user = new UserDto("user" + i, "password" + i, "name" + i, 999999, 1, "M", 12345678, 1012345678, "test"+i+"@example.com", "user" + i, "user" + i);
            userDao.insertUser(user);
        }

        // 상품 200개 생성
        for (int i = 1; i <= 200; i++) {
            ItemDto item = createItem(i);
            itemDao.insert(item);
        }

        // 좋아요 상품 200개 등록
        UserDto user = userDao.selectUser("user1");
        for (int i = 1; i <= 200; i++) {
            LikeItemDto likeItem = createLikeItem(i);
            likeItem.setId(user.getId());
            likeDao.insert(likeItem);
        }

    }

    @Test
    public void 유저_상품_페이지_조회() throws Exception {
        // 유저 1, 상품 200, 좋아요 상품 200
        // offSet : 48, pageSize : 12
        // 12개 들고오는지 확인
//        List<LikeItemDto> likeItems = likeDao.selectPage(48, 12);
//        assertEquals(12, likeItems.size());

        int num = 152;
//        for (LikeItemDto likeItem : likeItems) {
//            assertEquals(String.valueOf(num), likeItem.getNum());
//            num--;
//        }
    }


//    @AfterEach
//    public void clear() throws Exception  {
//        // 현재 사용하는 영역의 테이블 모두 비움
//        clearDB();
//    }
//
//    @DisplayName("테스트 코드 환경 확인")
//    @Test
//    public void check() {
//        assert(dao != null);
//        assert(ds != null);
//    }
//
//    // 기능 테스트
//    // 좋아요 상품 등록
//        // 등록
//            // 성공 -> 수량 늘리기(1, 20, 50, 100)
//            // 실패 ->
//            // 예외 -> pk null, 존재하지 않는 사용자 아이디, 존재하지 않는 상품 번호, not null 컬럼 null, 같은 상품 중복 등록
//
//        // 삭제
//            // 성공 -> 수량 늘리기(1, 20, 50, 100)
//            // 실패 -> 존재하지 않는 사용자 아이디, 존재하지 않는 상품 번호, 같은 상품 중복 삭제, pk null
//            // 예외 ->
//
//        // 모두 삭제
//            // 성공 -> 수량 늘리기(1, 20, 50, 100)
//            // 실패 -> 존재하지 않는 사용자 아이디, pk null(id),
//            // 예외 ->
//
//
//        // 조회
//            // 성공 -> 수량 늘리기(1, 20, 50, 100)
//            // 실패 -> 존재하지 않는 사용자 아이디, 존재하지 않는 상품 번호, pk null, not null 컬럼 null
//            // 예외 ->
//
//        // 모두 조회
//            // 성공 -> 수량 늘리기(1, 20, 50, 100)
//            // 실패 -> 존재하지 않는 사용자 아이디, pk null
//            // 예외 ->
//
//        // 수정
//            // 성공 -> 수량 늘리기(1, 20, 50, 100)
//            // 실패 -> 존재하지 않는 사용자 아이디, 존재하지 않는 상품 번호
//            // 예외 -> pk null, not null 컬럼 null
//
//    @DisplayName("더미 데이터 넣기")
//    @Test
//    public void 더미_데이터_넣기() throws Exception {
//        insertData(10);
//        String id = "1";
//
//        for (int i=1; i<=10; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            assertEquals(1, dao.insert(dto));
//        }
//    }
//
//    @DisplayName("1-1. 좋아요 상품 등록 성공 - 사용자가 여러 상품을 좋아요 상품으로 등록")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 20, 50, 100})
//    public void test1(int n) throws Exception {
//        // given : n개 상품 데이터 및 좋아요 데이터 생성
//        // when : dao를 통해 넣기
//        // then : 적용된 로우수 1, 개수 및 내용 비교
//        insertData(n);
//        String userId = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(userId);
//            list.add(dto);
//        }
//
//        // 적용된 로우수 확인
//        for (LikeItemDto dto : list) {
//            assertEquals(1, dao.insert(dto));
//        }
//
//        // 전체 개수 확인
//        assertEquals(n, dao.count(userId));
//
//        // 전체 등록된 상품 내용 비교
//        for (LikeItemDto dto : list) {
//            LikeItemDto selectedDto = dao.select(dto);
//            assertEquals(dto, selectedDto);
//        }
//    }
//
//    @DisplayName("1-2. 좋아요 상품 등록 예외 - 존재하지 않는 사용자로 여러 상품을 등록")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 20, 50, 100})
//    public void test2(int n) throws Exception {
//        // given : n개 데이터 생성, 존재하지 않는 아이디 정의
//        // when : dao를 통해 넣기
//        // then : 적용된 로우수 0 확인
//        String userId = "xxx";
//        insertData(n);
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(userId);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertThrows(DataIntegrityViolationException.class, () -> {
//                dao.insert(dto);
//            });
//        }
//    }
//
//    @DisplayName("1-3. 좋아요 상품 등록 예외 - 사용자가 존재하지 않는 상품을 등록")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 20, 50, 100})
//    public void test3(int n) throws Exception {
//        // given : n개 데이터 생성, 존재하지 않는 아이디 정의
//        // when : dao를 통해 넣기
//        // then : 예외 발생 여부 확인
//        String userId = "1";
//        String itemNum = "-1";
//        insertData(n);
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(userId);
//            dto.setNum(itemNum);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertThrows(DataIntegrityViolationException.class, () -> {
//                dao.insert(dto);
//            });
//        }
//    }
//
//
//
//    @DisplayName("1-4. 좋아요 상품 등록 예외 - 칼럼 not null 제약 위반(id나 num이 null)")
//    @Test
//    public void test4() {
//        // given : n개 데이터 생성, id나 num이 null
//        // when : dao를 통해 넣기
//        // then : 예외 발생 여부 확인
//        LikeItemDto dto = createLikeItem(1);
//        dto.setName(null);
//        assertThrows(DataIntegrityViolationException.class, () -> {
//            dao.insert(dto);
//        });
//
//        dto.setId("1");
//        dto.setNum(null);
//        assertThrows(DataIntegrityViolationException.class, () -> {
//            dao.insert(dto);
//        });
//
//    }
//
//    @DisplayName("1-5. 좋아요 상품 등록 예외 - 사용자가 같은 상품을 여러번 등록")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints = {1, 20, 50, 100})
//    public void test5(int n) throws Exception {
//        // given : n개 데이터 생성(존재하지 않는 상품)
//        // when : dao를 통해 넣기
//        // then : 처음에 적용된 로우수 1, 그 이후에는 예외 확인, 개수 및 내용 비교
//        insertData(n);
//        String userId = "1";
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(userId);
//            list.add(dto);
//        }
//
//        // 처음에 적용된 로우수 1, 그 이후에는 예외 발생
//        for (LikeItemDto dto : list) {
//            assertEquals(1, dao.insert(dto));
//            assertThrows(DataIntegrityViolationException.class, () -> {
//                dao.insert(dto);
//            });
//        }
//
//        // 개수 비교
//        assertEquals(n, dao.count(userId));
//
//
//        // 전체 등록된 상품 내용 비교
//        for (LikeItemDto dto : list) {
//            LikeItemDto selectedDto = dao.select(dto);
//            assertEquals(dto, selectedDto);
//        }
//    }
//
//    @DisplayName("2-1. 좋아요 상품 삭제 성공 - 사용자가 여러 상품을 삭제")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 삭제1(int n) throws Exception {
//        // given : n개 상품을 좋아요 상품으로 등록
//        // when : n개 상품을 삭제
//        // then : 적용된 로우수 1, 개수 0
//        String id = "1";
//        insertData(n);
//
//        List<LikeItemDto> list = new ArrayList<>();
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, dao.delete(dto));
//        }
//
//        assertEquals(0, dao.count(id));
//
//    }
//
//    @DisplayName("2-2. 좋아요 상품 삭제 실패 - 존재하지 않는 사용자의 좋아요 상품 삭제")
//    @Test
//    public void 삭제2() throws Exception {
//        // given : 상품 1개 생성, 아이디 1에 해당 상품 좋아요 상품으로 등록
//        // when : 등록되지 않은 사용자의 id로 상품 삭제
//        // then : 적용된 로우수 0
//        insertData(1);
//        String id = "1";
//
//        LikeItemDto dto = createLikeItem(1);
//        dto.setId(id);
//        assertEquals(1, dao.insert(dto));
//
//        dto.setId("xxx");
//        assertEquals(0, dao.delete(dto));
//        assertEquals(1, dao.count(id));
//
//    }
//
//    @DisplayName("2-3. 좋아요 상품 삭제 실패 - 존재하지 않는 상품 번호 삭제")
//    @Test
//    public void 삭제3() throws Exception {
//        // given : 상품 1개 생성, 아이디 1에 해당 상품 좋아요 상품으로 등록
//        // when : 존재하지 않는 상품 번호 삭제
//        // then : 적용된 로우수 0, 카운트 했을 때 상품 1개 존재
//        insertData(1);
//        String id = "1";
//        LikeItemDto dto = createLikeItem(1);
//        dto.setId(id);
//        assertEquals(1, dao.insert(dto));
//
//        dto.setNum("xxx");
//        assertEquals(0, dao.delete(dto));
//
//        assertEquals(1, dao.count(id));
//    }
//
//    @DisplayName("2-4. 좋아요 상품 삭제 실패 - 같은 상품 중복 삭제")
//    @Test
//    public void 삭제4() throws Exception {
//        // given : 상품 1개 생성, 아이디가 1에 해당 상품 좋아요 상품으로 등록
//        // when : 해당 상품 여러번 중복 삭제
//        // then : 처음 시도때는 적용된 로우수1, 그 이후에는 0, 카운트 했을 때 0
//        insertData(1);
//        String id = "1";
//
//        LikeItemDto dto = createLikeItem(1);
//        dto.setId(id);
//
//        assertEquals(1, dao.insert(dto));
//
//        for (int i=0; i<10; i++) {
//            if (i == 0) {
//                assertEquals(1, dao.delete(dto));
//            } else {
//                assertEquals(0, dao.delete(dto));
//            }
//        }
//
//        assertEquals(0, dao.count(id));
//    }
//
//    @DisplayName("2-4. 좋아요 상품 삭제 실패 - pk not null 제약 조건 x")
//    @Test
//    public void 삭제5() throws Exception {
//        // given : 상품 1개 생성, 해당 상품 아이디가 1인 유저의 좋아요 상품으로 등록
//        // when : dto에서 pk 부분 null 처리(id, num)
//        // then : 예외 발생
//        insertData(1);
//        String id = "1";
//
//        LikeItemDto dto = createLikeItem(1);
//
//        dto.setId(null);
//        assertEquals(0, dao.delete(dto));
//
//        dto.setId(id);
//        dto.setNum(null);
//        assertEquals(0, dao.delete(dto));
//    }
//
//
//    @DisplayName("3-1. 좋아요 상품 모두 삭제 성공 - 여러 좋아요 상품 모두 삭제")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 모두삭제1(int n) throws Exception {
//        // given : 상품 데이터 n개 생성, 아이디 1에 해당 상품 모두 좋아요 상품으로 등록
//        // when : 모두 삭제 실행
//        // then : 적용된 로우수 n개, 카운트 했을 때 개수 0
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        int cnt = dao.count(id);
//        assertEquals(cnt, dao.deleteAll(id));
//        assertEquals(0, dao.count(id));
//
//    }
//
//    @DisplayName("3-2. 좋아요 상품 모두 삭제 실패 - 존재하지 않는 사용자 아이디")
//    @Test
//    public void 모두삭제2() throws Exception {
//        // given : 상품 1개 생성, 해당 상품 아이디 1인 유저에 좋아요 상품으로 등록
//        // when : 없는 아이디로 모두 삭제 실행
//        // then : 적용된 로우수 0, 아이디 1인 유저 상품 카운트 1
//        insertData(1);
//        String id = "1";
//
//        LikeItemDto dto = createLikeItem(1);
//        dto.setId(id);
//
//        assertEquals(1, dao.insert(dto));
//        assertEquals(0, dao.deleteAll("xxx"));
//        assertEquals(1, dao.count(id));
//    }
//
//    @DisplayName("3-3. 좋아요 상품 모두 삭제 예외 - 아이디가 null인 경우")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 모두삭제3(int n) throws Exception {
//        // given : 상품 n개 생성, 해당 상품을 모두 아이디 1에 좋아요 상품으로 등록
//        // when : null로 모두 삭제 실행
//        // then : 적용된 로우수 0, 1유저의 상품 개수 n
//        insertData(n);
//        String id = "1";
//        List<LikeItemDto> list = new ArrayList<>();
//
//        for (int i=1; i<=n; i++) {
//            LikeItemDto dto = createLikeItem(i);
//            dto.setId(id);
//            list.add(dto);
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(1, dao.insert(dto));
//        }
//
//        assertEquals(0, dao.deleteAll(null));
//        assertEquals(n, dao.count(id));
//    }
//
//    @DisplayName("4-1. 좋아요 상품 모두 조회 성공 - 여러 상품 조회 성공")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 모두조회1(int n) throws Exception {
//        // given : 상품 데이터 n개 생성, 아이디 1에 좋아요 상품 등록
//        // when : 해당 아이디의 좋아요 상품 조회
//        // then : 적용된 로우수 1, 리스트 비교, 길이 비교(카운트)
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        List<LikeItemDto> selectedList = dao.selectAll(id);
//        assertEquals(list.size(), selectedList.size());
//
//        for (LikeItemDto dto : list) {
//            assertEquals(true, selectedList.contains(dto));
//        }
//    }
//
//    @DisplayName("4-2. 좋아요 상품 모두 조회 실패 - 존재하지 않는 사용자 아이디")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 모두조회2(int n) throws Exception {
//        // given : 상품 n개 생성, 아이디 1에 좋아요 상품 등록
//        // when : 존재하지 않는 아이디의 좋아요 상품 조회
//        // then : 조회된 리스트 길이 비교, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        List<LikeItemDto> selectedList = dao.selectAll("xxx");
//        assertNotEquals(list.size(), selectedList.size());
//        for (LikeItemDto dto : list) {
//            assertNotEquals(true, selectedList.contains(dto));
//        }
//
//    }
//
//    @DisplayName("4-3. 좋아요 상품 모두 조회 실패 - 아이디가 null")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 모두조회3(int n) throws Exception {
//        // given : 상품 n개 생성, 아이디 1에 좋아요 상품 등록
//        // when : 존재하지 않는 아이디의 좋아요 상품 조회
//        // then : 조회된 리스트 길이 비교, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        List<LikeItemDto> selectedList = dao.selectAll(null);
//        assertNotEquals(list.size(), selectedList.size());
//        for (LikeItemDto dto : list) {
//            assertNotEquals(true, selectedList.contains(dto));
//        }
//
//    }
//
//    @DisplayName("5-1. 좋아요 상품 조회 성공 - 여러 상품 조회")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 조회1(int n) throws Exception {
//        // given : 상품 n개 생성, 아이디가 1인 유저에 좋아요 상품 모두 등록
//        // when : 단건 조회
//        // then : 적용된 로우수 1, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (LikeItemDto dto : list) {
//            assertEquals(dto, dao.select(dto));
//        }
//
//    }
//
//    @DisplayName("5-2. 좋아요 상품 조회 실패 - 존재하지 않는 사용자 아이디")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 조회2(int n) throws Exception {
//        // given : 상품 n개 생성, 아이디가 1인 유저에 모든 상품 좋아요 상품으로 등록
//        // when : 존재하지 않는 아이디로 좋아요 상품 조회
//        // then : 적용된 로우수 0, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (LikeItemDto dto : list) {
//            dto.setId("xxx");
//            assertEquals(null, dao.select(dto));
//        }
//
//    }
//
//    @DisplayName("5-3. 좋아요 상품 조회 실패 - 존재하지 않는 상품 번호")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 조회3(int n) throws Exception {
//        // given : 상품 n개 생성, 아이디가 1인 유저에 모두 좋아요 상품 등록
//        // when : 존재하지 않는 상품 번호 조회
//        // then : 적용된 로우수 0, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (LikeItemDto dto : list) {
//            dto.setNum("xxx");
//            assertEquals(null, dao.select(dto));
//        }
//    }
//
//    @DisplayName("5-4. 좋아요 상품 조회 실패 - pk null")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 조회4(int n) throws Exception {
//        // given : 상품 데이터 n개 생성, 아이디가 1인 유저에 모두 좋아요 상품으로 등록
//        // when : pk가 null로 좋아요 상품 조회
//        // then : 적용된 로우수 0, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (LikeItemDto dto : list) {
//            dto.setId(null);
//            dto.setNum(null);
//
//            assertNotEquals(dto, dao.select(dto));
//        }
//    }
//
//    @DisplayName("6-1. 좋아요 상품 수정 성공 - 여러 상품 정보 변경")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 수정1(int n) throws Exception {
//        // given : 상품 n개 생성, 아이디가 1인 유저에 좋아요 상품으로 모두 등록
//        // when : 가격 정보 변경 적용
//        // then : 적용된 로우수 1, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (LikeItemDto dto : list) {
//            dto.setPrice(10000);
//            dto.setDisc_price(5000);
//
//            assertEquals(1, dao.update(dto));
//            LikeItemDto selectedDto = dao.select(dto);
//            assertEquals(dto, selectedDto);
//        }
//
//    }
//
//    @DisplayName("6-2. 좋아요 상품 수정 실패 - 존재하지 않는 사용자 아이디")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 수정2(int n) throws Exception {
//        // given : 상품 n개 생성, 아이디가 1인 유저에 좋아요 상품으로 모두 등록
//        // when : 존재하지 않는 사용자의 좋아요 상품 가격 정보 변경 적용
//        // then : 적용된 로우수 0, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (LikeItemDto dto : list) {
//            dto.setPrice(10000);
//            dto.setDisc_price(5000);
//            dto.setId("xxx");
//
//            assertEquals(0, dao.update(dto));
//            LikeItemDto selectedDto = dao.select(dto);
//            assertEquals(null, selectedDto);
//        }
//
//    }
//
//    @DisplayName("6-3. 좋아요 상품 수정 실패 - 존재하지 않는 상품 번호")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 수정3(int n) throws Exception {
//        // given : 상품 n개 생성, 아이디가 1인 유저에 좋아요 상품으로 모두 등록
//        // when : 존재하지 않는 사용자의 좋아요 상품 가격 정보 변경 적용
//        // then : 적용된 로우수 0, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (LikeItemDto dto : list) {
//            dto.setPrice(10000);
//            dto.setDisc_price(5000);
//            dto.setNum("xxx");
//
//            assertEquals(0, dao.update(dto));
//            LikeItemDto selectedDto = dao.select(dto);
//            assertEquals(null, selectedDto);
//        }
//
//    }
//
//
//    @DisplayName("6-4. 좋아요 상품 수정 실패 - 존재하지 않는 상품 번호")
//    @ParameterizedTest(name="[{index}]. 사용자가 등록한 상품 수량 -> {0}")
//    @ValueSource(ints={1, 20, 50, 100})
//    public void 수정4(int n) throws Exception {
//        // given : 상품 n개 생성, 아이디가 1인 유저에 좋아요 상품으로 모두 등록
//        // when : 존재하지 않는 사용자의 좋아요 상품 가격 정보 변경 적용
//        // then : 적용된 로우수 0, 내용 비교
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
//            assertEquals(1, dao.insert(dto));
//        }
//
//        for (LikeItemDto dto : list) {
//            dto.setPrice(10000);
//            dto.setDisc_price(5000);
//            dto.setId(null);
//            dto.setNum(null);
//
//            assertEquals(0, dao.update(dto));
//            LikeItemDto selectedDto = dao.select(dto);
//            assertEquals(null, selectedDto);
//        }
//
//    }
//
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
    private LikeItemDto createLikeItem(int i) {
        String id = String.valueOf(i);
        String num = String.valueOf(i);
        String name = "item" + String.valueOf(i);
        String type = "type" + String.valueOf(i);
        int price = i * 10000;
        int discPrice = i * 7000;
        String itemComt = "this item is ...";
        String mainImg = "...";
        int reviewCnt = i * 500;
        int likeCnt = i * 50;
        String stateCode = "SLA" + String.valueOf(i);
        String comt = ".....";
        Date regDate = null;
        String regId = "manager";
        Date upDate = null;
        String upId = "manager";

        return new LikeItemDto(id, num, name, type, price,
                discPrice, itemComt, mainImg, reviewCnt, likeCnt,
                stateCode, comt, regDate, regId, upDate, upId);
    }
//



}