package com.movement.xiaomi.service;

import com.movement.xiaomi.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChaosBear
 * @since 2020-11-11
 */
public interface UserService extends IService<User> {
    /**
     * 添加用户信息
     * @param username
     * @param pwd
     * @return
     */
    Boolean addUser(String username,String pwd);

    /**
     * 添加用户信息后立马调用刷步
     * @param username
     * @param pwd
     * @return
     */
    Boolean addUserAction(String username,String pwd);

    /**
     * 删除
     * @param username
     * @return
     */
    Boolean removeUser(String username);

    /**
     * 获得所有用户信息
     * @return
     */
    List<User> getUserList();

    /**
     * 验证用户信息是否存在
     * @param username
     * @return
     */
    Boolean getUserByUsername(String username);
}
