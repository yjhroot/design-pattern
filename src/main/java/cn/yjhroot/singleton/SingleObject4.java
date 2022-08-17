package cn.yjhroot.singleton;

/**
 * 懒汉式单例类
 * 优点：不浪费内存，加锁，线程安全
 * 缺点：类加载时没有初始化，在获取单例对象的方中，只在第一次判断对象为null时加锁，效率高
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject4 {
    /**
     * 单例对象
     */
    private static volatile SingleObject4 instance;

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject4() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法（加锁，线程安全，效率高）
     *
     * @return {@link SingleObject4}
     */
    public static SingleObject4 getInstance() {
        if (instance == null) {
            synchronized (SingleObject4.class) {
                if (instance == null) {
                    instance = new SingleObject4();
                }
            }
        }
        return instance;
    }
}
