package com.lijinlin.project.service.Impl;


import com.lijinlin.project.dao.T2Dao;
import com.lijinlin.project.pojo.T2;
import com.lijinlin.project.service.T2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class T2ServiceImpl implements T2Service {
    @Resource
    private T2Dao t2Dao;

    @Override
    public void getAll() {
        List<T2> list = new ArrayList<>();
        while(true){
            list.addAll(t2Dao.getAll());
            System.out.println(list.size());
        }
    }
}
