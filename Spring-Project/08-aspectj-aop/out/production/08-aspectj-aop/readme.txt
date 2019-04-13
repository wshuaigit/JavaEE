实现aop的框架由很多：

1.Spring框架实现aop,Spring使用接口表示切面的，使用方式比较笨重
2.aspectj框架实现aop,aspectj可以使用注解和xml配置文件实现aop

使用aspectj框架实现aop的准备工作：
1、加入支持aop的jar:
    1)spring-aop.jar
    2)aspectj框架对aop的实现jar:aspectjrt.jaraspectjweaver.jar
2、加入新的约束文件Spring-aop.xsd

步骤：
    1.新建java project
    2.导入jar
        必须的jar
        1) Spring的核心：Spring-beans.jar,Spring-core.jar,Spring-context.jar,Spring-expression.jar
        2) 日志：commons-logging.jar
        3)支持注解的使用：Spring-aop.jar
        4)aspectj框架对aop的实现jar:aspectjrt.jar,aspectjweaver.jar
    可选的：
        1）日志的实现：log4j.jar
        2) 单元测试：junit.jar
    3. 定义目标类，实现业务接口

    4.定义切面类，在切面类中定义方法实现切面的功能
        1）在类的上面加入@Aspect，表示当前类是切面类
        2）在类中自定义方法，实现切面的功能。在方法的上面加入AspectJ框架中的通知注解
        例如：@Before(value="aspectj框架自己的切入点表达式")

    5.定义Spring的配置文件
        1）加入约束文件spring-beans.xsd，spring-context.xsd,spring-aop.xsd
        2) 声明目标类对象
        3）声明切面类对象，把镀锡交给Spring创建和管理
        4）声明自动代理生成器，自动代理生成器是aspectJ框架的一个功能，根据目标对象和切面类生成符合条件的所有代理对象
            aspectj会修改目标对象，加入切面的功能，所以目标对象实际就是代理对象
    6、定义测试类，在代码中使用Spring
        创建接口ApplicationContext，表示Spring框架
        从Spring容器中获取目标对象（是修改后的代理对象），通过代理对象执行业务方法，实现功能的增强（执行切面）