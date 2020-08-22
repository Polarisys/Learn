package com.web;

/**
 * @anthor Tolaris
 * @date 2020/4/3 - 14:58
 */

public class TestThread1 extends Thread {
    @Override
    public void run() {
       //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码"+i);
        }
    }

    public static void main(String[] args) {

        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();

        //调用start()方法开启线程
        testThread1.start();

        //main线程，主线程
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程"+i);
        }
    }
}
