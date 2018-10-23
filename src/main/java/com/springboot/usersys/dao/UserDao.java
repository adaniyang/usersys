package com.springboot.usersys.dao;


import com.springboot.usersys.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    int addUser(User user);
    int delUser(Long Id);
    int updateUser(User user);
    List<User> getUsers(User user);
}
