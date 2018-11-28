package com.dujian.controller;

import com.dujian.model.User;
import com.jfinal.core.Controller;

import java.util.List;

public class UserController extends Controller {

    public void index(){
        renderText("你好！");
    }

    public void userList(){
        Integer age = getParaToInt("age");
        List<User> users = new User().findUsersByAge(age);
        renderJson(users);
    }

    public void pushView(){
        Integer age = getParaToInt("age");
        List<User> users = new User().findUsersByAge(age);
        setAttr("users",users);
        renderFreeMarker("indexF.ftl");
    }
}
