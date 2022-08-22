package cn.yjhroot.state;

/**
 * 状态接口
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public interface State {
    /**
     * 开灯方法
     */
    void open();

    /**
     * 关灯方法
     */
    void close();
}
