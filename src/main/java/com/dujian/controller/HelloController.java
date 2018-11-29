package com.dujian.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller {

    public void index(){
        renderFreeMarker("system/login.ftl");
    }
}
