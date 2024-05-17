package com.neo.byez.controller;

import com.neo.byez.domain.UserCouponDetails;
import com.neo.byez.service.CustCouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CustCouponsController {

    @Autowired
    CustCouponsService custCouponsService;

    // 마이페이지 쿠폰함
    @RequestMapping("/goMyCouponPage")
    public String goMyCouponPage(HttpServletRequest request, Model model) throws Exception {

        // 현재 접속 고객의 id정보를 가져옴
//        HttpSession session = request.getSession();
//        String loginId = (String) session.getAttribute("loginId");

        String loginId = "spa11";

        // 고객의 id정보로 보유쿠폰들을 가져와서 view에 전달
        List<UserCouponDetails> coupons = custCouponsService.getUserCouponDetailsByUserId(loginId);
        model.addAttribute("coupons", coupons);

        return "myCouponPage";
    }

    @RequestMapping("/grantCoupon")
    public String grantCoupon(String userId, String couponName) throws Exception {

        custCouponsService.grantCouponToUser(userId, couponName);

        return "redirect: /home";
    }

}
