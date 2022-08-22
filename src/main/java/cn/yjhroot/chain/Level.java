package cn.yjhroot.chain;

/**
 * 处理等级枚举类（用于责任链对象判断是否应该处理请求）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public enum Level {
    /**
     * 等级1
     */
    LEVEL1,

    /**
     * 等级2
     */
    LEVEL2,

    /**
     * 等级3
     */
    LEVEL3,

    /**
     * 等级4（当前演示中没有对应的处理器）
     */
    LEVEL4
}
