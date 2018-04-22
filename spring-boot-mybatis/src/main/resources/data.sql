

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;


-- create table `account`
DROP TABLE IF EXISTS  `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `account` VALUES ('1', 'aaa', '1000');
INSERT INTO `account` VALUES ('2', 'bbb', '1000');
INSERT INTO `account` VALUES ('3', 'ccc', '1000');

DROP TABLE IF EXISTS  `student_t`;
CREATE TABLE student_t
(
  stuno INT PRIMARY KEY,
  stuname VARCHAR(20),
  stuage INT,
  stuaddress VARCHAR(20) ,
  classid INT
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS  `class_t`;
CREATE TABLE class_t
(
  classid INT PRIMARY KEY,
  classname VARCHAR(20)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into student_t values (1,'tom',18,'广东深圳',1);
insert into student_t values (2,'jack',18,'广东深圳',1);
insert into student_t values (3,'rose',18,'广东深圳',1);

insert into class_t values (1,'政治');
insert into class_t values (2,'音乐');
insert into class_t values (3,'绘画');
insert into class_t values (4,'历名');
insert into class_t values (5,'语文');