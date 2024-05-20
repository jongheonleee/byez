package com.neo.byez.dao.item;


import com.neo.byez.domain.item.ItemPriceDto;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemPriceDaoImpl {

    private static final String namespace = "com.neo.byez.dao.item.ItemPriceDao.";

    @Autowired
    private SqlSession session;

    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    public ItemPriceDto select(String num) throws Exception {
        return session.selectOne(namespace + "select", num);
    }

    public List<ItemPriceDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    public int insert(ItemPriceDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    public int updateDiscRate(ItemPriceDto dto) throws Exception {
        return session.update(namespace + "updateDiscRate", dto);
    }

    public int increasePeriod(ItemPriceDto dto) throws Exception {
        return session.update(namespace + "increasePeriod", dto);
    }

    public int decreasePeriod(ItemPriceDto dto) throws Exception {
        return session.update(namespace + "decreasePeriod", dto);
    }

    public int delete(String num) throws Exception {
        return session.delete(namespace + "delete", num);
    }

    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }
}
