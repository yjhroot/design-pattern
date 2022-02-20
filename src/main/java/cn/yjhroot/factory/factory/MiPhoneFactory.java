package cn.yjhroot.factory.factory;

/**
 * 小米手机工厂类 负责创建小米手机 功能单一
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class MiPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new MiPhone("小米");
    }
}
