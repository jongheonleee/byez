package com.neo.byez.controller.item;


import com.neo.byez.domain.item.Category;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.service.item.ItemServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

//    @ResponseBody
//    @GetMapping("/")
//    public String home(Model model) {
//
//        try {
//            List<ItemDto> list = itemService.getAllItem();
//            model.addAttribute("list", list);
//        } catch (Exception e) {
//            model.addAttribute("err", "상품을 잘못 조회했습니다.");
//            e.printStackTrace();
//        }
//        return "index";
//    }

    @GetMapping("/item/categories/{code}")
    public String list(@PathVariable String code) {
        Category category = new Category(code);
        System.out.println(category.getItem_type());
        return "index";
    }

    @GetMapping("/item/categories/best")
    public String bestList() {
        // 베스트 상품들 조회
        // 페이지에 뿌리기
        System.out.println("best!");
        return "index";
    }

    @GetMapping("/item/categories/discount")
    public String discList() {
        // 할인 상품들 조회
        // 페이지에 뿌리기
        System.out.println("discount");
        return "index";
    }

    @GetMapping("/goods/{itemNum}")
    public String detail(@PathVariable String itemNum) {
        // 해당 상품 조회
        // 상세 페이지에 뿌리기
        System.out.println("detail");
        return "index";
    }

    @PostMapping("/goods/{itemNum}")
    public String order(@PathVariable String itemNum, @RequestBody ItemDto dto) {
        // 해당 상품 조회
        // 해당 주문 내역 주문 페이지로 이동
        System.out.println("go to order!!");
        return "index";
    }

}
