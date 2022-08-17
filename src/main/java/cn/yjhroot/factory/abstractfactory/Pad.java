package cn.yjhroot.factory.abstractfactory;

/**
 * Pad类 所有Pad的父类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class Pad {
    /**
     * 品牌
     */
    protected String brand;

    /**
     * 显示方法
     */
    public void show() {
        System.out.println(brand + "牌的Pad展示画面");
    }
}
