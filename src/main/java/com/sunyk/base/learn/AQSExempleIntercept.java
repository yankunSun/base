package com.sunyk.base.learn;


import com.sunyk.base.domain.ThreadDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//响应中断
public class AQSExempleIntercept {
    private static  Lock lock1 = new ReentrantLock();
    private static  Lock lock2 = new ReentrantLock();
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo(lock1,lock2),"线程A");
        Thread thread1 = new Thread(new ThreadDemo(lock1,lock2),"线程B");
        thread.start();
        thread1.start();
        thread.interrupt(); //使第一个线程中断

    }
}
