package cn.yjhroot.interpreter;

/**
 * 点表达式类
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public class PointExpression extends NonTerminalExpression {
    /**
     * 构造方法
     *
     * @param e1 端点表达式对象1
     * @param e2 端点表达式对象2
     */
    protected PointExpression(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public String interpreter(Context context) {
        // 将”.“翻译成”爱“ 并链接两个端点表达式
        return e1.interpreter(context) + "爱" + e2.interpreter(context);
    }
}
