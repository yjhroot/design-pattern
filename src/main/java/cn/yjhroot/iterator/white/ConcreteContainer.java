package cn.yjhroot.iterator.white;

/**
 * 具体容器实现类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class ConcreteContainer implements Container {
    /**
     * 存放对象的容器（为了演示方便 此容器内容不可变 因此为final）
     */
    private final Object[] objArray;

    /**
     * 构造方法 初始话容器（一般情况下 需要提供修改objArray内容的方法 此处仅为演示代码 因此不提供）
     *
     * @param objArray obj数组
     */
    public ConcreteContainer(Object[] objArray) {
        this.objArray = objArray;
    }

    @Override
    public Iterator createIterator() {
        // 传入当前容器类对象 体现白箱
        return new ConcreteIterator(this);
    }

    @Override
    public Object getItem(int index) {
        return objArray[index];
    }

    @Override
    public int size() {
        return objArray.length;
    }
}
