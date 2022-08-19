package cn.yjhroot.iterator.black;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class TestClass {
    public static void main(String[] args) {
        Object[] array = {"1", "2", "3", "4", "5", "6"};
        Container myContainer = new ConcreteContainer(array);
        Iterator myIterator = myContainer.createIterator();

        while (myIterator.hasNext()) {
            System.out.println(myIterator.currentItem());
            myIterator.next();
        }
    }
}
