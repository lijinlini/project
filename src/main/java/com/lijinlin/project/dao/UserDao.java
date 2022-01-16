package com.lijinlin.project.dao;

import com.lijinlin.project.pojo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**告诉spring mybatis的一个mapper类*/
@Mapper
/**将userdao交给spring容器管理*/
@Repository
/*@CacheNamespace*/
public interface UserDao {
    /**
     *    查询所有用户
     */
    public List<User> getUserList();


    public User getUserListByParam(User user);
}
