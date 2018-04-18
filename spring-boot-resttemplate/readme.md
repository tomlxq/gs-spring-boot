这篇文章主要介绍怎么用消费一个 Restful的web服务。我将用restTemplate去消费一个服务： http://gturnquist-quoters.cfapps.io/api/random.

构架工程

创建一个springboot工程，去消费RESTFUL的服务。这个服务是 http:///gturnquist-quoters.cfapps.io/api/random ，它会随机返回Json字符串。 
在Spring项目中，它提供了一个非常简便的类，叫RestTemplate，它可以很简便的消费服务。

消费服务

通过RestTemplate消费服务，需要先context中注册一个RestTemplate bean。
````
  @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            String quote = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", String.class);
            log.info(quote.toString());
        };
    }
````


参考资料

https://spring.io/guides/gs/consuming-rest/