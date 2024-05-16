package com.neo.byez.controller;

import com.neo.byez.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    TestServiceImpl testService;

//    @RequestMapping("/")
//    public String now(Model m){
//        String result = "";
//        result = testService.now();
//        if (result.equals("")){
//            m.addAttribute("msg", "Error");
//        }
//        m.addAttribute("now", result);
//        return "index";
//    }
}
