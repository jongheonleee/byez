package com.neo.byez.service;

import com.neo.byez.dao.QnaDao;
import com.neo.byez.domain.QnaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaServiceImpl implements QnaService{
    @Autowired
    QnaDao qnaDao;
    @Override
    public int getCount() {
        return qnaDao.count();
    }

    @Override
    public int write(QnaDto qnaDto) {
        return qnaDao.insert(qnaDto);
    }

    @Override
    public int remove(Integer seq_num) {
        return qnaDao.delete(seq_num);
    }

    @Override
    public int removeAll() {
        return qnaDao.deleteAll();
    }

    @Override
    public List<QnaDto> getSelectCust_id(String cust_id) {
        return qnaDao.selectAll(cust_id);
    }

    @Override
    public QnaDto getSelectSeq_num(Integer seq_num) {
        return qnaDao.select(seq_num);
    }

    @Override
    public int modify(QnaDto qnaDto) {
        return qnaDao.update(qnaDto);
    }

    @Override
    public List<QnaDto> getSearchCondition(Integer cate_num, String qna_title, String res_state) {
        return qnaDao.searchCondition(cate_num,qna_title,res_state);
    }

    @Override
    public List<QnaDto> getSelectPageCust_id(Integer page, Integer page_size, String cust_id) {
        return null;
    }

    @Override
    public int getSelectCount(String cust_id) {
        return 0;
    }

    @Override
    public int answerQna(QnaDto qnaDto) {
        return 0;
    }

    @Override
    public String getCateNumOption(QnaDto qnaDto) {
        return qnaDao.CateNumOption(qnaDto.getCate_num());
    }

}
