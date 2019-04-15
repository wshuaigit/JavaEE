22-interceptor:一个拦截器

拦截器拦截用户的请求，可以对请求做判断，处理的。可以控制请求是否被处理。
拦截器的执行时间点：获取到处理器的适配器之后，在处理器方法执行之前，拦截用户的请求。

拦截器的数量：在一个项目中拦截器可以有0-多个

拦截器是全局的，对所有的处理器对象都可以使用。

实现拦截器的步骤：
            1、定义类实现拦截器的接口Interceptor
            2、在SpringMVC的配置文件中，声明拦截器的存在，指定拦截器的URI地址

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
      定义请求参数name,age（使用整数表示年龄）

    5.新建控制器对象，是一个普通的Java类
        1）在类的上面加入注解@Controller,创建处理器对象
        2）在类中自定义方法，处理某个请求，在方法的上面加入@RequestMapping
        方法定义形参name , age

    6.新建jsp,显示请求的处理结果

    7.定义类实现HandlerInterceptor接口，实现接口中的三个方法
        在preHandle()方法中验证会话中的用户信息是否是张三，如果是张三能访问系统

    8.定义SpringMVC的配置文件
        1）声明组件扫描器，指定@Controller注解所在的包名
        2）声明视图解析器，处理视图
        3）声明拦截器对象，指定拦截的请求URI

    9.新建jsp,模拟登录login.jsp
              登出系统logout.jsp
