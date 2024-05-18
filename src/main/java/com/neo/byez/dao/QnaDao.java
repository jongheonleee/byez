package com.neo.byez.dao;

import com.neo.byez.domain.QnaCateJoinDto;
import com.neo.byez.domain.QnaDto;

import java.util.List;

public interface QnaDao {
    int count();

    int insert(QnaDto qnaDto);

    int delete(Integer seq_num);

    int deleteAll();

    List<QnaDto> selectAll(String cust_id);

    QnaDto select(Integer seq_num);

    int update(QnaDto qnaDto);

    int answer(QnaDto qnaDto);

//    List<QnaDto> selectPage(Integer page, Integer page_size, String cust_id);
//
//    int selectCount(String cust_id);

    List<QnaDto> searchCondition(Integer cate_num, String qna_title, String res_state);
    List<QnaDto> searchAllCondition(String cust_id,Integer cate_num,String qna_title,String qna_content,String res_state);

    String CateNumOption(Integer cate_num);

    List<QnaCateJoinDto> getListCateOpt(List<QnaDto> qnaDto, Integer page, Integer page_size, String cust_id);

    List<QnaCateJoinDto> getSearchAllOpt(String cust_id, Integer cate_num, String qna_title, String qna_content, String res_state, Integer page, Integer page_size);
}
