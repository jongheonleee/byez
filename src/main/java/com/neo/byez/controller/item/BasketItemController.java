package com.neo.byez.controller.item;


import com.neo.byez.common.validator.BasketItemValidator;
import com.neo.byez.domain.item.BasketDto;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.BasketItemDtos;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.OrderItemDto;
import com.neo.byez.domain.item.OrderItemDtos;
import com.neo.byez.service.item.BasketItemService;
import com.neo.byez.service.item.BasketItemServiceImpl;
import com.neo.byez.service.item.ItemServiceImpl;
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

    private BasketItemServiceImpl basketService;

    private ItemServiceImpl itemService;

    @Autowired
    public BasketItemController(BasketItemServiceImpl basketService, ItemServiceImpl itemService) {
        this.basketService = basketService;
        this.itemService = itemService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(new BasketItemValidator());
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
        id = "user1";
        dto.setId(id);
        try {
            // 해당 유저의 장바구니 상품 목록 조회
            List<BasketItemDto> list = basketService.getBasketItem(dto);
            int cnt = basketService.getCount(dto);

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
        id = "user1";
        dto.setId(id);
        try {
            ItemDto selectedDto = itemService.getItem(dto.getNum());
            dto.setMain_img(selectedDto.getMain_img());

            System.out.println(dto);
            if (!basketService.register(dto)) {
                return new ResponseEntity<>("장바구니 상품을 등록하지 지못했습니다.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("장바구니 상품을 등록하지 못했습니다.", HttpStatus.OK);
    }

    @PostMapping("/basket/delete")
    public String remove(BasketItemDto dto, RedirectAttributes ratt, HttpSession session) {
        String id = (String) session.getAttribute("id");
        id = "user1";
        dto.setId(id);
        if (!basketService.remove(dto)) {
            ratt.addAttribute("msg", "상품을 정상적으로 ");
        }

        return "redirect:/basket";
    }

    @GetMapping("/basket/delete/several")
    public String removeSeveral(@Valid BasketItemDtos dtos, RedirectAttributes ratt, HttpSession session) {
        // 여러 상품 삭제
        try {
            if (!basketService.removeSeveral(dtos)) {
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
        String id = (String) session.getAttribute("id");
        id = "user1";
        dto.setId(id);

        if (!basketService.removeAll(dto)) {
            ratt.addAttribute("msg", "상품을 정상적으로 모두 삭제하지 못했습니다.");
        }

        // 기존의 상품 페이지로 이동
        return "redirect:/basket";
    }


    @PostMapping("/basket/update")
    public String modify(@Valid BasketItemDto dto, RedirectAttributes ratt, HttpSession session) {
        String id = (String) session.getAttribute("id");
        id = "user1";
        dto.setId(id);
        System.out.println(dto);

        // 서비스로 해당 상품 수정
        try {
            ItemDto selectedDto = itemService.getItem(dto.getNum());
            dto.setMain_img(selectedDto.getMain_img());

            if (!basketService.modify(dto)) {
                throw new Exception("상품을 정상적으로 변경하지 못했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 기존 상품 페이지로 이동
        return "redirect:/basket";
    }

    @PostMapping("/order")
    public String order(BasketItemDtos dtos, Model model) {
        List<BasketItemDto> list = dtos.getOrders();
        for (BasketItemDto dto : list) {
            System.out.println(dto);
        }

        System.out.println("dede");
        model.addAttribute("list", list);
        return "order";
    }


}
