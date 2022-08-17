package cn.yjhroot.adapter;

/**
 * 被适配者子类
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class AdapteeChild extends Adaptee {
    @Override
    public void highVoltageCharge() {
        System.out.println("进行高压充电。。。");
    }
}
