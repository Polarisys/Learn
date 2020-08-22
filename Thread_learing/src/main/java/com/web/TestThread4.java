package com.web;

/**
 * @anthor Tolaris
 * @date 2020/4/3 - 16:32
 */

//多个线程同时操作一个对象
public class TestThread4 implements Runnable {

    private int ticketNumbers = 20;

    public void run() {
        while (true){
            if(ticketNumbers<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了"+ticketNumbers--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4,"小明").start();
        new Thread(testThread4,"小张").start();
        new Thread(testThread4,"小王").start();
    }
}
