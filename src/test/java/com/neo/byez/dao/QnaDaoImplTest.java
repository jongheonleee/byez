package com.neo.byez.dao;

import com.neo.byez.domain.QnaCateJoinDto;
import com.neo.byez.domain.QnaDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class QnaDaoImplTest {

    @Autowired
    QnaDaoImpl qnaDao;

    @DisplayName("웹페이지단에서 확인하기 위해 넣어두는 더미데이터")
    @Test
    public void insertDummy() {
        qnaDao.deleteAll();//0체크w w
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "환불해줘", "Mars");
        for (int i = 0; i < 134; i++) {
            qnaDao.insert(qnaDto);
        }
        QnaDto qnaDtoAnswer = qnaDao.select(qnaDao.selectAll("asdf").get(0).getSeq_num());
        System.out.println(qnaDtoAnswer.getSeq_num());
        System.out.println(qnaDtoAnswer.toString());
        qnaDtoAnswer.setRes_writer("resW");
        qnaDtoAnswer.setRes_title("resT");
        qnaDtoAnswer.setRes_content("resC");
        System.out.println(qnaDtoAnswer.toString());
        qnaDao.answer(qnaDtoAnswer);
        //
    }

    @DisplayName("검색 기능 더미 데이터")
    @Test
    public void searchTest() {
        qnaDao.deleteAll();
        assertEquals(0, qnaDao.count());
        QnaDto qnaDto1 = new QnaDto("asdf", "임찬빈", 100, "qwer", "a");
        QnaDto qnaDto2 = new QnaDto("asdf", "임찬빈", 100, "asdf", "b");
        QnaDto qnaDto3 = new QnaDto("asdf", "임찬빈", 100, "qwer", "b");
        QnaDto qnaDto4 = new QnaDto("asdf", "임찬빈", 100, "asdf", "a");
        QnaDto qnaDto5 = new QnaDto("asdf", "임찬빈", 200, "qwer", "a");
        QnaDto qnaDto6 = new QnaDto("asdf", "임찬빈", 200, "asdf", "b");
        QnaDto qnaDto7 = new QnaDto("asdf", "임찬빈", 200, "qwer", "b");
        QnaDto qnaDto8 = new QnaDto("asdf", "임찬빈", 200, "asdf", "a");
        for (int i = 1; i < 4; i++) {
            qnaDao.insert(qnaDto1);
            qnaDao.insert(qnaDto2);
            qnaDao.insert(qnaDto3);
            qnaDao.insert(qnaDto4);
            qnaDao.insert(qnaDto5);
            qnaDao.insert(qnaDto6);
            qnaDao.insert(qnaDto7);
            qnaDao.insert(qnaDto8);
        }
//        List<QnaDto> list = qnaDao.searchCondition(100, "qwer", "N");
//        assertEquals(list.size(), 6);
    }

    @DisplayName("넣은 개수에 맞게 게시판에 목록을 가져오는 기능 확인")
    @Test
    public void count() {
        qnaDao.deleteAll();
        assertEquals(0, qnaDao.count());
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "", "Mars");
        for (int i = 0; i < 47; i++) {
            qnaDto.setQna_title("i");
            qnaDao.insert(qnaDto);
        }
        assertEquals(47, qnaDao.count());
    }


    @DisplayName("DB에 값을 insert를 통해 넣었을 때 정상적으로 등록되었는지 확인")
    @Test
    public void insert정상값확인() {
        qnaDao.deleteAll();
        int firstCount = qnaDao.count(); // 넣기 전 DB의 전체 개수를 저장한다.
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "to the Mars", "Mars");
        qnaDto.setRes_state("N");
        qnaDao.insert(qnaDto);
        int secondCount = qnaDao.count();
        assertEquals("개수 증가 확인", firstCount + 1, secondCount);
        assertTrue(qnaDao.selectAll("asdf").get(0).equals(qnaDto));
    }

    @DisplayName("DB에 null을 insert를 통해 넣었을 때 정상적으로 등록되었는지 확인")
    @Test
    public void insertNull확인() {
        qnaDao.deleteAll();
        int firstCount = qnaDao.count(); // 넣기 전 DB의 전체 개수를 저장한다.
        QnaDto qnaDto = new QnaDto();
        try {
            qnaDao.insert(qnaDto);
        } catch (DataIntegrityViolationException e) {
            int secondCount = qnaDao.count();
        }
    }

    @DisplayName("원하는 값을 삭제하는지 확인")
    @Test
    public void delete() {
        qnaDao.deleteAll();
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "to the Mars", "Mars");
        qnaDao.insert(qnaDto);
        assertEquals(qnaDao.count(), 1);
        qnaDao.delete(qnaDao.selectAll("asdf").get(0).getSeq_num());
        assertEquals(qnaDao.count(), 0);
    }

    @DisplayName("삭제 조건으로 없는값이 들어갈때")
    @Test
    public void deleteNull() {
        qnaDao.deleteAll();
        assertEquals(qnaDao.count(), 0);
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "to the Mars", "Mars");
        qnaDao.insert(qnaDto);
        assertEquals(qnaDao.count(), 1);
        qnaDao.delete(-2);
        assertEquals(qnaDao.count(), 1);
    }

    @DisplayName("이름으로 검색한 리스트가 제대로 나오는지 확인한다.")
    @Test
    public void selectAll() {
        qnaDao.deleteAll();
        QnaDto qnaDto1 = new QnaDto("asdf", "임찬빈", 100, "tesla", "Mars");
        QnaDto qnaDto2 = new QnaDto("qwer", "빈찬임", 100, "elon", "musk");
        //insert를 다른값으로 다른 개수로 설정함으로써 넣은 값만큼 select를 제대로 하는지 확인하도록 한다.
        for (int i = 0; i < 50; i++) {
            qnaDao.insert(qnaDto1);
        }
        for (int i = 0; i < 70; i++) {
            qnaDao.insert(qnaDto2);
        }
        assertTrue(qnaDao.selectAll("asdf").size() == 50);
        assertTrue(qnaDao.selectAll("qwer").size() == 70);
    }


    @DisplayName("원하는 값 select 확인")
    @Test
    public void select() {
        qnaDao.deleteAll();
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "tesla", "Mars");
        qnaDao.insert(qnaDto);
        Integer seq_num = qnaDao.selectAll("asdf").get(0).getSeq_num();
        assertEquals(qnaDao.select(seq_num).getCust_id(), "asdf");
        assertEquals(qnaDao.select(seq_num).getQna_title(), "tesla");
        assertEquals(qnaDao.select(seq_num).getQna_content(), "Mars");
        assertEquals(qnaDao.select(seq_num).getCate_num(), 100);
        assertEquals(qnaDao.select(seq_num).getQna_writer(), "임찬빈");
    }

    @DisplayName("수정 후 원하는 값으로 바뀌는지 확인")
    @Test
    public void update() {
        qnaDao.deleteAll();
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "to the Mars", "Mars");
        qnaDao.insert(qnaDto);
        QnaDto qnaDtoOrigin = qnaDao.select(qnaDao.selectAll("asdf").get(0).getSeq_num());
        qnaDtoOrigin.setQna_content("content");
        qnaDtoOrigin.setQna_title("title");
        qnaDtoOrigin.setCate_num(300);
        qnaDao.update(qnaDtoOrigin);
        QnaDto qnaDtoChange = qnaDao.select(qnaDao.selectAll("asdf").get(0).getSeq_num());
        assertTrue(qnaDtoChange.equals(qnaDtoOrigin));
    }


    @DisplayName("관리자가 답변 작성하는 기능")
    @Test
    public void answer() {
        qnaDao.deleteAll();
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "tesla", "Mars");
        qnaDao.insert(qnaDto);
        QnaDto answer = qnaDao.select(qnaDao.selectAll("asdf").get(0).getSeq_num());
        answer.setRes_title("resT");
        answer.setRes_writer("resW");
        answer.setRes_content("resC");
        qnaDao.answer(qnaDto);
        assertEquals("답변 제목", answer.getRes_title(), "resT");
        assertEquals("답변 글쓴이", answer.getRes_writer(), "resW");
        assertEquals("답변 내용", answer.getRes_content(), "resC");
    }

