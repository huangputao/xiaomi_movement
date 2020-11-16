package com.movement.xiaomi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.movement.xiaomi.Http;
import com.movement.xiaomi.entity.User;
import com.movement.xiaomi.mapper.UserDao;
import com.movement.xiaomi.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChaosBear
 * @since 2020-11-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    Http http;

    @Override
    public Boolean addUser(String username, String pwd) throws UnsupportedEncodingException {
        if (username != null & pwd != null) {
            User user = new User();
            //使用base64加密密码存入数据库
            String base64 = Base64.getEncoder().encodeToString(pwd.getBytes("UTF-8"));
            user.setPassword(base64);
            user.setUsername(username);
            if (save(user)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean addUserAction(String username, String pwd) {
        if (username != null & pwd != null) {
            String num = http.addHandler(username, pwd);
            JSONObject object = JSONObject.parseObject(num);
            Integer code =  object.getInteger("code");
            if (code==1){
                User user = new User();
                user.setPassword(pwd);
                user.setUsername(username);
                save(user);
                return true;
            }
        }
        return false;
    }


    @Override
    public Boolean removeUser(String username) {
        if (username!=null){
            remove(new QueryWrapper<User>().lambda().eq(User::getUsername,username));
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUserList() {
        return list();
    }

    @Override
    public Boolean getUserByUsername(String username) {
        List<User> users =  list(new QueryWrapper<User>().lambda().eq(User::getUsername,username));
        if (users.size()>0){
            return true;
        }
        return false;
    }
}
