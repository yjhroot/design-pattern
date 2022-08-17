package cn.yjhroot.proxy.cglibporxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理工厂类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class ProxyFactory implements MethodInterceptor {
    /**
     * 被代理对象
     */
    private final Object target;

    /**
     * 构造方法
     *
     * @param target 目标
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 获得代理实例
     *
     * @return {@link Object}
     */
    public Object getProxyInstance() {
        // cglib工具对象
        Enhancer enhancer = new Enhancer();
        // 设置生成的代理对象的父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调 参数为该工厂类
        enhancer.setCallback(this);
        // 创建代理对象并返回
        return enhancer.create();
    }

    /**
     * 拦截方法
     *
     * @param o           对象
     * @param method      方法
     * @param objects     对象
     * @param methodProxy 方法代理
     * @return {@link Object}
     * @throws Throwable throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("帮客户找房子");
        Object result = methodProxy.invoke(target, objects);
        System.out.println("帮客户换门锁");
        return result;
    }
}
