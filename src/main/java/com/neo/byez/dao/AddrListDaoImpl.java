package com.neo.byez.dao;

import com.neo.byez.domain.AddressEntryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddrListDaoImpl implements AddrListDao {

    @Autowired
    SqlSession sqlSession;

    private static String namespace = "com.neo.byez.dao.AddrListMapper.";

    @Override
    public int count() throws Exception {
        return sqlSession.selectOne(namespace + "count");
    }

    @Override
    public List<AddressEntryDto> selectAll() throws Exception {
        return sqlSession.selectList(namespace + "selectAll");
    }

    @Override
    public List<AddressEntryDto> selectById(String id) throws Exception {
        return sqlSession.selectList(namespace + "selectById", id);
    }

    @Override
    public AddressEntryDto selectBySeq(Integer seq) throws Exception {
        return sqlSession.selectOne(namespace + "selectBySeq", seq);
    }

    @Override
    public int insert(AddressEntryDto addressEntryDto) throws Exception {
        return sqlSession.insert(namespace + "insert", addressEntryDto);
    }

    @Override
    public int deleteAll() throws Exception {
        return sqlSession.delete(namespace + "deleteAll");
    }

    @Override
    public int delete(Integer seq) throws Exception {
        return sqlSession.delete(namespace + "delete", seq);
    }

    @Override
    public int update(AddressEntryDto addressEntryDto) throws Exception {
        return sqlSession.update(namespace + "update", addressEntryDto);
    }
}
