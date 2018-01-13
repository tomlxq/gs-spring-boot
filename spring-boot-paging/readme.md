#PagingAndSortingRepository

##关于 Data Web 分页和排序相关的配置：
* 设置 spring.data.web.pageable.default-page-size 可修改分页大小，默认分页大小为 20
* 设置 spring.data.web.pageable.page-parameter 可修改当前页参数名，默认参数名为 page
* 设置 pring.data.web.pageable.size-parameter 可修改当前页参数名，默认参数名为 size
* 设置 spring.data.web.sort.sort-parameter 可修改字段排序参数名，默认参数名为 sort

接口只要继承 PagingAndSortingRepository 类即可。默认会提供很多实现，比如 CRUD 相关的实现。
支持的默认方法有： 
* count(), 
* findAll(), 
* findOne(ID), 
* delete(ID), 
* deleteAll(), 
* exists(ID), 
* save(DomainObject), 
* save(Iterable)。

最重要的是，PagingAndSortingRepository 提供了两个接口
* Iterable<T> findAll(Sort sort);
* Page<T> findAll(Pageable pageable);
用来支持 分页 和 排序 的获取数据接口。

##Test
POST http://localhost:8080/users/create Content-Type: application/json { "name":"javaer", "age":22, "birthday":"2019-09-19" }
GET http://localhost:8080/users?pageNumber=1&pageSize=3&orderBy=id,desc