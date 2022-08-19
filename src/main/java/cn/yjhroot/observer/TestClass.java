package cn.yjhroot.observer;

/**
 * @author YuJianHui
 * @date 2022/08/19
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建主题
        Subject subject = new ConcreteSubject();
        // 创建观察者
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        Observer observer3 = new ConcreteObserver();

        // 添加观察者
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);
        // 变更主题内容
        subject.doSomething("这是第一条消息");

        System.out.println("------------------");
        // 移除一个观察者
        subject.removeObserver(observer2);
        // 变更主题内容
        subject.doSomething("这是第二条消息");
    }
}
