package com.neo.byez.controller.item;


import com.neo.byez.domain.item.*;
import com.neo.byez.service.item.*;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ItemController {

    private ItemServiceImpl itemService;

    private BasketItemServiceImpl basketItemService;


    @Autowired
    public ItemController(ItemServiceImpl itemService, BasketItemServiceImpl basketItemService) {
        this.itemService = itemService;
        this.basketItemService = basketItemService;
    }


    @GetMapping("/item/categories/{type}")
    public String categoryList(@PathVariable String type, SearchCondition sc, Model model, HttpSession session) {
        // 추가적으로 페이징 핸들러 처리
        int cnt = 0;
        try {
            // 세션에서 아이디 조회
            String id = (String) session.getAttribute("id");
            id = "user1";
            if (id != null) {
                BasketItemDto dto = new BasketItemDto();
                dto.setId(id);
                // 장바구니 상품 수량 조회
                cnt = basketItemService.getCount(dto);
            }

            // 카테고리 상품 조회
            sc.setTypeKeyword(type);
            sc.checkOption();
            List<ItemDto> list = itemService.readBySearchCondition(sc);

            // 페이징 처리
            int searchCnt = itemService.countSearchCondition(sc);
            PageHandler ph = new PageHandler(searchCnt, sc);

            // 모델 저장 및 페이지 이동
            model.addAttribute("cnt", cnt);
            model.addAttribute("searchCnt", searchCnt);
            model.addAttribute("list", list);
            model.addAttribute("ph", ph);
            model.addAttribute("type", type);

            // 해당하는 카테고리 페이지로 전달
            if (type.length() >= 2 && type.charAt(0) == '0' && type.charAt(1) == '1') {
                return "category01";
            } else if (type.length() >= 2 && type.charAt(0) == '0' && type.charAt(1) == '2') {
                return "category02";
            } else {
                return "category03";
            }
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "errorPage";
        }
    }

    @GetMapping("/item")
    public String itemList(SearchCondition sc, Model model, HttpSession session) {
        // 추가적으로 페이징 핸들러 처리
        int cnt = 0;
        try {
            // 세션에서 아이디 조회
            String id = (String) session.getAttribute("id");
            if (id != null) {
                BasketItemDto dto = new BasketItemDto();
                dto.setId(id);
                // 장바구니 상품 수량 조회
                cnt = basketItemService.getCount(dto);
            }

            // 카테고리 상품 조회
            sc.checkOption();
            List<ItemDto> list = itemService.readBySearchCondition(sc);

            // 페이징 처리
            int searchCnt = itemService.countSearchCondition(sc);
            PageHandler ph = new PageHandler(searchCnt, sc);

            // 모델 저장 및 페이지 이동
            model.addAttribute("cnt", cnt);
            model.addAttribute("searchCnt", searchCnt);
            model.addAttribute("list", list);
            model.addAttribute("ph", ph);
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "errorPage";
        }

        return "category02";
    }



    @GetMapping("/item/best")
    public String bestList() {
        // 베스트 상품들 조회
        // 페이지에 뿌리기
        return "index";
    }

    @GetMapping("/item/discount")
    public String discList(SearchCondition sc, Model model, HttpSession session) {
        // 추가적으로 페이징 핸들러 처리
        int cnt = 0;
        try {
            // 세션에서 아이디 조회
            String id = (String) session.getAttribute("id");
            id = "user1";
            if (id != null) {
                BasketItemDto dto = new BasketItemDto();
                dto.setId(id);
                // 장바구니 상품 수량 조회
                cnt = basketItemService.getCount(dto);
            }

            // 할인 상품 조회, 상위 8개만 보여주기, 이 로직 서비스에서 따로 관리
                // 맨투맨/스웨트셔츠 0101
                // 후드/집업 0102
                // 니트/스웨터 0103
                // 폴리스/덤블 0202
                // 가디건 0205
                // 셔츠/블라우스 0104
                // 슬랙스 0301
            sc.setOption("T");
            sc.setPageSize(8);

            sc.setTypeKeyword("0101");
            List<ItemDto> list1 = itemService.readDiscountItem(sc);

            sc.setTypeKeyword("0102");
            List<ItemDto> list2 = itemService.readDiscountItem(sc);

            sc.setTypeKeyword("0202");
            List<ItemDto> list3 = itemService.readDiscountItem(sc);

            sc.setTypeKeyword("0204");
            List<ItemDto> list4 = itemService.readDiscountItem(sc);

            sc.setTypeKeyword("0301");
            List<ItemDto> list5 = itemService.readDiscountItem(sc);

            sc.setTypeKeyword("0303");
            List<ItemDto> list6 = itemService.readDiscountItem(sc);


            // 모델 저장 및 페이지 이동
            model.addAttribute("cnt", cnt);
            model.addAttribute("list1", list1);
            model.addAttribute("list2", list2);
            model.addAttribute("list3", list3);
            model.addAttribute("list4", list4);
            model.addAttribute("list5", list5);
            model.addAttribute("list6", list6);

        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "errorPage";
        }

        return "discount";
    }

    @GetMapping("/goods/{num}")
    public String detail(@PathVariable String num, Model model, HttpSession session) {
        int cnt = 0;
        try {
            // 세션에서 아이디 조회
            String id = (String) session.getAttribute("id");
            id = "user1";
            if (id != null) {
                BasketItemDto dto = new BasketItemDto();
                dto.setId(id);
                // 장바구니 상품 수량 조회
                cnt = basketItemService.getCount(dto);
            }

            ItemDetailPageDto itemDetail = itemService.readDetailItem(num);
            if (itemDetail == null) {
                throw new Exception("상세 상품 정보를 정상적으로 조회하지 못했습니다. 존재하지 않는 상품일 확률이 높습니다.");
            }

            model.addAttribute("cnt", cnt);
            model.addAttribute("itemDetail", itemDetail);

        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "errorPage";
        }
        return "detail";
    }

    @PostMapping("/goods/{itemNum}")
    public String order(@PathVariable String itemNum, BasketItemDto dto, RedirectAttributes ratt, HttpSession session, Model model) {
        // 로그인 확인
            // o, 장바구니 상품 등록
            // x, 주문 페이지 보내기
        // 추가적으로 페이징 핸들러 처리


        try {
            dto.setNum(itemNum);
            // 세션에서 아이디 조회
            String id = (String) session.getAttribute("id");
//            if (id == null) {
//                return "forward:/order";
//            }

            id = "user1";
            // 장바구니 상품 등록
            dto.setId(id);
            // 해당 상품 이미지 조회
            ItemDto selectedDto = itemService.getItem(dto.getNum());
            dto.setMain_img(selectedDto.getMain_img());

            basketItemService.register(dto);
            BasketItemDto target = basketItemService.readByContent(dto);
            BasketItemDtos dtos = new BasketItemDtos();
            dtos.addBasketItemDto(target);


            ratt.addFlashAttribute("dtos", dtos);
            return "redirect:/order";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "errorPage";
        }
    }


}
