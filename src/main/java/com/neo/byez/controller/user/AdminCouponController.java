package com.neo.byez.controller.user;

import com.neo.byez.domain.CouponDto;
import com.neo.byez.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminCouponController {

    @Autowired
    CouponService couponService;

    @RequestMapping("/adminCreateCoupon")
    public String adminCreateCoupon() {

        return "adminCreateCoupon";
    }

    @RequestMapping("/adminGrantCoupon")
    public String adminGrantCoupon(Model model) throws Exception {

        List<CouponDto> couponList = couponService.getAllCouponInfo();

        model.addAttribute("couponList", couponList);

        return "adminGrantCoupon";
    }

}
