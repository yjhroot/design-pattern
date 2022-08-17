package cn.yjhroot.decorator;

/**
 * 具体装饰类B
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class ConcreteDecoratorB extends Decorator {
    /**
     * 构造方法
     *
     * @param component 被装饰着对象
     */
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    /**
     * 装饰者B的私有方法
     */
    private void methodB() {
        System.out.println("装饰类B的方法B");
    }

    @Override
    public void operation() {
        methodB();
        super.operation();
    }
}
