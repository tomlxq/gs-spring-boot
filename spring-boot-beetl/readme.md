BeetSql是一个全功能DAO工具， 同时具有Hibernate 优点 & Mybatis优点功能，适用于承认以SQL为中心，同时又需求工具能自动能生成大量常用的SQL的应用。

beatlsql 优点

* 开发效率

无需注解，自动使用大量内置SQL，轻易完成增删改查功能，节省50%的开发工作量
数据模型支持Pojo，也支持Map/List这种快速模型，也支持混合模型
SQL 模板基于Beetl实现，更容易写和调试，以及扩展

* 维护性

SQL 以更简洁的方式，Markdown方式集中管理，同时方便程序开发和数据库SQL调试。
可以自动将sql文件映射为dao接口类
灵活直观的支持支持一对一，一对多，多对多关系映射而不引入复杂的OR Mapping概念和技术。
具备Interceptor功能，可以调试，性能诊断SQL，以及扩展其他功能

* 其他 

内置支持主从数据库支持的开源工具
支持跨数据库平台，开发者所需工作减少到最小，目前跨数据库支持mysql,postgres,oracle,sqlserver,h2,sqllite,DB2.


#参考资料

BeetlSQL2.8中文文档 http://ibeetl.com/guide/#beetlsql