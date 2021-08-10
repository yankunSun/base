package com.sunyk.base.domain;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
//限时等待.tryLock可以传入时间参数，表示等待时间，防止死锁；不传入时间参数，表示立即返回锁获取结果，true为获取锁成功，false为获取锁失败
public class ThreadDemoTryLock implements Runnable {
    Lock firstLock;
    Lock secondLock;
    public ThreadDemoTryLock(Lock firstLock, Lock secondLock){
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }
    @Override
    public void run() {
        try {
            if(!firstLock.tryLock()){TimeUnit.MICROSECONDS.sleep(10);}
            if(!secondLock.tryLock()){TimeUnit.MICROSECONDS.sleep(10);}
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            firstLock.unlock();
            secondLock.unlock();
            System.out.println(Thread.currentThread().getName()+"获取到资源，正常结束");
        }


    }
}
