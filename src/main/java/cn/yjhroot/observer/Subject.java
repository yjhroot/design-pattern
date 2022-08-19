package cn.yjhroot.observer;

/**
 * 主题接口（被观察者接口）
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Subject {
    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    void addObserver(Observer observer);

    /**
     * 删除观察者
     *
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();

    /**
     * 做某事
     *
     * @param message 消息
     */
    void doSomething(String message);
}
