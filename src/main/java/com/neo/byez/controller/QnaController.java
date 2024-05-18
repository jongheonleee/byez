package com.neo.byez.controller;

import com.neo.byez.dao.QnaDaoImpl;
import com.neo.byez.domain.PageHandlerBin;
import com.neo.byez.domain.QnaCateJoinDto;
import com.neo.byez.domain.QnaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/qna")
public class QnaController {
    @Autowired
    QnaDaoImpl qnaDao;

    @GetMapping("/list")
    public String list(HttpServletRequest request, HttpSession httpSession, Model model) {
        //원래 접속한 고객 id 세션에서 값을 가져오는 기능을 넣어야한다.
        int page;
        if (request.getParameter("page") == null) { // page값 default
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));// 넘어온 page값이 있다면 가져온 page값을 넣는다.
        }
        Integer cate_num = null;
        String title = null;
        String content = null;
        String resState = null;
        if (request.getParameter("mode") != null) {
            if (request.getParameter("mode").equals("search")) {
                model.addAttribute("mode", "search");
                if (Objects.equals(request.getParameter("search"), "title")) {
                    title = request.getParameter("searchContent");
                } else {
                    content = request.getParameter("searchContent");
                }
                resState = request.getParameter("res_state");
                try {
                    cate_num = Integer.valueOf(request.getParameter("cate_num"));
                } catch (NumberFormatException e) {
                    cate_num = null;
                }
            }
        }
        // 검색 기능에 따른 목록들을 찾아내어 page계산하는 과정
        List<QnaDto> listOrigin = qnaDao.searchAllCondition("asdf", cate_num, title, content, resState);
        Integer totalCnt = listOrigin.size();
        PageHandlerBin pageHandler = new PageHandlerBin(totalCnt);
        pageHandler.pageHandle(page);
        model.addAttribute("totalPage",pageHandler.getTotalPage());
        model.addAttribute("startPage", pageHandler.getStartPage());
        model.addAttribute("endPage", pageHandler.getEndPage());
        // 받은 검색기능들을 모아서 검색기능들을 계속해서 유지할 수 있도록 하는 과정
        model.addAttribute("cate_num", cate_num);
        model.addAttribute("search", request.getParameter("search"));
        model.addAttribute("searchContent", request.getParameter("searchContent"));
        model.addAttribute("res_state", request.getParameter("res_state"));
        List<QnaCateJoinDto> list = qnaDao.getSearchAllOpt("asdf", cate_num, title, content, resState, page, 10);
        model.addAttribute("list", list);
        return "qnaList";
    }

    @GetMapping("/write")
    public String writeForm(Model model) {
        model.addAttribute("mode", "write");
        return "qnaWrite";
    }

    @PostMapping("/write")
    public String write(QnaDto qnaDto) {
        qnaDto.setQna_writer("임찬빈"); // sql 쪽에서 값을 가져와야할것
        qnaDto.setCust_id("asdf");
        qnaDao.insert(qnaDto);
        return "redirect:/qna/list";
//        return "redirect:/qna/read?seq_num="+"";
//        쓴거 다시 볼수 있도록 구현하고 싶은데 저장하고 나서 db에서 처리되는 seq_num을 어떻게 다시 가져올지 모르겟음
    }

    @GetMapping("/read")
    public String read(HttpServletRequest httpServletRequest, Model model) {
        Integer seq_num = Integer.valueOf(httpServletRequest.getParameter("seq_num"));
        QnaDto qnaDto = qnaDao.select(seq_num);
        model.addAttribute("qnaDto", qnaDto);
        return "qnaRead";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest httpServletRequest) {
        Integer seq_num = Integer.valueOf(httpServletRequest.getParameter("seq_num"));
        qnaDao.delete(seq_num);
        return "redirect:/qna/list";
    }

    @GetMapping("/update")
    public String update1(HttpServletRequest httpServletRequest, Model model) {
        Integer seq_num = Integer.valueOf(httpServletRequest.getParameter("seq_num"));
        QnaDto qnaDto = qnaDao.select(seq_num);
        model.addAttribute("mode", "update");
        model.addAttribute("qnaDto", qnaDto);
        return "qnaWrite";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest httpServletRequest, QnaDto qnaDto, Model model, HttpSession httpSession) {
        //session 으로 cust_id를 가져온 후에 cust_id를 통해 writer의 이름을 가져오도록 한다. 또는 아예 페이지 세션에 이름값도 넣어버려서 두개를 세션에서 가져오도록 한다.
        //String cust_id = (String) httpSession.getAttribute("cust_id");
        Integer seq_num = Integer.valueOf(httpServletRequest.getParameter("seq_num")); // 가져온 Dto의 seq_num을 사용하도록 한다.
        //session 값으로 있는 cust_id를 가져오도록 한다.
        qnaDto.setCust_id("asdf"); //위에서 설정한 값이 들어가야함
        qnaDto.setQna_writer("임찬빈"); // 위에서 설정한 값이 들어가야함
        qnaDao.update(qnaDto);
        model.addAttribute("qnaDto", qnaDto);
        return "qnaRead";
    }
}

