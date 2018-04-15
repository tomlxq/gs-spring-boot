package com.example.service;

import com.example.entity.Account;

import java.util.List;

public interface AccountService {


    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();

}