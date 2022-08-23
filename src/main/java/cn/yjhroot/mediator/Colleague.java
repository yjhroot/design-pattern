package cn.yjhroot.mediator;

/**
 * 抽象同事类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public abstract class Colleague {
    /**
     * 对象id
     */
    private final String id;
    /**
     * 使用的中介者对象
     */
    final Mediator mediator;

    public Colleague(String id, Mediator mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    /**
     * 获取id
     *
     * @return {@link String}
     */
    public String getId() {
        return id;
    }

    /**
     * 接收中介者转发信息的方法
     *
     * @param fromId 来源id
     */
    abstract void receive(String fromId);

    /**
     * 发送信息到中介者的方法
     *
     * @param targetId 目标id
     */
    abstract void send(String targetId);
}
