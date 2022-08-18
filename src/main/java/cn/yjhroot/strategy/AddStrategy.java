package cn.yjhroot.strategy;

/**
 * 加法策略
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class AddStrategy implements Strategy {
    @Override
    public void calculate(int num1, int num2) {
        System.out.println("加法运算结果：" + (num1 + num2));
    }
}
