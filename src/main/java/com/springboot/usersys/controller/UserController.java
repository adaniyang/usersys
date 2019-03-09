package com.springboot.usersys.controller;

import com.springboot.usersys.pojo.User;
import com.springboot.usersys.pojo.vo.RoleGroupInforVo;
import com.springboot.usersys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiIgnore
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world!";
    }

    @ApiOperation(value="添加用户", notes="根据User对象创建用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userAccount",value = "用户名",dataType = "String",paramType = "path",required = true),
//            @ApiImplicitParam(name = "pwd",value = "密码",dataType = "String",paramType = "query",required = true),
//            @ApiImplicitParam(name = "delStatus",value = "删除状态 0:已删除 1:未删除",dataType = "Integer",paramType = "query",required = true)
//    })
//    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
//    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        System.out.println("2222");
        String result = "请求失败！";
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        if(userService.addUser(user) == 1) {
            result = "请求成功!";
        }
        return result;
    }

    @ApiOperation(value = "删除用户",notes = "根据Id删除用户")
//    @ApiImplicitParam(dataType = "Long",paramType = "path")
    @RequestMapping(value ="/delUser/{id}",method = RequestMethod.GET)
    public String delUser( @PathVariable("id") Long id,@RequestParam("b") int b){
        System.out.println(b+"ssssssssssssss");
        String result = "请求失败!";
        if(userService.delUser(id) == 1){
            result = "请求成功!";
       }
        return result;
    }

    @ApiOperation(value = "修改用户",notes = "根据用户id修改用户")
    @RequestMapping(value ="/updateUser",method = RequestMethod.POST)
    public String updateUser(@RequestBody  User user){
        String result = "请求失败!";
        if(userService.updateUser(user) == 1){
            result = "请求成功!";
        }
        return result;
    }

    @ApiOperation(value = "查找用户",notes = "查找所有用户")
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> userList = new ArrayList<User>();
        User user = new User();
        userList = userService.getUsers(user);
        return userList;
    }

    //测试返回结果集自动组装为list对象内的list属性
    @ApiOperation(value = "测试返回结果集自动组装为list对象内的list属性(created by yangni)")
    @GetMapping("/edubureauuser_management/testReturnResult")
    public List<RoleGroupInforVo> testReturnResult() {
        return  userService.testReturnResult();
    }
}
