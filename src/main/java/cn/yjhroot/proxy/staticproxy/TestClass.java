package cn.yjhroot.proxy.staticproxy;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建代理对象
        Subject proxy = new Proxy();
        // 调用代理对象的方法
        proxy.doSomething();
    }
}
