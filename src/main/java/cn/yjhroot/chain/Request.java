package cn.yjhroot.chain;

/**
 * 请求类（为了统一处理方式 建议对请求进行封装）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class Request {
    /**
     * 每个请求都需要有一个等级 用于责任链对象判断是否应该处理该请求
     */
    private final Level level;

    /**
     * 构造方法（设置请求等级）
     *
     * @param level 等级
     */
    public Request(Level level) {
        this.level = level;
    }

    /**
     * 获取请求等级
     *
     * @return {@link Level}
     */
    public Level getLevel() {
        return level;
    }
}
