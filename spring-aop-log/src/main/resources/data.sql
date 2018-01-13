DELETE FROM admin;
INSERT INTO admin (id, nickname, passwd, phoneno) VALUES
  (1, 'tomluo', '123',  '13590785499'),
  (2, 'LiTao', '123',  '13590785499'),
  (3, 'Polly', '123',  '13590785499'),
  (4, 'HanMeiMei', '123', '13590785499'),
  (5, 'Mr Wang', '123', '13590785499');

DELETE FROM log;
INSERT INTO log (userid, createdate, content,operation) VALUES
  (1, '2016-05-19', '发票序号0002233','增加'),
  (1, '2016-05-19', '发票序号0002233','更新'),
  (1, '2016-05-19', '发票序号0002233','删除'),
  (2, '2016-05-19',  '发票序号0002234','增加'),
  (2, '2016-05-19', '发票序号0002234','更新');

DELETE FROM invoice;
INSERT INTO invoice (id, no, salary) VALUES
  (1, '0002234', 4500),
  (2, '0002235', 7800),
  (3, '0002236', 7900),
  (4, '0002237', 12200);

  insert into users(id, name, email) values(1,'Siva','siva@gmail.com');
insert into users(id, name, email) values(2,'Prasad','prasad@gmail.com');
insert into users(id, name, email) values(3,'Reddy','reddy@gmail.com');