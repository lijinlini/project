package com.lijinlin.project.dao;

import com.lijinlin.project.pojo.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SkuDao {
    public Sku getSkuListByParam(Sku sku);
}
