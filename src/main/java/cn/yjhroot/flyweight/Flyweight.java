package cn.yjhroot.flyweight;

/**
 * 抽象享元类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public abstract class Flyweight {
    /**
     * 内部状态
     */
    private String intrinsic = "aaa";

    /**
     * 打印操作
     *
     * @return {@link String}
     */
    public abstract String print();

    /**
     * 获取内部状态
     *
     * @return {@link String}
     */
    public String getIntrinsic() {
        return intrinsic;
    }

    /**
     * 设置内部状态
     *
     * @param value 价值
     */
    public void setIntrinsic(String value) {
        this.intrinsic = value;
    }
}
