package cn.yjhroot.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * 邮件类（可复制原型）
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
@Getter
@Setter
public abstract class Mail implements Cloneable {
    /**
     * 邮件id
     */
    protected Integer id;

    /**
     * 重写Object的clone方法
     *
     * @return {@link Mail}
     */
    @Override
    protected Mail clone() {
        Mail mail;
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            mail = null;
            e.printStackTrace();
        }
        return mail;
    }
}
