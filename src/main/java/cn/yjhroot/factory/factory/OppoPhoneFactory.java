package cn.yjhroot.factory.factory;

/**
 * Oppo手机工厂类 负责创建Oppo手机 功能单一
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class OppoPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new OppoPhone("Oppo");
    }
}
