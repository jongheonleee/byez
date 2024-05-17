package com.neo.byez.service;

import com.neo.byez.dao.CouponDaoImpl;
import com.neo.byez.domain.CouponDto;
import com.neo.byez.common.exception.DuplicateCouponNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponDaoImpl couponDao;

    @Override
    public int countCouponTypes() throws Exception {
        return couponDao.count();
    }

    @Override
    public CouponDto getCouponInfoByName(String couponName) throws Exception {
        return couponDao.selectByName(couponName);
    }

    @Override
    public List<CouponDto> getAllCouponInfo() throws Exception {
        return couponDao.selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createCouponType(CouponDto couponDto) throws Exception {

        // 쿠폰 이름이 이미 존재하는지 확인
        try {
            return couponDao.insert(couponDto);
        } catch (DuplicateKeyException e) {
            throw new DuplicateCouponNameException("중복된 쿠폰 이름입니다.");
        }
    }

    @Override
    public int removeAllCouponType() throws Exception {
        return couponDao.deleteAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeCouponTypeByName(String couponName) throws Exception {
        
        // 그 쿠폰이 고객에게 부여된 상황이라면 삭제가 되지 않게끔 해야함

        return couponDao.deleteByName(couponName);
    }

    @Override
    public int updateCouponInfo(CouponDto couponDto) throws Exception {
        return couponDao.update(couponDto);
    }
}
