package cn.yjhroot.chain;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class TestClass {
    public static void main(String[] args) {
        try {
            // 创建处理器
            Handler handler1 = new ConcreteHandler1(Level.LEVEL1);
            Handler handler2 = new ConcreteHandler2(Level.LEVEL2);
            Handler handler3 = new ConcreteHandler3(Level.LEVEL3);

            // 将处理器链接起来
            handler1.setSuccessor(handler2);
            handler2.setSuccessor(handler3);

            // 创建请求
            Request request = new Request(Level.LEVEL3);
            // 从处理器头传入请求
            handler1.handleRequest(request);

            // 创建不在处理器处理等级范围内的请求
            Request request2 = new Request(Level.LEVEL4);
            // 尝试处理 观察输出
            handler1.handleRequest(request2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
