package com.neo.byez.controller;

import com.neo.byez.domain.AddressEntryDto;
import com.neo.byez.service.AddrListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AddrListController {

    @Autowired
    AddrListService addrListService;

    @RequestMapping("/myAddrList")
    public String myAddrList(HttpServletRequest request, Model model) throws Exception {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        List<AddressEntryDto> addresses = addrListService.getUsersAddrById(userId);

        model.addAttribute("addresses", addresses);

        return "myAddrList";
    }

    @RequestMapping("addrRegisterForm")
    public String addrRegisterForm() throws Exception {
        return "addrRegisterForm";
    }

    @RequestMapping("addrEditForm")
    public String addrEditForm(Integer seq, Model model) throws Exception {

        AddressEntryDto addressEntryDto = addrListService.getUsersAddrBySeq(seq);

        model.addAttribute("address", addressEntryDto);

        return "addrEditForm";
    }

    @RequestMapping("/registerAddress")
    public String registerAddress(HttpServletRequest request, @Valid AddressEntryDto addressEntryDto, BindingResult bindingResult, Model model) throws Exception {

        if (bindingResult.hasErrors()) {
            // 유효성 검사 오류가 있는 경우 다시 등록 폼으로 이동
            model.addAttribute("error", "잘못된 정보가 등록되었습니다. 재등록바랍니다.");
            return "addrRegisterForm";
        }

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        addressEntryDto.setId(userId);

        addrListService.registerAddr(addressEntryDto);

        return "redirect: /myAddrList";
    }

    @RequestMapping("/editAddress")
    public String editAddress(AddressEntryDto addressEntryDto) throws Exception {

        addrListService.changeAddr(addressEntryDto);

        return "redirect: /myAddrList";
    }

    @RequestMapping("/deleteAddress")
    public String deleteAddress(Integer seq) throws Exception {

        addrListService.deleteAddrBySeq(seq);

        return "redirect: /myAddrList";
    }
}
