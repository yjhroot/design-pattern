package cn.yjhroot.adapter;

/**
 * 目标实现类
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class TargetImpl implements Target {
    @Override
    public void lowVoltageCharge() {
        System.out.println("进行低压充电。。。");
    }
}
