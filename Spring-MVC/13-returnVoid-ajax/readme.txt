12-returnVoid-ajax:处理器返回void,响应ajax请求

现在让处理器方法返回String,String表示视图：
1、可以是逻辑名称，需要使用视图解析器
2、视图的完整路径，不能使用视图解析器


要求：请求中参数名和对象的属性名一样，类必须有无参数构造方法

步骤：
    1、新建 web project
    2、导入jar：
        1）Spring的核心jar:Spring-beans.jar，Spring-core.jar,Spring-context.jar,Spring-expression.jar
        2）Spring-aop.jar
        3）web相关的jar:Spring-web.jar
        4）SpringMVC的实现jar:Spring-webmvc.jar
        5）日志：commons-logging.jar
        6）Jackson的工具库：三个jar
*** 3.修改web.xml,注册SpringMVC的核心对象：中央调度器DispatherServlet
***     1）中央调度器DispatherServlet是要给Servlet
***     2）中央调度器的作用：1）接受用户的请求；2）响应处理结果
***     3）中央调度器也叫做前端控制器（front controller）
    4.新建jsp,发起一个请求
      定义请求参数rname,rage（使用整数表示年龄）
      加入JQuery的库文件

    5.新建控制器对象，是一个普通的Java类
        1）在类的上面加入注解@Controller,创建处理器对象
        2）在类中自定义方法，处理某个请求，在方法的上面加入@RequestMapping
        方法定义形参name , age

    6.新建jsp,显示请求的处理结果
    7.定义SpringMVC的配置文件
        1）声明组件扫描器，指定@Controller注解所在的包名
        2）声明视图解析器，处理视图
    8.修改控制器，使用逻辑视图名称
