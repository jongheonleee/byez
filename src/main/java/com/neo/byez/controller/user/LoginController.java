package com.neo.byez.controller.user;

import com.neo.byez.common.validator.LoginValidator;
import com.neo.byez.domain.user.UserDto;
import com.neo.byez.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    UserServiceImpl userService;

    @Autowired
    public LoginController(UserServiceImpl service, BCryptPasswordEncoder encoder) {
        this.userService = service;
    }

    // 사용자가 입력한 데이터가 UserDto 객체로 바인딩 되기 전
    // UserValidator 를 사용하여 유효성 검사 시행
    @InitBinder
    public void checkDataFormat(WebDataBinder binder) {
        // UserValidator 를 WebDataBinder 의 로컬 validator 로 등록
        binder.setValidator(new LoginValidator());
    }

    @GetMapping("/form")
    public String moveToLoginForm(HttpServletRequest request, Model model) {
        model.addAttribute("prevPage", request.getParameter("prevPage"));
        return "/user/loginForm";
    }

    // 유저가 입력한 데이터가 /login/in 으로 전송됨.
    @PostMapping("/in")
    public String save(@Valid UserDto userDto, BindingResult result, String prevPage, boolean rememberId, HttpServletResponse response, HttpServletRequest request, RedirectAttributes ra) throws Exception {

        // UserValidator 를 통해 확인한 에러를 메세지로 출력
        // result 객체에 error 가 있다면
        // 첫번째 error 에 대한 메세지를 view 에서 사용자에게 보여줌
        if (result.hasErrors()) {
            List<ObjectError> errorMsgs = result.getAllErrors();
            ra.addFlashAttribute("errorMsg", errorMsgs.get(0).getCode());
        }

        String id = userDto.getId();
        String pwd = userDto.getPwd();

        // 2. 아이디 저장 체크박스
        // 2.1 rememberId 체크박스 상태에 따라, 쿠키에 아이디 저장 여부 달라짐
        // 2.1.1 체크되어 있으면 쿠키에 아이디 저장
        // 2.1.2 체크 안되어 있으면 쿠키에 저장된 아이디 삭제
        if (rememberId) {
            Cookie cookie = new Cookie("id", id);
            response.addCookie(cookie); // ID 저장
        } else {
            Cookie cookie = new Cookie("id", "");
            cookie.setMaxAge(0); // ID 삭제
            response.addCookie(cookie);
        }

        // 3. 로그인 처리
        // 3.1. DB 에서 사용자가 입력한 ID가 조회되는지 확인 (checkExistOfId)
        // 3.1.1. ID 존재하지 않는 경우
        // 3.1.1.1. 로그인창에서 오류메세지 출력
        // 3.1.2. ID 존재하는 경우
        // 3.1.2.1. ID, PWD 일치여부 확인 후 이전 페이지로 이동

        if (!userService.checkExistOfId(id) && !id.isEmpty() && !id.isBlank()) {
            ra.addFlashAttribute("memberShipCheckMsg", "존재하지 않는 아이디입니다.");
            return "redirect:/login/form";
        }

        // 3.2. ID, PWD 일치여부 확인
        // 3.2.1 ID, PWD 일치하지 않는 경우
        // 3.2.1.1. 다시 로그인 화면으로 이동
        // 3.2.2. ID, PWD 일치하는 경우
        // 3.2.2.1. 최근 로그인 시간 업데이트
        // 3.2.2.2. 세션에 로그인 상태(loginState) 및 고객명 저장
        // 3.2.2.3. 이전 페이지 주소 존재 시 이전 페이지로 이동하고, 없으면 메인 페이지로 이동
        if (!userService.checkPwdMatch(id, pwd)) {
            if (!id.isEmpty() && !id.isBlank()) {
                ra.addFlashAttribute("notMatchMsg", "ID 또는 Password 가 일치하지 않습니다.");
            }
            return "redirect:/login/form";
        } else {
            userService.updateRecentLoginHist(id);

            String userId = userDto.getId();
            String userName = userService.getCustLoginInfo(userId).getName();
            HttpSession session = request.getSession();
            session.setAttribute("loginState", "Y");
            session.setAttribute("userId", userId);
            session.setAttribute("userName", userName);

            // prevPage 이동
            if (prevPage != null && !prevPage.isEmpty()) {
                return "redirect:" + prevPage;
            }

            return "redirect:/";
        }
    }

    // 4. 로그아웃
    // 4.1. 세션 초기화하여 저장된 로그인 상태 삭제
    // 4.2. 로그아웃 후 메인 화면으로 이동
    @GetMapping("/out")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }
}