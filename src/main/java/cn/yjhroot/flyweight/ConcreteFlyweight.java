package cn.yjhroot.flyweight;

/**
 * 具体享元类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class ConcreteFlyweight extends Flyweight {
    /**
     * 外部状态（具有稳定性 不应该被改变）
     */
    private final String id;

    /**
     * 提供构造方法 设定外部状态 外部状态设定后 不应该被改变
     *
     * @param id id
     */
    public ConcreteFlyweight(String id) {
        this.id = id;
    }

    @Override
    public String print() {
        return "外部状态：" + id + "，内部状态：" + getIntrinsic();
    }
}
