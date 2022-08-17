package cn.yjhroot.factory.abstractfactory;

/**
 * 联想工厂
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class LenovoFactory implements AbstractFactory {
    @Override
    public Computer createComputer() {
        return new LenovoComputer("联想小新");
    }

    @Override
    public Pad createPad() {
        return new LenovoPad("联想小新");
    }
}
