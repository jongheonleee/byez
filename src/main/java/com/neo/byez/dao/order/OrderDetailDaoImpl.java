package com.neo.byez.dao.order;

import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.order.OrderDetailDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {
    @Autowired
    SqlSession session;

    private static String namespace = "com.neo.byez.dao.order.OrderDetailDao.";

    @Override
    public int count(String ord_num) throws Exception {
        return session.selectOne(namespace + "count", ord_num);
    }

    @Override
    public int countAll() throws Exception {
        return session.selectOne(namespace + "countAll");
    }

    @Override
    public int insert(OrderDetailDto orderDetailDto) throws Exception {
        return session.insert(namespace + "insert", orderDetailDto);
    }

    @Override
    public List<OrderDetailDto> select(String ord_num) throws Exception {
        return session.selectList(namespace + "select", ord_num);
    }

    @Override
    public List<OrderDetailDto> selectAll(String id) throws Exception {
        return session.selectList(namespace + "selectAll", id);
    }

    @Override
    public int update(OrderDetailDto orderDetailDto) throws Exception {
        return session.update(namespace + "update", orderDetailDto);
    }

    @Override
    public int delete(String ord_num) throws Exception {
        return session.delete(namespace + "delete", ord_num);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int getCount() throws Exception{
        return session.selectOne(namespace + "count");
    }
    @Override
    public List<OrderDetailDto> selectByOrdNum(String ord_num) throws Exception{
        return session.selectList(namespace + "selectByOrdNum" , ord_num);
    }

    @Override
    public List<OrderDetailDto> selectAllEtc(String id) throws Exception {
        return session.selectList(namespace + "selectAllEtc", id);
    }

    //옵션변경
    @Override
    public int updateOption(OrderDetailDto OrderDetailDto ) throws Exception {
        return session.update(namespace + "updateOption", OrderDetailDto);
    }

    @Override
    public OrderDetailDto selectNumAndSeq(String ord_num, Integer seq) throws Exception {
        Map map = new HashMap();
        map.put("ord_num", ord_num);
        map.put("seq", seq);
        return session.selectOne(namespace + "selectNumAndSeq", map);
    }

    @Override
    public int updateOrdState(OrderDetailDto OrderDetailDto ) throws Exception {
        return session.update(namespace + "updateOrdState", OrderDetailDto);
    }

    @Override
    public int updateEachOrdState(OrderDetailDto OrderDetailDto) {
        return session.update(namespace + "updateEachOrdState", OrderDetailDto);
    }

    @Override
    public List<OrderDetailDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }
   //찬빈 추가
    @Override
    public List<OrderDetailDto> selectById(String id) {
        Map map = new HashMap();
        map.put("id", id);
        return session.selectList(namespace + "selectById", map);
    }

    @Override
    public OrderDetailDto selectOrdItem(String ord_num, String item_num, String id) {
        Map map = new HashMap<>();
        map.put("ord_num", ord_num);
        map.put("item_num", item_num);
        map.put("id",id);
        return session.selectOne(namespace + "selectOrdItem", map);
    }

    @Override
    public int updateReviewState(ReviewDto reviewDto) {
        return session.update(namespace+"updateReviewState",reviewDto);
    }
}
