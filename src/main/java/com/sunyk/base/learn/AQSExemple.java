package com.sunyk.base.learn;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//锁的基本使用
public class AQSExemple {
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(() -> test(),"线程A").start();
        new Thread(() -> test(), "线程B").start();

    }

    public static void test(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获取了锁");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }
}
