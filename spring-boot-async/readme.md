介绍在springboot 使用异步方法，去请求github api.

#创建工程
在pom文件引入相关依赖

创建一个请求的　githib的service:
````
@Async
public Future<User> findUser(String user) throws InterruptedException {
    logger.info("Looking up " + user);
    String url = String.format("https://api.github.com/users/%s", user);
    User results = restTemplate.getForObject(url, User.class);
    Thread.sleep(1000L);
    return new AsyncResult<>(results);
}
````
RestTemplate去请求，另外加上类@Async 表明是一个异步任务。
#开启异步任务：
通过@EnableAsync开启异步任务；并且配置AsyncConfigurerSupport，比如最大的线程池为2.
````
@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final GitHubLookupService gitHubLookupService;

    public AppRunner(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        Future<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        Future<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        Future<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
            Thread.sleep(10); //10-millisecond pause between each check
        }

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
    }

}
````
通过maven 命令：

第一步：mvn clean

第二步： mvn package docker:bulid ,如下：
````
Step 2/6 : VOLUME /tmp 
—> Running in a98be3878053 
—> 8286e98b54c5 
Removing intermediate container a98be3878053 
Step 3/6 : ADD springboot-with-docker-0.0.1-SNAPSHOT.jar app.jar 
—> c6ce13e50bbd 
Removing intermediate container a303a3058869 
Step 4/6 : RUN sh -c ‘touch /app.jar’ 
—> Running in cf231afe700e 
—> 9a0ec8936c00 
Removing intermediate container cf231afe700e 
Step 5/6 : ENV JAVA_OPTS “” 
—> Running in e192597fc881 
—> 2cb0d73bbdb0 
Removing intermediate container e192597fc881 
Step 6/6 : ENTRYPOINT sh -c java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar 
—> Running in ab85f53fcdd8 
—> 60fdb5c61692 
Removing intermediate container ab85f53fcdd8 
Successfully built 60fdb5c61692 
[INFO] Built tom/springboot-with-docker 
[INFO] ———————————————————————— 
[INFO] BUILD SUCCESS 
[INFO] ———————————————————————— 
[INFO] Total time: 01:45 min 
[INFO] Finished at: 2017-04-19T05:37:44-07:00 
[INFO] Final Memory: 19M/48M 
[INFO] ————————————————————————
````
镜像构建成功。查看镜像：
````
docker images
````
显示：
````
tom/springboot-with-docker latest 60fdb5c61692 About a minute ago 195 MB
````
启动镜像：
````
$ docker run -p 8080:8080 -t tom/springboot-with-docker
````
打开浏览器访问 localhost:8080;浏览器显示：Hello Docker World。 
说明docker 的springboot工程已部署。

停止镜像：
````
docker stop 60fdb5c61692
````
删除镜像：
````
docker rm 60fdb5c61692
````


#参考资料
https://docs.docker.com/engine/reference/builder/
http://www.runoob.com/docker/docker-tutorial.html