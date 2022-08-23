package cn.yjhroot.memento;

/**
 * 管理者类（存储备忘录的地方）
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class Caretaker {
    /**
     * 备忘录对象（一般项目中 可以结合单例模式 使用map管理备忘录对象集合）
     */
    private Memento memento;

    /**
     * 存储备忘录对象
     *
     * @param memento 纪念品
     */
    public void storeMemento(Memento memento) {
        this.memento = memento;
    }

    /**
     * 获取存储的备忘录对象
     *
     * @return {@link Memento}
     */
    public Memento getMemento() {
        return memento;
    }
}
