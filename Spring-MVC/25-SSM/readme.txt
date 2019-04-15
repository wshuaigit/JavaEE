
25-SSM：SSM整合开发，在一个项目中使用SpringMVC + Spring + MyBatis

SSM整合的思路：把视图层的对象交给SpringMVC容器管理，把Service和Dao层交给Spring容器管理

把视图层的对象定义在SpringMVC的配置文件中：
1、处理器对象，使用@Controller创建，声明组件扫描器
2、视图解析器
3、注解驱动<mvc:annotation-driver>

把Service和Dao对象定义Spring的配置文件中：
1、Service层对象，使用注解@Service，声明组件扫描器
2、数据源DataSource(druid,dbcp)
3、SqlSessionFactory
4、MyBatis的动态代理技术，创建Dao对象
5、工具类和其他类

SpringMVC容器和Spring容器的关系：SpringMVC容器是Spring容器的子容器
那么子容器中可以访问父容器的对象，也就是Controller可以访问Service
反过来Service不能访问Controller

SpringMVC容器和Spring容器关系的建立是通过SpringMVC容器对象中的属性parent实现的。
parent属性值是Spring的容器对象

SpringMVC --->  parent ---> Spring


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
    1)注册Spring的监听器，COntextLoaderListener,创建Spring的容器对象。加载Spring的配置文件
    2)注册SpringMVC的中央调度器，创建SpringMVC的容器对象，加入SpringMVC配置文件
    3)注册字符集过滤器，解决POST请求乱码的问题
4、定义程序中包的结构，实体beans,Dao包，Service包，Controller包
5、编写配置文件
   1)SpringMVC的配置文件
   2)Spring的配置
   3)定义数据库的属性配置文件
   4)MyBatis主配置文件
6、编写代码：定义实体类，Dao接口和Sql映射文件，Service接口和实现类，Controller类
7、定义视图文件（jsp）