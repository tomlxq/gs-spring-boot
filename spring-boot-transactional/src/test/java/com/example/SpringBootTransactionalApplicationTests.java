package com.example;

import com.example.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTransactionalApplicationTests {
	@Autowired
	AccountService accountService;
	@Test
	@Rollback(false)
	public void contextLoads() {
		accountService.transfer();
		accountService.transfer2();
	}

}
