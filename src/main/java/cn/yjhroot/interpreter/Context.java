package cn.yjhroot.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文类（存放当前环境下的一些公共信息
 * 当前demo中 存放的是端点表达式子类代表的意思 如”i“代表”我“
 * 也可以存放非端点表达式代表子类的一些信息 比如"."代表"爱" 此处为演示方便 没存
 * 同时 也可以放一些解释方法等）
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public class Context {
    /**
     * 端点表达式解释信息
     */
    private final Map<String, String> map = new HashMap<String, String>();

    /**
     * 设置表达式含义
     *
     * @param key   键
     * @param value 含义
     */
    public void setExpression(String key, String value) {
        map.put(key, value);
    }

    /**
     * 通过键 获取表达式含义
     *
     * @param key 关键
     * @return {@link String}
     */
    public String getValueByKey(String key) {
        return map.get(key);
    }

    /**
     * 翻译方法
     *
     * @param description 描述
     * @return {@link String} 根据描述得到的翻译
     */
    public String translate(String description) {
        // demo为了简化 直接解释了”.“用PointExpression类对象来解释 实际项目中 不同的表达式需要使用不同的表达式类来解释
        String[] strArray = description.split("\\.");
        Expression value1 = new ValueExpression(strArray[0]);
        Expression value2 = new ValueExpression(strArray[1]);
        return new PointExpression(value1, value2).interpreter(this);
    }
}
