package cn.yjhroot.decorator;

/**
 * 装饰者抽象类
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public abstract class Decorator implements Component {
    /**
     * 被装饰者对象
     */
    protected Component component;

    /**
     * 构造方法
     *
     * @param component 被装饰着对象
     */
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
