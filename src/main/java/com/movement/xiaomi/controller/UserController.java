package com.movement.xiaomi.controller;

import com.movement.xiaomi.Http;
import com.movement.xiaomi.service.UserService;
import com.movement.xiaomi.util.RobotUtil;
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

    @ApiOperation(value = "添加,立马执行一次刷步数", notes = "")
    @PostMapping("/addUser")
    public String addUser(String username,String password){
        if (username!=null & password!=null){
            String num = userService.addUser(username, password);
            return num;
        }
        return "失败";
    }

    @ApiOperation(value = "单添加", notes = "")
    @PostMapping("/addUserOne")
    public String addUserOne(String username,String password){
        if (username!=null & password!=null){
            String num = userService.addUserOne(username, password);
            return num;
        }
        return "失败";
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


    @ApiOperation(value = "查询", notes = "")
    @GetMapping("/gettest")
    public String gettest(){
        RobotUtil.get("刷步成功!","内容");
        return userService.getUserList().toString();
    }
}
