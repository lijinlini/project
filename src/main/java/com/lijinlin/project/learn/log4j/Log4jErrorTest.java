package com.lijinlin.project.learn.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jErrorTest {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        // 注意这个变量
        String error = "${java:vm}";
        logger.error("==============危险打印，{}", error);
    }
}
