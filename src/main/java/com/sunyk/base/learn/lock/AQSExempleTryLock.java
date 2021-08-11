package com.sunyk.base.learn.lock;


import com.sunyk.base.domain.ThreadDemo;
import com.sunyk.base.domain.ThreadDemoTryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//响应中断
public class AQSExempleTryLock {
    private static  Lock lock1 = new ReentrantLock();
    private static  Lock lock2 = new ReentrantLock();
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemoTryLock(lock1,lock2),"线程A");
        Thread thread1 = new Thread(new ThreadDemoTryLock(lock1,lock2),"线程B");
        thread.start();
        thread1.start();

    }
}
