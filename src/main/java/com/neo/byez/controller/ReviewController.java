package com.neo.byez.controller;

import com.neo.byez.domain.ReviewItemJoinDto;
import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.order.OrderDetailDto;
import com.neo.byez.service.ReviewServiceImpl;
import com.neo.byez.service.order.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewServiceImpl reviewServiceimpl;
    @Autowired
    OrderDetailService ordDetailServiceImpl;

    @GetMapping("/list")
    public String list(Model model, HttpSession httpSession) {
        //SESSION 통해 현재 접속해있는 고객의 ID값을 가져와야한다. 현재는 "asdf"로 설정해주도록 한다.
        //on이 리뷰완료된것 off가 리뷰안된것
        String userId = (String) httpSession.getAttribute("userId");
        List<OrderDetailDto> reviewOfflist = ordDetailServiceImpl.searchById(userId);
        List<ReviewItemJoinDto> reviewOnList = reviewServiceimpl.searchJoinItem(userId);
        model.addAttribute("reviewOffList", reviewOfflist);
        model.addAttribute("reviewOnList", reviewOnList);
        return "reviewList";
    }

    @GetMapping("/write")
    public String writeStart(HttpServletRequest httpServletRequest, Model model,HttpSession httpSession) {
        // 또한 여기서 sqlsession을 통해 id값을 가져와야한다.
        String ord_num = httpServletRequest.getParameter("ord_num");
        String item_num = httpServletRequest.getParameter("item_num");
        String userId = (String) httpSession.getAttribute("userId");
        // url을 통한 validate
        if( !ordDetailServiceImpl.validateSearchOrdItem(ord_num,item_num,userId)){
            return "redirect:/review/list";
        }
        OrderDetailDto ordDetailDto = ordDetailServiceImpl.searchOrdItem(ord_num, item_num, userId);
        //값이 잘못들어가서 위에 nullpointException 경우 생각해서 test 코드 작성 및 예외처리 해주기
        model.addAttribute("ordDetailDto", ordDetailDto);
        model.addAttribute("mode", "write");
        return "reviewWrite";
    }

    @PostMapping("/write")
    public String writeEnd(ReviewDto reviewDto,HttpSession httpSession) {
        //해당 밑 부분은 리팩토링해야함 + sqlsession으로 가져와야하는 것을 잊지말것
        String userId = (String) httpSession.getAttribute("userId");
        reviewDto.setId(userId);
        reviewDto.setReg_id(userId);
        reviewDto.setUp_id(userId);
        reviewDto.setWriter(userId);
        reviewServiceimpl.write(reviewDto);
        ordDetailServiceImpl.changeReviewState(reviewDto);
        return "redirect:/review/list";
    }

    @GetMapping("/modify")
    public String modifyStart(HttpServletRequest httpServletRequest, Model model,HttpSession httpSession) {
        String ord_num = httpServletRequest.getParameter("ord_num");
        String item_num = httpServletRequest.getParameter("item_num");
        String userId = (String) httpSession.getAttribute("userId");
        Integer review_num;
        // Integer 값 받을 때, NumberFormatException 체크
        try{review_num=Integer.valueOf(httpServletRequest.getParameter("review_num"));}
        catch (NumberFormatException e){
            return "redirect:/review/list";
        }
        // url을 통한 validate
        if( !ordDetailServiceImpl.validateSearchOrdItem(ord_num,item_num,userId)){
            return "redirect:/review/list";
        }
        //ordDetailDto를 통해서 주문번호와 상품번호를 통해서 고객이 선택한 opt를 가져오도록 한다. (리뷰 테이블에 옵션 컬럼 추가방안고민)
        OrderDetailDto ordDetailDto = ordDetailServiceImpl.searchOrdItem(ord_num, item_num, userId);
        // reviewDto에서 seq_num을 통해 고객이 입력했던 제목과 내용값을 가져와야 한다.
        ReviewDto reviewDto = reviewServiceimpl.searchByReviewNum(review_num);
        model.addAttribute("ordDetailDto", ordDetailDto);
        model.addAttribute("reviewDto", reviewDto);
        model.addAttribute("mode", "update");
        return "reviewWrite";
    }

    @PostMapping("/modify")
    public String modifyEnd(ReviewDto reviewDto) {
        reviewServiceimpl.modify(reviewDto);
        return "redirect:/review/list";
    }

    @GetMapping("/delete")
    public String delete() {
        return null;
    }
}
