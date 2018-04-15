package com.example.dao;

/**
 * Created by tom on 2018/3/30.
 */


import com.example.enums.UserSexEnum;
import com.example.vo.UserEntity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void testInsert() throws Exception {
        userDao.deleteAllData();
        userDao.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
        userDao.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
        userDao.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userDao.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = userDao.getAll();
        if (users == null || users.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(users.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        UserEntity user = userDao.getOne(1l);
        System.out.println(user.toString());
        user.setNickName("neo");
        userDao.update(user);
        Assert.assertTrue(("neo".equals(userDao.getOne(1l).getNickName())));
    }

}