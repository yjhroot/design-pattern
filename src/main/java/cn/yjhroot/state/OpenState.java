package cn.yjhroot.state;

/**
 * 开灯状态
 * 允许关灯 不允许开灯
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class OpenState implements State {
    @Override
    public void open() {
        throw new IllegalStateException("错误：灯已经是开启状态！");
    }

    @Override
    public void close() {
        System.out.println("关灯成功");
    }
}
