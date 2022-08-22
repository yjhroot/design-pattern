package cn.yjhroot.command;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建接收者Receiver
        MusicPlayer player = new MusicPlayer();

        // 创建命令Command并指定接收者
        Command nextCommand = new NextCommand(player);
        Command previousCommand = new PreviousCommand(player);

        // 创建调用者Invoker并设置命令
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setCommand(nextCommand);
        controlPanel.action();

        // 切换命令
        controlPanel.setCommand(previousCommand);
        controlPanel.action();
    }
}
