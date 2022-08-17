package cn.yjhroot.bridge;

/**
 * 相机应用（具体实现类）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class Camera implements Application {
    @Override
    public void run() {
        System.out.println("相机已经打开");
    }
}
