package cn.yjhroot.visitor;

import java.util.List;

/**
 * 测试类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class TestClass {
    public static void main(String[] args) {
        AllAnimal allAnimal = new AllAnimal();
        List<Animal> animals = allAnimal.getAnimalList();

        System.out.println("喂动物：");
        for (Animal animal : animals) {
            animal.accept(new EatVisitor());
        }

        System.out.println("听动物叫声");
        for (Animal animal : animals) {
            animal.accept(new SoundVisitor());
        }
    }
}
