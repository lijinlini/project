package com.lijinlin.project.learn.redis;

import redis.clients.jedis.Jedis;

public class Hyperloglog {

    private static final Jedis jedis = new Jedis();

    public static void main(String[] args) {
        String uv = "pv";
        for (int i=0; i < 10; i++){
            jedis.pfadd("pv","zk"+i);
        }
        long abinCount = jedis.pfcount("pv");
        String merge = jedis.pfmerge("new","pv","abin");
        System.out.println(jedis.pfcount("new"));
        jedis.expire("new",1);
        // 需求 在epg中展示模板数据看哪个模板uv访问量比较大，辅助业务调整模板顺序


        //key:产品+统计类型uv+clientId
        //业务想要统计某些作品1天内的uv独立访问用户数在epg的素材页面展示，来方便调整展示顺序
        //1查看详情接口中根据产品+统计类型+clientId执行pfadd
        //2
    }
}
