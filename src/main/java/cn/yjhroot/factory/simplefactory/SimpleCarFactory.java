package cn.yjhroot.factory.simplefactory;

/**
 * 简单工厂类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class SimpleCarFactory {
    /**
     * 创建汽车的方法
     *
     * @param brand 品牌
     * @return {@link Car}
     */
    public Car createCar(String brand) {
        Car car;
        switch (brand) {
            case "奔驰":
                car = new Benz(brand);
                break;
            case "宝马":
                car = new Bmw(brand);
                break;
            default:
                car = new Car();
        }
        return car;
    }
}
