package cn.yjhroot.bridge;

/**
 * 小米手机（抽象类/桥接类的具体实现）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class MiPhone extends Phone {
    /**
     * 构造方法 提醒用户必须传入一个具体实现的对象
     *
     * @param application 应用程序
     */
    public MiPhone(Application application) {
        super(application);
    }

    @Override
    public void voiceHelper() {
        System.out.println("你好，我是小爱，请说出需要打开的app名称：__");
        System.out.println("相机");
        super.voiceHelper();
    }
}
