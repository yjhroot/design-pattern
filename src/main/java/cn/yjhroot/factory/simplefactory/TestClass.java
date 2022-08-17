package cn.yjhroot.factory.simplefactory;

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
     * @param args 参数
     */
    public static void main(String[] args) {
        SimpleCarFactory simpleFactory = new SimpleCarFactory();
        Car benz = simpleFactory.createCar("奔驰");
        benz.run();
        Car bmw = simpleFactory.createCar("宝马");
        bmw.run();
    }
}
