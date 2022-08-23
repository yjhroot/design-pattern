package cn.yjhroot.memento;

/**
 * 备忘录类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class Memento {
    /**
     * 被保存的状态 与发起者内部状态对应
     */
    private final String state;

    /**
     * 构造方法
     *
     * @param state 被保存的状态
     */
    public Memento(String state) {
        this.state = state;
    }

    /**
     * 获取当前保存的状态信息
     *
     * @return {@link String}
     */
    public String getState() {
        return state;
    }
}
