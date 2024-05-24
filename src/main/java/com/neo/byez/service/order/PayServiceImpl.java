package com.neo.byez.service.order;

import com.neo.byez.dao.CustCouponsDaoImpl;
import com.neo.byez.dao.order.OrderDaoImpl;
import com.neo.byez.dao.order.PayDaoImpl;
import com.neo.byez.dao.order.PayHistoryDaoImpl;
import com.neo.byez.dao.order.PayStateDaoImpl;
import com.neo.byez.domain.order.OrderDto;
import com.neo.byez.domain.order.PayDto;
import com.neo.byez.domain.order.PayHistoryDto;
import com.neo.byez.domain.order.PayStateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayServiceImpl implements PayService {
    // 결제관련 Dao
    @Autowired
    PayDaoImpl payDao;
    @Autowired
    PayStateDaoImpl payStateDao;
    @Autowired
    PayHistoryDaoImpl payHistoryDao;
    @Autowired
    OrderDaoImpl orderDao;
    @Autowired
    CustCouponsDaoImpl custCouponsDao;


    // 2. retURL 파라미터와 임시 데이터 검증
    // 쿼리 파라미터의 값이 임시 저장 데이터와 일치하는지 확인
    /*
        결제 정보 검증

        결제 정보와 DB의 값이 일치하는지 검증

        1. 주문번호, 결제금액을 받는다.
        2. 주문번호로 주문Dto를 가져온다.
        3. 주문Dto의 총 결제금액과 결제금액이 같은지 비교
            3-1. 다르면 -1반환
            3-2. 같으면 4번으로 이동
        4. paymentKey를 결제정보에 저장한다.

     */
    // 1. 주문번호, 결제금액을 받는다.
    public boolean paymentValidate(String paymentKey, String ord_num, String price) {
        boolean priceCheck = false;
        try {
            // 2. 주문번호로 주문Dto를 얻는다.
            OrderDto orderDto = orderDao.select(ord_num);
            // 주문정보가 없으면 예외 발생
            if (orderDto == null){
                throw new Exception("주문정보가 없습니다.");
            }
            // 결제금액이 같은지 비교
            priceCheck = orderDto.getTotal_pay_price().equals(Integer.parseInt(price));

            // 결제금액이 다르면
            if(!priceCheck){
                throw new Exception("결제금액이 다릅니다.");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            // 결제금액이 같으면 성공으로 반환
            return priceCheck;

        }
    }

    // 결제정보 업데이트
    /*
        결제 승인 후 결제 정보 업데이트
            1. pay, pay_state 진행 상태 update
            2. pay_hist insert
            3.
     */
    @Transactional(rollbackFor = {Exception.class})
    public int payApproval(String ord_num, String state){
        try {
            // 결제번호
            String pay_num = "P"+ord_num;

            // 결제Dto 조회
            PayDto payDto = payDao.select(pay_num);
            // 주문번호로 id 조회
            String id = orderDao.select(ord_num).getId();
            // 결제 상태 업데이트
            payDto.setState(state);
            payDao.update(payDto);

            // 결제 진행상태 생성
            PayStateDto payStateDto = new PayStateDto(pay_num, 2, state);
            payStateDto.setReg_id(id);
            payStateDto.setUp_id(id);

            // 결제 진행상태 데이터 삽입
            payStateDao.insert(payStateDto);

            // 결제금액 조회
            Integer price = payDto.getPrice();
            // 결제이력 생성
            PayHistoryDto payHistoryDto = new PayHistoryDto(pay_num, 1, price, state);
            payHistoryDto.setReg_id(id);
            payHistoryDto.setUp_id(id);

            // 결제 이력 삽입
            payHistoryDao.insert(payHistoryDto);

            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
