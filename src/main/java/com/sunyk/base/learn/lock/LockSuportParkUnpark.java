package com.sunyk.base.learn.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSuportParkUnpark {
    public static void main(String[] args) {

    }
    //测试阻塞和唤醒
    static void method1(){
        Thread a = new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "------come in ");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "---state----" + Thread.currentThread().getState());
        },"a");
        a.start();
        Thread b = new Thread(() ->{
            System.out.println(a.getName() + "---state----" + a.getState());
            LockSupport.unpark(a);
            System.out.println("=========通知==========");
        },"b");
        b.start();
    }
    //证明多次发放证书无效，证书最大值为1
    static void method2(){
        Thread a = new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "------come in ");
            LockSupport.park();
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "---state----" + Thread.currentThread().getState());
        },"a");
        a.start();
        Thread b = new Thread(() ->{
            System.out.println(a.getName() + "---state----" + a.getState());
            LockSupport.unpark(a);
            LockSupport.unpark(a);
            System.out.println("=========通知==========");
        },"b");
        b.start();
    }



}
