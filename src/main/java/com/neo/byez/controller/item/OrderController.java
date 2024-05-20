package com.neo.byez.controller.item;

import com.neo.byez.domain.item.BasketItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {

    @PostMapping("/order")
    public String list(BasketItemDto dto) {
        System.out.println("post");
        System.out.println(dto);
        return "index";
    }

}
