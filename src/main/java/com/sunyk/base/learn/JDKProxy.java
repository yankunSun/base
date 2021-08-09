package com.sunyk.base.learn;

import com.sunyk.base.service.UserManager;
import com.sunyk.base.service.ipml.UserManagerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//jdk动态代理实现逻辑，需要实现InvocationHandler。目标类如果实现了接口，采用jdk动态代理，也可以采用cglib代理，代理的目标对象是实现了接口的实现类targetObject；
public class JDKProxy implements InvocationHandler {

    private Object targetObject;//需要代理的目标对象

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理，代理方法执行开始，监听开始；");
        Object object = method.invoke(targetObject,args);
        System.out.println("jdk动态代理，代理方法执行结束，监听结束；");
        return object;
    }
//定义获取代理对象的方法
    public Object getProxyTargetObject(Object targetObject){
        //为目标对象赋值
        this.targetObject = targetObject;
//        jdk动态代理只能对实现了接口的类进行代理，传参可以看出，需要拿到目标对象的接口
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();

        //获取代理对象
        UserManager userManager = (UserManager) jdkProxy.getProxyTargetObject(new UserManagerImpl());
//        执行代理对象方法
        userManager.addUser("admin","admin");
    }




}
