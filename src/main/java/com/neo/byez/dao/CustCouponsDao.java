package com.neo.byez.dao;

import com.neo.byez.domain.CustCouponsDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustCouponsDao {
    int count() throws Exception;

    List<CustCouponsDto> selectAll() throws Exception;

    List<CustCouponsDto> select(String id) throws Exception;

    int insert(String id, String couponName) throws Exception;

    int deleteAll() throws Exception;

    int delete(Integer seq) throws Exception;

    int update(Integer seq) throws Exception;
}
