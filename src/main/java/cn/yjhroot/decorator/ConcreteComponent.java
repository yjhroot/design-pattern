package cn.yjhroot.decorator;

/**
 * 具体组件（被装饰者）
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("未被装饰的操作");
    }
}
