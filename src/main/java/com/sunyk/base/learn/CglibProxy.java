package com.sunyk.base.learn;

import com.sunyk.base.service.UserManager;
import com.sunyk.base.service.ipml.UserManagerImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//Cglib动态代理需要实现 MethodInterceptor
public class CglibProxy implements MethodInterceptor {
// 需要代理的目标对象
    private Object targetObject;

//    重写拦截方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理，代理方法开始执行，监听开始!");
//       代理方法执行 参数： targetObject目标对象，objects 参数数组
        Object object = method.invoke(targetObject,objects);
        System.out.println("cglib动态代理，代理方法执行结结束，监听结束！");

        return object;
    }
//      获取代理对象
    public Object getCglibProxyObject(Object targetObject){
//      为目标对象赋值
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
//       设置代理对象的超类，Cglib代理基于继承实现的,是针对指定的类生成子类实现的，需要执行代理类的父类，
//      设置代理对象执行的回调类
        enhancer.setCallback(this);
        enhancer.setSuperclass(targetObject.getClass());
//      创建并返回代理对象
        return enhancer.create();
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy  = new CglibProxy();
        //获取代理对象
        UserManager userManager = (UserManager) cglibProxy.getCglibProxyObject(new UserManagerImpl());
        userManager.delUser("admin");
    }
}
