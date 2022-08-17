package cn.yjhroot.proxy.cglibporxy;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建被代理类对象
        RealSubject realSubject = new RealSubject();
        // 创建代理工厂对象
        ProxyFactory proxyFactory = new ProxyFactory(realSubject);
        // 获取代理对象
        RealSubject proxy = (RealSubject) proxyFactory.getProxyInstance();
        // 调用代理对象的方法
        proxy.doSomething();
    }
}
