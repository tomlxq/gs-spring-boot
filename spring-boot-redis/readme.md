#redis安装与配置
1. redis概述

    redis是一个开源的，先进的 key-value 存储可用于构建高性能的存储解决方案。它支持数据结构有字符串，哈希，列表，集合，带有范围查询的排序集，位图，超文本和具有半径查询的地理空间索引。 NoSQL，Not Only [SQL]，泛指非关系型的数据库。所以redis是一种nosql。敲黑板画重点：redis是一种nosql.
    
    redis的优点：
    
    * 异常快速
    * 支持丰富的数据类型
    * 操作都是原子的

2. 在java应用中使用redis—jedis

    前提是redis 已经安装，并且已经开启服务。
    
    jedis 下载地址 https://github.com/xetorthio/jedis
    
    ````
     @Test
        public void testJds(){
            Jedis jedis = new Jedis("localhost");
            System.out.println("Connection to server sucessfully");
            //check whether server is running or not
            System.out.println("Server is running: "+jedis.ping());
            jedis.lpush("tom-list", "Redis");
            jedis.lpush("tom-list", "Mongodb");
            jedis.lpush("tom-list", "Mysql");
            // Get the stored data and print it
            List<String> list = jedis.lrange("tom-list", 0 ,5);
            for(int i=0; i<list.size(); i++) {
                System.out.println("Stored string in redis:: "+list.get(i));
            }
        }
    ````
3. 文件介绍

    |文件名	|简要|
    |----|-----|
    |redis-benchmark.exe	|基准测试  redis-benchmark为redis性能测试工具|
    |redis-check-aof.exe	|aof         AOF是AppendOnly File的缩写，是Redis系统提供了一种记录Redis操作的持久化方案|
    |redischeck-dump.exe	|dump      redis的备份和还原，借助了第三方的工具，redis-dump|
    |redis-cli.exe	|客户端|
    |redis-server.exe	|服务器|
    |redis.windows.conf	|配置文件|

4. redis.windows.conf文件中设置redis密码

    ````
    requirepass Redis123
    ````

5. 点击redis-server.exe  启动redis服务器端
6. 将redis注册为系统服务
    cmd进入dos窗口
    首先cd进入到redis目录下，然后注册为系统服务
    命令行：
    ````
    redis-server.exe --service-install redis.windows.conf --loglevel verbose
    redis-server --service-start
    ````
    卸载服务, 可以保存为 uninstall-service.bat 文件
    ````
    redis-server --service-stop
    redis-server --service-uninstall
    ````
    常用的redis服务命令。
    
    卸载服务：redis-server --service-uninstall
    
    开启服务：redis-server --service-start

    停止服务：redis-server --service-stop
7. redis-cli.exe 客户端使用  
   点击redis-cli.exe
   测试服务器启动连接情况
   `127.0.0.1:6379> ping`
   
    查看服务器级别信息（测试服务器）
    `127.0.0.1:6379> info`
8. redis-benchmark 性能测试工具
    默认双击打开是按照默认的测试参数进行测试，而且它自己测试跑完之后，就会自动关闭DOS窗口了。
    
    `redis-benchmark.exe -c 10 -n 100`
    输入如下命令后会看到如下信息，表明同时并发10个连接，总共100次操作。通俗易懂的说就是10个用户同时操作，总共每人操作10次的意思
    ```` 
    requests completed in 0.01 seconds （100个请求完成于0.01秒）
    parallel clients （10个客户端并发）
    bytes payload （每次写入3个字节）
    
    keep alive: 1 （保存一个链接数）
    
    100.00% <= 1 milliseconds （100%的操作小于1秒完成）
    
    16666.67 requests per second （每秒完成16666.67次查询）
    ```` 
    命令参数说明
    ````
    redis-benchmark [-h <host>] [-p <port>] [-c <clients>] [-n <requests]> [-k <boolean>]
    
    -h <hostname> 主机名 (默认 127.0.0.1)
    
    -p <port> 主机端口 (默认 6379)
    
    -s <socket> 主机套接字 (覆盖主机和端口)
    
    -c <clients> 并发连接的数量 (默认 50)
    
    -n <requests> 请求总数 (默认 10000)
    
    -d <size> SET/GET数据的字节大小(默认 2)
    
    -k <boolean> 1=keep alive 0=reconnect (默认 1)
    
    -r <keyspacelen> SET/GET/INCR使用随机产生的key, SADD使用随机值使用这个选项 get/set keys时会用mykey_rand:000000012456代替常量key， <keyspacelen>参数决定了随机数产生的最大值，比如，设置参数为10，那么产生的随机数范围是rand:000000000000 -rand:000000000009
    
    -P <numreq> Pipeline请求的数量. 默认 1 (不使用pipeline).
    
    -q 展示query/sec值
    
    --csv 以CSV格式输出
    
    -l 本地循环. 一直运行测试
    
    -t <tests> 在运行逗号分割列表的测试. 测试的名字与产生输出的名字一样。
    
    -I 空闲模式. 打开 N 个空闲连接，然后等待.  
    ````  
    运行示例
    ````  
    对指定服务器、端口进行20个同时并发操作，总共操作100000次
    
    redis-benchmark -h 192.168.1.136 -p 6379 -n 100000 -c 20
    
    测试set写入操作1000000次，随机数范围在100000000
    
    redis-benchmark -t set -n 1000000 -r 100000000
    
    测试ping、set、get操作100000次，结果输出用csv格式
    
    redis-benchmark -t ping,set,get -n 100000 –-csv
    
    redis-benchmark -r 10000 -n 10000 lpush mylist ele:rand:000000000000
    ````  
9. redis-check-aof 基本用法
 
    检查本地日志信息，加--fix参数为修复log文件
    
    `redis-check-aof.exe log.aof`
 
10. redis-check-dump 检查数据库文件
 
    `redis-check-dump.exe dump.rdb 会输出该文件大小、使用情况。`
11. Redis可视化工具 Redis Desktop Manager

    官网下载：https://redisdesktop.com/download
    
    github地址：https://github.com/uglide/RedisDesktopManager/releases
    
    安装Redis Desktop Manager
    
    redis-desktop-manager-0.8.8.384.exe   傻瓜式安装，点击下一步就行
  
  
#issues
1. 解决问题redis问题：ERR Client sent AUTH, but no password is set是的，这又是一个坑爹的问题。

    明明在redis.conf中设置了密码，而且redis还启动了，为什么说没有密码呢？
    
    大家都知道linux下启动redis有很多种方法，
    
    其中有 ./redis-server &  
    
    这种方法启动，不会带上你的redis.conf配置文件启动
    
    还有 ./redis-server ../redis.conf
    
    这种方法启动的时候，会去带上配置文件redis.conf
    
    上面的问题 ERR Client sent AUTH, but no password is set 。我遇到过一次，原因是我大意了，我用了第一种方式启动，
    
    这个时候redis是没有密码的，但是我的redis配置文件中配置了密码，所以当我在set值的时候就报这个错误了。
    
    所以如果你配置了redis.conf这个文件，那么启动redis的时候也一定要带上这个文件启动。我以后一定要细心，大家也一定要细心，共勉。     
#参考资料

[messaging-redis](https://spring.io/guides/gs/messaging-redis/)