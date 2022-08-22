package cn.yjhroot.command;

/**
 * 上一曲命令
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class PreviousCommand implements Command {
    /**
     * 命令接收者
     */
    private final MusicPlayer player;

    /**
     * 构造方法（初始化命令接收者）
     *
     * @param player 球员
     */
    public PreviousCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.previous();
    }
}
