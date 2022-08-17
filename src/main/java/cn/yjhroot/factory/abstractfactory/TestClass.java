package cn.yjhroot.factory.abstractfactory;

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
        //苹果工厂创建苹果产品簇的所有产品
        AbstractFactory appleFactory = new AppleFactory();
        Computer appleComputer = appleFactory.createComputer();
        Pad applePad = appleFactory.createPad();
        appleComputer.show();
        applePad.show();

        //联想工厂创建联想产品簇的所有产品
        AbstractFactory lenovoFactory = new LenovoFactory();
        Computer lenovoComputer = lenovoFactory.createComputer();
        Pad lenovoPad = lenovoFactory.createPad();
        lenovoComputer.show();
        lenovoPad.show();
    }
}
