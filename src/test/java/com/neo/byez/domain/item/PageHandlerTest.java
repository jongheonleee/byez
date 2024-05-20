package com.neo.byez.domain.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
class PageHandlerTest {

    @Test
    void 좋아요_페이징() {
        // 좋아요 상품수 250, 현재 페이지 6
        // [PREV] 1 2 ... 10 [NEXT]
        // 마지막 페이지 21
        PageHandler ph = new PageHandler(250, 6, 12);
        ph.print();

        assertEquals(20, ph.getTotalPage());
        assertEquals(1, ph.getBeginPage());
        assertEquals(10, ph.getEndPage());
        assertTrue(ph.isShowPrev());
        assertTrue(ph.isShowNext());

    }

    @Test
    void 좋아요_페이징2() {
        // 좋아요 상품수 250, 현재 페이지 10
        // [PREV] 1 2 ... 10 [NEXT]
        // 마지막 페이지 20
        PageHandler ph = new PageHandler(250, 10, 12);
        ph.print();

        assertEquals(20, ph.getTotalPage());
        assertEquals(1, ph.getBeginPage());
        assertEquals(10, ph.getEndPage());
        assertTrue(ph.isShowPrev());
        assertTrue(ph.isShowNext());

    }

    @Test
    void 좋아요_페이징3() {
        // 좋아요 상품수 250, 현재 페이지 20
        // [PREV] 11 12 ... 20
        // 마지막 페이지 20
        PageHandler ph = new PageHandler(250, 20, 12);
        ph.print();

        assertEquals(20, ph.getTotalPage());
        assertEquals(11, ph.getBeginPage());
        assertEquals(20, ph.getEndPage());
        assertTrue(ph.isShowPrev());
        assertFalse(ph.isShowNext());

    }

    @Test
    void 좋아요_페이징4() {
        // 좋아요 상품수 250, 현재 페이지 20
        // 1 2 ... 10 [NEXT]
        // 마지막 페이지 20
        PageHandler ph = new PageHandler(250, 1, 12);
        ph.print();

        assertEquals(20, ph.getTotalPage());
        assertEquals(1, ph.getBeginPage());
        assertEquals(10, ph.getEndPage());
        assertFalse(ph.isShowPrev());
        assertTrue(ph.isShowNext());

    }

    @Test
    void 장바구니_페이징() {
        // 장바구니 상품수 250, 현재 페이지 6
        // [PREV] 1 2 ... 10 [NEXT]
        // 마지막 페이지 25
        PageHandler ph = new PageHandler(250, 6, 10);
        ph.print();

        assertEquals(25, ph.getTotalPage());
        assertEquals(1, ph.getBeginPage());
        assertEquals(10, ph.getEndPage());
        assertTrue(ph.isShowPrev());
        assertTrue(ph.isShowNext());

    }

    @Test
    void 장바구니_페이징2() {
        // 장바구니 상품수 250, 현재 페이지 10
        // [PREV] 1 2 ... 10 [NEXT]
        // 마지막 페이지 25
        PageHandler ph = new PageHandler(250, 10, 10);
        ph.print();

        assertEquals(25, ph.getTotalPage());
        assertEquals(1, ph.getBeginPage());
        assertEquals(10, ph.getEndPage());
        assertTrue(ph.isShowPrev());
        assertTrue(ph.isShowNext());

    }

    @Test
    void 장바구니_페이징3() {
        // 장바구니 상품수 250, 현재 페이지 25
        // [PREV] 21 22 ... 25 
        // 마지막 페이지 25
        PageHandler ph = new PageHandler(250, 25, 10);
        ph.print();

        assertEquals(25, ph.getTotalPage());
        assertEquals(21, ph.getBeginPage());
        assertEquals(25, ph.getEndPage());
        assertTrue(ph.isShowPrev());
        assertFalse(ph.isShowNext());

    }


    @Test
    void 장바구니_페이징4() {
        // 장바구니 상품수 250, 현재 페이지 18
        // [PREV] 11 12 ... 20 [NEXT]
        // 마지막 페이지 25
        PageHandler ph = new PageHandler(250, 18, 10);
        ph.print();

        assertEquals(25, ph.getTotalPage());
        assertEquals(11, ph.getBeginPage());
        assertEquals(20, ph.getEndPage());
        assertTrue(ph.isShowPrev());
        assertTrue(ph.isShowNext());

    }



}