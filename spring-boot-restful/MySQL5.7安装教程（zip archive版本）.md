1.  从官网下载zip archive版本http://dev.mysql.com/downloads/mysql/
2. 解压缩至相应目录，并配置环境变量（将*\bin添加进path中）；
3. （重要）在根目录新建my.ini文件，写入以下内容：
````
[mysql]  
# 设置mysql客户端默认字符集  
default-character-set=utf8  
[mysqld]  
# 设置3306端口  
port = 3306   
# 设置mysql的安装目录  
basedir=D:\Database\MySQL Server 5.7  
# 设置mysql数据库的数据的存放目录  
datadir=D:\Database\MySQL Server 5.7\data  
# 允许最大连接数  
max_connections=200  
# 服务端使用的字符集默认为8比特编码的latin1字符集  
character-set-server=utf8  
# 创建新表时将使用的默认存储引擎  
default-storage-engine=INNODB   
# 跳过密码验证  
#skip-grant-tables  
````
4. 运行cmd（切记要用管理员身份）；
5. （重要）执行命令mysqld --initialize

## 该步骤非常重要，因为之前的版本直接执行install命令便可安装服务，5.7之后需要初始化生成数据库文件（根目录下的data文件），否则后续无法启动服务；

6. 执行命令mysqld install，安装服务；
7. 执行命令net start mysql，启动服务；（停止服务net stop mysql）
8. 执行命令mysql -uroot -p，会报错ERROR 1045(28000)，需要设置登录密码；
9. 打开配置文件my.ini，将skip-grant-tables前面的#去掉，然后重启服务，再次登录就可略过密码；
10. 进入mysql数据库，依次执行以下命令：

use mysql;

update user set authentication_string=password("root") where user="root";

flush privileges;

quit;

11. 打开配置文件my.ini，在skip-grant-tables前面加上#注释掉，然后重启服务，使用设置的密码再次登录；

12. 输入命令show databases，报错ERROR 1820 (HY000)；

13. 修改一次密码set password=password("root");

14. 至此安装完成；


#其它用法：
1. 设置密码的方法：mysqladmin -u root -p password 密码
2. 环境变量设置
右键我的电脑->属性->高级系统设置->环境变量->path->编辑，将你的mysql软件下的bin目录的全路径放里面。
我建议童鞋们放在最前面，最后在那个目录的路径后面加个英文的分号（;）保存就行了。
如F:\server\mysql-5.7.21-winx64\bin;

3. 常用命令
````
cmd->mysql -uroot -p ->回车输入密码
->show databases；查找数据库
->use 数据库名；切换数据库目录
->show tables;查找表
->sql查询工作select * from 表名
->exit退出。
````
4. 给你们推荐几个图形化的管理工具：
    1. phpMyAdmin
    2. MySQLDumper
    3. Navicat
    4. MySQL GUI Tools
    5. MySQL ODBC Connector


end.