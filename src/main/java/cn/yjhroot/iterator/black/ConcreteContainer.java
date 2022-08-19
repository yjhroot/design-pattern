package cn.yjhroot.iterator.black;

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
        // 创建并返回内部类对象
        return new ConcreteIterator();
    }

    /**
     * 具体迭代器类（内部类 体现黑箱）
     *
     * @author YuJianHui
     * @date 2022/08/19
     */
    private class ConcreteIterator implements Iterator {
        /**
         * 当前游标位置
         */
        private int index;
        /**
         * 集合大小（为了演示方便 集合大小创建集合时的构造函数确定 不可改变 因此此字段为final）
         */
        private final int size;

        /**
         * 构造方法（设置游标位置 设置集合大小）
         */
        public ConcreteIterator() {
            size = objArray.length;
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
            return objArray[index];
        }
    }
}
