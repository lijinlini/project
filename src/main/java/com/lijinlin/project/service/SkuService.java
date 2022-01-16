package com.lijinlin.project.service;

import com.lijinlin.project.pojo.Sku;

public interface SkuService {
    Sku getSkuByParam(Integer id, String skuName,Integer skuNum);
}
