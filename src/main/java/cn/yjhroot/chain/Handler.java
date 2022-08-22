package cn.yjhroot.chain;

/**
 * 责任链对象（处理器对象）的父类
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public abstract class Handler {
    /**
     * 继任者（下一个处理者）
     */
    private Handler successor;
    /**
     * 处理着等级 匹配请求等级则处理
     */
    private final Level handlerLevel;
    /**
     * 处理者处理方法对象（为的是不让外界使用handle方法 如果在本类中有handle方法 则外界可以使用 会跳过责任链的等级匹配）
     */
    private final HandlerMethod handlerMethod;

    /**
     * 构造方法（初始化处理器等级和接口实现类）
     *
     * @param handlerLevel 处理等级
     */
    public Handler(Level handlerLevel) throws Exception {
        this.handlerLevel = handlerLevel;
        // 强转 因为Handler子类同时也是该接口的实现类
        if (this instanceof HandlerMethod) {
            this.handlerMethod = (HandlerMethod) this;
        } else {
            this.handlerMethod = null;
            throw new Exception("初始化错误");
        }
    }

    /**
     * 设置下一个处理者 关键方法（通常不用构造方法设置 因为构造方法不够灵活 不便于修改）
     *
     * @param successor 下一个处理者
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 处理请求方法 关键方法 唯一的暴露的处理请求方法（根据处理器等级与请求等级 判断是否处理或传给下一个处理器）
     * 使用final修饰 因此子类不可修改控制流程
     *
     * @param request 请求
     * @return {@link Response}
     */
    public final Response handleRequest(Request request) {
        Response response;
        // 判断该请求是否由本处理者处理
        if (getHandlerLevel().equals(request.getLevel())) {
            // 断言
            assert handlerMethod != null;
            // 调用接口实现类的处理方法
            response = handlerMethod.handle(request);
        } else {
            // 如果处理等级不匹配 且有下一个处理者
            if (successor != null) {
                // 传递请求给下一个处理者
                response = successor.handleRequest(request);
            } else {
                // 没有下一个处理者 默认返回一个相应
                System.out.println("责任链末端了，没有处理者！");
                response = new Response();
            }
        }
        return response;
    }

    /**
     * 获取当前处理器等级
     *
     * @return {@link Level}
     */
    Level getHandlerLevel() {
        return handlerLevel;
    }
}
