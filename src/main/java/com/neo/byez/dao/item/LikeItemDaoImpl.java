package com.neo.byez.dao.item;


import com.neo.byez.domain.item.LikeItemDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeItemDaoImpl {

    @Autowired
    SqlSession session;


    private static final String namespace = "com.neo.byez.dao.item.LikeItemDao.";

    // 00. 유저 좋아요 상품 카운트
    public int count(String id) throws Exception {
        return session.selectOne(namespace + "count", id);
    }

    // 01. 유저 좋아요 상품 단건 조회
    public LikeItemDto select(LikeItemDto dto) throws Exception {
        return session.selectOne(namespace + "select", dto);
    }

    // 02. 유저 좋아요 상품 리스트 조회
    public List<LikeItemDto> selectAll(String id) throws Exception {
        return session.selectList(namespace + "selectAll", id);
    }

    // 03. 유저 좋아요 상품 등록
    public int insert(LikeItemDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    // 04. 유저 좋아요 상품 삭제
    public int delete(LikeItemDto dto) throws Exception {
        return session.delete(namespace + "delete", dto);
    }

    // 05. 유저 좋아요 상품 모두 삭제
    public int deleteAll(String id) throws Exception {
        return session.delete(namespace + "deleteAll", id);
    }

    // 06. 유저 좋아요 상품 업데이트
    public int update(LikeItemDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    // 07. 유저 좋아요 상품 페이지로 조회
    public List<LikeItemDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }

}
