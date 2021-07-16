package com.sunyk.base.service.ipml;

import com.sunyk.base.service.UserManager;

public class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String userName, String password) {
        System.out.println("添加用户方法");
        System.out.println(String.format("添加的用户名%s，密码%s；",userName,password));

    }

    @Override
    public void delUser(String userName) {
        System.out.println("删除用户方法");
        System.out.println(String.format("添加的用户名%s;" , userName));

    }
}
