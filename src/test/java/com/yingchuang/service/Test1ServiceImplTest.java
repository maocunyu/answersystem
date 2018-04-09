package com.yingchuang.service;

import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Test1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msi on 2018/4/5.

 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1ServiceImplTest {
    @Resource
    private Test1Service test1Service;

    @Test

    public void queryAllTest1() throws Exception {
        PageInfo<Test1> pageInfo = test1Service.queryAllTest1(1, 3);
        List<Test1> list = pageInfo.getList();
        if (list != null) {
            for (Test1 test1 : list) {
                System.out.println(test1);
            }
        }
    }
    public void addTest1() throws Exception {
        Test1 test1 = new Test1();
        test1.setQuestion("question");
        test1.setAnswerA("A");
        test1.setAnswerB("B");
        test1.setAnswerC("C");
        test1.setAnswerD("D");
        test1.setRightAnswer(0);
        System.out.println(test1Service.addTest1(test1));
    }

    @Test
    public void updateStatus() throws Exception {
    }

    @Test
    public void updatePower() throws Exception {
    }

    @Test
    public void queryTest1ByStatus() throws Exception {
    }

    @Test
    public void queryTest1ById() throws Exception {
    }

    @Test
    public void queryTest1ByPower() throws Exception {
        Test1 test1 = new Test1();
        test1.setStatus(1);
        test1.setPower(1);
        PageInfo<Test1> pageInfo = test1Service.queryTest1ByStatus(1, 10, test1);
        List<Test1> list = pageInfo.getList();
        List<Integer> listInt = new ArrayList<>();
        for (Test1 test11 : list) {
            System.out.println(test11);
            listInt.add(test11.getId());
        }
        for (int i =0;i<10;i++) {
            Test1 test = test1Service.queryTest1ById(listInt.get((int) (Math.random() * listInt.size())));
            System.out.println(test);

        }
    }

}