package com.neo.byez.service;

import com.neo.byez.dao.TestDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestDaoImpl testDao;

    @Override
    public String now(){
        String result = "";
        try {
            result = testDao.now();
        }catch (Exception e){
            return result;
        }
        return result;
    }
}
