package com.neo.byez.controller;

import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.service.item.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ItemServiceImpl itemService;

    @RequestMapping("/")
    public String index(Model model) {
        ItemDto dto = new ItemDto();
        try {
            List<ItemDto> boardList;
            List<ItemDto> boardList2;
            List<ItemDto> boardList3;

            boardList = itemService.showWTop8(dto);
            boardList2 = itemService.showMTop8(dto);
            boardList3 = itemService.showUTop8(dto);

            model.addAttribute("boardList", boardList);
            model.addAttribute("boardList2", boardList2);
            model.addAttribute("boardList3", boardList3);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            return "errorPage";
        }
        return "index2";
    }


    @RequestMapping("/adminOrderDashBoard")
    public String adminOrderDashBoard() {
        return "adminOrderDashBoard";
    }

    @RequestMapping("/adminBoardDashBoard")
    public String adminBoardDashBoard() {
        return "adminBoardDashBoard";
    }

    @RequestMapping("/adminItemDashBoard")
    public String adminItemDashBoard() {
        return "adminItemDashBoard";
    }

    @RequestMapping("/adminCustDashBoard")
    public String adminCustDashBoard() {
        return "adminCustDashBoard";
    }

    @RequestMapping("/adminStaticDashBoard")
    public String adminStaticDashBoard() {
        return "adminStaticDashBoard";
    }

    @RequestMapping("/adminCouponDashBoard")
    public String adminCouponDashBoard() {
        return "adminCouponDashBoard";
    }

    @RequestMapping("/adminDashBoard")
    public String adminDashBoard() {
        return "adminDashBoard";
    }

}