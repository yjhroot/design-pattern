package cn.yjhroot.iterator.white;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class TestClass {
    public static void main(String[] args) {
        Object[] array = {"A", "B", "C", "D", "E", "F"};
        Container myContainer = new ConcreteContainer(array);
        Iterator myIterator = myContainer.createIterator();

        while (myIterator.hasNext()) {
            System.out.println(myIterator.currentItem());
            myIterator.next();
        }
    }
}
