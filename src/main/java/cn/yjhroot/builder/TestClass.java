package cn.yjhroot.builder;

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
        LenovoComputerBuilderDirector director = new LenovoComputerBuilderDirector();
        Computer lenovoComputer = director.getLenovoComputer();
        System.out.println(lenovoComputer);
    }
}
