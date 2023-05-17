package com.lijinlin.project.learn.redis;

import redis.clients.jedis.Jedis;

public class Hyperloglog {

    private static final Jedis jedis = new Jedis();

    public static void main(String[] args) {
        String uv = "uv";
        for (int i=0; i < 10; i++){
            jedis.pfadd(uv,"zk"+i);
        }
        long abinCount = jedis.pfcount(uv);
        String merge = jedis.pfmerge("new",uv,"abin");
        System.out.println(jedis.pfcount("new"));
        jedis.expire("new",1);
        // 需求 在epg中展示模板数据看哪个模板uv访问量比较大，辅助业务调整模板顺序


        //key:产品+统计类型uv+templateId
        //业务想要统计某些作品1天内的uv独立访问用户数在epg的素材页面展示，来方便调整展示顺序
        //1查看详情接口中根据产品+统计类型+templateId执行jedis.pfadd,此时累计1次uv
        //2后台epg列表查询时从redis中根据key获取模板的数量
    }
}
