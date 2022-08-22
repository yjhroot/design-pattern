package cn.yjhroot.state;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建状态
        State state = new OpenState();
        // 为环境设置初始状态
        Light light = new Light(state);

        System.out.println("当前状态：" + light.getCurrentState());
        light.open();
        light.close();

        System.out.println("---------------------------");
        System.out.println("当前状态：" + light.getCurrentState());
        light.close();
        light.open();
    }
}
