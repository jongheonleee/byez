package com.neo.byez.dao.item;


import com.neo.byez.domain.item.BasketItemDto;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasketItemDaoImpl implements BasketItemDao {
    @Autowired
    SqlSession session;

    // com.neo.byez.dao.item.BasketItemDaoImpl
    private static final String namespace = "com.neo.byez.dao.item.BasketItemDao.";

    // 00. 유저 장바구니 상품 카운트
    @Override
    public int count(BasketItemDto dto) throws Exception {
        return session.selectOne(namespace + "count", dto);
    }

    // 01. 유저의 특정 장바구니 상품 조회(1개)
    @Override
    public BasketItemDto get(BasketItemDto dto) throws Exception {
        return session.selectOne(namespace + "select", dto);
    }

    // 02. 유저 장바구니 상품 목록 조회
    @Override
    public List<BasketItemDto> getList(BasketItemDto dto) throws Exception {
        return session.selectList(namespace + "selectAll", dto);
    }

    // 03. 유저 장바구니 상품 등록
    @Override
    public int insert(BasketItemDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }


    // 04. 유저 장바구니 상품 id, seq로 삭제
    @Override
    public int delete(BasketItemDto dto) throws Exception {
        return session.delete(namespace + "delete", dto);
    }

    // 05. 유저 장바구니 상품 dto로 삭제
    @Override
    public int deleteByContent(BasketItemDto dto) throws Exception {
        return session.delete(namespace + "deleteByContent", dto);
    }


    // 06. 유저 장바구니 상품 모두 삭제
    @Override
    public int deleteAll(BasketItemDto dto) throws Exception {
        return session.delete(namespace + "deleteAll", dto);
    }

    // 07. 유저 장바구니 상품 업데이트
    @Override
    public int update(BasketItemDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    @Override
    public BasketItemDto selectByContent(BasketItemDto dto) throws Exception {
        return session.selectOne(namespace + "select2", dto);
    }
}

