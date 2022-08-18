package cn.yjhroot.template;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class TestClass {
    public static void main(String[] args) {
        Template template1 = new GoToSchool();
        template1.doSomething();

        System.out.println("---------------------------");
        Template template2 = new GoHome();
        template2.doSomething();
    }
}
