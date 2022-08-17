package cn.yjhroot.bridge;

/**
 * 手机类（抽象角色 桥接重点类 通过该类桥接）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public abstract class Phone {
    /**
     * 应用程序接口具体实现对象
     */
    protected Application application;

    /**
     * 构造方法 提醒用户必须传入一个具体实现的对象
     *
     * @param application 应用程序
     */
    public Phone(Application application) {
        this.application = application;
    }

    /**
     * 语音助手
     */
    public void voiceHelper() {
        application.run();
    }
}
