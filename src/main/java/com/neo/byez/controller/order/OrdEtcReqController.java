package com.neo.byez.controller.order;


import com.neo.byez.dao.order.DeliveryDaoImpl;
//import com.neo.byez.service.DlvServiceImpl;
import com.neo.byez.domain.order.*;
import com.neo.byez.service.order.OrderDetailServiceImpl;
import com.neo.byez.service.order.OrdEtcReqServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.util.List;

@Controller
public class OrdEtcReqController {

    @Autowired
    OrdEtcReqServiceImpl ordEtcReqService;
    @Autowired
    OrderDetailServiceImpl orderDetailService;
    @Autowired
    DeliveryDaoImpl deliveryDao;


/*
    주문취소 구현
      1. 주문취소 정의 :  해당 주문번호의 주문상태가 주문완료인 경우 취소버튼 show
        --> 배송이 시작되기 전까지만 취소가 가능하다.

        2. flow
            2-1) 아이디별로 조회된 주문내역 페이지
            2-2)  특정 주문번호의 취소버튼 클릭
            2-3)   취소신청 페이지로 이동
                      - 해당 주문번호의 주문내역만 select하여 보여줌(주문상품정보)
                      - 취소사유선택/상세사유
                      - 취소사유가 선택되지 않으면(빈값이면) 얼럿창 띄우고 현재창에 머물게함

        3. 반품신청 시 영향을 받는 테이블
            a. ord_etc_req에 취소정보 insert
            b. ord_detail에 update
            c. ord_state에 insert
            d. order에 update
         --> 4개의 프로세스를 하나의 트랜잭션으로 묶었음

        *  주문상태가 취소완료로 바뀐 상품은 더이상 주문취소버튼이 확인되지 않음

        주문취소버튼을 누르면 위 프로세스가 진행되고 db에 데이터를 저장
        리스트로 돌아왔을때 보여지는 주문상태가 변경이 되어 있게 구현

*/

    @RequestMapping(value = "/cancel")
    public String cancelForm(HttpSession session, String ord_num, Model m) throws Exception {

        String userId = "user1";
//        String userId = (String) session.getAttribute("userId");

        List<OrderDetailDto> cancelList = orderDetailService.selectOneOrdDetail(ord_num);
        m.addAttribute("id", userId);
        m.addAttribute("ord_num",ord_num);
        m.addAttribute("cancelList",cancelList);
        return "/order/orderCancelForm";
    }

    @RequestMapping(value = "/cancelOrder")
    public String cancelOrder(HttpSession session,Model m, OrdEtcReqDto ordEtcReqDto, OrderStateDto orderStateDto, OrderDetailDto orderDetailDto, OrderDto orderDto, String ord_state) throws Exception {

        /*
            -확인-
            값이 잘 넘어왔는지 확인할것(ord_num이 빈문자열임..)
            트랜잭션으로 묶인 서비스메서드를 호출하지 말고
            insert/update 총 4개의 메서드를 호출해 디비에 저장되고 업데이트 되는지 확인
        */

        /*flow
               orderCancelPage에서 취소버튼 클릭 시
               /cancelOrder url로 연결되어 아래의 로직들을 구현함
                1. db수정 및 삽입
                2. 업데이트 된 새로운 리스트를 list에 담아 모델을 통해 뷰로 보내준다.
                --> 상태가 주문완료였던 컬럼값이 "주문취소"인 점 확인해야함

        */
        //
        //aaa 고객이 주문한 모든 내역을 불러옴
        //실제 구현시에는 로그인한 고객의 아이디를 세션에서 불러와 조회한다.

        String userId = "user1";
//        String userId = (String) session.getAttribute("userId");
        List<OrderDetailDto> list = orderDetailService.getOrderDetailsList("asdf1234");
        //주문내역(list)을 모델에 담아 view로 보내준다
        m.addAttribute("id", userId);
        m.addAttribute("list", list);
        //주문내역을 불러올때 주문번호가 ordDetailDto에 담기기 때문에
        //
        m.addAttribute("orderDetailDto", orderDetailDto);

        /*
        트랜잭션으로 묶인 일련의 주문취소 메서드를
        호출해 보기 전 단일 메서드를 호출해 정상작동하는지 테스트

        ordEtcReqService.insertCancel(ordEtcReqDto);
        ordEtcReqService.insertOrderState(orderStateDto);
        ordEtcReqService.updateStateCode(orderDto);
        ordEtcReqService.updateOrdState(ordDetailDto);
        */

            ordEtcReqService.insertCancelInfo(session, ordEtcReqDto , orderDetailDto, orderDto, orderStateDto);

        return "redirect:/order/list";
    }

