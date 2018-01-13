package com.example;

import com.example.domain.Invoice;
import com.example.domain.Log;
import com.example.domain.User;
import com.example.mappers.LogMapper;
import com.example.mappers.UserMapper;
import com.example.service.InvoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringAopLogApplication.class)
@WebAppConfiguration
public class SpringAopLogApplicationTests {
Logger logger= LoggerFactory.getLogger(SpringAopLogApplicationTests.class);
	@Test
	public void contextLoads() {
	}
	@Autowired
	private LogMapper logMapper;

	@Autowired
	private InvoiceService invoiceService;
	@Autowired private UserMapper userMapper;
	//@Autowired private UserAnnotationMapper userMapper;

	@Test
	public void findAllUsers()  {
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());

	}

	@Test
	public void findUserById()  {
		User user = userMapper.findUserById(1);
		assertNotNull(user);
	}

	@Test
	public void createUser() {
		User user = new User(0, "Siva", "siva@gmail.com");
		userMapper.insertUser(user);
		User newUser = userMapper.findUserById(user.getId());
		assertEquals("Siva", newUser.getName());
		assertEquals("siva@gmail.com", newUser.getEmail());
	}
	@Test
	public void createLog() {
		Log log = new Log(1l,new Date(),"发票序号为0002222","添加");
		logMapper.insertLog(log);
		logger.debug("{} ",log.getId());
		Log newLog = logMapper.findLogById(log.getId());
		assertEquals("发票序号为0002222", newLog.getContent());
		assertEquals("添加", newLog.getOperation());
	}
	@Test
	public void invoiceService() {

		Invoice invoice=new Invoice("006655",new Date(),7500f);
		invoiceService.insertInvoice(invoice);
		//Log newLog = logMapper.findLogById(log.getId());
		//assertEquals("发票序号为0002222", newLog.getContent());
		//assertEquals("添加", newLog.getOperation());
	}


}
