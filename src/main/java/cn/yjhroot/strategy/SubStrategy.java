package cn.yjhroot.strategy;

/**
 * 减法策略
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class SubStrategy implements Strategy {
    @Override
    public void calculate(int num1, int num2) {
        System.out.println("减法运算结果：" + (num1 - num2));
    }
}
