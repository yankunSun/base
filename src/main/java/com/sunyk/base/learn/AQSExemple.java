package com.sunyk.base.learn;

import java.util.concurrent.locks.ReentrantLock;

public class AQSExemple {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        System.out.println("被锁资源");
        reentrantLock.unlock();
    }
}
