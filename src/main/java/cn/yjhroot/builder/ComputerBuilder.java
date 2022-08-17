package cn.yjhroot.builder;

/**
 * 电脑建造者接口
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public interface ComputerBuilder {
    /**
     * 创建cpu
     */
    void createCpu();

    /**
     * 创建主板
     */
    void createMainBoard();

    /**
     * 创建键盘
     */
    void createKeyboard();

    /**
     * 创建内存
     */
    void createMemory();

    /**
     * 创建屏幕
     */
    void createScreen();

    /**
     * 创建鼠标
     */
    void createMouse();

    /**
     * 创建电脑
     *
     * @return {@link Computer}
     */
    Computer buildComputer();
}
