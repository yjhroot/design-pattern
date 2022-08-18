package cn.yjhroot.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合类（复合体 可以有子节点）
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class Composite extends Component {
    List<Component> components = new ArrayList<Component>();

    /**
     * 构造方法
     *
     * @param name 名字
     */
    public Composite(String name) {
        super.name = name;
    }

    @Override
    void add(Component component) {
        components.add(component);
    }

    @Override
    void remove(Component component) {
        components.remove(component);
    }

    @Override
    void each() {
        System.out.println(super.name + "被打印");
        for (Component component : components) {
            // 调用每个子节点的each 体现单体和组合体的使用方法一致性
            component.each();
        }
    }
}
