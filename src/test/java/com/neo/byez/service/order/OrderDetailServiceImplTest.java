package com.neo.byez.service.order;

import com.neo.byez.dao.order.OrderDetailDaoImpl;
import com.neo.byez.domain.order.ItemOptionDto;
import com.neo.byez.domain.order.OrderDetailDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class) //ac 생성
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}) //설정파일 찾기
public class OrderDetailServiceImplTest {

    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    OrderDetailDaoImpl orderDetailDao;
    //2024-05-03
    //1. 특정고객의 주문내역 insert하기
        //1-1 insert
    //2. 고객별 주문내역 불러오기(selectAll(id))

    //추가되어야하는 테스트 및 기능
    //1 기간별 주문내역 불러오기
    //2.주문상태별 주문내역 불러오기


    //초기테스트
    @Test
    public void test(){
        assertTrue(orderDetailService != null);
    }
    @Test
    public void selectOneOrdDetail() throws Exception {
        List<OrderDetailDto> list = orderDetailService.selectOneOrdDetail("20240503-0001");
        System.out.println(list);
    }

    @Test
    public void selectOneSeqForExchange() throws Exception {
        OrderDetailDto exchange = orderDetailService.selectOneSeqForExchange("20240503-0001", 1);
        System.out.println(exchange);
    }
    @Test
    public void getOrderDetailsList() throws Exception {
        List<OrderDetailDto> list = orderDetailService.getOrderDetailsList("aaa");
        assertTrue(list != null);
    }
    @Test
    public void selectColorOption(){
        //조회성공사례
        List<ItemOptionDto> list = orderDetailService.selectColorOption("1000");
        int colorCnt = orderDetailService.getCountColor("1000");

        assertTrue(list.size() == colorCnt);

        List<ItemOptionDto> list1 = orderDetailService.selectColorOption("1001");
        int colorCnt1 = orderDetailService.getCountColor("1001");

        assertTrue(list1.size() == colorCnt1);

        //조회실패사례
        List<ItemOptionDto> list2 = orderDetailService.selectColorOption("2000");
        Assertions.assertTrue(list2.size() == 0);
    }

    @Test
    public void selectSizeOption(){
        //조회성공사례
        List<ItemOptionDto> list = orderDetailService.selectSizeOption("1000");
        int sizeCnt = orderDetailService.getCountSize("1000");

        assertTrue(list.size() == sizeCnt);

        List<ItemOptionDto> list1 = orderDetailService.selectSizeOption("1001");
        int colorCnt1 = orderDetailService.getCountSize("1001");

        assertTrue(list1.size() == colorCnt1);

        //조회실패사례
        List<ItemOptionDto> list2 = orderDetailService.selectSizeOption("2000");
        Assertions.assertTrue(list2.size() == 0);
    }

    // getPage 테스트

    // getCount 테스트

    // updateIfChanged 테스트
    @Test
    public void updateIfChanged() throws Exception {

        //옵션테스트를 위한 옵션초기화(black/L)
        updateInit();

        //1. 성공사례
        //옵션이 2개 모두 변경되었을 경우
        OrderDetailDto currentOption = orderDetailService.selectOneSeqForExchange("20231212-0001", 1);
        currentOption.setOpt1("yellow");
        currentOption.setOpt2("S");
        currentOption.setOrd_state("교환신청");
        int rowCnt = orderDetailService.updateIfChanged(currentOption);
        assertTrue(rowCnt == 1);


        //옵션이 1개만 변경되었을 경우
        OrderDetailDto currentOption1 = orderDetailService.selectOneSeqForExchange("20231212-0001", 1);
        currentOption1.setOpt1("orange");
        currentOption1.setOpt2("S");
        currentOption1.setOrd_state("교환신청");
        int rowCnt1 = orderDetailService.updateIfChanged(currentOption1);
        assertTrue(rowCnt1 == 1);
//        System.out.println(rowCnt1);

        //2. 실패사례
        //옵션이 변경되지 않아 테스트 실패
        OrderDetailDto currentOption2 = orderDetailService.selectOneSeqForExchange("20231212-0001", 1);
        currentOption1.setOpt1("orange");
        currentOption1.setOpt2("S");
        currentOption1.setOrd_state("교환신청");
        int rowCnt2 = orderDetailService.updateIfChanged(currentOption1);
        assertTrue(rowCnt2 == 0);
//        System.out.println(rowCnt2);

    }
    /*
    옵션이 모두 변경되었을때 update
    옵션이 1개만 변경되었을때 update
    옵션이 1개도 변경되지 않았을때 update 되지 않는 점
    */


    //보조메서드
    public void updateInit() throws Exception {
        OrderDetailDto orderDetailDto = new OrderDetailDto("20231212-0001","1000","aaa","기본반팔티",15000,1,15000,"black","S","배송완료");
        orderDetailDao.insert(orderDetailDto);
        OrderDetailDto currentOption = orderDetailService.selectOneSeqForExchange("20231212-0001", 1);
        currentOption.setOpt1("black");
        currentOption.setOpt2("L");
        currentOption.setOrd_state("배송완료");
        orderDetailService.updateIfChanged(currentOption);
    }

    //------------------------------찬빈추가
    @Test
    public void 작성안한리뷰아이디로찾기() {
        assertEquals(orderDetailService.searchById("TestID0").size(),1);
    }

//    @Test
//    public void 값찾기_상품주문ID() {
//        OrderDetailDto ordDetailDto = orderDetailService.searchOrdItem("TestOrd_num0","0","TestID0");
//       assertEquals(ordDetailDto.getOrd_num(),"TestOrd_num0");
//        assertEquals(ordDetailDto.getItem_num(),"0");
//        assertEquals(ordDetailDto.getId(),"TestID0");
//    }

}