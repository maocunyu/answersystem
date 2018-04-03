package com.yingchuang.dao;

import com.yingchuang.entity.Test1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1MapperTest {
    @Resource
    private Test1Mapper test1Mapper;


    @Test
    public void addTest1() throws Exception {
        int a=test1Mapper.addTest1(new Test1(0,0,1,0,0,"question","aaa","bbb","ccc","dddd","code"));

    }

    @Test
    public void updateStatus() throws Exception {
        int a=test1Mapper.updateStatus(new Test1(1,0,1,0,0,"question","aaa","bbb","ccc","dddd","code"));
    }

    @Test
    public void updatePower() throws Exception {
        int a=test1Mapper.updatePower(new Test1(2,0,1,3,0,"question","aaa","bbb","ccc","dddd","code"));
    }

    @Test
    public void queryTest1ByStatus() throws Exception {
        List<Test1> list=test1Mapper.queryTest1ByStatus(new Test1(0,0,1,0,0,"question","aaa","bbb","ccc","dddd","code"));
        for (Test1 test1 : list) {
            System.out.println(test1);
        }
    }

    @Test
    public void queryTest1ById() throws Exception {
        Test1 test1=test1Mapper.queryTest1ById(1);
        System.out.println(test1);
    }

}