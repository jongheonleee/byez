package com.neo.byez.service.user;

import com.neo.byez.domain.user.UserInfoHistDto;

import java.util.List;

public interface UserInfoHistService {

    // 고객정보 변경이력 조회
    List<UserInfoHistDto> getCustChangedInfoHist();

    // 고객정보 변경이력 저장
    boolean saveCustChangedInfo(UserInfoHistDto userInfoHistDto);
}
