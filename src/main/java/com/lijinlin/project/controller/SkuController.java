package com.lijinlin.project.controller;

import com.lijinlin.project.pojo.Sku;
import com.lijinlin.project.service.SkuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("/sku")
public class SkuController {

    @Resource
    private SkuService skuService;
    @GetMapping("/getSkuDetail")
    public String getUserDetail(Integer id,String name,Integer num) {
        Sku sku = skuService.getSkuByParam(id,name,num);
        return sku.toString();
    }
}
