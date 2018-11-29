package com.dujian.controller;

import com.dujian.model.User;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.FreeMarkerRender;
import com.jfinal.template.Engine;

import java.util.Properties;

public class Config extends JFinalConfig {



    @Override
    public void configConstant(Constants constants) {
        PropKit.use("config.properties");
        constants.setDevMode(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.setBaseViewPath("views");
        routes.add("/",HelloController.class);
        routes.add("/hello",HelloController.class);
        routes.add("/user",UserController.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins me) {
        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
        me.add(c3p0Plugin);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        me.add(arp);
        arp.setShowSql(true);
        arp.addMapping("user",User.class);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {
        //添加后在页面可以使用${ctx}的方式引用项目路径
        handlers.add(new ContextPathHandler("ctx"));
    }



    @Override
    public void afterJFinalStart() {
        Properties p = loadPropertyFile("freemarker.properties");
        //由于我们用到freemarker，所以在此进行freemarker配置文件的装载
        FreeMarkerRender.setProperties(p);
    }
}
