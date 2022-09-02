package cn.yjhroot.interpreter;

/**
 * 非端点表达式抽象类
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public abstract class NonTerminalExpression implements Expression {
    /**
     * 端点表达式子类对象1
     */
    final Expression e1;
    /**
     * 端点表达式子类对象2
     */
    final Expression e2;

    /**
     * 构造方法（初始化端点表达式子类）
     *
     * @param e1 端点表达式子类对象1
     * @param e2 端点表达式子类对象2
     */
    protected NonTerminalExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
}
