package com.dujian.controller;

import com.dujian.model.User;
import com.google.common.collect.Maps;
import com.jfinal.core.Controller;

import java.util.List;
import java.util.Map;

public class UserController extends Controller {

    public void index(){

        renderFreeMarker("system/login");
    }

    public void userList(){
        Integer age = getParaToInt("age");
        List<User> users = new User().findUsersByAge(age);
        renderJson(users);
    }

    public void login(){
        Map<String, Object> result = Maps.newHashMap();

        String username = getPara("username");
        System.out.println("username:"+username);
        String password = getPara("password");

        User user= new User().findUsersByUsername(username);

        if (user==null || !user.getPassword().equals(password)){
            result.put("status","error");
            renderJson(result);
            return;
        }

        result.put("status","OK");
        renderJson(result);

    }

    public void pushView(){
        Integer age = getParaToInt("age");
        List<User> users = new User().findUsersByAge(age);
        setAttr("users",users);
        renderFreeMarker("indexF.ftl");
    }
}