//    @DisplayName("관리자가 답변할때 아무런 값을 넣지 않았을 때 예외가 발생하는지 확인")
//    @Test
//    public void answerNull() {
//    }

    @DisplayName("검색 기능 확인")
    @Test
    public void searchCondition() {
        qnaDao.deleteAll();
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "tesla", "Mars");
        qnaDao.insert(qnaDto);
        List<QnaDto> qnaDtoSearch = qnaDao.searchCondition(100, "tesla", "N");
        assertEquals(qnaDtoSearch.size(), 1);
    }

    @DisplayName("eqauls가 제대로 작동하는지 확인")
    @Test
    public void equals() {
        qnaDao.deleteAll();
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "tesla", "Mars");
        qnaDto.setRes_state("N");
        qnaDao.insert(qnaDto);
        assertTrue(qnaDto.equals(qnaDao.selectAll("asdf").get(0)));
        assertEquals(qnaDao.selectAll("asdf").get(0), qnaDto);
    }

    @DisplayName("Null 값이 들어간 검색 기능 확인")
    @Test
    public void searchNullOption() {
        qnaDao.deleteAll();
        // insert 추가된거 확인
        assertEquals(qnaDao.count(), 0);
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "tesla", "Mars");
        qnaDao.insert(qnaDto);
        assertEquals(qnaDao.count(), 1);
        //주려는 옵션값을 다양하게 null을 넣어가며 확인해보도록 한다.
        List<QnaDto> opt1 = qnaDao.searchCondition(null, "tesla", "N");
        assertEquals(opt1.size(), 1);
        assertEquals(qnaDao.selectAll("asdf").get(0), (opt1.get(0)));
        List<QnaDto> opt2 = qnaDao.searchCondition(100, null, "N");
        assertEquals(qnaDao.selectAll("asdf").get(0), opt2.get(0));
        List<QnaDto> opt3 = qnaDao.searchCondition(100, "tesla", null);
        assertEquals(qnaDao.selectAll("asdf").get(0), opt3.get(0));
        List<QnaDto> opt4 = qnaDao.searchCondition(null, null, "N");
        assertEquals(qnaDao.selectAll("asdf").get(0), opt4.get(0));
        List<QnaDto> opt5 = qnaDao.searchCondition(null, "tesla", null);
        assertEquals(qnaDao.selectAll("asdf").get(0), opt5.get(0));
        List<QnaDto> opt6 = qnaDao.searchCondition(100, null, null);
        assertEquals(qnaDao.selectAll("asdf").get(0), opt6.get(0));
        List<QnaDto> opt7 = qnaDao.searchCondition(null, null, null);
        assertEquals(opt7.size(), 1); // 검색하려는것이 없으니 전부 꺼내온다.
    }


