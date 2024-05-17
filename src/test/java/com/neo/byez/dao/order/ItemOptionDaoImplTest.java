package com.neo.byez.dao.order;

import com.neo.byez.domain.order.ItemOptionDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}) //설정파일 찾기
public class ItemOptionDaoImplTest {

    @Autowired
    ItemOptionDaoImpl itemOptionDao;


    /*
    [성공사례]
    1. 존재하는 상품번호의 사이즈옵션과 색상정보를 가져옴
    2. select 해온 옵션정보를 list에 담아 사이즈를 구한뒤
    3. 해당 상품번호 옵션의 count 결과값과 같은지 비교

    [실패사례]
    1. 존재하지않는 상품번호의 사이즈옵션과 색상옵션 불러오기 예외
    */

    //초기테스트
    @Test
    public void test(){
        System.out.println(itemOptionDao);
        assertTrue(itemOptionDao !=null);
    }
    @Test
    void selectColor() {

//         [성공사례]
//        1. 존재하는 상품번호의 사이즈옵션과 색상정보를 가져옴
//        2. select 해온 옵션정보를 list에 담아 사이즈를 구한뒤
//        3. 해당 상품번호 옵션의 count 결과값과 같은지 비교

        List<ItemOptionDto> list = itemOptionDao.selectColor("1000");
        int colorCnt = itemOptionDao.getCountColor("1000");

        assertEquals(list.size(), colorCnt);

        List<ItemOptionDto> list1 = itemOptionDao.selectColor("1001");
        int colorCnt1 = itemOptionDao.getCountColor("1001");

        assertEquals(list1.size(), colorCnt1);

//         [실패사례]
//        1. 존재하지않는 상품번호의 사이즈옵션과 색상옵션 불러오기

        List<ItemOptionDto> list2 = itemOptionDao.selectColor("2000");
        assertTrue(list2.size() == 0);

    }

    @Test
    void selectSize() {

        //         [성공사례]
//        1. 존재하는 상품번호의 사이즈옵션과 색상정보를 가져옴
//        2. select 해온 옵션정보를 list에 담아 사이즈를 구한뒤
//        3. 해당 상품번호 옵션의 count 결과값과 같은지 비교

        List<ItemOptionDto> list = itemOptionDao.selectSize("1000");
        int sizeCnt = itemOptionDao.getCountSize("1000");

        assertEquals(list.size(), sizeCnt);

        List<ItemOptionDto> list1 = itemOptionDao.selectSize("1001");
        int sizeCnt1 = itemOptionDao.getCountSize("1001");

        assertEquals(list1.size(), sizeCnt1);

        //         [실패사례]
//        1. 존재하지않는 상품번호의 사이즈옵션과 색상옵션 불러오기

        List<ItemOptionDto> list2 = itemOptionDao.selectColor("2000");
        assertTrue(list2.size() == 0);
    }

}