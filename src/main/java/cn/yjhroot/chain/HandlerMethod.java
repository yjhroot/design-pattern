package cn.yjhroot.chain;

/**
 * 处理方法接口
 * （为什么不把handle方法写在Handler类中：因为在类中要让子类重写 那么用protected关键字后 外界可以调用Handler的handle方法 跳过了等级匹配）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public interface HandlerMethod {
    /**
     * 处理方法
     *
     * @param request 请求
     * @return {@link Response}
     */
    Response handle(Request request);
}
