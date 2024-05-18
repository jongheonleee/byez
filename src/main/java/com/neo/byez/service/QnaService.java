package com.neo.byez.service;

import com.neo.byez.domain.QnaDto;

import java.util.List;

public interface QnaService {
    int getCount();

    int write(QnaDto qnaDto);

    int remove(Integer seq_num);

    int removeAll();

    List<QnaDto> getSelectCust_id(String cust_id);

    QnaDto getSelectSeq_num(Integer seq_num);

    int modify(QnaDto qnaDto);

    List<QnaDto> getSearchCondition(Integer cate_num, String qna_title, String res_state);

    List<QnaDto> getSelectPageCust_id(Integer page, Integer page_size, String cust_id);

    int getSelectCount(String cust_id);

    int answerQna(QnaDto qnaDto);

    String getCateNumOption(QnaDto qnaDto);

}
