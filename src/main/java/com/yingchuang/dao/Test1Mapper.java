package com.yingchuang.dao;

import com.yingchuang.entity.Test1;

import java.util.List;

/**
 * Created by Administrator on 2018/4/3.
 */
public interface Test1Mapper {
    //添加
    public int addTest1(Test1 test1);

    //根据ID修改状态
    public int updateStatus(Test1 test1);

    //根据ID修改等级
    public int updatePower(Test1 test1);

    //根据状态查询  //根据状态和等级查询
    public List<Test1> queryTest1ByStatus(Test1 test1);

    //根据ID查询
    public Test1 queryTest1ById(int id);


    //查询所有
    public List<Test1> queryAllTest1();



    //根据等级和Id查询
    List<Test1> queryTest1ByPower(Integer power,Integer id);



}
