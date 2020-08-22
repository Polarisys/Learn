package com.lambda;

/**
 * @anthor Tolaris
 * @date 2020/4/3 - 21:18
 */
public class TestLambda1 {

    public static void main(String[] args) {

        ILove iLove = (int a) -> {
            System.out.println("i love you" + a);
        };

        iLove.love(520);
    }
}

interface ILove {
    void love(int a);
}
