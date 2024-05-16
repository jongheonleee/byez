package com.neo.byez.dao.order;


import com.neo.byez.domain.order.OrderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderDaoImplTest {
    @Autowired
    OrderDaoImpl orderDao;

    /*
        테스트 환경 테스트

        1. DAO가 빈으로 등록 되었는가
        2. instanceof의 결과가 참인가
        3. 테이블 전체 삭제가 정상적으로 되는가
    */
    @DisplayName("환경초기화 테스트")
    @Test
    public void 환경초기화테스트() throws Exception{
        // 빈이 정상적으로 등록
        assertTrue(orderDao != null);
        assertTrue(orderDao instanceof OrderDaoImpl);
        assertTrue(orderDao instanceof OrderDao);

        // 테이블 전체 삭제
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);
    }

/* INSERT TEST----------------------------------------------------------------------------*/
    /*
        INSERT TEST
        데이터 삽입 테스트

        ※ 실패하면 예외 발생

        성공 조건
            1. PK가 중복 되지 않아야한다.
            2. NOT NULL 제약조건을 지켜야한다.
            3. 타입이 일치하거나, 자동 형변환이 가능해야한다.
            4. 길이를 초과하지 않아야한다.

        실패 조건
            1. 동일한 PK 값을 삽입한다.                          Error Code: 1062. Duplicate entry '[값]' for key '[테이블명.PRIMARY]'
            2. NOT NULL 컬럼에 NULL이 들어간다.                 Error Code: 1364. Field '[컬럼명]' doesn't have a default value
            3. 다른 타입이 들어가거나, 자동 형변환이 불가능하다.     Error Code: 1366. Incorrect integer value: '[값]' for column '[컬럼명]' at row 1
            4. 길이를 초과한다.                                Error Code: 1406. Data too long for column '[컬럼명]' at row 1
                                                            Error Code: 1264. Out of range value for column '[컬럼명]' at row 1

        시나리오
            1. 성공 조건을 모두 만족
            2. 실패 조건을 모두 만족
            3. 실패 조건을 n개만 만족
            4. 각 시나리오의 수량을 점차적으로 증가

        테스트 방식
            1. 비교 기준값(DB에 저장하기 전 값)과 대상값(DB에 저장된 값)을 비교
            2. 성공, 실패의 반환 값이 예상한 값인지 확인 (0, 1, n)
            3. isEmpty, equals 등의 메서드 사용 권장
    */



    // INSERT TEST
    // 시나리오 1. 성공 조건을 모두 만족
    // 비교 기준값(DB 저장 전)과 비교 대상값(DB 저장 후)이 일치하는가
    @Test
    public void 성공_insert테스트_1개() throws Exception{
        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 비교 기준
        // 객체 1개 생성
        String ord_num = "20240501-0000001";
        String id = "asdf123";
        Integer total_item_qty = 1;
        Integer total_price = 20000;
        Integer total_dlv_price = 2500;
        Integer total_disc_price = 0;
        Integer total_pay_price = 17500;
        String ord_state = "주문완료";
        OrderDto srcDto = new OrderDto(ord_num, id, total_item_qty, total_price, total_dlv_price, total_disc_price, total_pay_price, ord_state);

        // INSERT 데이터 삽입
        // insert 결과가 1인가
        assertTrue(orderDao.insert(srcDto) == 1);

        // 동일한 PK값을 삽입하면 실패하는가
        try{
            assertTrue(orderDao.insert(srcDto) == 0);
        // 중복키 예외를 던지는가
        } catch (DuplicateKeyException e){
            // 데이터 삽입에 실패했는가
            assertTrue(orderDao.countAll() == 1);
        }

        // count 결과가 1인가
        assertTrue(orderDao.countAll() == 1);

        // 비교 대상
        // 저장한 주문을 가져온다.
        OrderDto targetDto = orderDao.select(ord_num);

        // 비교
        // src와 target 비교

        // 주문번호가 같은가
        assertTrue(ord_num.equals(targetDto.getOrd_num()));
        // id가 같은가
        assertTrue(id.equals(targetDto.getId()));
        // 주문상품 수량이 같은가
        assertTrue(total_item_qty.equals(targetDto.getTotal_item_qty()));
        // 주문금액이 같은가
        assertTrue(total_price.equals(targetDto.getTotal_price()));
        // 배송비가 같은가
        assertTrue(total_dlv_price.equals(targetDto.getTotal_dlv_price()));
        // 할인금액이 같은가
        assertTrue(total_disc_price.equals(targetDto.getTotal_disc_price()));
        // 최종결제금액이 같은가
        assertTrue(total_pay_price.equals(targetDto.getTotal_pay_price()));
        // 주문상태가 같은가
        assertTrue(ord_state.equals(targetDto.getOrd_state()));
    }


    // INSERT TEST 반복
    // 시나리오 1. 성공 조건을 모두 만족
    // 비교 기준값(DB 저장 전)과 비교 대상값(DB 저장 후)이 일치하는가
    @Test
    public void 성공_insert테스트_n개() throws Exception{
        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 성공_데이터삽입테스트_1개()
        // 10회 반복 테스트
        성공_데이터삽입반복_n개(10);
        assertTrue(orderDao.countAll() == 10);

        // 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 100회 반복 테스트
        성공_데이터삽입반복_n개(100);
        assertTrue(orderDao.countAll() == 100);

        // 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 1000회 반복 테스트
        성공_데이터삽입반복_n개(1000);
        assertTrue(orderDao.countAll() == 1000);

        // 10000회 반복 테스트
//        성공_데이터삽입반복_n개(10000);
//        assertTrue(orderDao.countAll() == 10000);
    }

    // INSERT TEST
    // 시나리오 2. 실패 조건을 모두 만족
    // 1. 동일한 PK Insert 시도
    // 2. NOT NULL 컬럼에 NULL
    // 3. 데이터 길이 초과
    @Test
    public void 실패_insert테스트_1개() throws Exception{
        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 테스트객체 1개 생성
        OrderDto srcDto = 주문객체생성(0);

        // PK 중복 삽입 테스트
        // 1. 중복되지 않는 데이터 삽입
        assertTrue(orderDao.insert(srcDto) == 1);

        try{
            // 2. 동일한 PK값을 삽입
            assertTrue(orderDao.insert(srcDto) == 0);
            // 3. 중복키 예외 발생
        } catch (DuplicateKeyException e){
            // 4. 데이터 삽입 실패 확인
            assertTrue(orderDao.countAll() == 1);
        }

        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // NOT NULL(PK) 컬럼에 NULL 값 삽입 테스트
        // 1. PK, NOT NULL 컬럼이 NULL인 객체 생성
        srcDto = new OrderDto();
        try {
            // 2. NOT NULL 컬럼에 NULL 삽입
            assertTrue(orderDao.insert(srcDto) == 0);
        // 3. 무결성 제약조건 위배 예외 발생
        } catch (DataIntegrityViolationException e){
            assertTrue(orderDao.countAll() == 0);
        }

        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 길이가 초과된 데이터 삽입 테스트
        srcDto = 주문객체생성(0);

        srcDto.setOrd_num("200000000000000000000000000000002");

        try {
            // 2. 길이가 초과된 데이터 삽입
            assertTrue(orderDao.insert(srcDto) == 0);
            // 3. 무결성 제약조건 위배 예외 발생
        } catch (DataIntegrityViolationException e){
            assertTrue(orderDao.countAll() == 0);
        }
    }

    // INSERT TEST 반복
    // 시나리오 2. 실패 조건을 모두 만족 반복
    // 1. 동일한 PK Insert 시도
    // 2. NOT NULL 컬럼에 NULL
    // 3. 데이터 길이 초과
    @Test
    public void 실패_insert테스트_n개() throws Exception{
        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 10회 반복 테스트
        실패_데이터삽입반복_n개(10);
        assertTrue(orderDao.countAll() == 0);

        // 100회 반복 테스트
        실패_데이터삽입반복_n개(100);

        assertTrue(orderDao.countAll() == 0);

        // 1000회 반복 테스트
        실패_데이터삽입반복_n개(1000);
        assertTrue(orderDao.countAll() == 0);

        // 10000회 반복 테스트
//        실패_데이터삽입반복_n개(10000);
//        assertTrue(orderDao.countAll() == 0);
    }
