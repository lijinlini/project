package com.lijinlin.project.service;

import com.lijinlin.project.pojo.Sku;
import org.springframework.stereotype.Service;


public interface SkuService {
    Sku getSkuByParam(Integer id, String skuName,Integer skuNum);
}
