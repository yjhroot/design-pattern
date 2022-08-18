package cn.yjhroot.composite;

/**
 * 叶子节点（单体 没有子节点）
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class Leaf extends Component {
    /**
     * 构造方法
     *
     * @param name 名字
     */
    public Leaf(String name) {
        super.name = name;
    }

    @Override
    void add(Component component) {
        // 不做任何事
    }

    @Override
    void remove(Component component) {
        // 不做任何事
    }

    @Override
    void each() {
        System.out.println(super.name + "被打印");
    }
}
