package cn.yjhroot.template;

/**
 * 抽象模板类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public abstract class Template {
    /**
     * 做某事方法
     */
    final void doSomething() {
        step1();
        step2();
        step3();
    }

    /**
     * 步骤1
     */
    protected abstract void step1();

    /**
     * 步骤2
     */
    protected abstract void step2();

    /**
     * 步骤3
     */
    protected abstract void step3();
}
