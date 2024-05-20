package com.neo.byez.service.user;

import com.neo.byez.dao.user.UserDaoImpl;
import com.neo.byez.dao.user.UserInfoHistDaoImpl;
import com.neo.byez.domain.user.UserInfoHistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoHistServiceImpl implements UserInfoHistService {
    private UserDaoImpl userDao;
    private UserInfoHistDaoImpl userInfoHistDao;

    @Autowired
    public UserInfoHistServiceImpl(UserDaoImpl userDao, UserInfoHistDaoImpl userInfoHistDao) {
        this.userDao = userDao;
        this.userInfoHistDao = userInfoHistDao;
    }

    // 고객정보 변경이력 조회
    @Override
    public List<UserInfoHistDto> getCustChangedInfoHist() {
        List<UserInfoHistDto> histList = null;
        try {
            histList = userInfoHistDao.selectAllUserInfoHist();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return histList;
    }

    // 고객정보 변경이력 저장
    @Override
    public boolean saveCustChangedInfo(UserInfoHistDto userInfoHistDto) {
        try {
            userInfoHistDao.insertUserInfoHist(userInfoHistDto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
