package com.lijinlin.project.controller;

import com.lijinlin.project.pojo.User;
import com.lijinlin.project.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/getUserList")
    public String getUserList() {
        List<User> userList = userService.getUserList();
        return "hello,Sprintboot";
    }

    @GetMapping("/getUserDetail")
    public String getUserDetail(Integer id,String name) {
        User user = userService.getUserListByParam(id,name);
        return user.toString();
    }
}
