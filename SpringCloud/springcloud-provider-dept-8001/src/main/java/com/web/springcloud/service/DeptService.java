package com.web.springcloud.service;

import com.web.pojo.Dept;

import java.util.List;

/**
 * @anthor Tolaris
 * @date 2020/4/18 - 1:45
 */
public interface DeptService {


    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
