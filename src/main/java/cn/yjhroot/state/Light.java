package cn.yjhroot.state;

/**
 * 灯类（环境类Context）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class Light {
    /**
     * 当前状态
     */
    State currentState;
    /**
     * 开灯状态
     */
    static final State OPEN_STATE = new OpenState();
    /**
     * 关灯状态
     */
    static final State CLOSE_STATE = new CloseState();

    /**
     * 构造方法 初始化当前状态
     *
     * @param currentState 当前状态
     */
    public Light(State currentState) {
        this.currentState = currentState;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    private void setState(State state) {
        this.currentState = state;
    }

    /**
     * 开灯方法
     */
    public void open() {
        try {
            currentState.open();
            // 成功则切换状态
            setState(OPEN_STATE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 关灯方法
     */
    public void close() {
        try {
            currentState.close();
            // 成功则切换状态
            setState(CLOSE_STATE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 获取当前状态
     *
     * @return {@link String}
     */
    public String getCurrentState() {
        return currentState.getClass().getName();
    }
}
