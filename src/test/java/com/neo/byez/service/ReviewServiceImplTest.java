package com.neo.byez.service;

import com.neo.byez.domain.ReviewDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class ReviewServiceImplTest {
    @Autowired
    ReviewService reviewService;
    @Test
    void getCount(){
        reviewService.removeAll();
        assertEquals(reviewService.getCount(), 0);
    }
    @DisplayName("")
    @Test
    void write() {
        reviewService.removeAll();
        assertEquals(reviewService.getCount(), 0);
        ReviewDto reviewDto = new ReviewDto("ord1", "asdf", "item1", "title", "writer", "content", 3, "asfd", "asfd");
        reviewService.write(reviewDto);
        assertEquals(reviewService.getCount(), 1);
    }

//    @Test
//    void remove() {
//        reviewService.remove(2,"user1");
//    }

    @Test
    void modify() {
    }

    @Test
    void searchById() {
        reviewService.removeAll();
        assertEquals(reviewService.getCount(), 0);
        ReviewDto reviewDto = new ReviewDto("ord", "asdf", "item_num", "title", "writer", "content", 3, "asfd", "asfd");
        reviewService.write(reviewDto);
        assertEquals(reviewService.getCount(), 1);
        assertTrue(reviewService.searchById("asdf").get(0).equals(reviewDto));
    }
    @DisplayName("한줄평/내용/별점 null값 입력")
    @Test
    void searchReviewNum_Null(){
    }
}
