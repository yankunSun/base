package com.sunyk.base.learn;

import com.sunyk.base.domain.MyTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
//线程池的基本使用。线程池的基本原理是为线程提供一个容器，并对峰值任务进行列队操作，为线程的执行提供统一的执行入口，并进行线程生命周期管理。
//能够任务的依旧是线程
public class DoubleThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = getThreadPool("fix");
        for (int i = 0; i < 15 ; i++) {
            MyTask myTask = new MyTask(i);
            executorService.execute(myTask);
            System.out.println("线程池中线程数目："+executorService.getPoolSize()+"，队列中等待执行的任务数目："+
                    executorService.getQueue().size()+"，已执行玩别的任务数目："+executorService.getCompletedTaskCount());
        }
        executorService.shutdown();
    }

    public static ThreadPoolExecutor getThreadPool(String string){
        ThreadPoolExecutor executorService = null;
        switch (string){
            case "fix": executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);

        }
        return executorService;
    }
}

