package com.neo.byez.service;

import com.neo.byez.dao.QnaDaoImpl;
import com.neo.byez.domain.QnaDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class QnaServiceImplTest {
    @Autowired
    QnaService qnaService;
    @Autowired
    QnaDaoImpl qnaDao;
    @Test
    public void getCateNumOption() {
        qnaDao.deleteAll();
        assertEquals(qnaDao.count(),0);
        QnaDto qnaDto = new QnaDto("asdf", "임찬빈", 100, "to the Mars", "Mars");
        qnaDao.insert(qnaDto);
        assertEquals(qnaDao.count(),1);
        assertEquals(qnaDao.CateNumOption(qnaDto.getCate_num()),"교환");
    }
}