package com.neo.byez.dao;

import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.ReviewItemJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReviewDaoImpl implements ReviewDao {
    @Autowired
    SqlSession sqlSession;
    private static String namespace = "com.neo.byez.dao.ReviewDao";


    @Override
    public int count() {
        return sqlSession.selectOne(namespace + "count");
    }

    @Override
    public int insert(ReviewDto reviewDto) {
        return sqlSession.insert(namespace + "insert", reviewDto);
    }

    @Override
    public int delete(Integer review_num) {
//        Map map = new HashMap<>();
//        map.put("review_num", review_num);
//        map.put("id", id);
        return sqlSession.delete(namespace + "delete", review_num);
    }

    @Override
    public int deleteAll() {
        return sqlSession.delete(namespace + "deleteAll");
    }

    @Override
    public int update(ReviewDto reviewDto) {
        return sqlSession.delete(namespace + "update", reviewDto);
    }

    @Override
    public List<ReviewDto> selectById(String id) {
        return sqlSession.selectList(namespace + "select", id);
    }

    @Override
    public List<ReviewDto> selectAll() {return sqlSession.selectList(namespace+"selectAll");
    }

    @Override
    public List<ReviewItemJoinDto> selectJoinItem(String id) {
        return sqlSession.selectList(namespace+"selectJoinItem",id);
    }

    @Override
    public ReviewDto selectByReviewNum(Integer review_num) {
        return sqlSession.selectOne(namespace+"selectByReviewNum",review_num);
    }
    @Override
    public List<ReviewDto> selectByItem(String item_num){
        return sqlSession.selectList(namespace+"selectByItem",item_num);
    }
}
