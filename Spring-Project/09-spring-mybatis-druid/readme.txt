09-spring-mybatis-druid：整合Spring和MyBatis，使用阿里的druid数据库的连接池

Spring整合MyBatis的主要思路：把MyBatis的对象交给Spring统一创建和管理

哪些对象交给Spring:
    1.数据源:DataSource,表示数据库的连接。访问数据库的
    2.SqlSessionFactory,使用它创建SqlSession对象
    3.Dao对象，由Spring使用MyBatis的动态代理技术，创建Dao接口的实现类对象

步骤：
    1.新建mysql的数据库SpringDB，新建表student(id,name,age)
    2.新建java project
    3.导入jar
        1)Spring的核心：Spring-core.jar,Spring-beans.jar,Spring-context.jar,Spring-expression.jar
        2)Spring的aop：Spring-aop.jar(支持环绕通知，使用事务处理)
        3)Spring访问数据库的相关jar:Spring-jdbc.jar,Spring-tx.jar
            Spring整合MyBatis事务是自动提交的方式
        4)MyBatis的核心：mybatis-3.4.5.jar
        5)MyBatis和Spring的整合包：MyBatis-Spring-1.3.1.jar
            整合包的作用：能够在Spring框架中创建MyBatis的对象。整合包来自MyBatis的官网
        6)数据库的却动：mySql的驱动
        7）数据库的连接池：druid.1.1.9.jar
        8)其他：日志，单元测试。
    4.定义实体类：Student
    5.定义Dao接口和Sql映射文件
    6.定义MyBatis的主配置文件
    7.定义Service接口和实现类，在实现类中应该有一个Dao的属性
*** 8.定义Spring的配置文件 ****
        1）声明数据源DataSource,访问数据库
        2) 声明SqlSessionFactoryBean,创建SqlSessionFactory对象
        3）声明MyBatis的扫描器对象，创建Dao接口的实现类对象
        4) 声明Service对象，把Dao对象注入给Service的属性
    9.定义测试类，访问数据库
