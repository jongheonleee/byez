package com.neo.byez.controller.item;


import com.neo.byez.common.validator.BasketItemValidator;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.BasketItemDtos;
import com.neo.byez.domain.item.OrderItemDto;
import com.neo.byez.domain.item.OrderItemDtos;
import com.neo.byez.service.item.BasketItemService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static com.neo.byez.common.config.BasketItemConstant.*;
import static com.neo.byez.common.message.ErrorMessage.*;

@Controller
public class BasketItemController {

    @Autowired
    private BasketItemService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new BasketItemValidator());
    }

    // 장바구니 기능
        // 유저의 장바구니 상품 목록을 보여줌 .
        // 유저의 장바구니 상품을 추가함 .
        // 유저의 장바구니 상품을 삭제함 .
        // 유저의 장바구니 상품을 수정함

    // 유저의 장바구니 상품 목록을 보여줌
    @GetMapping("/basket")
    public String list(BasketItemDto dto, Model model, String msg, HttpSession session) {
        String id = (String) session.getAttribute("id");
        id = "1";
        dto.setId(id);
        try {
            // 해당 유저의 장바구니 상품 목록 조회
            List<BasketItemDto> list = service.getBasketItem(dto);
            int cnt = service.getCount(dto);

            // 모델에 저장
            session.setAttribute("cnt", cnt);
            model.addAttribute("cnt", cnt);
            model.addAttribute("list", list);
            model.addAttribute("msg", msg);

            // 페이지 이동
            return "basket";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", ITEM_SELECT_FAIL.getMessage());

            return "basket";
        }
    }

    //
    // 유저의 장바구니 상품을 추가함
    @PostMapping("/basket/add")
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody BasketItemDto dto, RedirectAttributes ratt, HttpSession session) {
        String id = (String) session.getAttribute("id");
        id = "1";
        dto.setId(id);
        System.out.println(dto);
        if (!service.register(dto)) {
            return new ResponseEntity<>("장바구니 상품을 등록하지 지못했습니다.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("장바구니 상품을 등록하지 못했습니다.", HttpStatus.OK);
    }

    @PostMapping("/basket/delete")
    public String remove(BasketItemDto dto, RedirectAttributes ratt, HttpSession session) {
        String id = (String) session.getAttribute("id");
        id = "1";
        dto.setId(id);
        if (!service.remove(dto)) {
            ratt.addAttribute("msg", "상품을 정상적으로 ");
        }

        return "redirect:/basket";
    }

    @GetMapping("/basket/delete/several")
    public String removeSeveral(@Valid BasketItemDtos dtos, RedirectAttributes ratt, HttpSession session) {
        // 여러 상품 삭제
        try {
            if (!service.removeSeveral(dtos)) {
                throw new Exception("제대로 삭제되지 않았습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ratt.addAttribute("msg", e.getMessage());
            return "redirect:/basket";
        }


        // 기존 페이지로 이동
        return "redirect:/basket";
    }

    @PostMapping("/basket/delete/all")
    public String removeAll(BasketItemDto dto, RedirectAttributes ratt, HttpSession session) {
//        String id = (String) session.getAttribute("id");
//        id = "1";
//        dto.setId(id);

        if (!service.removeAll(dto)) {
            ratt.addAttribute("msg", "상품을 정상적으로 모두 삭제하지 못했습니다.");
        }

        // 기존의 상품 페이지로 이동
        return "redirect:/basket";
    }


    @PostMapping("/basket/update")
    public String modify(@Valid BasketItemDto dto, RedirectAttributes ratt, HttpSession session) {
        String id = (String) session.getAttribute("id");
        id = "1";
        dto.setId(id);
        System.out.println(dto);

        // 서비스로 해당 상품 수정
        try {
            if (!service.modify(dto)) {
                throw new Exception("상품을 정상적으로 변경하지 못했습니다.");
            }
        } catch (Exception e) {
            ratt.addAttribute("msg", e.getMessage());
        }


        // 기존 상품 페이지로 이동
        return "redirect:/basket";
    }

//    @PostMapping("/order")
//    public String order(OrderItemDtos opd, Model model) {
//        List<OrderItemDto> list = opd.getOrders();
//        for (OrderItemDto dto : list) {
//            System.out.println(dto);
//        }
//
//        model.addAttribute("list", list);
//        return "order";
//    }


}


// 서비스로 해당 상품 등록
//        try {
//            int rowCnt = service.register(dto);
//            // 적용되지 않음
//            if (rowCnt != 1) {
//                throw new Exception(ITEM_REGISTER_FAIL.getMessage());
//            }
//
//            // 기존의 장바구니 상품 페이지로 이동, 💥어떤 것을 쓸지 고민해보기(여기서 굳이 redirect를 써야할까??)
//            return "redirect:/basket2";
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("msg", e.getMessage());
//            return "inbasket2";
//        }


// 서비스로 유저의 장바구니 상품 모두 삭제
//        try {
//            int rowCnt = service.removeAll(dto);
//        } catch (Exception e) {
//            model.addAttribute("msg", e.getMessage());
//            return "basket2";
//        }

// 서비스로 해당 상품 삭제
//        try {
//            int rowCnt = service.remove(dto);
//            if (rowCnt != 1) {
//                throw new Exception(ITEM_REMOVE_FAIL.getMessage());
//            }
//
//            // 기존의 상품 페이지로 이동
//            return "redirect:/basket";
//        } catch (Exception e) {
//            model.addAttribute("msg", e.getMessage());
//            return "basket2";
//        }