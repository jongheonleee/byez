package com.neo.byez.dao.item;


import com.neo.byez.domain.item.BasketDto;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasketDaoImpl {

    @Autowired
    SqlSession session;

    private static final String namespace = "com.neo.byez.dao.item.BasketDao.";

    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    public BasketDto select(String id) throws Exception {
        return session.selectOne(namespace+"select", id);
    }

    public List<BasketDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    public int insert(BasketDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    }

    public int delete(String id) throws Exception {
        return session.delete(namespace+"delete", id);
    }

    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }
}
