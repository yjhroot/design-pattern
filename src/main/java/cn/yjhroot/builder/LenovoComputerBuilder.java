package cn.yjhroot.builder;

/**
 * 联想电脑建造者实现类（实际建造者）
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class LenovoComputerBuilder implements ComputerBuilder {

    private final Computer lenovoComputer = new Computer();

    @Override
    public void createCpu() {
        lenovoComputer.setCpu("i5-1135G");
        System.out.println("造cpu");
    }

    @Override
    public void createMainBoard() {
        lenovoComputer.setMainBoard("华硕主板");
        System.out.println("造主板");
    }

    @Override
    public void createKeyboard() {
        lenovoComputer.setKeyboard("罗技键盘");
        System.out.println("造键盘");
    }

    @Override
    public void createMemory() {
        lenovoComputer.setMemory("金士顿16G内存");
        System.out.println("造内存");
    }

    @Override
    public void createScreen() {
        lenovoComputer.setScreen("三星显示器");
        System.out.println("造显示器");
    }

    @Override
    public void createMouse() {
        lenovoComputer.setMouse("小米鼠标");
        System.out.println("造鼠标");
    }

    @Override
    public Computer buildComputer() {
        return lenovoComputer;
    }
}
