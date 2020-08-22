package com.web;

import redis.clients.jedis.Jedis;

/**
 * @anthor Tolaris
 * @date 2020/4/11 - 1:33
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("123.57.9.242", 6379);
        System.out.println(jedis.ping());
    }

}
