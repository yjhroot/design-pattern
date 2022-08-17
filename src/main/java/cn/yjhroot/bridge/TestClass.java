package cn.yjhroot.bridge;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建应用程序为相机
        Application application = new Camera();
        // 创建小米手机
        Phone phone = new MiPhone(application);
        // 使用语音助手
        phone.voiceHelper();

        System.out.println("--------------------------------");
        // 创建新的应用程序
        application = new Music();
        // 创建苹果手机
        phone = new iPhone(application);
        // 使用语音助手
        phone.voiceHelper();
    }
}
