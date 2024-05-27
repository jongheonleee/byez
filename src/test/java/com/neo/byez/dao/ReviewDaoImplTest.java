package com.neo.byez.dao;

import com.neo.byez.domain.ReviewDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class ReviewDaoImplTest {
    @Autowired
    ReviewDao reviewDao;

    @Test
    void count() {
        reviewDao.deleteAll();
        assertEquals(reviewDao.count(), 0);
    }

    @Test
    void insert() {
        reviewDao.deleteAll();
        assertEquals(reviewDao.count(), 0);
        ReviewDto reviewDto = new ReviewDto("ord", "asdf", "item_num", "title", "writer", "content", 3, "asfd", "asfd");
        reviewDao.insert(reviewDto);
        assertEquals(reviewDao.count(), 1);
    }

    @Test
    void delete() {
        reviewDao.deleteAll();
        assertEquals(reviewDao.count(), 0);
        ReviewDto reviewDto = new ReviewDto("ord", "asdf", "item_num", "title", "writer", "content", 3, "asfd", "asfd");
        reviewDao.insert(reviewDto);
        assertEquals(reviewDao.count(), 1);
    }

    @Test
    void update() {
        reviewDao.deleteAll();
        assertEquals(reviewDao.count(), 0);
        ReviewDto reviewDto = new ReviewDto("ord", "asdf", "item_num", "title", "writer", "content", 3, "asfd", "asfd");
        reviewDao.insert(reviewDto);
        assertEquals(reviewDao.count(), 1);
        ReviewDto updateDto = reviewDao.selectAll().get(0);
        updateDto.setTitle("change title");
        updateDto.setContent("change content");
        updateDto.setScore(5);
        reviewDao.update(updateDto);
        assertTrue(reviewDao.selectAll().get(0).equals(updateDto));
        assertTrue(reviewDao.selectAll().get(0).getReview_num() == updateDto.getReview_num());
    }

    @Test
    void selectAll() {
        reviewDao.deleteAll();
        assertEquals(reviewDao.count(), 0);
        ReviewDto reviewDto = new ReviewDto("ord", "asdf", "item_num", "title", "writer", "content", 3, "asfd", "asfd");
        reviewDao.insert(reviewDto);
        assertEquals(reviewDao.count(), 1);
        assertTrue(reviewDao.selectAll().get(0).equals(reviewDto));
    }

    @Test
    void select() {
        reviewDao.deleteAll();
        assertEquals(reviewDao.count(), 0);
        ReviewDto reviewDto = new ReviewDto("ord", "asdf", "item_num", "title", "writer", "content", 3, "asfd", "asfd");
        reviewDao.insert(reviewDto);
        assertEquals(reviewDao.count(), 1);
        assertTrue(reviewDao.selectById("asdf").get(0).equals(reviewDto));
    }
//    @Test
//    void selectbyItemNum() {
//       List<ReviewDto> list= reviewDao.selectByItem(113+"");
//        System.out.println(list.get(0));
//    }
}