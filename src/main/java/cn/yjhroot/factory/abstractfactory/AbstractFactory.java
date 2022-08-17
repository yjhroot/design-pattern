package cn.yjhroot.factory.abstractfactory;

/**
 * 抽象工厂类 负责生产产品簇 功能全面
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public interface AbstractFactory {
    /**
     * 生产个人电脑的方法
     *
     * @return {@link Computer}
     */
    Computer createComputer();

    /**
     * 生产Pad的方法
     *
     * @return {@link Pad}
     */
    Pad createPad();
}
