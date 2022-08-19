package cn.yjhroot.observer;

/**
 * 观察者接口
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Observer {
    /**
     * 更新
     * 接收被观察者发出的通知并更新的方法
     *
     * @param message 消息
     */
    void update(String message);
}
