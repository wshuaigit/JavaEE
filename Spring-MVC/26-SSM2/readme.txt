
25-SSM：一个容器，SpringMVC容器管理项目中的所有对象

SSM整合的步骤：
1、使用SpringDB的数据库，student表
2、新建的web应用
    导入jar：
        1)Spring的核心jar：Spring-bean-jar,Spring-core.jar,Spring-context.jar,Spring-expression.jar
        2)Spring-aop.jar
        3)数据库和事务相关的：Spring-jdbc.jar,Spring-tx.jar
        4)web相关的jar:Spring-web.jar,Spring-webmvc.jar
        5)MyBatis的核心jar:mybatis-3.2.7.jar
        6)Mybatis和Spring整合的jar:Mybatis-Spring.jar
        7)数据库的连接池druid.jar
        8)MySQL的驱动，日志commons-logging.jar,log4j.jar
        9)json的工具jar:Jackson
3、修改web.xml

    2)注册SpringMVC的中央调度器，创建SpringMVC的容器对象，加入SpringMVC配置文件
    3)注册字符集过滤器，解决POST请求乱码的问题
4、定义程序中包的结构，实体beans,Dao包，Service包，Controller包
5、编写配置文件
   1)SpringMVC的配置文件
   3)定义数据库的属性配置文件
   4)MyBatis主配置文件
6、编写代码：定义实体类，Dao接口和Sql映射文件，Service接口和实现类，Controller类
7、定义视图文件（jsp）