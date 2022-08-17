package cn.yjhroot.singleton;

/**
 * 枚举单例类
 * 优点：不加锁，线程安全，书写简单
 * 缺点：对初学者难以理解
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public enum SingleObject6 {
    /**
     * SingleObject6类实例
     */
    INSTANCE;

    /**
     * 私有化的构造方法 JVM保证只调用一次
     */
    SingleObject6() {
        System.out.println("创建对象");
    }

    /**
     * 任意方法（实例方法）
     */
    public void doSomething() {
    }
}
