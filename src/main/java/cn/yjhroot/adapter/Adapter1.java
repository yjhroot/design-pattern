package cn.yjhroot.adapter;

/**
 * 适配器类（对象适配器）
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class Adapter1 implements Target {
    /**
     * 被适配者对象
     */
    private final Adaptee adaptee;

    /**
     * 构造方法
     *
     * @param adaptee adaptee
     */
    public Adapter1(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void lowVoltageCharge() {
        adaptee.highVoltageCharge();
        System.out.println("高压转低压1");
        System.out.println("低压充电中1。。。");
    }
}
