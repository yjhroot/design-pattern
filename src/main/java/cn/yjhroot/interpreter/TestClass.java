package cn.yjhroot.interpreter;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建环境对象
        Context context = new Context();
        // 设置当前环境下 不同的符号代表的意思
        context.setExpression("i", "我");
        context.setExpression("you", "你");

        // 调用当前环境对语句进行解释
        System.out.println("i.you" + " 解释为=》 " + context.translate("i.you"));
    }
}
