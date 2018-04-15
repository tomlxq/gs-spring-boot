###声明式缓存

Spring 定义 CacheManager 和 Cache 接口用来统一不同的缓存技术。例如 JCache、 EhCache、 Hazelcast、 Guava、 Redis 等。在使用 Spring 集成 Cache 的时候，我们需要注册实现的 CacheManager 的 Bean。

Spring Boot 为我们自动配置了 JcacheCacheConfiguration、 EhCacheCacheConfiguration、HazelcastCacheConfiguration、GuavaCacheConfiguration、RedisCacheConfiguration、SimpleCacheConfiguration 等。

###默认使用 ConcurrenMapCacheManager

在我们不使用其他第三方缓存依赖的时候，springboot自动采用ConcurrenMapCacheManager作为缓存管理器。

###环境依赖

在pom文件引入spring-boot-starter-cache环境依赖：
````
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
````

启动程序，你会发现程序在控制台依次打印了：
````
2018-04-15 17:44:40.348  INFO 9752 --- [           main] com.example.AppRunner                    : .... Fetching books
2018-04-15 17:44:43.348  INFO 9752 --- [           main] com.example.AppRunner                    : id-1234 -->com.example.entity.Book@200606de
2018-04-15 17:44:46.348  INFO 9752 --- [           main] com.example.AppRunner                    : id-4567 -->com.example.entity.Book@750fe12e
2018-04-15 17:44:49.348  INFO 9752 --- [           main] com.example.AppRunner                    : id-1234 -->com.example.entity.Book@f8908f6
2018-04-15 17:44:52.348  INFO 9752 --- [           main] com.example.AppRunner                    : id-4567 -->com.example.entity.Book@3e587920
2018-04-15 17:44:55.349  INFO 9752 --- [           main] com.example.AppRunner                    : id-1234 -->com.example.entity.Book@2ef8a8c3
2018-04-15 17:44:58.349  INFO 9752 --- [           main] com.example.AppRunner                    : id-1234 -->com.example.entity.Book@24f43aa3
````
你会发现程序依次3s打印一行日志。这时还没开启缓存技术。

#开启缓存技术

    * 在程序的入口中加入@ EnableCaching开启缓存技术：
    ````
    @SpringBootApplication
    @EnableCaching
    public class SpringBootCacheApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringBootCacheApplication.class, args);
        }
    }
    ````
    
    * 在需要缓存的地方加入@Cacheable注解，比如在getById（）方法上加入@Cacheable(“books”)，这个方法就开启了缓存策略，当缓存有这个数据的时候，会直接返回数据，不会等待去查询数据库。
    ````
    @Component
    public class SimpleBookRepository implements BookRepository {
    
        @Override
        @Cacheable("books")
        public Book getById(String id) {
            simulateSlowService();
            return new Book(id, "Some book");
        }
    
        // Don't do this at home
        private void simulateSlowService() {
            try {
                long time = 3000L;
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }
    ````
    这时再启动程序，你会发现程序打印：
    ````
    2018-04-15 17:47:51.940  INFO 4968 --- [           main] com.example.AppRunner                    : .... Fetching books
    2018-04-15 17:47:54.946  INFO 4968 --- [           main] com.example.AppRunner                    : id-1234 -->com.example.entity.Book@5aa360ea
    2018-04-15 17:47:57.946  INFO 4968 --- [           main] com.example.AppRunner                    : id-4567 -->com.example.entity.Book@6548bb7d
    2018-04-15 17:47:57.948  INFO 4968 --- [           main] com.example.AppRunner                    : id-1234 -->com.example.entity.Book@5aa360ea
    2018-04-15 17:47:57.948  INFO 4968 --- [           main] com.example.AppRunner                    : id-4567 -->com.example.entity.Book@6548bb7d
    2018-04-15 17:47:57.948  INFO 4968 --- [           main] com.example.AppRunner                    : id-1234 -->com.example.entity.Book@5aa360ea
    2018-04-15 17:47:57.949  INFO 4968 --- [           main] com.example.AppRunner                    : id-1234 -->com.example.entity.Book@5aa360ea
    ````
#参考资料

[caching](https://spring.io/guides/gs/caching/)

[Spring Boot 揭秘与实战（二） 数据缓存篇 - 快速入门](http://blog.720ui.com/2017/springboot_02_data_cache_concurrenmapcache/)