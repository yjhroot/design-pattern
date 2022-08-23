package cn.yjhroot.memento;

/**
 * 发起者类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class Originator {
    /**
     * 内部状态 希望被保存的内容
     */
    private String state;

    /**
     * 获取当前状态
     *
     * @return {@link String}
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 创建备忘录
     *
     * @return {@link Memento}
     */
    public Memento createMemento() {
        return new Memento(state);
    }

    /**
     * 恢复状态（为什么不直接调用设置状态方法：语义区分 形参区分）
     *
     * @param memento 纪念品
     */
    public void restoreMemento(Memento memento) {
        setState(memento.getState());
    }
}
