package com.example.dao;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao  extends JpaRepository<Account,Integer> {
}

