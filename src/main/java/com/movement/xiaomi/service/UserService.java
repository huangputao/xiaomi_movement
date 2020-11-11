package com.movement.xiaomi.service;

import java.util.List;
import java.util.Map;

/**
 * @author 17839
 */
public interface UserService {
    /**
     * 添加用户进map
     * @param username
     * @param pwd
     */
   String addUser(String username,String pwd);

   String addUserOne(String username,String pwd);

   String removeUser(String username);

   Map<String,String> getUserList();
}
