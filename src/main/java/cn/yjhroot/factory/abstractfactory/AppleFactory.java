package cn.yjhroot.factory.abstractfactory;

/**
 * 苹果工厂
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public Computer createComputer() {
        return new AppleComputer("Macbook");
    }

    @Override
    public Pad createPad() {
        return new ApplePad("iPad");
    }
}
