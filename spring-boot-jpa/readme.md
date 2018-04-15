JPA全称Java Persistence API.JPA通过JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中。

JPA 的目标之一是制定一个可以由很多供应商实现的API，并且开发人员可以编码来实现该API，而不是使用私有供应商特有的API。

JPA是需要Provider来实现其功能的，Hibernate就是JPA Provider中很强的一个，应该说无人能出其右。从功能上来说，JPA就是Hibernate功能的一个子集。

1. 配置数据源，在application.properties文件配置
注意，如果通过jpa在数据库中建表，将jpa.hibernate,ddl-auto改为create，建完表之后，要改为update,要不然每次重启工程会删除表并新建。

2. 创建实体类
通过@Entity 表明是一个映射的实体类， @Id表明id， @GeneratedValue 字段自动生成

3. Dao层
数据访问层，通过编写一个继承自 JpaRepository 的接口就能完成数据访问,其中包含了几本的单表查询的方法，非常的方便。值得注意的是，这个Account 对象名，而不是具体的表名，另外Interger是主键的类型，一般为Integer或者Long
````
public interface AccountDao  extends JpaRepository<Account,Integer> {
}
````

4. web层