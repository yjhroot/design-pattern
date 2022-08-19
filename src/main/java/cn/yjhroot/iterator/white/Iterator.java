package cn.yjhroot.iterator.white;

/**
 * 迭代器接口
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Iterator {
    /**
     * 将游标移动到第一个
     */
    void toFirst();

    /**
     * 将游标移动到下一个
     */
    void next();

    /**
     * 是否还有下一个
     *
     * @return boolean
     */
    boolean hasNext();

    /**
     * 返回当前游标指向的对象
     *
     * @return {@link Object}
     */
    Object currentItem();
}
