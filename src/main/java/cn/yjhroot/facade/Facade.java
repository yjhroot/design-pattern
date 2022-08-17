package cn.yjhroot.facade;

/**
 * 外观类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class Facade {
    /**
     * 子系统对象A
     */
    private final SubSystemA subSystemA = new SubSystemA();
    /**
     * 子系统对象B
     */
    private final SubSystemB subSystemB = new SubSystemB();

    /**
     * 某方法A
     */
    public void doSomethingA() {
        subSystemA.methodA();
    }

    /**
     * 某方法B
     */
    public void doSomethingB() {
        subSystemB.methodB();
    }
}
