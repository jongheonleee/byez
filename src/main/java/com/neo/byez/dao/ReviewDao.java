package com.neo.byez.dao;

import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.ReviewItemJoinDto;

import java.util.List;

public interface ReviewDao {
    int count();
    int insert(ReviewDto reviewDto);

    int delete(Integer review_num);
    int deleteAll();

    int update(ReviewDto reviewDto);

    List<ReviewDto> selectById(String id);
    List<ReviewDto> selectAll();
    List<ReviewItemJoinDto> selectJoinItem(String id);
    ReviewDto selectByReviewNum(Integer review_num);
    List<ReviewDto> selectByItem(String item_num);
}
