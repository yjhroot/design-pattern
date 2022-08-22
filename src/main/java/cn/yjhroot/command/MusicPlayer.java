package cn.yjhroot.command;

/**
 * 音乐播放器类（命令接收者Receiver）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class MusicPlayer {
    /**
     * 下一曲
     */
    public void next() {
        System.out.println("下一曲");
    }

    /**
     * 上一曲
     */
    public void previous() {
        System.out.println("上一曲");
    }
}
