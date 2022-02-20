package cn.yjhroot.prototype;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class TestClass {
    /**
     * main方法
     *
     * @param args 参数
     * @throws InterruptedException       异常
     * @throws CloneNotSupportedException 异常
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int objNum = 10;
        for (int i = 0; i < objNum; i++) {
            Mail mail = new TencentMail(i + 1);
            System.out.println("邮件Id:" + mail.getId());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("不使用原型拷贝耗时：" + (endTime - startTime) + "ms");

        Mail tencentMail = new TencentMail(1);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < objNum; i++) {
            Mail mail = tencentMail.clone();
            mail.setId(i + 1);
            System.out.println("邮件Id:" + mail.getId());
        }
        endTime = System.currentTimeMillis();
        System.out.println("使用原型拷贝耗时：" + (endTime - startTime) + "ms");
    }
}
