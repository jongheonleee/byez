package com.neo.byez.dao.item;

import com.neo.byez.domain.item.Category;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl {

    @Autowired
    SqlSession session;

    private static final String namespace = "com.neo.byez.dao.item.CategoryDao.";

    public int insert(Category category) throws Exception {
        return session.insert(namespace + "insert", category);
    }

    public Category select(String cate_num) throws Exception {
        return session.selectOne(namespace + "select", cate_num);
    }

    public List<Category> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    public int update(Category category) throws Exception {
        return session.update(namespace + "update", category);
    }

    public int delete(Category category) throws Exception {
        return session.delete(namespace + "delete", category);
    }

    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }


}
