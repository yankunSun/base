package com.sunyk.base.config;


import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class ShrioConfig {

    @Value("${spring.application.name}")
    public String config;

    public String getConfig(){
        return this.config;
    }
    @Bean
    public Realm realm() {
        //创建SimpleAccountRealm对象
        SimpleAccountRealm realm = new SimpleAccountRealm();
         //添加两个用户。参数分别是username、password、roles。
        realm.addAccount("admin", "123456", "admin");
        realm.addAccount("fox", "123456", "user");
        return realm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        //创建DefaultWebSecurityManager对象
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置其使用的Realm
        securityManager.setRealm(this.realm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        System.out.println(config);
        //创建ShiroFilterFactoryBean对象，用于创建ShiroFilter过滤器
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        //设置SecurityManager
        filterFactoryBean.setSecurityManager(this.securityManager());
        //设置URL
        filterFactoryBean.setLoginUrl("/login");//登录URL
        filterFactoryBean.setSuccessUrl("/come/come");//登录成功URL
        filterFactoryBean.setUnauthorizedUrl("/come/come");//无权限URL
        //设置URL的权限配置ConfigurationClassPostProcessor
        filterFactoryBean.setFilterChainDefinitionMap(this.filterChainDefinitionMap());
        return filterFactoryBean;
    }

    private Map<String, String> filterChainDefinitionMap() {
        //注意要使用有序的LinkedHashMap，顺序匹配
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/**", "anon");//允许匿名访问
        filterMap.put("/test/admin", "roles[admin]");//需要admin角色
        filterMap.put("/test/normal", "roles[user]");//需要user角色
        filterMap.put("/logout", "logout");//退出
        filterMap.put("/authc/**", "authc");//默认剩余的URL，需要经过认证
        return filterMap;
    }
    //加上该bean会导致配置类初始化提前至拦截bean注册的时候，此时其他的bean只有bean定义而没有
    @Bean(name="lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }


}
