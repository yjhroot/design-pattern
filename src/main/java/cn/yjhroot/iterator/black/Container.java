package cn.yjhroot.iterator.black;

/**
 * 容器接口（为了演示方便 此接口不提供改变集合内容的方法 因此集合一旦初始化 大小不可改变）
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Container {
    /**
     * 创建迭代器对象
     *
     * @return {@link Iterator}
     */
    Iterator createIterator();
}
