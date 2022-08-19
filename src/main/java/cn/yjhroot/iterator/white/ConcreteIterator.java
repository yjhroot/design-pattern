package cn.yjhroot.iterator.white;

/**
 * 具体迭代器类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class ConcreteIterator implements Iterator {
    /**
     * 容器对象
     */
    private final Container container;
    /**
     * 当前游标位置
     */
    private int index;
    /**
     * 集合大小（为了演示方便 集合大小创建集合时的构造函数确定 不可改变 因此此字段为final）
     */
    private final int size;

    /**
     * 构造方法（设置游标位置 设置集合大小 设置容器对象 体现白箱）
     */
    public ConcreteIterator(Container container) {
        this.container = container;
        size = container.size();
        index = 0;
    }

    @Override
    public void toFirst() {
        index = 0;
    }

    @Override
    public void next() {
        if (index < size) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Object currentItem() {
        return container.getItem(index);
    }
}
