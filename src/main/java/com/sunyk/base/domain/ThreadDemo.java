package com.sunyk.base.domain;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class ThreadDemo implements Runnable {
    Lock firstLock;
    Lock secondLock;
    public ThreadDemo(Lock firstLock, Lock secondLock){
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }
    @Override
    public void run() {
        try {
            firstLock.lockInterruptibly();
            TimeUnit.SECONDS.sleep(50);
            secondLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            firstLock.unlock();
            secondLock.unlock();
            System.out.println(Thread.currentThread().getName()+"获取到资源，正常结束");
        }


    }
}
