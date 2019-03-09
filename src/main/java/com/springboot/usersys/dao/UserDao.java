package com.springboot.usersys.dao;


import com.springboot.usersys.pojo.User;
import com.springboot.usersys.pojo.vo.RoleGroupInforVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    int addUser(User user);
    int delUser(Long Id);
    int updateUser(User user);
    List<User> getUsers(User user);

    //测试返回结果集自动组装为list对象内的list属性
    List<RoleGroupInforVo> testReturnResult();
}
