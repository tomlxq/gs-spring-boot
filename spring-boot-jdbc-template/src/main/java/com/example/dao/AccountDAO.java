package com.example.dao;

import com.example.entity.Account;

import java.util.List;

public interface AccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}