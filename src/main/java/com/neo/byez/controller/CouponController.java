package com.neo.byez.controller;

import com.neo.byez.domain.CouponDto;
import com.neo.byez.service.CouponService;
import com.neo.byez.service.CustCouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CouponController {

    @Autowired
    CouponService couponService;

    @Autowired
    CustCouponsService custCouponsService;

    @RequestMapping("/goGrantCouponForm")
    public String goGrantCouponForm() throws Exception {
        return "grantCouponForm";
    }



    @RequestMapping("/goManageCoupons")
    public String goManageCoupons(Model model) throws Exception {

        List<CouponDto> couponList = couponService.getAllCouponInfo();

        model.addAttribute("couponList", couponList);
        return "manageCoupons";
    }

    @RequestMapping("/goCreateCoupon")
    public String goCreateCoupon() throws Exception {

        return "createCoupon";
    }

    @RequestMapping("/createCouponType")
    public String createCouponType(@Valid CouponDto couponDto, BindingResult bindingResult, Model model) throws Exception {

        if (bindingResult.hasErrors()) {
            // 유효성 검사 오류가 있는 경우 다시 등록 폼으로 이동
            model.addAttribute("error", "잘못된 정보가 등록되었습니다. 재등록바랍니다.");
            return "createCoupon";
        }

        couponService.createCouponType(couponDto);

        return "redirect: /goManageCoupons";
    }

    @RequestMapping("/deleteCouponType")
    public String deleteCouponType(String name) throws Exception {

        couponService.removeCouponTypeByName(name);

        return "redirect: /goManageCoupons";
    }

}