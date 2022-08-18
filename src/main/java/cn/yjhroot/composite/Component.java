package cn.yjhroot.composite;

/**
 * 组件（抽象类 叶子类和分支类的共同父类）
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public abstract class Component {
    /**
     * 组件名
     */
    String name;

    /**
     * 添加子节点
     *
     * @param component 组件
     */
    void add(Component component) {
    }

    /**
     * 删除子节点
     *
     * @param component 组件
     */
    void remove(Component component) {
    }

    /**
     * 遍历节点
     */
    void each() {
    }
}
