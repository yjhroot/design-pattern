package cn.yjhroot.singleton;

/**
 * 懒汉式单例类
 * 优点：不浪费内存，没有加锁，执行效率会提高
 * 缺点：类加载时没有初始化，线程不安全
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject2 {
    /**
     * 单例对象
     */
    private static SingleObject2 instance;

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject2() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法
     *
     * @return {@link SingleObject2}
     */
    public static SingleObject2 getInstance() {
        if (instance == null) {
            instance = new SingleObject2();
        }
        return instance;
    }
}
