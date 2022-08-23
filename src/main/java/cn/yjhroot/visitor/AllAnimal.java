package cn.yjhroot.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有动物类 ObjectStruture
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class AllAnimal {
    /**
     * 动物对象列表
     */
    List<Animal> animalList = new ArrayList<>();

    /**
     * 获取动物类对象列表
     *
     * @return {@link List}<{@link Animal}>
     */
    public List<Animal> getAnimalList() {
        animalList.add(new Cat());
        animalList.add(new Dog());
        return animalList;
    }
}
