package cn.yjhroot.factory.factory;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class TestClass {
    /**
     * main方法
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        //小米手机工厂创建小米手机
        PhoneFactory miPhoneFactory = new MiPhoneFactory();
        Phone miPhone = miPhoneFactory.createPhone();
        miPhone.call();

        //oppo手机工厂创建oppo手机
        PhoneFactory oppoPhoneFactory = new OppoPhoneFactory();
        Phone oppoPhone = oppoPhoneFactory.createPhone();
        oppoPhone.call();
    }
}
