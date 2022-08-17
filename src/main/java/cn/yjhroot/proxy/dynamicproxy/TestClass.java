package cn.yjhroot.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建委托类对象
        Subject realSubject = new RealSubject();
        // 创建调用处理类对象
        InvocationHandler dynamicInvocationHandler = new DynamicInvocationHandler<>(realSubject);
        // 创建代理类对象
        Subject proxy = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                dynamicInvocationHandler);
        // 调用代理类对象的方法
        proxy.doSomething();
    }
}
