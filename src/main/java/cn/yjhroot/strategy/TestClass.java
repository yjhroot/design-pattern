package cn.yjhroot.strategy;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建环境对象并设置策略
        Context context = new Context(new AddStrategy());
        context.call(1, 2);

        //切换策略
        context.setStrategy(new SubStrategy());
        context.call(1, 2);
    }
}
