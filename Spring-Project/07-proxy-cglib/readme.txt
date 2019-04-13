
07-proxy-cglib : 使用动态代理

步骤：
    1、新建java projext
    2、导入cglib的jar:cglib-full.jar
    3、定义目标类，不需要实现接口
    4、定义类实现cglib中的接口MethodInterptor(等同于JDK中的InvocationHandle)
    5、定义工具类，在工具方法中创建代理对象
        cglib中的关键对象 Enhancer , 使用Enhancer创建代理对象
    6、定义测试类，创建代理对象，通过代理对象执行业务方法，实现功能的增强
