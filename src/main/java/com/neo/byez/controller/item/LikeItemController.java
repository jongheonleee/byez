package com.neo.byez.controller.item;

import com.neo.byez.common.validator.LikeItemValidator;
import com.neo.byez.dao.item.BasketItemDaoImpl;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.LikeItemDto;
import com.neo.byez.domain.item.LikeItemDtos;
import com.neo.byez.domain.item.PageHandler;
import com.neo.byez.domain.item.SearchCondition;
import com.neo.byez.service.item.BasketItemServiceImpl;
import com.neo.byez.service.item.ItemServiceImpl;
import com.neo.byez.service.item.LikeItemServiceImpl;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/like")
public class LikeItemController {


    private ItemServiceImpl itemService;

    private BasketItemServiceImpl basketItemService;

    private LikeItemServiceImpl likeItemService;

    @Autowired
    public LikeItemController(ItemServiceImpl itemService, LikeItemServiceImpl likeItemService, BasketItemServiceImpl basketItemService) {
        this.itemService = itemService;
        this.likeItemService = likeItemService;
        this.basketItemService = basketItemService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new LikeItemValidator());
    }

    // 좋아요 상품 기능
        // 유저의 좋아요 상품 목록을 보여줌
        // 유저의 좋아요 상품 추가함
        // 유저의 좋아요 상품 삭제함
        // 유저의 좋아요 상품 변경함
    @GetMapping()
    public String list(SearchCondition sc, Model model, HttpSession session, String msg) {
        int likeCnt = 0; // 장바구니 상품 카운트 기록
        int basketCnt = 0;

        try {
            // 세션 아이디 조회
            String id = (String) session.getAttribute("userId");
            if (id != null) {
                BasketItemDto dto = new BasketItemDto();
                dto.setId(id);
                // 장바구니 수 카운트
                basketCnt = basketItemService.getCount(dto);
            }

            // 좋아요 상품 조회
            List<LikeItemDto> list = likeItemService.getSelectedPage(id, (sc.getPage()-1)*sc.getPageSize(), sc.getPageSize());

            // ph 생성
            int totalCnt = likeItemService.getCount(id);
            PageHandler ph = new PageHandler(totalCnt, sc);

            // 장바구니 수 카운트 저장
            // ph 저장
            // 좋아요 상품 리스트 저장
            model.addAttribute("basketCnt", basketCnt);
            model.addAttribute("likeCnt", likeCnt);
            model.addAttribute("list", list);
            model.addAttribute("ph", ph);

        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "errorPage";
        }

        return "like";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody LikeItemDto dto, RedirectAttributes ratt, HttpSession session) {
        String id = (String) session.getAttribute("userId");
        dto.setId(id);
        if (!likeItemService.register(dto)) {
            return new ResponseEntity<>("좋아요 상품을 등록하지 못했습니다.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("좋아요 상품을 등록했습니다.", HttpStatus.OK);

    }

    @PostMapping("/remove")
    public String remove(@Valid LikeItemDto dto, RedirectAttributes ratt, HttpSession session) {
        // 세션에서 아이디 조회
        // 로그인
            // 로그인 되어 있으면
                // 좋아요 상품 삭제
                // 좋아요 페이지 이동
        // 로그인 안되있으면
                // 메인 페이지로 이동
        String id = (String) session.getAttribute("userId");
        dto.setId(id);


        if (!likeItemService.remove(dto)) {
            ratt.addAttribute("msg", "상품을 정상적으로 삭제하지 못했습니다.");
        }

        return "redirect:/like";
    }

    @GetMapping("/remove/several")
    public String removeSeveral(LikeItemDtos dtos, RedirectAttributes ratt, HttpSession session) {
        try {
            likeItemService.removeSeveral(dtos);
        } catch (Exception e) {
            e.printStackTrace();
            ratt.addAttribute("msg", "err");
        }

        return "redirect:/like";
    }

    @PostMapping("/modify")
    public String modify(@Valid LikeItemDto dto, RedirectAttributes ratt, HttpSession session) {
        // 세션에서 아이디 조회
        // 로그인
            // 로그인 되어 있으면
                // 좋아요 상품 변경
                // 좋아요 페이지 이동
            // 로그인 안되있으면
                // 메인 페이지 이동
        String id = (String) session.getAttribute("userId");
        dto.setId(id);

        if (!likeItemService.modify(dto)) {
            ratt.addAttribute("msg", "상품을 정상적으로 변경하지 못했습니다.");
        }

        return "redirect:/like";
    }
}


