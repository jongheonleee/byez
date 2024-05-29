package com.neo.byez.controller.item;


import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.BasketItemDtos;
import com.neo.byez.domain.item.ItemDetailPageDto;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.ItemRegisterInfo;
import com.neo.byez.domain.item.PageHandler;
import com.neo.byez.domain.item.SearchCondition;
import com.neo.byez.service.ReviewServiceImpl;
import com.neo.byez.service.item.BasketItemServiceImpl;
import com.neo.byez.service.item.ItemServiceImpl;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
    //찬빈추가
    @Autowired
    public ReviewServiceImpl reviewService;

    @GetMapping("/item/categories/{type}")
    public String categoryList(@PathVariable String type, SearchCondition sc, Model model, HttpSession session) {
        // 추가적으로 페이징 핸들러 처리
        int basketCnt = 0;
        try {
            // 세션에서 아이디 조회
            String id = (String) session.getAttribute("userId");
            if (id != null) {
                BasketItemDto dto = new BasketItemDto();
                dto.setId(id);
                // 장바구니 상품 수량 조회
                basketCnt = basketItemService.getCount(dto);
            }

            // 카테고리 상품 조회
            sc.setTypeKeyword(type);
            sc.checkOption();
            List<ItemDto> list = itemService.readBySearchCondition(sc);

            // 페이징 처리
            int searchCnt = itemService.countSearchCondition(sc);
            PageHandler ph = new PageHandler(searchCnt, sc);

            // 모델 저장 및 페이지 이동
            model.addAttribute("basketCnt", basketCnt);
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
        int basketCnt = 0;
        try {
            // 세션에서 아이디 조회
            String id = (String) session.getAttribute("userId");
            if (id != null) {
                BasketItemDto dto = new BasketItemDto();
                dto.setId(id);
                // 장바구니 상품 수량 조회
                basketCnt = basketItemService.getCount(dto);
            }

            // 카테고리 상품 조회
            sc.checkOption();
            List<ItemDto> list = itemService.readBySearchCondition(sc);

            // 페이징 처리
            int searchCnt = itemService.countSearchCondition(sc);
            PageHandler ph = new PageHandler(searchCnt, sc);

            // 모델 저장 및 페이지 이동
            model.addAttribute("basketCnt", basketCnt);
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
        return "best";
    }

    @GetMapping("/item/discount")
    public String discList(SearchCondition sc, Model model, HttpSession session) {
        // 추가적으로 페이징 핸들러 처리
        int basketCnt = 0;
        try {
            // 세션에서 아이디 조회
            String id = (String) session.getAttribute("userId");
            if (id != null) {
                BasketItemDto dto = new BasketItemDto();
                dto.setId(id);
                // 장바구니 상품 수량 조회
                basketCnt = basketItemService.getCount(dto);
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
            model.addAttribute("basketCnt", basketCnt);
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
        int basketCnt = 0;
        try {
            //찬빈 추가
            List<ReviewDto> reviewList = reviewService.searchByItem(num);
            // 세션에서 아이디 조회
            String id = (String) session.getAttribute("userId");
            if (id != null) {
                BasketItemDto dto = new BasketItemDto();
                dto.setId(id);
                // 장바구니 상품 수량 조회
                basketCnt = basketItemService.getCount(dto);
            }

            ItemDetailPageDto itemDetail = itemService.readDetailItem(num);
            ItemDto itemDto = itemService.getItem(num);
            if (itemDetail == null) {
                throw new Exception("상세 상품 정보를 정상적으로 조회하지 못했습니다. 존재하지 않는 상품일 확률이 높습니다.");
            }

            model.addAttribute("basketCnt", basketCnt);
            model.addAttribute("itemDto", itemDto);
            model.addAttribute("itemDetail", itemDetail);
            //리뷰 내용 전송
            model.addAttribute("reviewList",reviewList);
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
            String id = (String) session.getAttribute("userId");
//            if (id == null) {
//                return "forward:/order";
//            }
            // 장바구니 상품 등록
            dto.setId(id);
            // 해당 상품 이미지 조회
            ItemDto selectedDto = itemService.getItem(dto.getNum());
            dto.setMain_img(selectedDto.getMain_img());
            basketItemService.register(dto);
            BasketItemDto target = basketItemService.readByContent(dto);
            BasketItemDtos basketItemDtos = new BasketItemDtos();
            basketItemDtos.addBasketItemDto(target);

            ratt.addFlashAttribute("basketItemDtos", basketItemDtos);
            return "redirect:/order/orderForm";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "errorPage";
        }
    }


    @GetMapping("/item/search")
    public String getResult(SearchCondition sc, Model model, HttpSession session) {
        sc.checkOption();

        try {
            // 장바구니 수량 조회
            String userId = (String) session.getAttribute("userId");
            BasketItemDto basketItemDto = new BasketItemDto();
            basketItemDto.setId(userId);
            int basketCnt = basketItemService.getCount(basketItemDto);

            // 해당 결과 조회
            List<ItemDto> list = itemService.readBySearchCondition(sc);
            int searchCnt = itemService.countSearchCondition(sc);

            if (list.size() != searchCnt) {
                throw new Exception("검색 결과를 정상적으로 수행하지 못했습니다.");
            }

            // 페이지 핸들러 생성
            PageHandler ph = new PageHandler(searchCnt, sc);

            // 조회된 결과 모델 저장
            model.addAttribute("nameKeyword", sc.getNameKeyword());
            model.addAttribute("basketCnt", basketCnt);
            model.addAttribute("searchCnt", searchCnt);
            model.addAttribute("list", list);
            model.addAttribute("ph", ph);


        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }

        // 모델 저장

        // 뷰 보이기
        return "searchResult";
    }


}