    /*
        주문반품기능

        1. 주문반품 정의 :  해당 주문번호의 주문상태가 배송중,배송완료,교환완료인 경우
               반품버튼 show

         2. flow
            2-1) 아이디별로 조회된 주문내역 페이지
            2-2)  특정 주문번호의 반품버튼 클릭
            2-3)   반품신청 페이지로 이동
                      - 해당 주문번호의 주문내역만 select하여 보여줌(주문상품정보)
                      - 반품사유선택/상세사유
                      - 반품배송비(반품귀책사유가 고객인지 업체인지에 따라서 다름)
                      - 수거신청 : 1. 수거신청 2. 직접발송
                      - 수거지정보 : 수거를 신청한 경우 작성
                      - a. 배송지정보와 동일 :  배송테이블에서 수령인정보와 배송지주소 불러오기
                           TODO :  배송지정보를 불러오는 방법 생각해보기 - 조인? 주문번호로 조회가능
                      - b. 수거지 변경 :  input태그로 직접 입력하게
                           TODO :  배송지정보를 불러온 상태에서 입력가능한 빈칸의 상태로 변환시키는 방법 알아보기

          3. 반품신청 시 영향을 받는 테이블
            a. order 테이블 : ord_state 업데이트
            b. ord_detail 테이블 : ord_state 업데이트
            c. ord_state 테이블 : 인서트
            d. ord_etc_req 테이블 : 인서트

            여기까지는 주문취소기능과 같다.

            TODO :  추가되는 기능은 없고 ord_etc_req 테이블에 insert 해야하는 컬럼들이 추가됨
            1. 수거신청여부
            2. 수거지변경여부
                    *수거지 변경여부 Y인 경우
                    1. 수거신청인이름
                    2. 신청인휴대전화
                    3. 수거지우편번호
                    4. 수거지기본주소
                    5. 수거지상세주소
                    --> 수거지 변경여부가 Y이면 입력받아서 인서트
                    --> 수거지 변경여부가 N이면 배송테이블에서 배송주소 받아와서 인서트

               *** 배송 db / 배송 mapper / 배송 dto  추가 필요/배송 dao/배송service

               배송과 반품신청과의 관계
               반품신청을 위 4개의 테이블을 업데이트하는 것 외에도 반품수거신청을 신청한경우에 반품수거를 해야한다.
               반품수거는 택배사로 요청(배송기능 구현필요) 배송테이블에 반품수거배송에대한 정보를 insert해야한다.

           !! 최종
            a. order 테이블 : ord_state 업데이트
            b. ord_detail 테이블 : ord_state 업데이트
            c. ord_state 테이블 : 인서트
            d. ord_etc_req 테이블 : 인서트
            e. dlv 테이블 : 인서트

                //TODO 배송관련 필요한 메서드

                (일부 더미데이터 넣어서 반품수거지 정보 가져올수있도록 세팅필요)

                 *** 인서트
                 1. 배송번호(일단은 auto_increment 설정하여 중복되지 않도록)
                 2. 주문번호
                 !! 운송장번호/택배사는 null가능한데 직접발송하는 고객의 경우 운송장번호를 바로 입력할 수 없을 수 있기 때문이다.
                  3. .교환반품수거신청여부(디폴트 'N' )
                  4. 수령인
                  5. 수령인전화번호
                  6. 배송지우편번호
                  7. 배송지기본주소
                  8. 배송지상세주소

                  *** 셀렉트
                  주문번호로 배송정보 조회하기
                  조회된 주소지와 수령인정보를 반품신청폼에 넣어준다.
     */

    @RequestMapping(value = "/refund")
    public String moveToRefundForm(String ord_num, Integer seq, Model m) throws Exception {

        String userId = "user1";
//        String userId = (String) session.getAttribute("userId");

        DeliveryDto deliveryDto = deliveryDao.selectByOrdNum(ord_num);
//        List<OrderDetailDto> refundList = orderDetailService.selectOneOrdDetail(ord_num);

        //240524 유경 수정 -> 전체반품에서 부분반품 가능하도록 1개의 주문내역만 선택하기 위함
        //list로 한 ord_num의 모든 주문내역을 받아오다가 단 한개만 가져온다.

        OrderDetailDto orderDetailDto = orderDetailService.selectOneSeq(ord_num,seq);
        m.addAttribute("reg_id",userId);
        m.addAttribute("up_id",userId);
        m.addAttribute("ord_num",ord_num);
        m.addAttribute("orderDetailDto",orderDetailDto);
        m.addAttribute("deliveryDto", deliveryDto);
        System.out.println(orderDetailDto);

        return "/order/orderRefundForm";
    }

    @RequestMapping(value = "/refundOrder")
    public String refundOrder(HttpSession session,Model m, OrdEtcReqDto ordEtcReqDto, OrderStateDto orderStateDto, OrderDetailDto orderDetailDto, OrderDto orderDto,DeliveryDto deliveryDto) throws Exception {


        String userId = "user1";
//        String userId = (String) session.getAttribute("userId");
        m.addAttribute("reg_id",userId);
        m.addAttribute("up_id",userId);

//        List<OrderDetailDto> list = orderDetailService.getOrderDetailsList("aaa");
//        //주문내역(list)을 모델에 담아 view로 보내준다
//        m.addAttribute("list", list);
        //주문내역을 불러올때 주문번호가 ordDetailDto에 담기기 때문에
        m.addAttribute("orderDetailDto", orderDetailDto);


        ordEtcReqService.insertRefundInfo(session, ordEtcReqDto , orderDetailDto, orderDto, orderStateDto, deliveryDto);

        return "redirect:/order/list";
     }

