package com.yingchuang.dao;

import com.yingchuang.entity.Test2;

import java.util.List;

/**
 * Created by Administrator on 2018/4/3.
 */
public interface Test2Mapper {
    //添加
    public int addTest2(Test2 test2);

    //根据ID修改状态
    public int updateStatus(Test2 test2);

    //根据ID修改等级
    public int updatePower(Test2 test2);

    //根据状态查询  //根据状态和等级查询
    public List<Test2> queryTest2ByStatus(Test2 test2);

    //根据ID查询
    public Test2 queryTest2ById(int id);


    //查询所有
    public List<Test2> queryAllTest2();


    //根据等级查询
    List<Test2> queryTest2ByPower(Integer power, Integer id);


}
