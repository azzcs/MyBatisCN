**绑定流程**

1、项目启动Configuration对象加载配置文件，初始化mapperRegistry对象。
解析配置文件通过addMappers方法，向mapperRegistry对象中的knownMappers添加MapperProxyFactory。

2、mapperRegistry对象持有knownMappers，knownMappers是<Class,MapperProxyFactory>的一个map。
(其中Class是需要代理的接口)。


**获取mapper流程**

1、通过Configuration对象的getMapper方法调用MapperRegistry对象的getMapper方法。

2、MapperRegistry对象通过需要代理的接口Class在knownMappers中获取到该接口的MapperProxyFactory。

3、MapperProxyFactory调用newInstance方法返回MapperProxy对象。


**执行方法**

1、通过获取mapper流程我们得到了MapperProxy对象。

2、当执行需要代理的接口的方法时，会执行MapperProxy对象的invoke方法。

3、MapperProxy对象的invoke方法中包含Map<Method, MapperMethod> methodCache,
通过Method获取到对应的MapperMethod

4、执行MapperMethod的execute方法。