/* //INSERT TEST----------------------------------------------------------------------------*/

/* DELETE TEST----------------------------------------------------------------------------*/
    /*
        DELETE TEST
        데이터 삭제 테스트

        ※ 실패해도 에러가 발생하지 않음(결과가 0).

        성공조건
            1. 존재하는 주문번호로 삭제 시도

        실패조건
            2. 존재하지 않는 주문번호로 삭제 시도

        시나리오
            1. 1개 넣고 1개 삭제
            2. 여러개 넣고 1개 삭제
            3. 여러개 넣고 여러개 삭제

        테스트 방식
            1. 삭제 시도한 개수와 삭제된 결과 개수가 같은지 확인
            2. 삭제 시도한 값이 정상적으로 삭제 되었는지 확인
    */

    // DELETE TEST
    // 시나리오 1. 1개 넣고 1개 삭제
    @Test
    public void 성공_실패_delete테스트_1개() throws Exception{
        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 저장할 객체 1개 생성
        OrderDto srcDto = 주문객체생성(0);
        String ord_num = srcDto.getOrd_num();

        // DB에 저장
        assertTrue(orderDao.insert(srcDto) == 1);
        assertTrue(orderDao.select(ord_num) != null);
        assertTrue(orderDao.countAll() == 1);

        // 주문번호로 삭제
        assertTrue(orderDao.delete(ord_num) == 1);
        assertTrue(orderDao.countAll() == 0);

        // 삭제된 것을 다시 삭제
        assertTrue(orderDao.delete(ord_num) == 0);
        assertTrue(orderDao.countAll() == 0);

        // 삭제된 것을 조회
        assertTrue(orderDao.select(ord_num) == null);
    }

    // DELETE TEST 반복
    // 시나리오 1. 1개 넣고 1개 삭제 반복
    @Test
    public void 성공_실패_delete테스트_n개() throws Exception{
        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 10회 반복 테스트
        데이터삭제반복_n개(10);

        // 100회 반복 테스트
        데이터삭제반복_n개(100);

        // 1000회 반복 테스트
        데이터삭제반복_n개(1000);

        // 10000회 반복 테스트
//        데이터삭제반복_n개(10000);
    }
