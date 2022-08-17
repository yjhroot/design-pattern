package cn.yjhroot.prototype;

/**
 * 腾讯邮件类（可复制原型的子类）
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class TencentMail extends Mail {
    /**
     * 构造方法 模拟创建对象很耗时
     */
    public TencentMail(Integer id) {
        this.id = id;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
