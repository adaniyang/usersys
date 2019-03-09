package com.springboot.usersys.service;

import com.springboot.usersys.pojo.User;
import com.springboot.usersys.pojo.vo.RoleGroupInforVo;

import java.util.List;

public interface UserService {
    public int addUser(User user);
    public int delUser(Long Id);
    public int updateUser(User user);
    public List<User> getUsers(User user);

    //测试返回结果集自动组装为list对象内的list属性
    List<RoleGroupInforVo> testReturnResult();
}
