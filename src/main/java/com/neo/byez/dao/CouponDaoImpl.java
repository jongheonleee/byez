package com.neo.byez.dao;

import com.neo.byez.domain.CouponDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponDaoImpl implements CouponDao {

    @Autowired
    SqlSession sqlSession;
    private static final String namespace = "com.neo.byez.dao.CouponMapper.";

    // 쿠폰 테이블의 행 개수
    @Override
    public int count() throws Exception {
        return sqlSession.selectOne(namespace + "count");
    }

    // 이름으로 쿠폰정보 조회
    @Override
    public CouponDto selectByName(String name) throws Exception {
        return sqlSession.selectOne(namespace + "selectByName", name);
    }

    @Override
    public CouponDto selectBySeq(Integer seq) throws Exception {
        return sqlSession.selectOne(namespace + "selectBySeq", seq);
    }

    // 모든 쿠폰정보 조회
    @Override
    public List<CouponDto> selectAll() throws Exception {
        return sqlSession.selectList(namespace + "selectAll");
    }

    // 행 추가
    @Override
    public int insert(CouponDto couponDto) throws Exception {
        return sqlSession.insert(namespace + "insert", couponDto);
    }

    // 모든행 삭제
    @Override
    public int deleteAll() throws Exception {
        return sqlSession.delete(namespace + "deleteAll");
    }

    // 지정행 삭제
    @Override
    public int deleteByName(String name) throws Exception {
        return sqlSession.delete(namespace + "delete", name);
    }

    // 지정행 변경
    @Override
    public int update(CouponDto couponDto) throws Exception {
        return sqlSession.update(namespace + "update", couponDto);
    }

}
