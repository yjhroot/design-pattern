package cn.yjhroot.iterator.white;

/**
 * 容器接口（为了演示方便 此接口不提供改变集合内容的方法 因此集合一旦初始化 大小不可改变）
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Container {
    /**
     * 创建迭代器
     * 创建迭代器对象
     *
     * @return {@link Iterator}
     */
    Iterator createIterator();

    /**
     * 获取指定下标的对象
     *
     * @param index 指数
     * @return {@link Object}
     */
    Object getItem(int index);

    /**
     * 获取容器大小
     *
     * @return int
     */
    int size();
}
