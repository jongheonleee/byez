package com.neo.byez.controller.item;

import com.neo.byez.common.validator.LikeItemValidator;
import com.neo.byez.domain.item.LikeItemDto;
import com.neo.byez.domain.item.LikeItemDtos;
import com.neo.byez.service.item.LikeItemService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/like")
public class LikeItemController {

    @Autowired
    private LikeItemServiceImpl service;

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
    public String list(Model model, HttpSession session, String msg) {
        // 세션에서 아이디 조회
        // 로그인
            // 로그인 되어 있으면
                // 좋아요 페이지 이동
            // 로그인 안되있으면
                // 메인 페이지로 이동
        String id = (String) session.getAttribute("id");
        id = "1";

        try {
            List<LikeItemDto> list = service.getLikeItem(id);
            model.addAttribute("list", list);
            model.addAttribute("msg", msg);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", e.getMessage());
        }

        return "like";
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid LikeItemDto dto, RedirectAttributes ratt, HttpSession session) {
        // 세션에서 아이디 조회
        // 로그인
            // 로그인 되어 있으면
                // 좋아요 상품 등록
                // 좋아요 페이지 이동
            // 로그인 안되있으면
                // 메인 페이지로 이동
        String id = (String) session.getAttribute("id");
        id = "1";
        dto.setId(id);

        if (!service.register(dto)) {
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
        String id = (String) session.getAttribute("id");
        id = "1";
        dto.setId(id);

        if (!service.remove(dto)) {
            ratt.addAttribute("msg", "상품을 정상적으로 삭제하지 못했습니다.");
        }

        return "redirect:/like";
    }

    @GetMapping("/remove/several")
    public String removeSeveral(LikeItemDtos dtos, RedirectAttributes ratt, HttpSession session) {
        try {
            service.removeSeveral(dtos);
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
        String id = (String) session.getAttribute("id");
        id = "1";
        dto.setId(id);

        if (!service.modify(dto)) {
            ratt.addAttribute("msg", "상품을 정상적으로 변경하지 못했습니다.");
        }

        return "redirect:/like";
    }
}


