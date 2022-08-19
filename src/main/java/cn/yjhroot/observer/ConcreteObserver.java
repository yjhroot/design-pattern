package cn.yjhroot.observer;

/**
 * 具体观察者类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("接受到了新的消息：" + message);
    }
}
