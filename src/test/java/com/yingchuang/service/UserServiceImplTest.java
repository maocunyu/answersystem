package com.yingchuang.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by msi on 2018/4/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Test
    public void queryUserByUserNameAndPassword() throws Exception {
        System.out.println(userService.queryUserByUserNameAndPassword("user1", "1234"));
    }

    @Test
    public void addUser() throws Exception {

    }

    @Test
    public void updatePasswordByPhone() throws Exception {
    }

}