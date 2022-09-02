package cn.yjhroot.interpreter;

/**
 * 表达式接口
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public interface Expression {
    /**
     * 解释方法
     *
     * @param context 上下文对象
     * @return {@link String}
     */
    String interpreter(Context context);
}
