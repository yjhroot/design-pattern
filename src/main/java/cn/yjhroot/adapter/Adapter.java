package cn.yjhroot.adapter;

/**
 * 适配器类（类适配器）
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void lowVoltageCharge() {
        // 把高压转换成低压
        super.highVoltageCharge();
        System.out.println("高压转低压");
        System.out.println("进行低压充电。。。");
    }
}
