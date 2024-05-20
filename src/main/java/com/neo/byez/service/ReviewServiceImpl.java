package com.neo.byez.service;

import com.neo.byez.dao.ReviewDao;
import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.ReviewItemJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewDao reviewDao;

    @Override
    public int getCount() {
        return reviewDao.count();
    }

    @Override
    public int write(ReviewDto reviewDto) {
        return reviewDao.insert(reviewDto);
    }

    @Override
    public int remove(Integer review_num, String id) {
        return reviewDao.delete(review_num,id);
    }

    @Override
    public int removeAll() {
        return reviewDao.deleteAll();
    }

    @Override
    public int modify(ReviewDto reviewDto) {
        return reviewDao.update(reviewDto);
    }

    @Override
    public List<ReviewDto> searchById(String id) {
        return reviewDao.selectById(id);
    }

    @Override
    public List<ReviewItemJoinDto> searchJoinItem(String id) {
        return reviewDao.selectJoinItem(id);
    }

    @Override
    public ReviewDto searchByReviewNum(Integer review_num) {
        return reviewDao.selectByReviewNum(review_num);
    }
    @Override
    public List<ReviewDto> searchByItem(String item_num){return reviewDao.selectByItem(item_num);}
}
