package com.neo.byez.controller.order;



import com.neo.byez.dao.order.OrdEtcReqDao;
import com.neo.byez.dao.order.OrderDetailDao;

import com.neo.byez.domain.PageHandler;

import com.neo.byez.domain.order.OrderDetailDto;
import com.neo.byez.service.order.OrderDetailService;
import com.neo.byez.service.order.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    OrderDetailDao orderDetailDao;
    @Autowired
    OrdEtcReqDao ordEtcReqDao;

    // 아이디별 전체 주문내역 보여주기
    @RequestMapping(value = "/list")
    public String orderDetailList(Model m, HttpSession session, Integer curPage, Integer pageSize) throws Exception {

        /*
        마이페이지의 주문/배송
        [주문내역]

        TODO 1. 아이디별 전체주문내역
            --> selectAll 로 전체 리스트 보여준다.
        2. 아이디별 취소/반품/교환내역
            --> 주문상태가 구매완료/배송완료/주문완료가 아닌 주문내역만 select하기
            --> selectAllEtc

        고객아이디는 세션에서 받아와서 조회가능
        임의로 cust DB에 저장된 aaa라는 고객아이디를 사용
        아이디별 주문내역 조회하기 메서드로 받은 값을 list에 담아 모델에 저장하여 view로 옮겨준다
         */

        String id = "user1";
//        session.setAttribute("id", "user1");
//        String id = (String) session.getAttribute("id");
//        System.out.println("아이디:" +id);

        try {
            List<OrderDetailDto> list = orderDetailService.getOrderDetailsList(id);
            List<OrderDetailDto> etcList = orderDetailService.selectAllEtc(id);
            System.out.println("주문내역리스트" + list);
            if(list.isEmpty() ){
                m.addAttribute("message", "조회결과가 없습니다.");
            }
            if (curPage == null) {
                curPage = 1;
            }
            if (pageSize == null) {
                pageSize = 10;
            }
            int totalCnt = orderDetailService.getCount();
            PageHandler ph = new PageHandler(totalCnt, curPage, pageSize);
            // System.out.println("ph : " +ph);
            Map map = new HashMap();
            map.put("offset", (curPage - 1) * 10);
            map.put("pageSize",  pageSize);

            List<OrderDetailDto> limitList = orderDetailService.getPage(map);
            // System.out.println(limitList.size() == 10);

            //페이징된것
            m.addAttribute("limitList", limitList);

            //페이징상관없이 selectAll한다.
            m.addAttribute("list", list);

            m.addAttribute("ph", ph);
            m.addAttribute("curPage", curPage);
            m.addAttribute("pageSize", pageSize);
            m.addAttribute("etcList", etcList);
        } catch (IndexOutOfBoundsException e) {
            return "/order/list";
        }
        return "/order/list";
    }

    /*주문취소 반품 교환리스트 보여주기*/
//    @RequestMapping(value = "/etcList")
//    public String orderEtcList(Model m, Integer curPage, Integer pageSize) throws Exception {
//
//        /*
//        마이페이지의 주문/배송
//        [주문내역]
//
//        1. 아이디별 전체주문내역
//            --> selectAll 로 전체 리스트 보여준다.
//         TODO 2. 아이디별 취소/반품/교환내역
//            --> 주문상태가 구매완료/배송완료/주문완료가 아닌 주문내역만 select하기
//            --> selectAllEtc
//
//        고객아이디는 세션에서 받아와서 조회가능
//        임의로 cust DB에 저장된 aaa라는 고객아이디를 사용
//        아이디별 주문내역 조회하기 메서드로 받은 값을 list에 담아 모델에 저장하여 view로 옮겨준다
//         */
//
//        String id = "asdf1234";
//
//        try {
//            List<OrderDetailDto> etcList = orderDetailService.selectAllEtc(id);
//            System.out.println("취소반품교환리스트" + etcList);
//            List<OrderDetailDto> list1 = orderDetailService.getOrderDetailsList("asdf1234");
//            System.out.println("기존의 리스트" + list1);
//            if(etcList.isEmpty() ){
//                m.addAttribute("message", "조회결과가 없습니다.");
//            }
//            if (curPage == null) {
//                curPage = 1;
//            }
//            if (pageSize == null) {
//                pageSize = 10;
//            }
//            int totalCnt = orderDetailService.getCount();
//            PageHandler ph = new PageHandler(totalCnt, curPage, pageSize);
//            // System.out.println("ph : " +ph);
//            Map map = new HashMap();
//            map.put("offset", (curPage - 1) * 10);
//            map.put("pageSize",  pageSize);
//
//            List<OrderDetailDto> limitList = orderDetailService.getPage(map);
//            // System.out.println(limitList.size() == 10);
//            m.addAttribute("limitList", limitList);
//            m.addAttribute("ph", ph);
//            m.addAttribute("curPage", curPage);
//            m.addAttribute("pageSize", pageSize);
//            m.addAttribute("etcList", etcList);
//        } catch (IndexOutOfBoundsException e) {
//            return  "redirect:/order/list2";
//        }
//        return  "redirect:/order/list2";
//    }


}