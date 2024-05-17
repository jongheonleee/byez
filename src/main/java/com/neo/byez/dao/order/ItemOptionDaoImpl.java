package com.neo.byez.dao.order;

import com.neo.byez.domain.order.ItemOptionDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemOptionDaoImpl implements ItemOptionDao {

    @Autowired
    SqlSession session;

    private static final String namespace = "com.neo.byez.dao.order.itemOptionMapper.";
    @Override
    public List<ItemOptionDto> selectColor(String num) {
        return session.selectList(namespace + "selectColor", num);
    }

    @Override
    public List<ItemOptionDto> selectSize(String num) {
        return session.selectList(namespace + "selectSize", num);
    }

    @Override
    public int getCountSize(String num) {
        return session.selectOne(namespace + "getCountSize", num);
    }

    @Override
    public int getCountColor(String num) {
        return session.selectOne(namespace + "getCountColor", num);
    }


}