     /*
        구매확정
        구매상태가 배송완료,교환완료인 경우 주문상태에 구매확정버튼이 보여진다.
        //TODO 구매확정버튼 클릭 시,
        1. ord_state 테이블 인서트(상태코드 : CPS)
        2. ord_detail 태이블 주문상태 업데이트
        3. ord 테이블 주문상태 업데이트
     */
     @RequestMapping("/confirmPurchase")
     public String confirmPurchase(HttpSession session,OrderDto orderDto, OrderDetailDto orderDetailDto, OrderStateDto orderStateDto) throws Exception {

         ordEtcReqService.confirmPurchase(orderDto, orderDetailDto, orderStateDto);
            return "redirect:/order/list";
     }

     /*
        주문교환
        1. 주문교환의 정의
        기존의 주문상품을 새로운 상품과 교환 : 같은 상품으로의 교환만 가능
        (옵션변경 : 색 or 사이즈 / 둘중 한가지는 반드시 바뀌어야함)


           2. flow
                2-1) 아이디별로 조회된 주문내역 페이지
                2-2)  특정 주문번호의 교환버튼 클릭
                2-3)   교환신청 페이지로 이동
                      - 해당 주문번호의 주문내역만 select하여 보여줌(주문상품정보)
                      - 교환사유선택/상세사유
                      - 교환배송비(반품귀책사유가 고객인지 업체인지에 따라서 다름)
                      - 수거신청 : 1. 수거신청 2. 직접발송
                      - 수거지정보 : 수거를 신청한 경우 작성
                      - a. 배송지정보와 동일 :  배송테이블에서 수령인정보와 배송지주소 불러오기
                           TODO :  배송지정보를 불러오는 방법 생각해보기 - 조인? 주문번호로 조회가능
                      - b. 수거지 변경 :  input태그로 직접 입력하게
                           TODO :  배송지정보를 불러온 상태에서 입력가능한 빈칸의 상태로 변환시키는 방법 알아보기

          3. 교환신청 시 영향을 받는 테이블
            a. order 테이블 : ord_state 업데이트
            b. ord_detail 테이블 : ord_state 업데이트/상품옵션 업데이트
            c. ord_state 테이블 : 인서트
            d. ord_etc_req 테이블 : 인서트
            e. dlv 테이블 : 인서트

            4. 조회에 사용되는 테이블
            a. item
            b. item_size
            c. item_color
            조인해서 select한 뒤 itemOptionDto에 담아서 값을 넘겨줄 예정

     */

    @RequestMapping(value = "/exchange")
    public String moveToExchangeForm(HttpSession session,ItemOptionDto itemOptionDto, String item_num, String ord_num,  Integer seq, Model m) throws Exception {
        DeliveryDto deliveryDto = deliveryDao.selectByOrdNum(ord_num);

        String userId = "user1";
//        String userId = (String) session.getAttribute("userId");
        m.addAttribute("id",userId);


        OrderDetailDto orderDetailDto = orderDetailService.selectOneSeq(ord_num, seq);
        List<ItemOptionDto> colorList = orderDetailService.selectColorOption(item_num);
        List<ItemOptionDto> sizeList = orderDetailService.selectSizeOption(item_num);

        m.addAttribute("colorList", colorList);
        m.addAttribute("sizeList", sizeList);
        m.addAttribute("ord_num",ord_num);
        m.addAttribute("deliveryDto", deliveryDto);
        m.addAttribute("orderDetailDto", orderDetailDto);
        m.addAttribute("itemOptionDto", itemOptionDto);
        System.out.println(orderDetailDto);

        return "/order/orderExchangeForm";
    }

    @RequestMapping(value = "/exchangeOrder")
    public String exchangeOrder(HttpSession session, Model m,  String num, OrdEtcReqDto ordEtcReqDto, OrderStateDto orderStateDto, OrderDetailDto orderDetailDto, OrderDto orderDto, DeliveryDto deliveryDto, ItemOptionDto itemOptionDto) throws Exception {

        List<OrderDetailDto> list = orderDetailService.getOrderDetailsList("ugyung1");
        List<ItemOptionDto> colorList = orderDetailService.selectColorOption(num);
        List<ItemOptionDto> sizeList = orderDetailService.selectSizeOption(num);

        String userId = "user1";
//        String userId = (String) session.getAttribute("userId");
        m.addAttribute("id",userId);
        //주문내역(list)을 모델에 담아 view로 보내준다
        m.addAttribute("list", list);
        m.addAttribute("colorList", colorList);
        m.addAttribute("sizeList", sizeList);

        //주문내역을 불러올때 주문번호가 ordDetailDto에 담기기 때문에
        m.addAttribute("orderDetailDto", orderDetailDto);

        ordEtcReqService.insertExchangeInfo(session, ordEtcReqDto , orderDetailDto, orderDto, orderStateDto, deliveryDto);
        return "redirect:/order/list";
    }
}
