package cn.yjhroot.interpreter;

/**
 * 端点表达式抽象类
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public abstract class TerminalExpression implements Expression {
    /**
     * 键
     */
    final String key;

    /**
     * 构造方法（设置键 用于在Context中查找对应值）
     *
     * @param key 关键
     */
    public TerminalExpression(String key) {
        this.key = key.trim();
    }
}
