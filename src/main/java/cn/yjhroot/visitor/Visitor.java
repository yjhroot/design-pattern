package cn.yjhroot.visitor;

/**
 * 访问者接口
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public interface Visitor {
    /**
     * 访问方法 接收具体能访问的元素ConcreteElement
     *
     * @param cat 猫
     */
    void visit(Cat cat);

    /**
     * 访问方法 接收具体能访问的元素ConcreteElement
     *
     * @param dog 狗
     */
    void visit(Dog dog);
}
