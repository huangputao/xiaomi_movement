package com.movement.xiaomi.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.movement.xiaomi.Http;
import com.movement.xiaomi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    Http http;

    @Override
    public String addUser(String username, String pwd) {
        if (username != null & pwd != null) {
            //验证是否存在;
            String name = Http.map.get(username);
            if (name != null) {
                return "已存在";
            }

            if (username.length() < 9) {
                return "失败";
            }


            Http.map.put(username, pwd);
            String success = http.addHandler(username, pwd);
            JSONObject jsonObject = JSONObject.parseObject(success);
            int code = jsonObject.getInteger("code");
            String message = jsonObject.getString("message");
            if (code == 1 & message.equals("success")) {
                return success;
            } else {
                return "失败:" + success;
            }

        }

        return "失败";
    }

    @Override
    public String removeUser(String username) {
        if (username!=null){
            Http.map.remove(username);
        }
        return "true";
    }

    @Override
    public Map<String, String> getUserList() {

        return Http.map;
    }
}
