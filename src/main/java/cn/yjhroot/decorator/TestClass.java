package cn.yjhroot.decorator;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class TestClass {
    public static void main(String[] args) {
        // 未被装饰的对象
        Component component = new ConcreteComponent();
        component.operation();
        System.out.println("-----------------------");

        // 被A类装饰过的对象
        Component decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operation();
        System.out.println("-----------------------");

        // 被B类装饰过的A对象（装饰B套装饰A）
        Component decoratorB = new ConcreteDecoratorB(decoratorA);
        decoratorB.operation();
    }
}
