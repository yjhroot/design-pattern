package cn.yjhroot.visitor;

/**
 * 狗类（具体元素ConcreteElement）
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class Dog implements Animal {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void eat() {
        System.out.println("狗吃狗粮");
    }

    @Override
    public void sound() {
        System.out.println("汪汪汪");
    }
}
