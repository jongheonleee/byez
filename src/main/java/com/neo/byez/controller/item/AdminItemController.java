package com.neo.byez.controller.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminItemController {


    @GetMapping("/admin/item")
    public String index() {
        return "adminItem";
    }

    @GetMapping("/admin/itemForm")
    public String getAddForm() {
        return "adminItemForm";
    }

    @GetMapping("/admin/itemRegisterForm")
    public String getRegisterForm() {
        return "adminItemRegisterForm";
    }

}
