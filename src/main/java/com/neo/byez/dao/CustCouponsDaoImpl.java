package com.neo.byez.dao;

import com.neo.byez.domain.CustCouponsDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustCouponsDaoImpl implements CustCouponsDao {

    @Autowired
    SqlSession sqlSession;

    private static String namespace = "com.neo.byez.dao.CustCouponsMapper.";

    @Override
    public int count() throws Exception {
        return sqlSession.selectOne(namespace + "count");
    }

    @Override
    public List<CustCouponsDto> selectAll() throws Exception {
        return sqlSession.selectList(namespace + "selectAll");
    }

    @Override
    public List<CustCouponsDto> select(String id) throws Exception {
        return sqlSession.selectList(namespace + "select", id);
    }

    @Override
    public int insert(String id, String couponName) throws Exception {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("id", id);
        parameterMap.put("couponName", couponName);

        return sqlSession.insert(namespace + "insert", parameterMap);
    }

    @Override
    public int delete(Integer seq) throws Exception {
        return sqlSession.delete(namespace + "delete", seq);
    }

    @Override
    public int deleteAll() throws Exception {
        return sqlSession.delete(namespace + "deleteAll");
    }

    @Override
    public int update(Integer seq) throws Exception {
        return sqlSession.update(namespace + "update", seq);
    }


}