/* //DELETE TEST----------------------------------------------------------------------------*/

/* SELECT TEST----------------------------------------------------------------------------*/
    /*
        SELECT TEST
        데이터 조회 테스트

        ※ 실패해도 에러가 발생하지 않음(결과가 null).

        성공조건
            1. 존재하는 주문번호로 조회

        실패조건
            2. 존재하지 않는 주문번호로 조회

        시나리오
            1. 1개 넣고 1개 조회
            2. 여러개 넣고 1개 조회
            3. 여러개 넣고 여러개 조회

        테스트 방식
            1. 비교기준값(DB에 저장 전)과 비교대상값(DB에 저장된 값)이 일치하는지 비교
            2. 실제 저장한 개수와 조회한 개수가 일치하는지 확인
    */

    // SELECT TEST
    // 시나리오 1. 1개 넣고 1개 조회
    @Test
    public void 성공_실패_select테스트_1개() throws Exception{
        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 비교기준값(src) - 저장할 객체 1개 생성
        OrderDto srcDto = 주문객체생성(0);
        String src_ord_num = srcDto.getOrd_num();
        String src_id = "TestID";
        srcDto.setId(src_id);

        // DB에 저장
        assertTrue(orderDao.insert(srcDto) == 1);

        // 비교대상값(target) - 주문번호로 조회
        OrderDto targetDto = orderDao.select(src_ord_num);
        String target_ord_num = targetDto.getOrd_num();
        String target_id = targetDto.getId();

        // 기준값(DB 저장 전)과 대상값(DB에서 조회한 값)이 같은지 비교
        assertTrue(target_ord_num.equals(src_ord_num));
        assertTrue(target_id.equals(src_id));

        // ID에 해당하는 주문 개수
        int count = orderDao.count(src_id);

        // ID에 해당하는 주문List
        List<OrderDto> orderDtoList = orderDao.selectAll(src_id);
        target_id = orderDtoList.get(0).getId();
        target_ord_num = orderDtoList.get(0).getOrd_num();

        // List의 사이즈와 아이디로 Count한 값이 일치하는지 확인
        assertTrue(orderDtoList.size() == count);

        // 기준값(DB 저장 전)과 대상값(DB에서 조회한 값)이 같은지 비교
        assertTrue(target_id.equals(src_id));
        assertTrue(target_ord_num.equals(src_ord_num));

        // 삭제한 후에 조회
        // 삭제
        assertTrue(orderDao.delete(src_ord_num) == 1);

        // 삭제된 주문 조회
        // null이 반환되는가
        assertTrue(orderDao.select(src_ord_num) == null);
        // List의 사이즈가 0인가
        assertTrue(orderDao.selectAll(src_id).size() == 0);
        // ID에 해당하는 주문이 없는가
        assertTrue(orderDao.count(src_id) == 0);
    }

    // SELECT TEST
    // 시나리오 2. 여러개 넣고 여러개 조회
    @Test
    public void 성공_select테스트_n개() throws Exception{
        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 비교기준값(src) - 주문리스트 생성
        String src_id = "asdf1234";
        List<OrderDto> src_list = ID가_동일한_주문리스트(100, src_id);

        // DB에 저장
        for (OrderDto dto : src_list){
            assertTrue(orderDao.insert(dto) == 1);
        }

        // 비교대상값(target) - 주문리스트 조회
        List<OrderDto> target_list = orderDao.selectAll(src_id);

        // 기준값과 대상값이 일치하는지 확인
        // 사이즈가 같은가
        assertTrue(src_list.size() == target_list.size());

        // 저장된 각 요소가 서로 일치하는가
        for (int i = 0; i < src_list.size(); i++){
            // 아이디가 일치하는가
            assertTrue(src_id.equals(target_list.get(i).getId()));

            // 모든 주문이 저장되었는가
            String src_ord_num = src_list.get(i).getOrd_num();
            assertTrue(target_list.toString().contains(src_ord_num));
        }
        for(OrderDto targetDto : target_list){
            // 아이디가 일치하는가
            assertTrue(src_id.equals(targetDto.getId()));
            String target_ord_num = targetDto.getOrd_num();
            // 모든 주문이 DB에 저장되었는가
            assertTrue(src_list.toString().contains(target_ord_num));
        }
    }

