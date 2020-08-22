package com.state;

/**
 * @anthor Tolaris
 * @date 2020/4/3 - 21:48
 */
public class TestStop implements Runnable {

    //设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run thread" + i++);
        }
    }

    //设置一个公开的方法停止线程
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("main"+i);
            if(i==120){
                //调用stop方法切换标志位，让线程停止
                testStop.stop();
                System.out.println("线程已停止");
            }
        }
    }
}
