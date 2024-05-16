package com.neo.byez.dao.item;


import com.neo.byez.domain.item.LikeItemDto;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeItemDaoImpl implements LikeItemDao {

    @Autowired
    SqlSession session;


    private static final String namespace = "com.neo.byez.dao.item.LikeItemDao.";

    // 00. 유저 좋아요 상품 카운트
    @Override
    public int count(String id) throws Exception {
        return session.selectOne(namespace + "count", id);
    }

    // 01. 유저 좋아요 상품 단건 조회
    @Override
    public LikeItemDto select(LikeItemDto dto) throws Exception {
        return session.selectOne(namespace + "select", dto);
    }

    // 02. 유저 좋아요 상품 리스트 조회
    @Override
    public List<LikeItemDto> selectAll(String id) throws Exception {
        return session.selectList(namespace + "selectAll", id);
    }

    // 03. 유저 좋아요 상품 등록
    @Override
    public int insert(LikeItemDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    // 04. 유저 좋아요 상품 삭제
    @Override
    public int delete(LikeItemDto dto) throws Exception {
        return session.delete(namespace + "delete", dto);
    }

    // 05. 유저 좋아요 상품 모두 삭제
    @Override
    public int deleteAll(String id) throws Exception {
        return session.delete(namespace + "deleteAll", id);
    }

    // 06. 유저 좋아요 상품 업데이트
    @Override
    public int update(LikeItemDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

}
