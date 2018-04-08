package com.yingchuang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yingchuang.command.AutoCode;
import com.yingchuang.dao.Test2Mapper;
import com.yingchuang.entity.Test2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/3.
 */
@Service
public class Test2ServiceImpl implements Test2Service {
    @Resource
    private Test2Mapper test2Mapper;



    @Override
    public int addTest2(Test2 test2) {
        AutoCode autoCode=new AutoCode();
        String testCode=autoCode.autoTest2Code(test2);
        test2.setQuestionCode(testCode);
        return test2Mapper.addTest2(test2);
    }

    @Override
    public int updateStatus(Test2 test2) {
        return test2Mapper.updateStatus(test2);
    }

    @Override
    public int updatePower(Test2 test2) {
        return test2Mapper.updatePower(test2);
    }

    @Override
    public PageInfo<Test2> queryTest2ByStatus(Integer pageNum, Integer pageSize, Test2 test2) {
        PageHelper.startPage(pageNum,pageSize);
        List<Test2> list=test2Mapper.queryTest2ByStatus(test2);
        return new PageInfo<>(list);
    }

    @Override
    public Test2 queryTest2ById(int id) {
        return test2Mapper.queryTest2ById(id);
    }

    @Override

    public PageInfo<Test2> queryAllTest2(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Test2> list = test2Mapper.queryAllTest2();
        return new PageInfo<Test2>(list);
    }
    public List<Test2> queryTest2ByPower(Integer power, Integer id) {
        return test2Mapper.queryTest2ByPower(power,id);

    }
}
