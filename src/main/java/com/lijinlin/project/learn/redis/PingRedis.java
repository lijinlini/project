package com.lijinlin.project.learn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class PingRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        SetParams params = new SetParams();
        params.px(1000);
        params.nx();
        System.out.println(jedis.zrange("user:3",0,3));
    }
}
