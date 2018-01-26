package com.example.demo;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMicroserviceSimpleProviderUserApplicationTests {
	@Autowired
	private UserRepository repository;
	@Test
	public void contextLoads() {
	}


	@Test
	public void test(){
		User u = repository.findOne(1L);
		Assert.assertEquals("成功的测试用例", "张三", u.getName());
	}
}
