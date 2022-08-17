package cn.yjhroot.singleton;

/**
 * 懒汉式单例类
 * 优点：不浪费内存，加锁，线程安全
 * 缺点：类加载时没有初始化，整个获取单例对象的方法加锁，每次获取对象都要锁，执行效率低
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject3 {
    /**
     * 单例对象
     */
    private static SingleObject3 instance;

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject3() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法（加锁，线程安全，效率不高）
     *
     * @return {@link SingleObject3}
     */
    public static synchronized SingleObject3 getInstance() {
        if (instance == null) {
            instance = new SingleObject3();
        }
        return instance;
    }
}
