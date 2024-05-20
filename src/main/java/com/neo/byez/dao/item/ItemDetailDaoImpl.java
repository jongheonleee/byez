package com.neo.byez.dao.item;

import com.neo.byez.domain.item.ItemDetailDto;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDetailDaoImpl {

    private static final String namespace = "com.neo.byez.dao.item.ItemDetailDao.";
    @Autowired
    SqlSession session;


    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    public ItemDetailDto select(String num) throws Exception {
        return session.selectOne(namespace+"select", num);
    }

    public List<ItemDetailDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    public int insert(ItemDetailDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    public int update(ItemDetailDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    public int delete(String num) throws Exception {
        return session.delete(namespace+"delete", num);
    }

    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }

}
