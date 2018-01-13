
DROP DATABASE `spring-aop-log`;
CREATE DATABASE `spring-aop-log`;
USE `spring-aop-log`;

DROP TABLE IF EXISTS admin;
CREATE TABLE `admin` (
  `id`       BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(20)         NOT NULL DEFAULT ''
  COMMENT '管理员帐号',
  `passwd`   VARCHAR(20)         NOT NULL DEFAULT ''
  COMMENT '管理员密码',
  `phoneno`  VARCHAR(20)         NOT NULL DEFAULT ''
  COMMENT '联系电话',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
DROP TABLE IF EXISTS invoice;
CREATE TABLE `invoice` (
  `id`     BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `no`     VARCHAR(20)         NOT NULL DEFAULT ''
  COMMENT '发票序列号',
  `salary` INT(6)              NOT NULL DEFAULT 0
  COMMENT '工资',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS log;
CREATE TABLE `log` (
  `id`         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userid`     BIGINT(20) UNSIGNED NOT NULL,
  `createdate` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `content`    VARCHAR(8000)       NOT NULL DEFAULT ''
  COMMENT '日志内容',
  `operation`  VARCHAR(250)        NOT NULL DEFAULT ''
  COMMENT '用户所做的操作',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS USERS;

CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  email varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);



