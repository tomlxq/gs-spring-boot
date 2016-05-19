package com.example;

import com.example.domain.Log;
import com.example.mappers.LogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

	/*@Test
	public void findAllUsers() {
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}*/

//	@Test
	//public void findUserById() {
	//	Log log = logMapper.findLogById(1l);
	//	assertNotNull(log);
	//}
	//private Long userid;//管理员id
	//private Date createdate;//日期
	//private String content;//日志内容
	//private String operation;//操作(主要是"添加"、"修改"、"删除")
	@Test
	public void createLog() {
		Log log = new Log(1l,new Date(),"发票序号为0002222","添加");
		logMapper.insertLog(log);
		logger.debug("{} ",log.getId());
		Log newLog = logMapper.findLogById(log.getId());
		assertEquals("发票序号为0002222", newLog.getContent());
		assertEquals("添加", newLog.getOperation());
	}

}
