package cn.yjhroot.command;

/**
 * 音乐播放器的遥控器类（调用者Invoker）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class ControlPanel {
    /**
     * 命令
     */
    private Command command;

    /**
     * 设置命令方法
     *
     * @param command 下一曲命令
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 点击按钮
     */
    public void action() {
        command.execute();
    }
}
