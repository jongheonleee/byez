package com.neo.byez.dao.item;

import com.neo.byez.domain.item.ItemDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemBestDaoImpl implements ItemDao {
    @Autowired
    SqlSession session;

    private static final String namespace = "com.neo.byez.dao.item.ItemDao.";



    //베스트 페이지 url에서 gender, sort 값 매개변수로 받아옴, 각 정렬기준별 top 50개의 상품 select
    public List<ItemDto> selectBest50(
//            Integer page, Integer pageSize
            Integer gender, Integer sort
    ) throws Exception {
        Map map = new HashMap();
//        map.put("offset", (page-1)*pageSize);
//        map.put("pageSize", pageSize);
        map.put("gender", gender);
        map.put("sort", sort);
        return session.selectList(namespace + "selectBest50", map);
    }

}
