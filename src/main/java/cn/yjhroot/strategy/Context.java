package cn.yjhroot.strategy;

/**
 * 上下文环境类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class Context {
    /**
     * 策略
     */
    private Strategy strategy;

    /**
     * 构造方法
     *
     * @param strategy 策略
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 调用策略的方法
     *
     * @param num1 num1
     * @param num2 num2
     */
    public void call(int num1, int num2) {
        strategy.calculate(num1, num2);
    }

    /**
     * 改变策略方法（可以不提供）
     *
     * @param strategy 策略
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
