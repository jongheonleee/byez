package com.neo.byez.dao.item;

import static org.junit.jupiter.api.Assertions.*;

import com.neo.byez.domain.item.Category;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class CategoryDaoImplTest {

    @Autowired
    CategoryDaoImpl dao;

    @BeforeEach
    public void clear() throws Exception {
        dao.deleteAll();
        List<Category> selected = dao.selectAll();
        assertEquals(0, selected.size());
    }

    @Test
    void insert() throws Exception {
        Category category = new Category("010101", "여성-맨투맨/스웨트셔츠", "", "");
        int rowCnt = dao.insert(category);
        assertEquals(1, rowCnt);
    }

    @Test
    void select() throws Exception {
        Category category = new Category("010101", "여성-맨투맨/스웨트셔츠", "", "");
        int rowCnt = dao.insert(category);
        assertEquals(1, rowCnt);

        Category found = dao.select("010101");
        assertNotNull(found);
        assertEquals(category.getCate_num(), found.getCate_num());
        assertEquals(category.getCate_name(), found.getCate_name());
    }

    @Test
    void selectAll() throws Exception {
        Category category = new Category("010101", "여성/맨투맨/스웨트셔츠", "", "");
        int rowCnt = dao.insert(category);
        assertEquals(1, rowCnt);

        Category category2 = new Category("010102", "여성/후드/집업", "", "");
        int rowCnt2 = dao.insert(category2);
        assertEquals(1, rowCnt2);

        List<Category> selected = dao.selectAll();
        assertEquals(2, selected.size());

        Category found1 = selected.get(0);
        assertNotNull(found1);
        assertEquals(category.getCate_num(), found1.getCate_num());
        assertEquals(category.getCate_name(), found1.getCate_name());

        Category found2 = selected.get(1);
        assertNotNull(found2);
        assertEquals(category2.getCate_num(), found2.getCate_num());
        assertEquals(category2.getCate_name(), found2.getCate_name());

    }

    @Test
    void update() throws Exception {
        Category category = new Category("010101", "여성/맨투맨/스웨트셔츠", "", "");
        int rowCnt = dao.insert(category);
        assertEquals(1, rowCnt);

        Category category2 = new Category("010101", "여성-맨투맨-스웨트셔츠", "", "");
        int rowCnt2 = dao.update(category2);
        assertEquals(1, rowCnt2);

        Category found = dao.select("010101");
        assertNotNull(found);
        assertEquals(category2.getCate_num(), found.getCate_num());
        assertEquals(category2.getCate_name(), found.getCate_name());


    }

    @Test
    void delete() throws Exception {
        Category category = new Category("010101", "여성/맨투맨/스웨트셔츠", "", "");
        int rowCnt = dao.insert(category);
        assertEquals(1, rowCnt);

        int rowCnt2 = dao.delete(category);
        assertEquals(1, rowCnt2);

        Category found = dao.select("010101");
        assertNull(found);

    }

    @Test
    void deleteAll() throws Exception {
        Category category = new Category("010101", "여성/맨투맨/스웨트셔츠", "", "");
        int rowCnt = dao.insert(category);
        assertEquals(1, rowCnt);

        Category category2 = new Category("010102", "여성/후드/집업", "", "");
        int rowCnt2 = dao.insert(category2);
        assertEquals(1, rowCnt2);

        int rowCnt3 = dao.deleteAll();
        assertEquals(2, rowCnt3);
    }
}