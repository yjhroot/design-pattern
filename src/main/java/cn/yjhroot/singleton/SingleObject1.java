package cn.yjhroot.singleton;

/**
 * 饿汉式单例类
 * 优点：没有加锁，执行效率会提高，线程安全
 * 缺点：类加载时就初始化，浪费内存
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject1 {
    /**
     * 单例对象
     */
    private static final SingleObject1 INSTANCE = new SingleObject1();

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject1() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法
     *
     * @return {@link SingleObject1}
     */
    public static SingleObject1 getInstance() {
        return INSTANCE;
    }
}
