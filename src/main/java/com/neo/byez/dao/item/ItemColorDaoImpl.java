package com.neo.byez.dao.item;

import com.neo.byez.domain.item.ItemOptDto;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemColorDaoImpl {

    @Autowired
    private SqlSession session;

    private static final String namespace = "com.neo.byez.dao.item.ItemColorDao.";



    public int count(String num) throws Exception {
        return session.selectOne(namespace + "count", num);
    }

    public int countAll() throws Exception {
        return session.selectOne(namespace + "countAll");
    }

    public int insert(ItemOptDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    public List<ItemOptDto> select(String num) throws Exception {
        return session.selectList(namespace + "select", num);
    }

    public List<ItemOptDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    public int update(ItemOptDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    public int delete(ItemOptDto dto) throws Exception {
        return session.delete(namespace + "delete", dto);
    }

    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    public int deleteAllColor(String num) throws Exception {
        return session.delete(namespace + "deleteAllColor", num);
    }


}
