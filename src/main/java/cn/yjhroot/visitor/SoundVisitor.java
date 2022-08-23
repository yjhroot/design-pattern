package cn.yjhroot.visitor;

/**
 * 声音方法的具体访问类 ConcreteVisitor
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class SoundVisitor implements Visitor {
    @Override
    public void visit(Cat cat) {
        cat.sound();
    }

    @Override
    public void visit(Dog dog) {
        dog.sound();
    }
}
