package cn.yjhroot.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态调用处理类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class DynamicInvocationHandler<T> implements InvocationHandler {
    /**
     * 被代理对象
     */
    private final T target;

    /**
     * 构造方法（因为是动态代理 代理对象是在运行时创建的 不建议像静态代理一样写死类型 因此用泛型传参创建被代理对象）
     *
     * @param target 被代理对象
     */
    public DynamicInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 输出仅作为代理前后处理的演示 动态代理不建议针对某一特定对象做处理
        System.out.println("帮客户找房子");
        Object result = method.invoke(target, args);
        System.out.println("帮客户换门锁");
        return result;
    }
}
