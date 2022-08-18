package cn.yjhroot.template;

/**
 * 回家类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class GoHome extends Template {
    @Override
    public void step1() {
        System.out.println("收拾书包");
    }

    @Override
    public void step2() {
        System.out.println("打扫卫生");
    }

    @Override
    public void step3() {
        System.out.println("坐公交车");
    }
}
