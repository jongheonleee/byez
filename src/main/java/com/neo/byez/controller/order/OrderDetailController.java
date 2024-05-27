package com.neo.byez.controller.order;



import com.neo.byez.dao.order.OrdEtcReqDao;
import com.neo.byez.dao.order.OrderDetailDao;

import com.neo.byez.domain.PageHandler;

import com.neo.byez.domain.order.EtcListRequestDto;
import com.neo.byez.domain.order.EtcListResponseDto;
import com.neo.byez.domain.order.OrderDetailDto;
import com.neo.byez.service.order.OrderDetailService;
import com.neo.byez.service.order.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // 아이디별 전체 주문내역 보여주기(Ajax)
    @PostMapping(value = "/listData")
    @ResponseBody
    public ResponseEntity<EtcListResponseDto> getOrderList(@RequestBody EtcListRequestDto requestDto, HttpSession session) throws Exception {


        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Integer curPage = requestDto.getCurPage() != null ? requestDto.getCurPage() : 1;
        Integer pageSize = requestDto.getPageSize() != null ? requestDto.getPageSize() : 10;

        List<OrderDetailDto> orderList = orderDetailService.getOrderDetailsList(userId);
        int totalCnt = orderDetailService.getCount(userId);
        PageHandler ph = new PageHandler(totalCnt, curPage, pageSize);
        List<OrderDetailDto> limitOrderList = orderDetailService.getPage(curPage, pageSize, userId);

        EtcListResponseDto response = new EtcListResponseDto();
        response.setItems(limitOrderList);
        response.setCurrentPage(ph.getCurPage());
        response.setTotalPages(ph.getTotalPages());
        response.setHasNext(ph.isShowNext());
        response.setHasPrevious(ph.isShowPrev());

        return ResponseEntity.ok(response);
    }
    
    //아이디별 취소반품교환내역 보여주기(Ajax)
    @RequestMapping("/etcListData")
    @ResponseBody
    public ResponseEntity<EtcListResponseDto> getEtcList(@RequestBody EtcListRequestDto requestDto, HttpSession session) throws Exception {
        // 세션에서 userId 가져오기
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();  // 또는 적절한 예외 처리
        }

        // 페이징 처리를 위한 기본값 설정
        Integer curPage = requestDto.getCurPage() != null ? requestDto.getCurPage() : 1;
        Integer pageSize = requestDto.getPageSize() != null ? requestDto.getPageSize() : 10;

        // 데이터 조회
        List<OrderDetailDto> etcList = orderDetailService.selectAllEtc(userId);
        int etcTotalCnt = orderDetailService.getEtcCount(userId);
        PageHandler phEtc = new PageHandler(etcTotalCnt, curPage, pageSize);
        List<OrderDetailDto> limitEtcList = orderDetailService.getEtcPage(curPage, pageSize, userId);

        // 응답 객체 생성 및 설정
        EtcListResponseDto response = new EtcListResponseDto();
        response.setItems(limitEtcList);  // 필터링 또는 전체 리스트 중 선택한 페이지의 리스트만 보내기
        response.setCurrentPage(phEtc.getCurPage());
        response.setTotalPages(phEtc.getTotalPages());
        response.setHasNext(phEtc.isShowNext());
        response.setHasPrevious(phEtc.isShowPrev());


        // 리스트가 비어 있을 경우
//        if (etcList.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }

        return ResponseEntity.ok(response);
    }

    //첫 주문내역화면 띄우기
    @GetMapping(value = "/list")
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
        임의로 cust DB에 저장된 user1이라는 고객아이디를 사용
        아이디별 주문내역 조회하기 메서드로 받은 값을 list에 담아 모델에 저장하여 view로 옮겨준다
         */

        String userId = (String) session.getAttribute("userId");

        try {
            List<OrderDetailDto> list = orderDetailService.getOrderDetailsList(userId);
            if (curPage == null) {
                curPage = 1;
            }
            if (pageSize == null) {
                pageSize = 10;
            }
            int totalCnt = orderDetailService.getCount(userId);

            PageHandler ph = new PageHandler(totalCnt, curPage, 10);

            List<OrderDetailDto> limitList = orderDetailService.getPage(curPage, pageSize, userId);

            if(limitList.isEmpty() ){
                m.addAttribute("listMessage", "조회결과가 없습니다.");
            }

//                if(etcList.isEmpty()){
//                    m.addAttribute("etcMessage", "조회결과가 없습니다.");
//            }

            //페이징된것
            m.addAttribute("limitList", limitList);

            //페이징상관없이 selectAll한다.
            m.addAttribute("list", list);

            m.addAttribute("ph", ph);

            m.addAttribute("curPage", curPage);
            m.addAttribute("pageSize", pageSize);

        } catch (IndexOutOfBoundsException e) {
            return "/order/list";
        }
        return "/order/list";
    }
}

