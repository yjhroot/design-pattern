package cn.yjhroot.visitor;

/**
 * 动物类接口（元素接口Element）
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public interface Animal {
    /**
     * 接受访问者方法
     *
     * @param visitor 访问者
     */
    void accept(Visitor visitor);

    /**
     * 吃方法
     */
    void eat();

    /**
     * 叫声方法
     */
    void sound();
}
