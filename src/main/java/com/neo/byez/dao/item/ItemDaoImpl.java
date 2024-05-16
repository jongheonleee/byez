package com.neo.byez.dao.item;

import com.neo.byez.domain.item.Category;
import com.neo.byez.domain.item.ItemDto;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    SqlSession session;

    private static final String namespace = "com.neo.byez.dao.item.ItemDao.";

    // 카운트
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    // 모두 조회
    public List<ItemDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    // 조회
    public ItemDto select(String num) throws Exception {
        return session.selectOne(namespace +"select", num);
    }

    // 등록
    public int insert(ItemDto dto) throws Exception {
        return session.insert(namespace +"insert", dto);
    }

    // 상품 상태 등록

    // 상품 가격 등록


    // 수정
    public int update(ItemDto dto) throws Exception {
        return session.update(namespace +"update", dto);
    }

    // 삭제
    public int delete(ItemDto dto) throws Exception {
        return session.delete(namespace + "delete", dto);
    }

    // 모두 삭제
    public int deleteAll() throws Exception {
        return session.delete(namespace +"deleteAll");
    }

    // 특정 카테고리 상품 조회
    public List<ItemDto> selectItemType(Category category) {
        return session.selectList(namespace+"selectItemType", category);
    }

//    // 상품 상태 등록
//    public int insertItemState(ItemStateDto dto) throws Exception {
//        return session.insert(namespace + "insertItemState", dto);
//    }
//    // 상품 가격 등록
//    public int insertItemPrice(ItemPriceDto dto) throws Exception {
//        return session.insert(namespace + "insertItemPrice", dto);
//    }

}