/* //SELECT TEST----------------------------------------------------------------------------*/

/* UPDATE TEST----------------------------------------------------------------------------*/
    /*
        UPDATE TEST
        데이터 갱신 테스트
        ※ 실패하면 예외 또는 0 발생

        성공 조건
            1. 주문번호(PK)가 존재해야한다. (where ord_num = #{ord_num)
            2. NOT NULL 제약조건을 지켜야한다.
            3. 타입이 일치하거나, 자동 형변환이 가능해야한다.
            4. 길이를 초과하지 않아야한다.

        실패 조건
            1. 주문번호가 존재해야한다.                          결과 : 0
            2. NOT NULL 컬럼에 NULL이 들어간다.                 Error Code: 1048. Column '[컬럼명]' cannot be null
            3. 다른 타입이 들어가거나, 자동 형변환이 불가능하다.     Error Code: 1366. Incorrect integer value: '[값]' for column '[컬럼명]' at row 1
            4. 길이를 초과한다.                                Error Code: 1406. Data too long for column '[컬럼명]' at row 1
                                                            Error Code: 1264. Out of range value for column '[컬럼명]' at row 1

        시나리오 - 성공, 실패
            1. 1개 넣고 1개 업데이트
            2. 여러개 넣고 1개 업데이트
            3. 여러개 넣고 여러개 업데이트

        테스트 방식
            1. 비교기준값(DB에 업데이트 하려는 값)과 비교대상값(DB에 업데이트 한 값)이 일치하는지 비교
            2. 실제 업데이트가 된 개수가 예상한 결과와 같은지 확인
    */

    // UPDATE TEST
    // 시나리오 1. 1개 넣고 1개 업데이트
    @Test
    public void 성공_업데이트테스트_1개() throws Exception {
        // 테이블 초기화
        orderDao.deleteAll();
        assertTrue(orderDao.countAll() == 0);

        // 1. 업데이트 할 객체 생성
        // 2. DB에 저장
        // 3. 객체 수정
        // 4. DB에 업데이트
        // 5. DB에 저장된 값 조회
        // 6. 3번 객체와 5번 객체가 일치하는지 비교

        // 업데이트할 객체 생성
        OrderDto srcDto = 주문객체생성(0);

        // DB에 저장
        assertTrue(orderDao.insert(srcDto) == 1);

        // 비교기준값(업데이트 하기 전) DB에 저장된 객체 조회
        srcDto = orderDao.select(srcDto.getOrd_num());

        // 데이터 수정
        // 수정사항 : 총 상품수량, 총 상품금액, 총 배송비, 총 할인금액, 최종결제금액, 주문일시, 주문상태, up_id(시스템컬럼)
        srcDto = 주문객체업데이트(srcDto);

        // 업데이트
        assertTrue(orderDao.update(srcDto) == 1);

        // 비교대상값(DB에 업데이트 된 값) 조회
        OrderDto targetDto = orderDao.select(srcDto.getOrd_num());

        // 정상적으로 업데이트 되었는가
        assertTrue(targetDto.equals(srcDto));
    }

    public OrderDto 주문객체업데이트(OrderDto srcDto){
        Integer total_item_qty = 99;
        Integer total_price = 999999;
        Integer total_dlv_price = 9999;
        Integer total_disc_price = 9999;
        Integer total_pay_price = 999999;
        String ord_date = "2024-05-01 12:00:00";
        String ord_state = "주문취소";
        String up_id = "id";

        srcDto.setTotal_item_qty(total_item_qty);
        srcDto.setTotal_price(total_price);
        srcDto.setTotal_dlv_price(total_dlv_price);
        srcDto.setTotal_disc_price(total_disc_price);
        srcDto.setTotal_pay_price(total_pay_price);
        srcDto.setOrd_date(ord_date);
        srcDto.setOrd_state(ord_state);
        srcDto.setUp_id(up_id);

        return srcDto;
    }

    public OrderDto 주문객체생성(int num){
        String ord_num = ("20240501-" + num);
        String id = "asdf123" + num;
        Integer total_item_qty = num%3;
        Integer total_price = 20000 + num;
        Integer total_dlv_price = 2500 + num;
        Integer total_disc_price = 0 + num;
        Integer total_pay_price = 17500 + num;
        String ord_state = "주문완료" + num;
        return new OrderDto(ord_num, id, total_item_qty, total_price, total_dlv_price, total_disc_price, total_pay_price, ord_state);
    }

    public List<OrderDto> ID가_동일한_주문리스트(int num, String id){
        List<OrderDto> list = new ArrayList<>();
        for (int i=0; i < num; i++){
            OrderDto dto = 주문객체생성(i);
            dto.setId(id);
            list.add(dto);
        }
        return list;
    }

    public void 성공_데이터삽입반복_n개(int num) throws Exception {
        for(int i = 0; i < num; i++){
            OrderDto srcDto = 주문객체생성(i);

            // INSERT 데이터 삽입
            // insert 결과가 1인가
            int count = orderDao.countAll();
            assertTrue(orderDao.insert(srcDto) == 1);

            // 동일한 PK값을 삽입하면 실패하는가
            try{
                assertTrue(orderDao.insert(srcDto) == 0);
                // 중복키 예외를 던지는가
            } catch (DuplicateKeyException e){
                // 데이터 삽입에 실패했는가
                assertTrue(orderDao.countAll() == count + 1);
            }

            // count 결과가 1인가
            assertTrue(orderDao.countAll() == count + 1);

            // 비교 대상
            // 저장한 주문을 가져온다.
            OrderDto targetDto = orderDao.select(srcDto.getOrd_num());

            // 비교
            // src와 target 비교

            // 주문번호가 같은가
            assertTrue(srcDto.getOrd_num().equals(targetDto.getOrd_num()));
            // id가 같은가
            assertTrue(srcDto.getId().equals(targetDto.getId()));
            // 주문상품 수량이 같은가
            assertTrue(srcDto.getTotal_item_qty().equals(targetDto.getTotal_item_qty()));
            // 주문금액이 같은가
            assertTrue(srcDto.getTotal_price().equals(targetDto.getTotal_price()));
            // 배송비가 같은가
            assertTrue(srcDto.getTotal_dlv_price().equals(targetDto.getTotal_dlv_price()));
            // 할인금액이 같은가
            assertTrue(srcDto.getTotal_disc_price().equals(targetDto.getTotal_disc_price()));
            // 최종결제금액이 같은가
            assertTrue(srcDto.getTotal_pay_price().equals(targetDto.getTotal_pay_price()));
            // 주문상태가 같은가
            assertTrue(srcDto.getOrd_state().equals(targetDto.getOrd_state()));
        }
    }

    public void 실패_데이터삽입반복_n개(int num) throws Exception{
        for(int i = 0; i < num; i++){
            // 테이블 초기화
            orderDao.deleteAll();
            assertTrue(orderDao.countAll() == 0);

            // 테스트객체 1개 생성
            OrderDto srcDto = 주문객체생성(num);

            // PK 중복 삽입 테스트
            // 1. 중복되지 않는 데이터 삽입
            assertTrue(orderDao.insert(srcDto) == 1);

            try{
                // 2. 동일한 PK값을 삽입
                assertTrue(orderDao.insert(srcDto) == 0);
                // 3. 중복키 예외 발생
            } catch (DuplicateKeyException e){
                // 4. 데이터 삽입 실패 확인
                assertTrue(orderDao.countAll() == 1);
            }


            // 테이블 초기화
            orderDao.deleteAll();
            assertTrue(orderDao.countAll() == 0);

            // NOT NULL(PK) 컬럼에 NULL 값 삽입 테스트
            // 1. PK가 NULL인 객체 생성
            srcDto = new OrderDto();
            try {
                // 2. 제약조건에 위배되는 테이터 삽입
                assertTrue(orderDao.insert(srcDto) == 0);
                // 3. 무결성 제약조건 위배 예외 발생
            } catch (DataIntegrityViolationException e){
                assertTrue(orderDao.countAll() == 0);
            }


            // 테이블 초기화
            orderDao.deleteAll();
            assertTrue(orderDao.countAll() == 0);


            // 길이가 초과된 데이터 삽입 테스트
            srcDto = 주문객체생성(num);
            srcDto.setOrd_num("200000000000000000000000000000002");

            try {
                // 2. 길이가 초과된 데이터 삽입
                assertTrue(orderDao.insert(srcDto) == 0);
                // 3. 무결성 제약조건 위배 예외 발생
            } catch (DataIntegrityViolationException e){
                assertTrue(orderDao.countAll() == 0);
            }
        }
    }

    public void 데이터삭제반복_n개(int num) throws Exception {
        for(int i = 0; i < num; i++){
            // 삭제할 객체 생성
            OrderDto srcDto = 주문객체생성(num);
            String ord_num = srcDto.getOrd_num();

            // DB에 저장
            assertTrue(orderDao.insert(srcDto) == 1);
            assertTrue(orderDao.select(ord_num) != null);
            assertTrue(orderDao.countAll() == 1);

            // 주문번호로 삭제
            assertTrue(orderDao.delete(ord_num) == 1);
            assertTrue(orderDao.countAll() == 0);

            // 삭제된 것을 삭제
            assertTrue(orderDao.delete(ord_num) == 0);
            assertTrue(orderDao.countAll() == 0);

            // 삭제된 것을 조회
            assertTrue(orderDao.select(ord_num) == null);
        }
    }
}