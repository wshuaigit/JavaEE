01-primary:配置式的SpringMVC项目
配置式：在SpringMVC的配置文件中，使用<bean>创建控制器（处理器）对象

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
    4.新建jsp,发起一个请求
    5.新建控制器对象，在配置是的方式中需要实现接口Controller
      控制器对象是处理用户请求的。也称为后端控制器（back controller）
    6.新建jsp,显示请求的处理结果
    7.定义SpringMVC的配置文件
        1）使用<bean>声明控制器（处理器）对象，让他处理某个请求
        2）声明视图解析器，处理视图
    8.修改控制器，使用逻辑视图名称
