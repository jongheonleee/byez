package com.neo.byez.controller.order;

import com.neo.byez.domain.UserCouponDetails;
import com.neo.byez.domain.item.*;
import com.neo.byez.domain.order.OrderDto;
import com.neo.byez.domain.order.OrderReadyInfo;
import com.neo.byez.domain.order.OrderResultInfoDto;
import com.neo.byez.domain.order.OrderResultInfoDto;
import com.neo.byez.domain.order.PaymentInfo;
import com.neo.byez.service.CustCouponsServiceImpl;
import com.neo.byez.service.order.OrderResultInfoServiceImpl;
import com.neo.byez.service.order.OrderServiceImpl;
import com.neo.byez.service.order.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = {"/order"})
public class OrderController {
    private OrderServiceImpl orderService;
    private CustCouponsServiceImpl custCouponsService;
    private OrderResultInfoServiceImpl orderResultInfoService;
    @Autowired
    public OrderController(OrderServiceImpl orderService, CustCouponsServiceImpl custCouponsService, OrderResultInfoServiceImpl orderResultInfoService) {
        this.orderService = orderService;
        this.custCouponsService = custCouponsService;
        this.orderResultInfoService = orderResultInfoService;
    }

    /*
        주문 요청 - 주문 프로세스
        주문 폼에서 결제하기 버튼 클릭
        0. 주문번호 생성
        1. 주문 데이터 유효성 검증
        2. 임시 저장
        3. 결제 생성 요청
        4. 결제 정보 유효성 검증
        5. 결제 승인 요청

        0. 주문번호 생성
            1. 유일한 주문번호 반환
                1.

        1. 주문 데이터 유효성 검증
            #. 총 주문금액 유효성
            #. 할인금액 유효성
            #. 결제금액 유효성
            #. 총 주문금액 유효성
                1. 상품번호로 (상품단가 * 수량) 주문상품 금액 도출
                2. 주문 상품목록의 총 주문상품금액 도출
                3. 입력 받은 총 주문상품금액과 비교
            #. 할인금액 유효성
                1. 쿠폰번호(고객아이디 + seq)로 쿠폰 조회  사용여부 - 유효한지
                2. 할인금액이 계산
                3. 입력 받은 할인금액과 비교
            #. 결제금액 유효성
                1. (총 주문상품금액 - 총 할인금액 = 결제금액)
                2. 입력 받은 결제금액과 비교

        2. 주문 데이터 임시저장
            1. 주문번호로 주문(주문대기) insert
            2. 주문번호+seq로 주문상품목록(주문대기) insert
            3. 주문번호+seq(1)로 주문진행상태(주문대기) insert
            4. 배송지정보(주문번호) insert
            5. 결제번호로 결제정보(결제대기) insert
            6. 결제번호로 결제진행상태(결제대기) insert

        3. 결제 생성 요청

        4. 결제 정보 유효성 검증
        5. 결제 승인 요청


        Controller 처리 로직

        1. 주문 데이터 유효성 검증
            1-1. 성공 : 다음 로직 수행
            1-2. 실패 : "유효하지 않은 주문입니다."
        2. 주문 데이터 임시저장
            2-1. 성공 : 다음 로직 수행
            2-2. 실패 : "서버 에러(주문 정보 저장 중 에러 발생)"
        3. 결제 생성 요청
            3-1. 결제 데이터 생성
            3-2. 결제 생성 요청
                3-2-1. 성공 : 다음 로직 수행
                3-2-2. 실패 : 실패 메시지 return
        4. 결제 정보 유효성 검증
            4-1. 성공 : 다음 로직 수행
            4-2. 실패 : "결제 정보가 유효하지 않습니다."
        5. 결제 승인 요청
            5-1. 성공 : 결제 정보 update(pay, pay_state), insert (pay_hist) - 결제완료 (#####재고차감 할 것)
            5-2. 실패 : 결제 정보 update(pay, pay_state), insert (pay_hist) - 결제실패, 결제취소
        6. 결제 완료 페이지 이동

     */

    // 0. 주문번호 생성
    @ResponseBody
    @GetMapping("/orderNumGenerator")
    public ResponseEntity<String> orderNumGenerator(){
        // 주문번호 생성하기
        String ordNum = orderService.orderNumGenerator();

        // 주문번호가 "" 또는 " "이면 서버 에러
        if (ordNum.isBlank()){
            return ResponseEntity.internalServerError().body(ordNum);
        }
        return ResponseEntity.ok().body(ordNum);
    }

    // 주문 정보 유효성 검증 후 저장
    @ResponseBody
    @PostMapping("/orderReady")
    public ResponseEntity<Object> orderReady(@RequestBody OrderReadyInfo orderReadyInfo, HttpSession session){
        String userId = (String)session.getAttribute("userId");
        String userName = (String)session.getAttribute("userName");
        PaymentInfo paymentInfo = null;
        try {
            // 주문 정보 검증 및 저장 시도
            // 예외 발생하면 검증 or 저장 실패
            orderService.saveOrderInfo(orderReadyInfo, userId);
            paymentInfo = new PaymentInfo(orderReadyInfo, "user1@user1.com", userName, "01012345678");

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(paymentInfo);
        }
        // 검증 및 저장 성공
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentInfo);
    }

    // 주문 폼 요청
    @RequestMapping("/orderForm")
    public String index(HttpSession session, BasketItemDtos basketItemDtos, Model m) throws Exception {
        String id = (String)session.getAttribute("userId");

        List<BasketItemDto> basketItemDtoList = basketItemDtos.getOrders();
        HashMap<String,Object> map = orderService.orderForm(id, basketItemDtoList);
        List<UserCouponDetails> coupons = custCouponsService.getUserCouponDetailsByUserId(id);

        m.addAttribute("coupons", coupons);
        m.addAttribute("orderDto", map.get("orderDto"));
        m.addAttribute("basketItemDtoList", basketItemDtoList);
        m.addAttribute("addressEntryDtoList", map.get("addressEntryDtoList"));

        return "/order/orderForm";
    }

    // 주문완료페이지 - 임시 생성
    @GetMapping("/orderHist")
    public String orderHist(String ord_num, Model m){
        OrderResultInfoDto orderResultInfoDto = orderResultInfoService.getOrderResultInfo(ord_num);
        List<OrderResultInfoDto> orderResultInfoDtoList = orderResultInfoService.getOrderedItemList(ord_num);

        if(orderResultInfoDto == null || orderResultInfoDtoList.size() == 0){
            m.addAttribute("msg", "주문상세 정보 조회 실패!!!");
            return "/order/error";
        }

        m.addAttribute("orderResultInfoDto", orderResultInfoDto);
        m.addAttribute("orderResultInfoDtoList", orderResultInfoDtoList);

        return "/order/orderHist";
    }

    @GetMapping("/orderComplete")
    public String orderComplete(){
        return "/order/orderComplete";
    }
}
