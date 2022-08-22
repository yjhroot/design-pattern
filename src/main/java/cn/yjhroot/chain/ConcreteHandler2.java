package cn.yjhroot.chain;

/**
 * 具体处理者类2 必须实现HandlerMethod接口 否则无法工作
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class ConcreteHandler2 extends Handler implements HandlerMethod {
    /**
     * 构造方法（初始化处理器等级）
     *
     * @param handlerLevel 处理等级
     */
    public ConcreteHandler2(Level handlerLevel) throws Exception {
        super(handlerLevel);
    }

    @Override
    public Response handle(Request request) {
        System.out.println("我是2号处理者，处理了该请求。");
        return null;
    }
}
