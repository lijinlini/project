package com.lijinlin.project.controller;

import com.lijinlin.project.pojo.Sku;
import com.lijinlin.project.pojo.T2;
import com.lijinlin.project.service.SkuService;
import com.lijinlin.project.service.T2Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Resource
    private SkuService skuService;

    @Resource
    private T2Service t2Service;
    @GetMapping("/getSkuDetail")
    public String getUserDetail(Integer id,String name,Integer num) {
        Sku sku = skuService.getSkuByParam(id,name,num);
        return sku.toString();
    }

    @GetMapping("/getT2All")
    public String getT2All() {
        t2Service.getAll();
        return "success";
    }
}
