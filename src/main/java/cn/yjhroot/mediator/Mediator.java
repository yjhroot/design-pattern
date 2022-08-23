package cn.yjhroot.mediator;

/**
 * 中介者接口
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public interface Mediator {
    /**
     * 注册同事对象方法
     *
     * @param colleague 同事对象
     */
    void register(Colleague colleague);

    /**
     * 转发方法
     *
     * @param fromColleague 信息来源
     * @param targetId      目标id
     */
    void transmit(Colleague fromColleague, String targetId);
}
