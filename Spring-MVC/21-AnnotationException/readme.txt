21-AnnotationException：使用注解处理异常，@ExceptionHandler

实现自定义的异常处理器：
1、定义类实现HandlerExceptionResolver接口
2、在SpringMVC的配置文件中声明自定义异常处理器

步骤：
    1、新建 web project
    2、导入jar：
        1）Spring的核心jar:Spring-beans.jar，Spring-core.jar,Spring-context.jar,Spring-expression.jar
        2）Spring-aop.jar
        3）web相关的jar:Spring-web.jar
        4）SpringMVC的实现jar:Spring-webmvc.jar
        5）日志：commons-logging.jar
*** 3.修改web.xml,注册SpringMVC的核心对象：中央调度器DispatherServlet
***     1）中央调度器DispatherServlet是要给Servlet
***     2）中央调度器的作用：1）接受用户的请求；2）响应处理结果
***     3）中央调度器也叫做前端控制器（front controller）

    4、新建异常类 MyUserException
        子类NameException ,AgeException
    5.新建jsp,发起一个请求
      定义请求参数name,age（使用整数表示年龄）

    6.新建控制器对象，是一个普通的Java类
        1）在类的上面加入注解@Controller,创建处理器对象
        2）在类中自定义方法，处理某个请求，在方法的上面加入@RequestMapping
        方法定义形参name , age
        根据请求的参数name,age的值分别抛出NameException，AgeException

    7.新建jsp,显示请求的处理结果
    8.定义SpringMVC的配置文件
        1）声明组件扫描器，指定@Controller注解所在的包名
        2）声明视图解析器，处理视图
        3）声明异常处理器，处理异常

    9.一定处理异常的视图页面
