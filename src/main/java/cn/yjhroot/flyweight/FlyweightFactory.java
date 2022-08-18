package cn.yjhroot.flyweight;

import java.util.HashMap;

/**
 * 享元工厂类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class FlyweightFactory {
    /**
     * 享元对象池
     */
    private static final HashMap<String, Flyweight> POOL = new HashMap<>();

    /**
     * 根据外部状态（ID） 获取享元对象
     *
     * @param id id
     * @return {@link Flyweight}
     */
    public static Flyweight getFlyweight(String id) {
        Flyweight flyweight;
        // 如果池中存在 则直接返回池中对象
        if (POOL.containsKey(id)) {
            flyweight = POOL.get(id);
        } else {
            // 若不存在 则创建享元对象加入池
            flyweight = new ConcreteFlyweight(id);
            POOL.put(id, flyweight);
        }
        return flyweight;
    }

    /**
     * 获取池大小
     *
     * @return int
     */
    public static int getPoolSize() {
        return POOL.size();
    }
}
