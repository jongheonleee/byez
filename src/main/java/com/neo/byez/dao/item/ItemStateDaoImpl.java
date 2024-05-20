package com.neo.byez.dao.item;

import com.neo.byez.domain.item.ItemStateDto;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemStateDaoImpl {
    @Autowired
    SqlSession session;
    private static final String namespace = "com.neo.byez.dao.item.ItemStateDao.";

    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    public List<ItemStateDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    public ItemStateDto select(String num) throws Exception {
        return session.selectOne(namespace+"select", num);
    }

    public int insert(ItemStateDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    public int increaseSalesQty(Map map) throws Exception {
        return session.update(namespace + "increaseSalesQty", map);
    }

    public int increaseStockQty(Map map) throws Exception {
        return session.update(namespace + "increaseStockQty", map);
    }

    public int increaseViewCnt(String num) throws Exception {
        return session.update(namespace + "increaseViewCnt", num);
    }

    public int updateStateCode(Map map) throws Exception {
        return session.update(namespace + "updateStateCode", map);
    }

    public int delete(String num) throws Exception {
        return session.delete(namespace + "delete", num);
    }

    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }
}
