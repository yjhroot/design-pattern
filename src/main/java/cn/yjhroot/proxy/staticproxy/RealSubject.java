package cn.yjhroot.proxy.staticproxy;

/**
 * 委托类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("成功租房子");
    }
}
