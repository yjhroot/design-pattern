package cn.yjhroot.factory.abstractfactory;

/**
 * 个人电脑类 所有电脑类的父类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class Computer {
    /**
     * 品牌
     */
    protected String brand;

    /**
     * 显示方法
     */
    public void show() {
        System.out.println(brand + "牌的个人电脑展示画面");
    }
}
