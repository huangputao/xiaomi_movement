package com.movement.xiaomi.controller;

import com.movement.xiaomi.entity.User;
import com.movement.xiaomi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author 17839
 */
@RestController
@Api(tags = "user控制类",produces = "application/json")
@RequestMapping("/xiaomi")
public class UserController {
    @Resource
    UserService userService;

    @ApiOperation(value = "单添加(添加完等任务调度执行)", notes = "")
    @PostMapping("/addUser")
    public Boolean addUser(@RequestBody User user) throws UnsupportedEncodingException {
         return userService.addUser(user.getUsername(), user.getPassword());
    }


    //public SbException addUserAction(@RequestParam("username") String username,@RequestParam("password") String password){
    @ApiOperation(value = "添加,立马执行一次刷步数", notes = "")
    @PostMapping("/addUserAction")
    @ResponseBody
    public Boolean addUserAction(@RequestBody User user) throws UnsupportedEncodingException {
        return  userService.addUserAction(user.getUsername(), user.getPassword());
    }

    @ApiOperation(value = "删除", notes = "")
    @PostMapping("/removeUser")
    public Boolean removeUser(String username){
        if (username!=null){
            return userService.removeUser(username);
        }
        return false;
    }

/*    @ApiOperation(value = "查询", notes = "")
    @GetMapping("/getUserList")
    public List<User> getUserList(){
        return userService.getUserList();
    }*/


    @ApiOperation(value = "根据username查询是否存在数据", notes = "")
    @PostMapping("/getUserByUserName")
    public Boolean getUserByUserName(String username){
        if (username!=null){
            return userService.getUserByUsername(username);
        }
        return false;
    }
}
