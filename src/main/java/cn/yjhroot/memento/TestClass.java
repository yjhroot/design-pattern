package cn.yjhroot.memento;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class TestClass {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("状态1");

        Caretaker caretaker = new Caretaker();
        caretaker.storeMemento(originator.createMemento());
        System.out.println("备忘录中存的状态：" + caretaker.getMemento().getState());

        originator.setState("状态2");
        System.out.println("发起者中的最新状态：" + originator.getState());

        originator.restoreMemento(caretaker.getMemento());
        System.out.println("发起者恢复后的状态：" + originator.getState());
    }
}
