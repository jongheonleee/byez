package com.neo.byez.controller.user;

import com.neo.byez.domain.user.UserDto;
import com.neo.byez.service.user.NaverService;
import com.neo.byez.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class NaverController {

    private UserServiceImpl userService;
    private NaverService naverService;

    @Autowired
    public NaverController(UserServiceImpl userService, NaverService naverService) {
        this.userService = userService;
        this.naverService = naverService;
    }

    @RequestMapping(value = "/naverLogin", method = RequestMethod.GET)
    public String login(@RequestParam(value = "code", required = false) String code,
                        @RequestParam(value = "state", required = false) String state,
                        Model model, HttpServletRequest request) {
        String accessToken = naverService.getAccessTokenFromNaver(code, state);
        String nickname = naverService.getUserNickname(accessToken);

        String userId = userService.getCustIdBySnsNickname(nickname);
        if (!userId.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("loginState", "Y");
            session.setAttribute("userId", userId);
            return "index2";
        } else {
            model.addAttribute("showAlert", true);
            return "/user/requestEmailForm";
        }
    }

    @RequestMapping(value = "/naverConnection", method = RequestMethod.GET)
    public String connect(@RequestParam(value = "code", required = false) String code,
                          @RequestParam(value = "state", required = false) String state,
                          Model model, HttpServletRequest request) {
        String accessToken = naverService.getAccessTokenFromNaver(code, state);
        String nickname = naverService.getUserNickname(accessToken);

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userId");
        UserDto userDto = userService.getCustLoginInfo(id);

        // 2.1. 특정 조건 해당여부 확인
        try {
            // 2.1.1. 조건에 부합하는 경우
            // 2.1.1.1. 네이버 서버로부터 전달 받은 닉네임이 존재하는 경우
            // 2.1.1.2. 고객 테이블의 네이버 계정 연동여부 'N'인 경우
            // 2.1.1.3. 고객 테이블의 닉네임 컬럼에 저장된 값 없는 경우
            // 2.1.1.4. 전체 고객 닉네임 조회 결과 동일한 닉네임 없는 경우
            // 2.1.2. 아이디와 닉네임을 고객 테이블의 각 컬럼에 저장
            // 2.1.3. 다시 회원정보 변경 페이지로 이동
            if (nickname != null && userDto.getNaver_conn().equals("N") && userDto.getNickname() == null && userService.getCustIdBySnsNickname(nickname).isEmpty()) {
                session.setAttribute("nickname", nickname);
                userService.saveNaverNickname(id, nickname);
                return "redirect:/mypage/modifyPage";
            }
            // 2.2 조건에 부합하지 않는 경우
            // 2.2.1. 다른 유저가 연동해둔 계정인 경우
            // 2.2.2. 이미 계정 연동 완료된 상태인 경우
            // 2.2.3. 계정이 존재하지 않는 경우
            else if ((userDto.getKakao_conn().equals("Y") || userDto.getNaver_conn().equals("Y")) && userDto.getNickname() != null){
                String encodedMessage = URLEncoder.encode("카카오 또는 네이버 계정이 이미 연동되어 있습니다.", StandardCharsets.UTF_8.toString());
                return "redirect:/mypage/modifyPage?msg=" + encodedMessage;
            } else if (userService.getCustIdBySnsNickname(nickname) != null && id != userService.getCustIdBySnsNickname(nickname)) {
                String encodedMessage = URLEncoder.encode("이미 사용 중인 계정입니다.", StandardCharsets.UTF_8.toString());
                return "redirect:/mypage/modifyPage?msg=" + encodedMessage;
            } else {
                String encodedMessage = URLEncoder.encode("네이버 계정이 존재하지 않습니다.", StandardCharsets.UTF_8.toString());
                return "redirect:/mypage/modifyPage?msg=" + encodedMessage;
            }
        } catch (Exception e) {
            return "errorPage";
        }
    }
}
