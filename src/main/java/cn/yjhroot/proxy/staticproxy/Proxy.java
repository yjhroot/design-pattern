package cn.yjhroot.proxy.staticproxy;

/**
 * 代理类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class Proxy implements Subject {
    /**
     * 委托对象
     */
    private RealSubject realSubject;

    /**
     * 构造方法（区别于装饰类）
     */
    public Proxy() {
        // 创建委托对象 而不是通过构造传参创建对象 隐藏了客户端对委托对象的可见性
        realSubject = new RealSubject();
    }

    @Override
    public void doSomething() {
        System.out.println("帮客户找房子");
        realSubject.doSomething();
        System.out.println("帮客户换门锁");
    }
}
