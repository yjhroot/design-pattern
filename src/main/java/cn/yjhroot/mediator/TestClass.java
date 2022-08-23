package cn.yjhroot.mediator;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建中介者对象
        Mediator mediator = new ConcreteMediator();

        // 创建同事对象 并使用同一个中介者对象
        Colleague colleague1 = new ConcreteColleague1("1", mediator);
        Colleague colleague2 = new ConcreteColleague2("2", mediator);

        // 注册同事对象
        mediator.register(colleague1);
        mediator.register(colleague2);

        // 互相发送消息
        colleague1.send("2");
        System.out.println("------------------");
        colleague2.send("1");
    }
}
