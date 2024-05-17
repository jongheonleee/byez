package com.neo.byez.service;

import com.neo.byez.dao.CouponDao;
import com.neo.byez.dao.CouponDaoImpl;
import com.neo.byez.dao.CustCouponsDao;
import com.neo.byez.dao.CustCouponsDaoImpl;
import com.neo.byez.domain.CouponDto;
import com.neo.byez.domain.CustCouponsDto;
import com.neo.byez.domain.order.OrderDto;
import com.neo.byez.domain.UserCouponDetails;
import com.neo.byez.common.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustCouponsServiceImpl implements CustCouponsService {

    @Autowired
    CustCouponsDaoImpl custCouponsDao;

    @Autowired
    CouponDaoImpl couponDao;

    @Override
    public int getTotalCouponCount() throws Exception {
        return custCouponsDao.count();
    }

    @Override
    public List<CustCouponsDto> getAllUserCoupons() throws Exception {
        return custCouponsDao.selectAll();
    }

    @Override
    public List<CustCouponsDto> getCouponsByUserId(String userId) throws Exception {
        return custCouponsDao.select(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void grantCouponToUser(String userId, String couponName) throws Exception {

        CouponDto couponDto = couponDao.selectByName(couponName);

        if (couponDto.getAbleChk().equals("N")) {
            throw new CouponNotGrantedException("지급 불가한 쿠폰입니다.");
        }

        int affectedRow = custCouponsDao.insert(userId, couponName);

        if (affectedRow == 0) {
            throw new CouponNotGrantedException(("쿠폰이 지급되지 않았습니다. 다시 시도해주세요."));
            // GlobalExceptionHandler로 처리합니다.
        }

    }

    @Override
    public boolean deleteCouponHistory(Integer seq) throws Exception {
        return custCouponsDao.delete(seq) == 1;
    }

    @Override
    public int deleteAllCouponHistory() throws Exception {
        return custCouponsDao.deleteAll();
    }

    @Override
    public boolean useCoupon(Integer seq) throws Exception {
        return custCouponsDao.update(seq) == 1;
    }

    // 유저의 id로 쿠폰발행정보와 그 쿠폰들의 상세정보를 얻어옴
    @Override
    public List<UserCouponDetails> getUserCouponDetailsByUserId(String userId) throws Exception {

        List<UserCouponDetails> userCouponDetailsList = new ArrayList<>();

        // 유저 id로 보유중인 쿠폰을 전부 가져온다
        List<CustCouponsDto> userCoupons = custCouponsDao.select(userId);

        for (CustCouponsDto custCouponsDto : userCoupons) {
            // 보유중인 쿠폰의 쿠폰번호를 가져와서 쿠폰 정보를 가져온다
            Integer couponSeq = custCouponsDto.getCouponSeq();
            CouponDto couponDto = couponDao.selectBySeq(couponSeq);

            // 보유중인 쿠폰과 쿠폰 정보를 한 객체에 담는다
            UserCouponDetails userCouponDetails = new UserCouponDetails(custCouponsDto, couponDto);
            userCouponDetailsList.add(userCouponDetails);
        }


        return userCouponDetailsList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void validateAndUseCoupon(OrderDto orderDto, CouponDto couponDto, Integer seq) throws Exception {

        // 1. 쿠폰 정보가 조작되었는지 확인
        CouponDto dbCouponDto = couponDao.selectByName(couponDto.getName());

        // db의 정보와 사용자가 보낸 정보 일치하는지 확인
        if (!(dbCouponDto.getName().equals(couponDto.getName()) &&
        dbCouponDto.getPrmo() == couponDto.getPrmo() &&
        dbCouponDto.getMinPayPrice() == couponDto.getMinPayPrice() &&
        dbCouponDto.getMaxDiscPrice() == couponDto.getMaxDiscPrice() &&
        dbCouponDto.getDiscType().equals(couponDto.getDiscType()))) {
            throw new CouponManipulationException("쿠폰 정보가 조작되었습니다.");
        }

        // 2. 할인 혜택 검증
        int totalPrice = orderDto.getTotal_price();
        String discType = couponDto.getDiscType();
        int prmo = couponDto.getPrmo();
        int maxDiscPrice = couponDto.getMaxDiscPrice();
        int discountAmount = 0;

        if (discType.equals("PER")) {
            discountAmount = (int)((prmo / 100.0) * totalPrice);
        } else if (discType.equals("ABS")) {
            discountAmount = prmo;
        } else { // 유효하지 않은 할인 혜택 유형
            throw new InvalidDiscountTypeException("유효하지 않은 할인 혜택 유형입니다: " + discType);
        }

        if (discountAmount > maxDiscPrice) {
            discountAmount = maxDiscPrice;
        }

        int totalPaymentAmount = totalPrice - discountAmount;

        if(!(orderDto.getTotal_price() == totalPrice &&
        orderDto.getTotal_disc_price() == discountAmount &&
        orderDto.getTotal_pay_price() == totalPaymentAmount)) {
            throw new OrderManipulationException("주문 정보가 조작되었습니다.");
        }

        // 3. 쿠폰 사용 처리
        if(custCouponsDao.update(seq) == 0) {
            throw new CouponUsageException("쿠폰 사용 처리 중 문제가 발생했습니다.");
        }
    }
}
