package cn.yjhroot.mediator;

/**
 * 具体同事类1
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(String id, Mediator mediator) {
        super(id, mediator);
    }

    @Override
    void receive(String fromId) {
        System.out.println("我的id是1，接收到来自id为:" + fromId + "发来的信息");
    }

    @Override
    void send(String targetId) {
        System.out.println("我的id是1，我要发送信息给id为：" + targetId + "的同事");
        mediator.transmit(this, targetId);
    }
}
