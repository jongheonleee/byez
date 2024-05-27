package com.neo.byez.dao.item;

import com.neo.byez.domain.item.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class ItemAdminDaoImplTest {

    @Autowired
    private ItemDaoImpl dao;

    @Autowired
    private ItemStateDaoImpl itemStateDao;

    @Test
    void selectAllItemOnAdmin() throws Exception {
        SearchCondition sc = new SearchCondition();
        sc.setPageSize(10);
        List<AdminItemDto> result = dao.selectAllItemOnAdmin(sc);
        result.stream().forEach(i -> System.out.println(i));
    }

    @Test
    void selectAllItemStockInfoOnAdmin() throws Exception {
        SearchCondition sc = new SearchCondition();
        sc.setPageSize(10);
        List<AdminItemDto> result = dao.selectAllItemStockInfoOnAdmin(sc);
        result.stream().forEach(i -> System.out.println(i));
    }

    @Test
    void increaseStockQty() throws Exception {
        String num = "304";
        Integer qty = 10;

        ItemStateDto selected = itemStateDao.select(num);
        int rowCnt = dao.increaseStockQty(num, qty);
        assertEquals(1, rowCnt);

        ItemStateDto updated = itemStateDao.select(num);
        assertEquals(selected.getStock_qty() + qty, updated.getStock_qty());
    }
    @Test
    void selectItemDetailInfoOnAdmin() throws Exception {
        String num = "304";

        ItemRegisterInfo result = dao.selectItemDetailInfoOnAdmin(num);
        System.out.println(result);
    }
}