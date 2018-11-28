package com.dujian.controller;

import com.jfinal.core.JFinal;

public class StartController {
    public static void main(String[] args) {
        JFinal.start("src/main/webapp",8080,"/");
    }
}
