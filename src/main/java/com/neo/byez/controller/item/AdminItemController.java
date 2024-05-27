package com.neo.byez.controller.item;

import com.neo.byez.domain.item.*;
import com.neo.byez.service.item.ItemServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminItemController {
    @Autowired
    private ItemServiceImpl itemService;

    @GetMapping("/admin/item")
    public String list(SearchCondition sc, Model model) {
        try {
            sc.setPageSize(15);
            List<AdminItemDto> list = itemService.readAllItemOnAdmin(sc);
            int totalCnt = itemService.getCount();

            PageHandler ph = new PageHandler(totalCnt, sc);
            model.addAttribute("list", list);
            model.addAttribute("ph", ph);
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }

        return "adminItemList";
    }


    @GetMapping("/admin/itemRegister")
    public String getRegisterForm() {
        return "adminItemRegister";
    }

    @PostMapping("/admin/itemRegister")
    public String doRegisterForm(ItemRegisterInfo info) {
        // 필요한 DTO 생성
        ItemDto itemDto = info.getItemDto();
        ItemDetailDto itemDetailDto = info.getItemDetailDto();
        ItemStateDto itemStateDto = info.getItemStateDto();
        List<ItemOptDto> sizeList = info.getSizeList();
        List<ItemOptDto> colorList = info.getColorList();
        ItemPriceDto itemPriceDto = info.getItemPriceDto();

        try {
            itemService.add(itemDto, itemDetailDto, itemStateDto, sizeList, colorList, itemPriceDto);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "redirect:/admin/item";
    }


    @GetMapping("/admin/item/{num}")
    public String getModifyForm(@PathVariable String num, Model model) {
        try {
            ItemRegisterInfo itemRegisterInfo = itemService.readItemDetailInfoOnAdmin(num);
            model.addAttribute("itemRegisterInfo", itemRegisterInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "adminItemDetail";
    }

    @PostMapping("/admin/item/{num}")
    public String doModifyForm(@PathVariable String num) {
        return "adminItemDetail";
    }

    @GetMapping("/admin/itemStock")
    public String getStockForm(SearchCondition sc, Model model) {
        try {
            sc.setPageSize(15);
            List<AdminItemDto> list = itemService.readAllItemOnAdmin(sc);
            int totalCnt = itemService.getCount();

            PageHandler ph = new PageHandler(totalCnt, sc);
            model.addAttribute("list", list);
            model.addAttribute("ph", ph);
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }


        return "adminItemStock";
    }

}
