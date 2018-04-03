package com.yingchuang.service;

import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Test1;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/3.
 */
@Service
public interface Test1Service {
    //添加
    public int addTest1(Test1 test1);

    //根据ID修改状态
    public int updateStatus(Test1 test1);

    //根据ID修改等级
    public int updatePower(Test1 test1);

    //根据状态查询  //根据状态和等级查询
    public PageInfo<Test1> queryTest1ByStatus(Integer pageNum, Integer pageSize, Test1 test1);

    //根据ID查询
    public Test1 queryTest1ById(int id);




}
