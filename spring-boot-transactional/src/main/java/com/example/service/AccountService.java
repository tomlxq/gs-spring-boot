package com.example.service;

import com.example.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    /**
     * @Transactional，声明事务，并设计一个转账方法，用户1减10块，用户2加10块。在用户1减10 ，之后，抛出异常，即用户2加10块钱不能执行，当加注解@Transactional之后，两个人的钱都没有增减。
     * 当不加@Transactional，用户1减了10，用户2没有增加，即没有操作用户2 的数据。可见@Transactional注解开启了事物。
     * @throws RuntimeException
     */
    @Transactional
    public void transfer() throws RuntimeException{
        accountDao.update(90,1);//用户1减10块 用户2加10块
        int i=1/0;
        accountDao.update(110,2);
    }

    public void transfer2() throws RuntimeException{
        accountDao.update(90,1);//用户1减10块 用户2加10块
        int i=1/0;
        accountDao.update(110,2);
    }
}