//    @DisplayName("'<','>'기능 시, 없는 페이지 요청시 정상 작동 확인")
//    @Test
//    public void pageHandleScope() {
//        PageHandlerBin pageHandler = new PageHandlerBin(334);
//        assertEquals(34, pageHandler.getTotalPage());
//        pageHandler.pageHandle(35); // 없는 초과 페이지번호 요청
//        assertTrue(pageHandler.getStartPage() == 31 && pageHandler.getEndPage() == 34);
//        pageHandler.pageHandle(-2); // 없는 음수 페이지 번호 요청
//        assertTrue(pageHandler.getStartPage() == 1 && pageHandler.getEndPage() == 10);
//    }
//
//    @DisplayName("페이징 기능 확인")
//    @Test
//    public void pageCheck() {
//        PageHandlerBin pageHandler = new PageHandlerBin(334);
//        assertEquals(34, pageHandler.getTotalPage());
//        pageHandler.pageHandle(3);
//        assertTrue(pageHandler.getStartPage() == 1 && pageHandler.getEndPage() == 10);
//        pageHandler.pageHandle(14);
//        assertTrue(pageHandler.getStartPage() == 11 && pageHandler.getEndPage() == 20);
//        pageHandler.pageHandle(25);
//        assertTrue(pageHandler.getStartPage() == 21 && pageHandler.getEndPage() == 30);
//        pageHandler.pageHandle(32); // 10개가 출력되지 말아야하는 페이지 번호단 정상 출력 확인
//        assertTrue(pageHandler.getStartPage() == 31 && pageHandler.getEndPage() == 34);
//        pageHandler.pageHandle(1); // 진열된 번호중 가장 첫 번호 요청
//        assertTrue(pageHandler.getStartPage() == 1 && pageHandler.getEndPage() == 10);
//        pageHandler.pageHandle(10); // 진열된 번호중 가장 끝번호 요청
//        assertTrue(pageHandler.getStartPage() == 1 && pageHandler.getEndPage() == 10);
//        pageHandler.pageHandle(21); // 진열된 번호중 가장 첫 번호 요청
//        assertTrue(pageHandler.getStartPage() == 21 && pageHandler.getEndPage() == 30);
//        pageHandler.pageHandle(30); // 진열된 번호중 가장 끝번호 요청
//        assertTrue(pageHandler.getStartPage() == 21 && pageHandler.getEndPage() == 30);
//    }

    @DisplayName("카테고리값 가져오기")
    @Test
    public void getCateNumOption() {
        qnaDao.deleteAll();
        // insert 추가된거 확인
        assertEquals(qnaDao.count(), 0);
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "tesla", "Mars");
        qnaDao.insert(qnaDto);
        assertEquals(qnaDao.count(), 1);
        assertEquals(qnaDao.CateNumOption(100), "교환");
    }

    @DisplayName("JOIN후 검색과 페이지 기능 완료 테스트")
    @Test
    public void allCheckTest() {
        qnaDao.deleteAll();
        assertEquals(qnaDao.count(), 0);
        QnaDto qnaDto1 = new QnaDto("asdf", "임찬빈", 100, "qwer", "a");
        QnaDto qnaDto2 = new QnaDto("asdf", "임찬빈", 100, "asdf", "b");
        QnaDto qnaDto3 = new QnaDto("asdf", "임찬빈", 100, "qwer", "b");
        QnaDto qnaDto4 = new QnaDto("asdf", "임찬빈", 100, "asdf", "a");
        QnaDto qnaDto5 = new QnaDto("asdf", "임찬빈", 200, "qwer", "a");
        QnaDto qnaDto6 = new QnaDto("asdf", "임찬빈", 200, "asdf", "b");
        QnaDto qnaDto7 = new QnaDto("asdf", "임찬빈", 200, "qwer", "b");
        QnaDto qnaDto8 = new QnaDto("asdf", "임찬빈", 200, "asdf", "a");
        for (int i = 1; i < 4; i++) {
            qnaDao.insert(qnaDto1);
            qnaDao.insert(qnaDto2);
            qnaDao.insert(qnaDto3);
            qnaDao.insert(qnaDto4);
            qnaDao.insert(qnaDto5);
            qnaDao.insert(qnaDto6);
            qnaDao.insert(qnaDto7);
            qnaDao.insert(qnaDto8);
        }
        List<QnaCateJoinDto> list = qnaDao.getSearchAllOpt("asdf", 100, "qwer", "a", "N", 1, 10);
        assertEquals(list.size(), 3);
        list = qnaDao.getSearchAllOpt("asdf", 200, "qwer", "a", "N", 1, 10);
        assertEquals(list.size(),3);
        System.out.println("=");
        list = qnaDao.getSearchAllOpt("asdf", null, "qwer", "a", "N", 1, 10);
        assertEquals(list.size(),6);
        System.out.println("=");
        list = qnaDao.getSearchAllOpt("asdf", 100, "qwer", null, null, 1, 10);
        assertEquals(list.size(),6);
        List<QnaDto>list2 = qnaDao.searchAllCondition("asdf",null,"qwer",null,null);
        assertEquals(list2.size(),12);

    }
}