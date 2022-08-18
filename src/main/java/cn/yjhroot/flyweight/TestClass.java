package cn.yjhroot.flyweight;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class TestClass {
    public static void main(String[] args) {
        Flyweight flyweight1 = FlyweightFactory.getFlyweight("A");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("B");
        Flyweight flyweight3 = FlyweightFactory.getFlyweight("A");

        System.out.println(flyweight1.print());
        System.out.println(flyweight2.print());
        System.out.println(flyweight3.print());
        System.out.println(flyweight1 == flyweight2);
        System.out.println(flyweight1 == flyweight3);
        flyweight1.setIntrinsic("bbb");
        System.out.println(flyweight1.print());
        System.out.println(flyweight2.print());
        System.out.println(flyweight3.print());

        System.out.println("池大小：" + FlyweightFactory.getPoolSize());
    }
}
