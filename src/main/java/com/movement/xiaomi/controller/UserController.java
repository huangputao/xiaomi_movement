package com.movement.xiaomi.controller;

import com.movement.xiaomi.Http;
import com.movement.xiaomi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "控制类")
public class UserController {
    @Resource
    UserService userService;

    @ApiOperation(value = "添加", notes = "")
    @PostMapping("/addUser")
    public String addUser(String username,String password){
        if (username!=null & password!=null){
            String num = userService.addUser(username, password);
            if (num.equals("已存在")){
                return "falses";
            }else if (num.equals("失败")){
                return "false";
            }
        }

        return "true";
    }


    @ApiOperation(value = "删除", notes = "")
    @PostMapping("/removeUser")
    public String removeUser(String username){
        if (username!=null){
            userService.removeUser(username);
        }
        return "true";
    }

    @ApiOperation(value = "查询", notes = "")
    @GetMapping("/getUserList")
    public String getUserList(){

        return userService.getUserList().toString();
    }
}