package cn.yjhroot.composite;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class TestClass {
    public static void main(String[] args) {
        // 创建叶子节点
        Component leaf1 = new Leaf("叶子1");
        Component leaf2 = new Leaf("叶子2");
        Component leaf3 = new Leaf("叶子3");

        // 创建根节点
        Component root = new Composite("根节点");

        // 创建分支
        Component branchLeft = new Composite("左分支");
        Component branchRight = new Composite("右分支");

        // 根节点添加分支
        root.add(branchLeft);
        root.add(branchRight);

        // 分支节点添加叶子节点（注意不要递归添加本身）
        branchRight.add(leaf3);
        branchLeft.add(leaf1);
        branchLeft.add(leaf2);

        // 叶子节点each
        leaf1.each();
        System.out.println("--------------------------------");
        // 根节点each
        root.each();
    }
}
