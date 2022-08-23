package cn.yjhroot.visitor;

/**
 * 猫类（具体元素ConcreteElement）
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class Cat implements Animal {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void eat() {
        System.out.println("猫吃猫粮");
    }

    @Override
    public void sound() {
        System.out.println("喵喵喵");
    }
}
