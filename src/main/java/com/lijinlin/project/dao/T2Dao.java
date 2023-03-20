package com.lijinlin.project.dao;

import com.lijinlin.project.pojo.T2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface T2Dao {
    public List<T2> getAll();
}
