package cn.yjhroot.builder;

/**
 * 联想电脑创建的导演类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class LenovoComputerBuilderDirector {
    /**
     * 联想电脑建造者实现类对象
     */
    private final ComputerBuilder lenovoComputerBuilder = new LenovoComputerBuilder();

    /**
     * 获取联想电脑
     * 指挥建造者按步骤建造电脑对象
     * 顺序：造主板、造cpu、造内存、造屏幕、造键盘、造鼠标
     *
     * @return {@link Computer}
     */
    public Computer getLenovoComputer() {
        lenovoComputerBuilder.createMainBoard();
        lenovoComputerBuilder.createCpu();
        lenovoComputerBuilder.createMemory();
        lenovoComputerBuilder.createScreen();
        lenovoComputerBuilder.createKeyboard();
        lenovoComputerBuilder.createMouse();
        return lenovoComputerBuilder.buildComputer();
    }
}
