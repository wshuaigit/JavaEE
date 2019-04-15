14-returnObject-String:处理器方法返回Object(对象)，对象表示数据，和视图无关，可以响应ajax请求。

框架处理器方法返回对象，需要做的工作：
1、在SpringMVC的配置文件中加入<mvc:annotation>注解驱动
    创建HttpMessageConverter接口的7个实现类对象,
    7个类中有一个MappingJackson2HttpMessageConveter类，可以实现java对象到json的处理

2、加入操作json的工具库，SpringMVC框架默认使用的是Jackson工具库。
    注意的是SpringMVC4.3版本中要求Jackson的版本是2.6或以上

3、在处理器方法的上面，加入@ResponseBody.
    @ResponseBode的作用是把2中的数据输出到应答体（通过HttpServletResponse）

HttpMessageConverter接口的作用：
1、可以把请求中的数据转为java对象的
    使用接口中的canRead(),read()
2、可以把处理器方法的返回值转为某种格式的数据，交给输出流
    使用接口中的canWrite(),writer()

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
