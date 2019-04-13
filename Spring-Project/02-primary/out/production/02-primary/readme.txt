02-primary: 第一个spring项目

步骤：
    1.新建java project
    2.导入jar
        必须的jar
        1) Spring的核心：Spring-beans.jar,Spring-core.jar,Spring-context.jar,Spring-expression.jar
        2) 日志：commons-logging.jar
    可选的：
        1）日志的实现：log4j.jar
        2) 单元测试：junit.jar
    3.定义接口和实现类（可没有接口）：和没有使用框架一样定义á
    4.定义Spring的配置文件
        1）加入约束文件spring-beans.xsd
        2)声明bean对象。bean对象就是java对象
            bean:在Spring中把java对象称为bean
    5)定义测试类，在代码中使用Spring
        创建接口ApplicationContext，表示Spring框架

