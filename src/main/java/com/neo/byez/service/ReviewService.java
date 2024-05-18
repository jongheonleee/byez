package com.neo.byez.service;

import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.ReviewItemJoinDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    public int getCount();
    public int  write(ReviewDto reviewDto);
    public int remove(Integer review_num,String id);
    public int removeAll();
    public int modify(ReviewDto reviewDto);
    public List<ReviewDto> searchById(String id);
    public List<ReviewItemJoinDto> searchJoinItem(String id);

    public ReviewDto searchByReviewNum(Integer review_num);
}
