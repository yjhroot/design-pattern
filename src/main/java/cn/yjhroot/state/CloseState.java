package cn.yjhroot.state;

/**
 * 关灯状态
 * 允许开灯 不允许关灯
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class CloseState implements State {
    @Override
    public void open() {
        System.out.println("开灯成功");
    }

    @Override
    public void close() {
        throw new IllegalStateException("错误：灯已经是关闭状态！");
    }
}
