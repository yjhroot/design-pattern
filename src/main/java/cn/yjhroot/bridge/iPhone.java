package cn.yjhroot.bridge;

/**
 * 苹果手机（抽象类/桥接类的具体实现）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class iPhone extends Phone {
    /**
     * 构造方法 提醒用户必须传入一个具体实现的对象
     *
     * @param application 应用程序
     */
    public iPhone(Application application) {
        super(application);
    }

    @Override
    public void voiceHelper() {
        System.out.println("siri 打开音乐");
        super.voiceHelper();
    }
}
