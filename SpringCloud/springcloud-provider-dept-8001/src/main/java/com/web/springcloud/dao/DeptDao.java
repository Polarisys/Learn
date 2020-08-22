package com.web.springcloud.dao;

import com.web.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @anthor Tolaris
 * @date 2020/4/18 - 1:36
 */
@Mapper
@Repository
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
