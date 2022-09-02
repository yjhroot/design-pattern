package cn.yjhroot.interpreter;

/**
 * 值表达式类
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public class ValueExpression extends TerminalExpression {
    /**
     * 构造方法
     *
     * @param key 键
     */
    public ValueExpression(String key) {
        super(key);
    }

    @Override
    public String interpreter(Context context) {
        return context.getValueByKey(key);
    }
}
