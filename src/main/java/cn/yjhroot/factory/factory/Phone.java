package cn.yjhroot.factory.factory;

/**
 * 手机类 所有品牌手机的父类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class Phone {
    /**
     * 品牌
     */
    protected String brand;

    /**
     * 打电话方法
     */
    public void call() {
        System.out.println(brand + "牌的手机打电话");
    }
}
