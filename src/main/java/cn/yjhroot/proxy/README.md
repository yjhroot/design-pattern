# 代理模式

## 定义

代理模式给某一个对象提供一个代理对象，并由代理对象控制对原对象的引用。通俗的来讲代理模式就是我们生活中常见的中介。

## 针对问题

通常我们需要使用一个对象的某个方法，但是我们希望在调用这个方法之前或之后做一些额外的操作（如方法输入参数的数据准备等）。

## 模式分类

1. 静态代理模式
2. 动态代理模式（JDK）
3. CGLib代理模式

## 模式区别

1. 静态代理：代理对象和被代理对象（委托对象）需要实现相同的接口，类似与装饰模式。代理类在编译时已经确定。速度快。
2. 动态代理：被代理对象需要实现某一接口，JDK在运行时动态创建的代理类也会实现该接口。代理类在运行时根据传入参数的不同，动态生成不同的实现类。可以代理final类。速度慢。
3. CGLib代理：被代理对象不需要实现任何接口。在运行动态的生成一个被代理类的子类，通过拦截的方法实现对象控制。由于使用的是继承原理，因此不能代理final类的对象或普通类对象的final方法。速度快。

## 代理模式与装饰模式的区别

装饰器模式关注于在一个对象上动态的添加方法，然而代理模式关注于控制对对象的访问。  
通常来说，代理类可以对他的客户隐藏被代理对象的信息，因此使用代理模式时，一般都在代理类中创建被代理对象，而使用装饰模式时，一般在装饰类的构造方法的参数中传入被装饰的对象。  
然而，在动态代理模式中，为了凸显动态代理的灵活性，一般在代理工厂类或代理处理类中通过构造方法传入被代理对象。

## 详细信息

1. [静态代理模式](./staticproxy)
2. [动态代理模式](./dynamicproxy)
3. [CgLib动态代理模式](./cglibporxy)

