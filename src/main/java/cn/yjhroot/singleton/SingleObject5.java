package cn.yjhroot.singleton;

/**
 * 懒汉式单例类
 * 优点：不浪费内存，不加锁，线程安全
 * 缺点：有内部类（可忽略不算缺点）
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject5 {
    /**
     * 内部类（加载外部类时，内部类不会加载，只有在使用时才会加载）
     *
     * @author YuJianHui
     * @date 2022/02/19
     */
    private static class InnerClass {
        /**
         * 内部类静态对象
         */
        private static final SingleObject5 INSTANCE = new SingleObject5();
    }

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject5() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法（线程安全，效率高）
     *
     * @return {@link SingleObject5}
     */
    public static synchronized SingleObject5 getInstance() {
        return InnerClass.INSTANCE;
    }
}
