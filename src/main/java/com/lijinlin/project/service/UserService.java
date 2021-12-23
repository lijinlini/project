package com.lijinlin.project.service;

import com.lijinlin.project.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User getUserListByParam(Integer id,String name);
}
