package cn.yjhroot.adapter;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class TestClass {
    public static void main(String[] args) {
        // 原有低压充电方法
        Target target1 = new TargetImpl();
        target1.lowVoltageCharge();
        System.out.println("------------------");

        // 适配后的高压转低压充电方法（类适配）
        Target target2 = new Adapter();
        target2.lowVoltageCharge();
        System.out.println("------------------");

        // 适配后的高压转低压充电方法（对象适配）
        Target target3 = new Adapter1(new AdapteeChild());
        target3.lowVoltageCharge();
    }
}
