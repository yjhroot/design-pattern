package cn.yjhroot.bridge;

/**
 * 音乐应用（具体实现类）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class Music implements Application {
    @Override
    public void run() {
        System.out.println("音乐已播放");
    }
}
