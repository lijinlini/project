package com.lijinlin.project.learn.interview.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.*;

public class Draw {
    public static class Prize {
        //奖品唯一标示
        private Integer prizeId;
        //中奖概率
        private BigDecimal probability;
        //奖品数量
        private Integer quantity;

        public Integer getPrizeId() {
            return prizeId;
        }

        public void setPrizeId(Integer prizeId) {
            this.prizeId = prizeId;
        }

        public BigDecimal getProbability() {
            return probability;
        }

        public void setProbability(BigDecimal probability) {
            this.probability = probability;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
    // 放大倍数
    private static final int mulriple = 1000000;
    //抽奖
    public static int pay(List<Prize> prizes) {
        int lastScope = 0;
        // 洗牌，打乱奖品次序
        Collections.shuffle(prizes);
        Map prizeScopes = new HashMap();
        Map prizeQuantity = new HashMap();
        for (Prize prize : prizes) {
            int prizeId = prize.getPrizeId();
            // 划分区间
            int currentScope = lastScope + prize.getProbability().multiply(new BigDecimal(mulriple)).intValue();
            prizeScopes.put(prizeId, new int[]{lastScope + 1, currentScope});
            prizeQuantity.put(prizeId, prize.getQuantity());
            lastScope = currentScope;
        }
        // 获取1-1000000之间的一个随机数
        int luckyNumber = new Random().nextInt(mulriple);
        int luckyPrizeId = 0;
        // 查找随机数所在的区间
        if ((null != prizeScopes) && !prizeScopes.isEmpty()) {
            Set set = prizeScopes.entrySet();
            for (Object o : set) {
                Map.Entry m = (Map.Entry) o;
                int key = (int) m.getKey();
                Object value = m.getValue();
                Integer[] val = JSONObject.parseObject(JSONObject.toJSONString(value), Integer[].class);
                if (luckyNumber >= val[0] && luckyNumber <= val[1] && Integer.parseInt(prizeQuantity.get(key) + "") > 0) {
                    luckyPrizeId = key;
                    break;
                }
            }
        }
//        if (luckyPrizeId > 0) {
//            // 奖品库存减一
//        }
        return luckyPrizeId;
    }
    public static void main(String[] args) {
        List<Prize> prizes = new ArrayList();
        Prize prize1 = new Prize();
        prize1.setPrizeId(10000);
        prize1.setProbability(new BigDecimal(0.01));
        prize1.setQuantity(1);
        prizes.add(prize1);

        Prize prize2 = new Prize();
        prize2.setPrizeId(10001);
        prize2.setProbability(new BigDecimal(0.19));
        prize2.setQuantity(10);
        prizes.add(prize2);

        Prize prize3 = new Prize();
        prize3.setPrizeId(10);
        prize3.setProbability(new BigDecimal(0.8));
        prize3.setQuantity(1);
        prizes.add(prize3);

        int times = 1000;
        int prize1GetTimes = 0;
        int prize2GetTimes = 0;
        int prize3GetTimes = 0;

        for (int i = 0; i < times; i++) {
            int pay = pay(prizes);
            System.out.println("抽奖到了"+pay);
            switch (pay) {
                case 10000:
                    prize1GetTimes++;
                    break;
                case 10001:
                    prize2GetTimes++;
                    break;
                case 10:
                    prize3GetTimes++;
                    break;
            }
        }
        System.out.println("抽奖次数" + times);
        System.out.println("prize1中奖次数" + prize1GetTimes);
        System.out.println("prize2中奖次数" + prize2GetTimes);
        System.out.println("prize3中奖次数" + prize3GetTimes);

    }
}
