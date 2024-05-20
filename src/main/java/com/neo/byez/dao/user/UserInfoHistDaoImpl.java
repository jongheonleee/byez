package com.neo.byez.dao.user;

import com.neo.byez.domain.user.UserInfoHistDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoHistDaoImpl implements UserInfoHistDao {

    @Autowired SqlSession session;

    private static String namespace = "com.neo.byez.dao.user.UserInfoHistDao.";

    // 고객 정보 변경이력 전체 삭제
    @Override
    public int deleteAllUserInfoHist() throws Exception {
        return session.delete(namespace + "deleteAllUserInfoHist");
    }

    // 고객 정보 변경이력 전체 조회
    @Override
    public List<UserInfoHistDto> selectAllUserInfoHist() throws Exception {
        return session.selectList(namespace + "selectAllUserInfoHist");
    }

    // 특정 고객 정보 변경이력 전체 조회
    @Override
    public List<UserInfoHistDto> selectUserInfoHist(String id) throws Exception {
        return session.selectList(namespace + "selectUserInfoHist", id);
    }

    // 고객 정보 변경이력 추가
    @Override
    public int insertUserInfoHist(UserInfoHistDto userInfoHistDto) throws Exception {
        return session.insert(namespace + "insertUserInfoHist", userInfoHistDto);
    }

}
