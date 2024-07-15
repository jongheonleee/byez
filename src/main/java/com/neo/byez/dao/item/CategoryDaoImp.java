package com.neo.byez.dao.item;

import com.neo.byez.domain.item.Category;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImp {

    @Autowired
    private SqlSession session;

    private static final String namespace = "com.neo.byez.dao.item.CategoryDao.";


    // 카테고리 CRUD
        // 1. create
        // 2. read
        // 3. update
        // 4. delete

    public int count() throws Exception {
        return 0;
    }
    public List<Category> selectAllCategory() throws Exception {
        return null;
    }

    public List<Category> selectCategory(String str) throws Exception {
        return null;
    }

    public int insertCategory(Category category) throws Exception {
        return 0;
    }

    public int updateCategory(Category category) throws Exception {
        return 0;
    }

    public int deleteCategory(String str) throws Exception {
        return 0;
    }

    public int deleteAllCategory() throws Exception {
        return 0;
    }

}
