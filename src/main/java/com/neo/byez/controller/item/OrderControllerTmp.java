package com.neo.byez.controller.item;

import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.BasketItemDtos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderControllerTmp {

    @GetMapping("/order")
    public String list(Model model) {
        BasketItemDtos dtos = (BasketItemDtos) model.getAttribute("dtos");
        for (BasketItemDto dto : dtos.getOrders()) {
            System.out.println(dto);
        }

        return "index";
    }

}
