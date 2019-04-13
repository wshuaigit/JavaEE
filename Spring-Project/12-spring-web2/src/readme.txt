12-spring-web2 : 在web应用中，使用Spring.Spring管理Service,Dao对象等

web项目中使用spring的问题：
1.容器对象创建了多次，应该是创建一次（在应用启动的时候创建一次）
2.容器对象需要在多个Servlet中使用，需要把容器对象放入到屈居作用域ServletContext

解决问题使用监听器（自定义），框架提供了ContextLoaderLister监听器

步骤：
    1.新建web应用
    2.加入jar:spring-web.jar
    2.拷贝10-spring-mybatis-dbcp项目中的lib，src项目的源码和配置文件
    3.新建jsp,定义form，有参数name,age
    4.新建Servlet,接受请求参数，在Servlet中创建Spring的容器，获取Service对象，调用Service的业务方法
    5.新建显示处理结果的jsp
    6.修改web.xml
        1)注册servlet
        2)注册监听器