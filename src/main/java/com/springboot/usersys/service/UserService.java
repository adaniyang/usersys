package com.springboot.usersys.service;

import com.springboot.usersys.pojo.User;

import java.util.List;

public interface UserService {
    public int addUser(User user);
    public int delUser(Long Id);
    public int updateUser(User user);
    public List<User> getUsers(User user);
}
