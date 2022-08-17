package cn.yjhroot.decorator;

/**
 * 具体装饰类A
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class ConcreteDecoratorA extends Decorator {
    /**
     * 构造方法
     *
     * @param component 被装饰着对象
     */
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    /**
     * 装饰者A的私有方法
     */
    private void methodA() {
        System.out.println("装饰类A的方法A");
    }

    @Override
    public void operation() {
        methodA();
        super.operation();
    }
}
