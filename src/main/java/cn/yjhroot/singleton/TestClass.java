package cn.yjhroot.singleton;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class TestClass {
    /**
     * main方法
     *
     * @param args
     */
    public static void main(String[] args) {
        int threadNum = 100;

        System.out.println("测试饿汉式单例：");
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(() -> SingleObject1.getInstance());
            thread.start();
        }

        System.out.println("测试懒汉式单例1，线程不安全，可能出现多次构造方法调用：");
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(() -> SingleObject2.getInstance());
            thread.start();
        }

        System.out.println("测试懒汉式单例2：");
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(() -> SingleObject3.getInstance());
            thread.start();
        }

        System.out.println("测试懒汉式单例3：");
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(() -> SingleObject4.getInstance());
            thread.start();
        }

        System.out.println("测试懒汉式单例4：");
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(() -> SingleObject5.getInstance());
            thread.start();
        }

        System.out.println("测试m枚举式单例：");
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(SingleObject6.INSTANCE::doSomething);
            thread.start();
        }
    }
}
