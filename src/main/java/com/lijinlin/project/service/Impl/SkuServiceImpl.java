package com.lijinlin.project.service.Impl;

import com.lijinlin.project.dao.SkuDao;
import com.lijinlin.project.pojo.Sku;
import com.lijinlin.project.service.SkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class SkuServiceImpl implements SkuService {
    @Resource
    private SkuDao skuDao;

    @Override
    public Sku getSkuByParam(Integer id, String name,Integer skuNum) {
        Sku sku = new Sku();
        sku.setId(id);
        sku.setSkuName(name);
        sku.setSkuNum(skuNum);
        sku = skuDao.getSkuListByParam(sku);
        return sku;
    }
}
