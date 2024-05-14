package com.neo.byez.dao;

import com.neo.byez.domain.UserInfoHistDto;

import java.util.List;

public interface UserInfoHistDao {

    int deleteAllUserInfoHist() throws Exception;

    // 특정 고객 정보 변경이력 전체 조회
    List<UserInfoHistDto> selectUserInfoHist(String id) throws Exception;

    int insertUserInfoHist(UserInfoHistDto userInfoHistDto) throws Exception;

    List<UserInfoHistDto> selectAllUserInfoHist() throws Exception;
}
