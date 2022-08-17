package cn.yjhroot.factory.factory;

/**
 * 手机工厂接口
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public interface PhoneFactory {
    /**
     * 创建手机方法
     *
     * @return {@link Phone}
     */
    Phone createPhone();
}
