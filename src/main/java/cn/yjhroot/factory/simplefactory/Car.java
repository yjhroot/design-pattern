package cn.yjhroot.factory.simplefactory;

/**
 * 汽车类 所有汽车的父类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class Car {
    /**
     * 品牌
     */
    protected String brand;

    /**
     * 汽车跑方法
     */
    public void run() {
        System.out.println(brand + "牌的机车跑起来了！");
    }
}
