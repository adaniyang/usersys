package com.springboot.usersys.service.impl;

import com.springboot.usersys.dao.UserDao;
import com.springboot.usersys.pojo.User;
import com.springboot.usersys.pojo.vo.RoleGroupInforVo;
import com.springboot.usersys.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int delUser(Long Id) {
        return userDao.delUser(Id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> getUsers(User user) {
        return userDao.getUsers(user);
    }

    //测试返回结果集自动组装为list对象内的list属性
    @Override
    public List<RoleGroupInforVo> testReturnResult() {
        return userDao.testReturnResult();
    }
}
