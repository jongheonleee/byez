package com.neo.byez.dao.item;

import com.neo.byez.domain.item.Category;
import com.neo.byez.domain.item.ItemDetailPageDto;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.SearchCondition;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public ItemDto select(String num) throws Exception {
        return session.selectOne(namespace +"select", num);
    }

    public ItemDetailPageDto selectDetailItem(String num) throws Exception {
        return session.selectOne(namespace + "selectDetailItem", num);
    }


    // 모두 조회
    public List<ItemDto> selectAll(Integer page, Integer pageSize) throws Exception {
        Map map = new HashMap();
        map.put("offset", (page-1)*pageSize);
        map.put("pageSize", pageSize);
        return session.selectList(namespace + "selectAll", map);
    }

    public List<ItemDto> selectBySearchCondition(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "selectBySearchCondition", sc);
    }

    public int countSearchResult(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "countSearchResult", sc);
    }

    public List<ItemDto> selectDiscountItem(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "selectDiscountItem", sc);
    }

    public int countDiscountItem(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "countDiscountItem", sc);
    }



    // 등록
    public int insert(ItemDto dto) throws Exception {
        return session.insert(namespace +"insert", dto);
    }

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

    // 상품 상태


    //    메인페이지 여성 top 8개 상품 띄우기
    public List<ItemDto> selectWTop8(ItemDto dto) throws Exception {
        return session.selectList(namespace+"selectWTop8", dto);
    }

    //    메인페이지 남성 top 8개 상품 띄우기
    public List<ItemDto> selectMTop8(ItemDto dto) throws Exception {
        return session.selectList(namespace+"selectMTop8", dto);
    }

    //    메인페이지 혼성 top 8개 상품 띄우기
    public List<ItemDto> selectUTop8(ItemDto dto) throws Exception {
        return session.selectList(namespace+"selectUTop8", dto);
    }

}
