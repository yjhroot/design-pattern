package cn.yjhroot.factory.abstractfactory;

/**
 * 联想个人电脑类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class LenovoComputer extends Computer {
    /**
     * 构造方法
     *
     * @param brand 品牌
     */
    public LenovoComputer(String brand) {
        this.brand = brand;
    }
}
