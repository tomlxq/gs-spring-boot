package com.example.service;

import com.example.dao.IAccountDao;
import com.example.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private IAccountDao accountDao;

    public int add(String name, double money) {
        return accountDao.add(name, money);
    }
    public int update(String name, double money, int id) {
        return accountDao.update(name, money, id);
    }
    public int delete(int id) {
        return accountDao.delete(id);
    }
    public Account findAccount(int id) {
        return accountDao.findAccount(id);
    }
    public List<Account> findAccountList() {
        return accountDao.findAccountList();
    }
}
