package com.lijinlin.project.service.Impl;

import com.lijinlin.project.dao.UserDao;
import com.lijinlin.project.pojo.User;
import com.lijinlin.project.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUserListByParam(Integer id,String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        User re = userDao.getUserListByParam(user);
        return re;
    }
}
