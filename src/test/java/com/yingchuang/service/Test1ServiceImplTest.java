package com.yingchuang.service;

import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Test1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Max on 4-8-2018-008.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1ServiceImplTest {

    @Resource
    private Test1Service test1Service;

    @Test
    public void queryAllTest1() throws Exception {
        PageInfo<Test1> pageInfo=test1Service.queryAllTest1(1,3);
        List<Test1> list=pageInfo.getList();
        if (list!=null) {
            for (Test1 test1 : list) {
                System.out.println(test1);
            }
        }
    }

}