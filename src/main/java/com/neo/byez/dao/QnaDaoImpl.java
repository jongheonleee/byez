package com.neo.byez.dao;

import com.neo.byez.domain.QnaCateJoinDto;
import com.neo.byez.domain.QnaDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QnaDaoImpl implements QnaDao {
    @Autowired
    SqlSession sqlSession;
    private static String namespace = "com.neo.byez.dao.QnaDao.";

    @Override
    public int count() {
        return sqlSession.selectOne(namespace + "count");
    }

    @Override
    public int insert(QnaDto qnaDto) {
        return sqlSession.insert(namespace + "insert", qnaDto);
    }

    @Override
    public int delete(Integer seq_num) {
        return sqlSession.delete(namespace + "delete", seq_num);
    }
    @Override
    public int deleteAll(){return sqlSession.delete(namespace+"deleteAll");}

    @Override
    public List<QnaDto> selectAll(String cust_id) {
        return sqlSession.selectList(namespace + "selectAll", cust_id);
    }

    @Override
    public QnaDto select(Integer seq_num) {
        return sqlSession.selectOne(namespace + "select", seq_num);
    }

    @Override
    public int update(QnaDto qnaDto) {
        return sqlSession.update(namespace + "update", qnaDto);
    }

    @Override
    public int answer(QnaDto qnaDto) {
        return sqlSession.update(namespace + "answer", qnaDto);
    }


    @Override
    public List<QnaDto> searchCondition(Integer cate_num, String qna_title,String res_state) {
        Map map= new HashMap<>();
        map.put("cate_num", cate_num);
        map.put("qna_title",qna_title);
        map.put("res_state",res_state);
        return sqlSession.selectList(namespace+"searchCondition",map);
    }
    @Override
    public List<QnaDto> searchAllCondition(String cust_id, Integer cate_num, String qna_title, String qna_content, String res_state){
        Map map = new HashMap<>();
        map.put("cust_id", cust_id);
        map.put("cate_num", cate_num);
        map.put("qna_title",qna_title);
        map.put("qna_content",qna_content);
        map.put("res_state", res_state);
        return sqlSession.selectList(namespace+"searchAllCondition",map);
    }
    @Override
    public String CateNumOption(Integer cate_num) {
        return sqlSession.selectOne(namespace+"CateNumOption",cate_num);
    }
    @Override
    public List<QnaCateJoinDto> getListCateOpt(List<QnaDto> qnaDto, Integer page, Integer page_size, String cust_id){
        Map map = new HashMap();
        map.put("cust_id", cust_id);
        map.put("startCnt", (page - 1) * page_size);
        map.put("pageSize", page_size);
        map.put("qnaDto",qnaDto);
        return sqlSession.selectList(namespace+"getListCateOpt",map);
    }
    @Override
    public List<QnaCateJoinDto> getSearchAllOpt(String cust_id, Integer cate_num, String qna_title, String qna_content, String res_state, Integer page, Integer page_size){
        Map map = new HashMap<>();
        map.put("cust_id",cust_id);
        map.put("cate_num", cate_num);
        map.put("qna_title",qna_title);
        map.put("qna_content", qna_content);
        map.put("res_state", res_state);
        map.put("startCnt", (page-1)*page_size);
        map.put("pageSize",page_size);
        return sqlSession.selectList(namespace+"getSearchAllOpt",map);
    }
}
