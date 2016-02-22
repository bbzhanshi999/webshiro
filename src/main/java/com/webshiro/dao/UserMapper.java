package com.webshiro.dao;

import com.webshiro.entity.Permission;
import com.webshiro.entity.Role;
import com.webshiro.entity.User;
import com.webshiro.tag.MybatisDao;

import java.util.List;

/**
 * Created by Administrator on 2016/2/11 0011.
 */
@MybatisDao
public interface UserMapper {

    User findUserByUsername(String userName);

    User findRolesByUserName(String userName);

    User findPermissionsByUserName(String userName);

    void insert(User user);


}
