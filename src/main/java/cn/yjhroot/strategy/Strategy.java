package cn.yjhroot.strategy;

/**
 * 策略接口
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public interface Strategy {
    /**
     * 计算方法
     *
     * @param num1 数值1
     * @param num2 数值2
     */
    void calculate(int num1, int num2);
}
