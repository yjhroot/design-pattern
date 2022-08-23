package cn.yjhroot.visitor;

/**
 * 吃东西方法的具体访问类 ConcreteVisitor
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class EatVisitor implements Visitor {
    @Override
    public void visit(Cat cat) {
        cat.eat();
    }

    @Override
    public void visit(Dog dog) {
        dog.eat();
    }
}
