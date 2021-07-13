package com.sunyk.base.learn;

public class ThreadRunAndStart {
    public static void main(String[] args) {
       Thread thread =  new Thread(() ->{
           test();
       });
       thread.run();
       thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(":test");
    }

    static void test(){
        System.out.println("test");
    }
}
