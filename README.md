# 23种设计模式

## 文章地址

[23种设计模式](https://blog.csdn.net/achacker/article/details/126378416)

## 目录

1. [单例模式](./src/main/java/cn/yjhroot/singleton)
2. [工厂模式](./src/main/java/cn/yjhroot/factory)（简单工厂、工厂方法、抽象方法）
3. [建造者模式](./src/main/java/cn/yjhroot/builder)
4. [原型模式](./src/main/java/cn/yjhroot/prototype)
5. [适配器模式](./src/main/java/cn/yjhroot/adapter)
6. [装饰模式](./src/main/java/cn/yjhroot/decorator)
7. [代理模式](./src/main/java/cn/yjhroot/proxy)
8. [外观模式](./src/main/java/cn/yjhroot/facade)
9. [桥接模式](./src/main/java/cn/yjhroot/bridge)
10. [组合模式](./src/main/java/cn/yjhroot/composite)
11. [享元模式](./src/main/java/cn/yjhroot/flyweight)
12. [策略模式](./src/main/java/cn/yjhroot/strategy)
13. [模板模式](./src/main/java/cn/yjhroot/template)
14. [观察者模式](./src/main/java/cn/yjhroot/observer)
15. [迭代子模式](./src/main/java/cn/yjhroot/iterator)
16. [责任链模式](./src/main/java/cn/yjhroot/chain)
17. [命令模式](./src/main/java/cn/yjhroot/command)
18. [状态模式](./src/main/java/cn/yjhroot/state)
19. [备忘录模式](./src/main/java/cn/yjhroot/memento)
20. [访问者模式](./src/main/java/cn/yjhroot/visitor)
21. [中介者模式](./src/main/java/cn/yjhroot/mediator)
22. [解释器模式](./src/main/java/cn/yjhroot/interpreter)

---

# 模式分类（3大类）

## 创建型模式（共5种）

工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式

## 结构型模式（共7种）

适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式

## 行为型模式（共11种）

策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式

---

# 模式理解思维导图

图片转载于「万猫学社」 来源链接：https://blog.csdn.net/heihaozi/article/details/120224374

![模式理解思维导图](https://img-blog.csdnimg.cn/88b6b44d914f4ae6b1fd505e85d857ed.png#pic_center)

---

# 一、单例模式

## 定义

一个类有且仅有一个实例，并且自行实例化向整个系统提供。

## 针对问题

单例模式主要是为了避免因为创建了多个实例造成资源的浪费，且多个实例由于多次调用容易导致结果出现错误，而使用单例模式能够保证整个应用中有且只有一个实例。

## 模式分类

1. 饿汉式：在类加载阶段就实例化，预占用内存，大对象慎用
2. 懒汉式：在使用对象时才实例化，不预占用内存
3. 枚举式：线程安全，书写简单

## 实现步骤

1. 私有化构造方法，不允许new创建实例
2. 在该类中自己创建实例
3. 在该类中提供一个公有方法，使其他使用者可以获取该实例

## 实现代码

### 1. SingleObject1为饿汉式，线程安全，效率高

```java
/**
 * 饿汉式单例类
 * 优点：没有加锁，执行效率会提高，线程安全
 * 缺点：类加载时就初始化，浪费内存
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject1 {
    /**
     * 单例对象
     */
    private static final SingleObject1 INSTANCE = new SingleObject1();

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject1() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法
     *
     * @return {@link SingleObject1}
     */
    public static SingleObject1 getInstance() {
        return INSTANCE;
    }
}
```

### 2. SingleObject2为懒汉式，线程不安全

```java
/**
 * 懒汉式单例类
 * 优点：不浪费内存，没有加锁，执行效率会提高
 * 缺点：类加载时没有初始化，线程不安全
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject2 {
    /**
     * 单例对象
     */
    private static SingleObject2 instance;

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject2() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法
     *
     * @return {@link SingleObject2}
     */
    public static SingleObject2 getInstance() {
        if (instance == null) {
            instance = new SingleObject2();
        }
        return instance;
    }
}
```

### 3. SingleObject3为懒汉式，线程安全，效率低（锁）

```java
/**
 * 懒汉式单例类
 * 优点：不浪费内存，加锁，线程安全
 * 缺点：类加载时没有初始化，整个获取单例对象的方法加锁，每次获取对象都要锁，执行效率低
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject3 {
    /**
     * 单例对象
     */
    private static SingleObject3 instance;

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject3() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法（加锁，线程安全，效率不高）
     *
     * @return {@link SingleObject3}
     */
    public static synchronized SingleObject3 getInstance() {
        if (instance == null) {
            instance = new SingleObject3();
        }
        return instance;
    }
}
```

### 4. SingleObject4为懒汉式，线程安全，效率高（双重验证）

```java
/**
 * 懒汉式单例类
 * 优点：不浪费内存，加锁，线程安全
 * 缺点：类加载时没有初始化，在获取单例对象的方中，只在第一次判断对象为null时加锁，效率高
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject4 {
    /**
     * 单例对象
     */
    private static volatile SingleObject4 instance;

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject4() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法（加锁，线程安全，效率高）
     *
     * @return {@link SingleObject4}
     */
    public static SingleObject4 getInstance() {
        if (instance == null) {
            synchronized (SingleObject4.class) {
                if (instance == null) {
                    instance = new SingleObject4();
                }
            }
        }
        return instance;
    }
}
```

### 5. SingleObject5为懒汉式，线程安全，效率高（内部类）**推荐**

```java
/**
 * 懒汉式单例类
 * 优点：不浪费内存，不加锁，线程安全
 * 缺点：有内部类（可忽略不算缺点）
 *
 * @author YuJianHui
 * @date 2022/02/19
 */
public class SingleObject5 {
    /**
     * 内部类（加载外部类时，内部类不会加载，只有在使用时才会加载）
     *
     * @author YuJianHui
     * @date 2022/02/19
     */
    private static class InnerClass {
        /**
         * 内部类静态对象
         */
        private static final SingleObject5 INSTANCE = new SingleObject5();
    }

    /**
     * 私有化构造方法（防止new对象）
     */
    private SingleObject5() {
        System.out.println("创建对象");
    }

    /**
     * 获取单例对象方法（线程安全，效率高）
     *
     * @return {@link SingleObject5}
     */
    public static synchronized SingleObject5 getInstance() {
        return InnerClass.INSTANCE;
    }
}
```

### 6. SingleObject6为枚举式，线程安全，效率高，书写简单 **推荐**

```java
/**
 * 枚举单例类
 * 优点：不加锁，线程安全，书写简单
 * 缺点：对初学者难以理解
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public enum SingleObject6 {
    /**
     * SingleObject6类实例
     */
    INSTANCE;

    /**
     * 私有化的构造方法 JVM保证只调用一次
     */
    SingleObject6() {
        System.out.println("创建对象");
    }

    /**
     * 任意方法（实例方法）
     */
    public void doSomething() {
    }
}
```

## 获取单例对象方式

除枚举单例对象获取方式为`SingleObject6.INSTANCE::doSomething`外，其他单例模式都是使用其提供的`类名.getInstance()`
静态方法来获取单例对象。

---

# 二\三、工厂模式

## 定义

工厂模式是我们最常用的实例化对象模式了，是用工厂方法代替new操作的一种模式。在工厂模式中，我们创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。

## 针对问题

许多类型对象的创建都需要一系列的步骤，可能需要计算或取得对象的初始设置，选择生成哪个子对象实例，或者在生成需要的对象之前必须先生成一些辅助功能的对象，这些情况下，对象的建立就是一个复杂的过程，这些过程夹在在业务逻辑中，会使代码结构不清晰，难以理解，且代码耦合度高，因此可以把创建对象的过程封装起来，形成工厂工厂模式。

## 模式分类

1. 简单工厂模式
2. 工厂方法模式
3. 抽象工厂模式

## 模式区别

1. 在简单工厂中，工厂负责所有产品子类对象的创建，当创建逻辑复杂时，方法会显得非常复杂，维护不方便，类似于上帝类。
2. 在工厂方法中，工厂负责单一产品实例的创建，功能单一，且每创建一种产品，就需要创建对应的工厂，当产品数量庞大时，工厂类也对应增加，不便于维护。
3. 在抽象工厂中，工厂负责一类产品簇实例的创建，把有共同点（如品牌相同）的产品创建方法放置于工厂中，减少了工厂类，便于维护。

## 1、简单工厂模式

### 实现步骤

1. 创建一个待生产产品的父类
2. 为上述父类创建子类
3. 创建一个生产工厂，在工厂中提供一个获取父类实例的方法
4. 在上述方法中，根据不同的参数，创建出不同的子类对象

### UML类图

![简单工厂模式类图](https://img-blog.csdnimg.cn/f3f4bf5eb60d405da4aa321d3f2e371b.png#pic_center)

### 实现代码

```java
/**
 * 汽车类 所有汽车的父类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class Car {
    /**
     * 品牌
     */
    protected String brand;

    /**
     * 汽车跑方法
     */
    public void run() {
        System.out.println(brand + "牌的机车跑起来了！");
    }
}

public class Benz extends Car {
    /**
     * 构造方法
     *
     * @param brand 品牌
     */
    public Benz(String brand) {
        this.brand = brand;
    }
}

public class Bmw extends Car {
    /**
     * 构造方法
     *
     * @param brand 品牌
     */
    public Bmw(String brand) {
        this.brand = brand;
    }
}

/**
 * 简单工厂类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class SimpleCarFactory {
    /**
     * 创建汽车的方法
     *
     * @param brand 品牌
     * @return {@link Car}
     */
    public Car createCar(String brand) {
        Car car;
        switch (brand) {
            case "奔驰":
                car = new Benz(brand);
                break;
            case "宝马":
                car = new Bmw(brand);
                break;
            default:
                car = new Car();
        }
        return car;
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        SimpleCarFactory simpleFactory = new SimpleCarFactory();
        Car benz = simpleFactory.createCar("奔驰");
        benz.run();
        Car bmw = simpleFactory.createCar("宝马");
        bmw.run();
    }
}
------输出------
        奔驰牌的机车跑起来了！
        宝马牌的机车跑起来了！
```

## 2、工厂方法模式

### 实现步骤

1. 创建一个待生产产品的父类
2. 为上述父类创建子类
3. 创建一个工厂接口，在接口中提供一个获取产品父类实例的方法
4. 为工厂接口创建生产不同产品的工厂实现类
5. 利用上述创建的工厂实现类，创建不同的产品

### UML类图

![工厂方法模式类图](https://img-blog.csdnimg.cn/a355e380d25444d3964e5a46f73099c4.png#pic_center)

### 实现代码

```java
/**
 * 手机类 所有品牌手机的父类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class Phone {
    /**
     * 品牌
     */
    protected String brand;

    /**
     * 打电话方法
     */
    public void call() {
        System.out.println(brand + "牌的手机打电话");
    }
}

public class MiPhone extends Phone {
    /**
     * 构造方法
     *
     * @param brand 品牌
     */
    public MiPhone(String brand) {
        this.brand = brand;
    }
}

public class OppoPhone extends Phone {
    /**
     * 构造方法
     *
     * @param brand 品牌
     */
    public OppoPhone(String brand) {
        this.brand = brand;
    }
}
```

```java
/**
 * 手机工厂接口
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public interface PhoneFactory {
    /**
     * 创建手机方法
     *
     * @return {@link Phone}
     */
    Phone createPhone();
}

public class MiPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new MiPhone("小米");
    }
}

public class OppoPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new OppoPhone("Oppo");
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        //小米手机工厂创建小米手机
        PhoneFactory miPhoneFactory = new MiPhoneFactory();
        Phone miPhone = miPhoneFactory.createPhone();
        miPhone.call();

        //oppo手机工厂创建oppo手机
        PhoneFactory oppoPhoneFactory = new OppoPhoneFactory();
        Phone oppoPhone = oppoPhoneFactory.createPhone();
        oppoPhone.call();
    }
}
------输出------
        小米牌的手机打电话
        Oppo牌的手机打电话
```

## 3、抽象方法模式

### 实现步骤

1. 创建待生产产品簇的父类
2. 为上述父类创建子类
3. 创建一个工厂接口，在接口中提供一个获取产品簇父类实例的方法
4. 为工厂接口创建生产不同产品簇的工厂实现类
5. 利用上述创建的工厂实现类，创建不同的产品簇

### UML类图

![抽象工厂模式类图](https://img-blog.csdnimg.cn/e4f1c792b50a48d8af4d73eb4e55941a.png#pic_center)

### 实现代码

```java
/**
 * 个人电脑类 所有电脑类的父类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class Computer {
    /**
     * 品牌
     */
    protected String brand;

    /**
     * 显示方法
     */
    public void show() {
        System.out.println(brand + "牌的个人电脑展示画面");
    }
}

/**
 * Pad类 所有Pad的父类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class Pad {
    /**
     * 品牌
     */
    protected String brand;

    /**
     * 显示方法
     */
    public void show() {
        System.out.println(brand + "牌的Pad展示画面");
    }
}

public class AppleComputer extends Computer {
    public AppleComputer(String brand) {
        this.brand = brand;
    }
}

public class LenovoComputer extends Computer {
    public LenovoComputer(String brand) {
        this.brand = brand;
    }
}

public class ApplePad extends Pad {
    public ApplePad(String brand) {
        this.brand = brand;
    }
}

public class LenovoPad extends Pad {
    public LenovoPad(String brand) {
        this.brand = brand;
    }
}
```

```java
/**
 * 抽象工厂类 负责生产产品簇 功能全面
 * @author YuJianHui
 * @date 2022/02/20
 */
public interface AbstractFactory {
    /**
     * 生产个人电脑的方法
     * @return {@link Computer}
     */
    Computer createComputer();

    /**
     * 生产Pad的方法
     * @return {@link Pad}
     */
    Pad createPad();
}

public class AppleFactory implements AbstractFactory {
    @Override
    public Computer createComputer() {
        return new AppleComputer("Macbook");
    }

    @Override
    public Pad createPad() {
        return new ApplePad("iPad");
    }
}

public class LenovoFactory implements AbstractFactory {
    @Override
    public Computer createComputer() {
        return new LenovoComputer("联想小新");
    }

    @Override
    public Pad createPad() {
        return new LenovoPad("联想小新");
    }
}
```

```java
public class TestClass {

    public static void main(String[] args) {
        //苹果工厂创建苹果产品簇的所有产品
        AbstractFactory appleFactory = new AppleFactory();
        Computer appleComputer = appleFactory.createComputer();
        Pad applePad = appleFactory.createPad();
        appleComputer.show();
        applePad.show();

        //联想工厂创建联想产品簇的所有产品
        AbstractFactory lenovoFactory = new LenovoFactory();
        Computer lenovoComputer = lenovoFactory.createComputer();
        Pad lenovoPad = lenovoFactory.createPad();
        lenovoComputer.show();
        lenovoPad.show();
    }
}
------输出------
        Macbook牌的个人电脑展示画面
        iPad牌的Pad展示画面
        联想小新牌的个人电脑展示画面
        联想小新牌的Pad展示画面
```

---

# 四、建造者模式

## 定义

封装一个复杂对象构造过程，并允许按步骤构造。

## 针对问题

假设我们有一个对象需要建立，这个对象是由多个组件（Component）组合而成，每个组件的建立都比较复杂,并且有先后顺序的要求，此时，如果让对象的使用者去创建对象，那么将变得非常困难。如果用建造者模式来获取对象，则会非常简单，因为我们**
可以将构建复杂对象的步骤交给指挥者（Director），对象组件构建方法交给建造者（Builder）**，这样就很轻松的完成了复杂对象的创建。

## 实现步骤

1. 创建复杂对象类（如：Computer类，包含许多组件，假设每个组件的创建都很复杂）
2. 创建建造者接口（如：ComputerBuilder），指定需要提供创建组件的方法
3. 创建建造者类的具体实现类（如：LenovoComputerBuilder），实现复杂组件的创建并返回复杂对象
4. 创建指挥者类（如：LenovoComputerBuilderDirector），指挥创建者具体实现类**按步骤构建复杂对象**
5. 使用复杂对象

## UML类图

![建造者模式类图](https://img-blog.csdnimg.cn/5deb761445694d2ca9d80a13886e0259.png#pic_center)

## 实现代码

```java
/**
 * 电脑类（产品）
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
@Data
public class Computer {
    /**
     * cpu
     */
    private String cpu;

    /**
     * 主板
     */
    private String mainBoard;

    /**
     * 键盘
     */
    private String keyboard;

    /**
     * 内存
     */
    private String memory;

    /**
     * 显示器
     */
    private String screen;

    /**
     * 鼠标
     */
    private String mouse;
}

/**
 * 电脑建造者接口
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public interface ComputerBuilder {
    /**
     * 创建cpu
     */
    void createCpu();

    /**
     * 创建主板
     */
    void createMainBoard();

    /**
     * 创建键盘
     */
    void createKeyboard();

    /**
     * 创建内存
     */
    void createMemory();

    /**
     * 创建屏幕
     */
    void createScreen();

    /**
     * 创建鼠标
     */
    void createMouse();

    /**
     * 创建电脑
     *
     * @return {@link Computer}
     */
    Computer buildComputer();
}

/**
 * 联想电脑建造者实现类（实际建造者）
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class LenovoComputerBuilder implements ComputerBuilder {

    private final Computer lenovoComputer = new Computer();

    @Override
    public void createCpu() {
        lenovoComputer.setCpu("i5-1135G");
        System.out.println("造cpu");
    }

    @Override
    public void createMainBoard() {
        lenovoComputer.setMainBoard("华硕主板");
        System.out.println("造主板");
    }

    @Override
    public void createKeyboard() {
        lenovoComputer.setKeyboard("罗技键盘");
        System.out.println("造键盘");
    }

    @Override
    public void createMemory() {
        lenovoComputer.setMemory("金士顿16G内存");
        System.out.println("造内存");
    }

    @Override
    public void createScreen() {
        lenovoComputer.setScreen("三星显示器");
        System.out.println("造显示器");
    }

    @Override
    public void createMouse() {
        lenovoComputer.setMouse("小米鼠标");
        System.out.println("造鼠标");
    }

    @Override
    public Computer buildComputer() {
        return lenovoComputer;
    }
}

/**
 * 联想电脑创建的导演类
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class LenovoComputerBuilderDirector {
    /**
     * 联想电脑建造者实现类对象
     */
    private final ComputerBuilder lenovoComputerBuilder = new LenovoComputerBuilder();

    /**
     * 获取联想电脑
     * 指挥建造者按步骤建造电脑对象
     * 顺序：造主板、造cpu、造内存、造屏幕、造键盘、造鼠标
     *
     * @return {@link Computer}
     */
    public Computer getLenovoComputer() {
        lenovoComputerBuilder.createMainBoard();
        lenovoComputerBuilder.createCpu();
        lenovoComputerBuilder.createMemory();
        lenovoComputerBuilder.createScreen();
        lenovoComputerBuilder.createKeyboard();
        lenovoComputerBuilder.createMouse();
        return lenovoComputerBuilder.buildComputer();
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        LenovoComputerBuilderDirector director = new LenovoComputerBuilderDirector();
        Computer lenovoComputer = director.getLenovoComputer();
        System.out.println(lenovoComputer);
    }
}
------输出------
        造主板
        造cpu
        造内存
        造显示器
        造键盘
        造鼠标
        Computer(cpu=i5-1135G,mainBoard=华硕主板,keyboard=罗技键盘,memory=金士顿16G内存,screen=三星显示器,mouse=小米鼠标)
```

---

# 五、原型模式

## 定义

用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。

## 针对问题

主要用于对象的复制。类初始化需要消化非常多的资源，这个资源包括数据、硬件资源，这时可以用原型模式拷贝。使用对象时，不能使用原对象，就可以克隆一个一模一样的对象，也可以使用原型模式。

## 实现步骤

1. 创建一个需要拷贝的原型类prototype（如：Mail），实现Cloneable接口，重写其父类Object的clone方法
2. 为原型类创建子类，完成相应的业务
3. 当需要克隆对象时，使用对象的clone()方法进行克隆

## 注意事项

1. 注意区分浅拷贝和深拷贝，基本类型对象的拷贝，无论深浅，都会创建一个新的对象，而包装类型的对象如果进行浅拷贝，指挥将原对象的地址指向其引用，只有深拷贝才能创建新的对象。
2. 如果被拷贝对象中有包装类型的字段，必须在重写clone()方法内进行深拷贝，如有List<?>类型的字段等。

## UML类图

![原型模式类图](https://img-blog.csdnimg.cn/9256e62e40f4441c9aad8f35888f1fe6.png#pic_center)

## 实现代码

```java
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

/**
 * 腾讯邮件类（可复制原型的子类）
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
public class TencentMail extends Mail {
    /**
     * 构造方法 模拟创建对象很耗时
     */
    public TencentMail(Integer id) {
        this.id = id;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int objNum = 10;
        for (int i = 0; i < objNum; i++) {
            Mail mail = new TencentMail(i + 1);
            System.out.println("邮件Id:" + mail.getId());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("不使用原型拷贝耗时：" + (endTime - startTime) + "ms");

        Mail tencentMail = new TencentMail(1);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < objNum; i++) {
            Mail mail = tencentMail.clone();
            mail.setId(i + 1);
            System.out.println("邮件Id:" + mail.getId());
        }
        endTime = System.currentTimeMillis();
        System.out.println("使用原型拷贝耗时：" + (endTime - startTime) + "ms");
    }
}
------输出------
        邮件Id:1
        邮件Id:2
        邮件Id:3
        邮件Id:4
        邮件Id:5
        邮件Id:6
        邮件Id:7
        邮件Id:8
        邮件Id:9
        邮件Id:10
        不使用原型拷贝耗时：3107ms
        邮件Id:1
        邮件Id:2
        邮件Id:3
        邮件Id:4
        邮件Id:5
        邮件Id:6
        邮件Id:7
        邮件Id:8
        邮件Id:9
        邮件Id:10
        使用原型拷贝耗时：2ms
```

---

# 六、适配器模式

## 定义

适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。

## 针对问题

有两个正常工作的接口或类，但是它们之间的方法不兼容，不能一起工作，因此需要一个适配者，将两者进行适配。

## 模式分类

1. 类适配器：继承源类，实现目标接口。
2. 对象适配器：实现目标接口，使用源类的对象（关联关系）。

## 模式区别

1. 类适配器：代码简单，但耦合度高。
2. 对象适配器：代码复杂，但耦合度低。

## 实现步骤

1. 创建两个正常工作的接口或抽象类，分别实现或继承。
2. 创建适配者，如果使用类适配，则继承抽象类并实现目标接口；如果使用对象适配，则实现目标接口，使用源类的对象。

## 类说明

1. Adapter为类适配器
2. Adapter1为对象适配器

## UML类图

![适配器模式类图](https://img-blog.csdnimg.cn/b51b6b4795d340a5854e0cf8bdeade50.png#pic_center)

```java
/**
 * 目标接口
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public interface Target {
    /**
     * 低压充电方法
     */
    void lowVoltageCharge();
}

/**
 * 源抽象类（被适配者）
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public abstract class Adaptee {
    /**
     * 高电压充电方法
     */
    void highVoltageCharge() {
    }
}

/**
 * 目标实现类
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class TargetImpl implements Target {
    @Override
    public void lowVoltageCharge() {
        System.out.println("进行低压充电。。。");
    }
}

/**
 * 被适配者子类
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class AdapteeChild extends Adaptee {
    @Override
    public void highVoltageCharge() {
        System.out.println("进行高压充电。。。");
    }
}
```

```java
/**
 * 适配器类（类适配器）
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void lowVoltageCharge() {
        // 把高压转换成低压
        super.highVoltageCharge();
        System.out.println("高压转低压");
        System.out.println("进行低压充电。。。");
    }
}

/**
 * 适配器类（对象适配器）
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class Adapter1 implements Target {
    /**
     * 被适配者对象
     */
    private final Adaptee adaptee;

    /**
     * 构造方法
     *
     * @param adaptee adaptee
     */
    public Adapter1(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void lowVoltageCharge() {
        adaptee.highVoltageCharge();
        System.out.println("高压转低压1");
        System.out.println("低压充电中1。。。");
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 原有低压充电方法
        Target target1 = new TargetImpl();
        target1.lowVoltageCharge();
        System.out.println("------------------");

        // 适配后的高压转低压充电方法（类适配）
        Target target2 = new Adapter();
        target2.lowVoltageCharge();
        System.out.println("------------------");

        // 适配后的高压转低压充电方法（对象适配）
        Target target3 = new Adapter1(new AdapteeChild());
        target3.lowVoltageCharge();
    }
}
------输出------
        进行低压充电。。。
        ------------------
        高压转低压
        进行低压充电。。。
        ------------------
        进行高压充电。。。
        高压转低压1
        低压充电中1。。。
```

---

# 七、装饰模式

## 定义

动态的给一个对象添加一些额外的职责。就增加功能来说，装饰模式相比生成子类更为灵活。

## 针对问题

需要给某个对象添加额外的功能，而又不想改变原有对象的类。

## 实现步骤

1. 创建一个原有对象类（或接口），实现某些原有功能。
2. 创建一个装饰类，继承（或实现）原有对象类，然后将原有对象作为其属性，通过构造方法实例化，并且有一些额外的功能。
3. 在装饰类中，重写原有对象类的方法，并在其中调用（增加）额外的功能。
4. 实例化装饰类，并调用被装饰过的方法，实现功能增强。

## UML类图

![装饰模式类图](https://img-blog.csdnimg.cn/4e2fc03931944d20a9759a2a1412bab1.png#pic_center)

## 实现代码

```java
/**
 * 组件接口（被装饰着的基类或接口）
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public interface Component {
    /**
     * 某一操作
     */
    void operation();
}

/**
 * 具体组件（被装饰者）
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("未被装饰的操作");
    }
}
```

```java
/**
 * 装饰者抽象类
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public abstract class Decorator implements Component {
    /**
     * 被装饰者对象
     */
    protected Component component;

    /**
     * 构造方法
     *
     * @param component 被装饰着对象
     */
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

/**
 * 具体装饰类A
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class ConcreteDecoratorA extends Decorator {
    /**
     * 构造方法
     *
     * @param component 被装饰着对象
     */
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    /**
     * 装饰者A的私有方法
     */
    private void methodA() {
        System.out.println("装饰类A的方法A");
    }

    @Override
    public void operation() {
        methodA();
        super.operation();
    }
}

/**
 * 具体装饰类B
 *
 * @author YuJianHui
 * @date 2022/08/15
 */
public class ConcreteDecoratorB extends Decorator {
    /**
     * 构造方法
     *
     * @param component 被装饰着对象
     */
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    /**
     * 装饰者B的私有方法
     */
    private void methodB() {
        System.out.println("装饰类B的方法B");
    }

    @Override
    public void operation() {
        methodB();
        super.operation();
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 未被装饰的对象
        Component component = new ConcreteComponent();
        component.operation();
        System.out.println("-----------------------");

        // 被A类装饰过的对象
        Component decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operation();
        System.out.println("-----------------------");

        // 被B类装饰过的A对象（装饰B套装饰A）
        Component decoratorB = new ConcreteDecoratorB(decoratorA);
        decoratorB.operation();
    }
}
------输出------
        未被装饰的操作
        -----------------------
        装饰类A的方法A
        未被装饰的操作
        -----------------------
        装饰类B的方法B
        装饰类A的方法A
        未被装饰的操作
```

---

# 八、代理模式

## 定义

代理模式给某一个对象提供一个代理对象，并由代理对象控制对原对象的引用。通俗的来讲代理模式就是我们生活中常见的中介。

## 针对问题

通常我们需要使用一个对象的某个方法，但是我们希望在调用这个方法之前或之后做一些额外的操作（如方法输入参数的数据准备等）。

## 模式分类

1. 静态代理模式
2. 动态代理模式（JDK）
3. CGLib代理模式

## 模式区别

1. 静态代理：代理对象和被代理对象（委托对象）需要实现相同的接口，类似与装饰模式。代理类在编译时已经确定。速度快。
2. 动态代理：被代理对象需要实现某一接口，JDK在运行时动态创建的代理类也会实现该接口。代理类在运行时根据传入参数的不同，动态生成不同的实现类。可以代理final类。速度慢。
3. CGLib代理：被代理对象不需要实现任何接口。在运行动态的生成一个被代理类的子类，通过拦截的方法实现对象控制。由于使用的是继承原理，因此不能代理final类的对象或普通类对象的final方法。速度快。

## 代理模式与装饰模式的区别

装饰器模式关注于在一个对象上动态的添加方法，然而代理模式关注于控制对对象的访问。  
通常来说，代理类可以对他的客户隐藏被代理对象的信息，因此使用代理模式时，一般都在代理类中创建被代理对象，而使用装饰模式时，一般在装饰类的构造方法的参数中传入被装饰的对象。  
然而，在动态代理模式中，为了凸显动态代理的灵活性，一般在代理工厂类或代理处理类中通过构造方法传入被代理对象。

## 1、静态代理模式

### 实现步骤

1. 创建一个代理类和被代理类的共同接口，拥有某一方法。
2. 创建一个被代理类，实现上述接口，实现某一方法。
3. 创建一个代理类，继承被代理类，并聚合上述被代理类对象，该对象在构造函数中被初始化（非传参初始化，体现对客户端对被代理对象的不可见性）。
4. 在代理类中实现某一方法，在该方法中调用被代理类的某一方法，并在调用被代理对象方法前后，可以做一些其他操作。
5. 创建代理对象，并调用代理对象的某一方法。

### UML类图

![静态代理模式类图](https://img-blog.csdnimg.cn/a7699030d5874abaa3a27682270f8257.png#pic_center)

### 实现代码

```java
/**
 * 主题接口（代理类和委托类的统一接口）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public interface Subject {
    /**
     * 做某事方法
     */
    void doSomething();
}

/**
 * 委托类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("成功租房子");
    }
}
```

```java
/**
 * 代理类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class Proxy implements Subject {
    /**
     * 委托对象
     */
    private RealSubject realSubject;

    /**
     * 构造方法（区别于装饰类）
     */
    public Proxy() {
        // 创建委托对象 而不是通过构造传参创建对象 隐藏了客户端对委托对象的可见性
        realSubject = new RealSubject();
    }

    @Override
    public void doSomething() {
        System.out.println("帮客户找房子");
        realSubject.doSomething();
        System.out.println("帮客户换门锁");
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建代理对象
        Subject proxy = new Proxy();
        // 调用代理对象的方法
        proxy.doSomething();
    }
}
------输出------
        帮客户找房子
        成功租房子
        帮客户换门锁
```

## 2、动态代理模式（JDK）

### 实现步骤

1. 创建一个被代理类的接口，拥有某一方法。
2. 创建一个被代理类，实现上述接口，实现某一方法。
3. 创建一个动态调用处理类，实现InvocationHandler接口，并聚合上述被代理类对象，该对象在构造函数中被初始化（传参初始化，体现动态代理的灵活性）。
4. 在动态调用处理类中，重写InvocationHandler接口的invoke方法，在方法中回调被代理对象的某一方法，在此期间，可以做一些其他操作。
5. 创建被代理对象，并将该对象传入动态调用处理类。
6. 通过Proxy类，动态创建代理对象，调用代理对象的某一方法。

### UML类图

![动态代理模式类图](https://img-blog.csdnimg.cn/c99bcc79d52b4b439a964e4794d20f6d.png#pic_center)

### 实现代码

```java
/**
 * 主题接口（代理类和委托类的统一接口）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public interface Subject {
    /**
     * 做某事方法
     */
    void doSomething();
}

/**
 * 委托类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("成功租房子");
    }
}
```

```java
/**
 * 动态调用处理类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class DynamicInvocationHandler<T> implements InvocationHandler {
    /**
     * 被代理对象
     */
    private final T target;

    /**
     * 构造方法（因为是动态代理 代理对象是在运行时创建的 不建议像静态代理一样写死类型 因此用泛型传参创建被代理对象）
     *
     * @param target 被代理对象
     */
    public DynamicInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 输出仅作为代理前后处理的演示 动态代理不建议针对某一特定对象做处理
        System.out.println("帮客户找房子");
        Object result = method.invoke(target, args);
        System.out.println("帮客户换门锁");
        return result;
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建委托类对象
        Subject realSubject = new RealSubject();
        // 创建调用处理类对象
        InvocationHandler dynamicInvocationHandler = new DynamicInvocationHandler<>(realSubject);
        // 创建代理类对象
        Subject proxy = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                dynamicInvocationHandler);
        // 调用代理类对象的方法
        proxy.doSomething();
    }
}
------输出------
        帮客户找房子
        成功租房子
        帮客户换门锁
```

## 3、CGLib代理模式

### 实现步骤

1. 创建一个被代理类，包含某一方法。
2. 创建代理工厂类，实现MethodInterceptor接口，被代理对象作为其属性，该对象在构造函数中被初始化（传参初始化，体现动态代理的灵活性）。
3. 在该代理工厂类中，需要有一个获取代理对象的方法，方法中需要设置代理对象的父类（用于cglib创建被代理对象的子类），设置回调函数，返回代理对象。
4. 同时，在该代理工厂类中，需要重写MethodInterceptor接口的intercept拦截方法，在该方法中调用被代理对象的某一方法，并在调用被代理对象方法前后，可以做一些其他操作。
5. 通过代理工厂类提供的获取代理对象方法，创建代理对象，并调用代理对象的某一方法。

### UML类图

![CGLib动态代理模式类图](https://img-blog.csdnimg.cn/f6841e2a070e4f84868dbb6989dc31c8.png#pic_center)

### 实现代码

```java
/**
 * 委托类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class RealSubject {
    public void doSomething() {
        System.out.println("成功租房子");
    }
}
```

```java
/**
 * 代理工厂类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class ProxyFactory implements MethodInterceptor {
    /**
     * 被代理对象
     */
    private final Object target;

    /**
     * 构造方法
     *
     * @param target 目标
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 获得代理实例
     *
     * @return {@link Object}
     */
    public Object getProxyInstance() {
        // cglib工具对象
        Enhancer enhancer = new Enhancer();
        // 设置生成的代理对象的父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调 参数为该工厂类
        enhancer.setCallback(this);
        // 创建代理对象并返回
        return enhancer.create();
    }

    /**
     * 拦截方法
     *
     * @param o           对象
     * @param method      方法
     * @param objects     对象
     * @param methodProxy 方法代理
     * @return {@link Object}
     * @throws Throwable throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("帮客户找房子");
        Object result = methodProxy.invoke(target, objects);
        System.out.println("帮客户换门锁");
        return result;
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建被代理类对象
        RealSubject realSubject = new RealSubject();
        // 创建代理工厂对象
        ProxyFactory proxyFactory = new ProxyFactory(realSubject);
        // 获取代理对象
        RealSubject proxy = (RealSubject) proxyFactory.getProxyInstance();
        // 调用代理对象的方法
        proxy.doSomething();
    }
}
------输出------
        帮客户找房子
        成功租房子
        帮客户换门锁
```

---

# 九、外观模式

## 定义

隐藏了系统的复杂性，并向客户端提供了一个可以访问系统的接口。

## 针对问题

子系统使用很复杂，客户想简化使用子系统，那么把一些复杂的流程封装成一个接口供给外部用户更简单的使用。

## 实现步骤

1. 创建两个子系统类A和B，实现某些复杂的功能。
2. 创建一个门面类，提供一些简单的方法，实现对A和B的复杂功能调用。
3. 对门面类进行实例化，使用其提供的简单方法，从而实现对复杂子系统A和B的调用。

## 优缺点

1. 优点：简化调用、降低耦合、分层控制、迪米特法则（最少知道原则）。
2. 缺点：子系统扩展容易产生风险、不符合开闭原则（子系统扩展时，门面类需要做对应修改）。

## UML类图

![外观模式类图](https://img-blog.csdnimg.cn/df3d8b982bfe4858ba5bb03b220b68b2.png#pic_center)

## 实现代码

```java
/**
 * 子系统A类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class SubSystemA {
    /**
     * 某方法A
     */
    public void methodA() {
        System.out.println("子系统A的methodA()被调用");
    }
}

/**
 * 子系统B类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class SubSystemB {
    /**
     * 某方法B
     */
    public void methodB() {
        System.out.println("子系统B的methodB()被调用");
    }
}
```

```java
/**
 * 外观类
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class Facade {
    /**
     * 子系统对象A
     */
    private final SubSystemA subSystemA = new SubSystemA();
    /**
     * 子系统对象B
     */
    private final SubSystemB subSystemB = new SubSystemB();

    /**
     * 某方法A
     */
    public void doSomethingA() {
        subSystemA.methodA();
    }

    /**
     * 某方法B
     */
    public void doSomethingB() {
        subSystemB.methodB();
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doSomethingA();
        facade.doSomethingB();
    }
}
------输出------
        子系统A的methodA()被调用
        子系统B的methodB()被调用
```

---

# 十、桥接模式

## 定义

将抽象和实现解耦，使得两者可以独立地变化。

## 针对问题

桥接模式是为了解决类的继承缺点而设计的，当一个类想拥有另一个类或接口的某些方法时，可以不用继承或实现某个类或接口，只需搭建一个桥梁（抽象类）即可。  
一般在接口或抽象类不稳定的情况下，或不希望使用继承的场景下使用桥接模式。

## 实现步骤

1. 这里使用举例的方式演示，介绍：手机类（抽象类）需要某些应用程序（实现类），但是手机和应用程序又是两个维度的东西，不想相互继承，且可分开变化。
2. 创建应用程序接口，包含一个run()方法。
3. 为应用程序接口创建两个具体实现类，相机类和音乐类，并实现具体的run()方法。
4. 创建一个手机抽象类，聚合应用程序接口对象，并用构造方法对该对象进行初始化。
5. 手机类提供一些抽象方法做其他事（可以省略，主要是演示用）。
6. 为手机类创建两个具体实现类，在具体实现类中，可以重写其父类的抽象方法，或定义自己的方法调用应用程序接口提供的方法。
7. 实现了手机类没有继承应用程序类，但可以调用应用程序提供的方法，同时，手机类和应用程序接口可以分开单独变化而不互相影响。

## UML类图

![桥接模式类图](https://img-blog.csdnimg.cn/d7588c2713384a13ae1e49218de58d2f.png#pic_center)

## 实现代码

```java
/**
 * 应用程序接口（实现类接口）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public interface Application {
    /**
     * 运行方法
     */
    void run();
}

/**
 * 相机应用（具体实现类）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class Camera implements Application {
    @Override
    public void run() {
        System.out.println("相机已经打开");
    }
}

/**
 * 音乐应用（具体实现类）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class Music implements Application {
    @Override
    public void run() {
        System.out.println("音乐已播放");
    }
}
```

```java
/**
 * 手机类（抽象角色 桥接重点类 通过该类桥接）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public abstract class Phone {
    /**
     * 应用程序接口具体实现对象
     */
    protected Application application;

    /**
     * 构造方法 提醒用户必须传入一个具体实现的对象
     *
     * @param application 应用程序
     */
    public Phone(Application application) {
        this.application = application;
    }

    /**
     * 语音助手
     */
    public void voiceHelper() {
        application.run();
    }
}

/**
 * 小米手机（抽象类/桥接类的具体实现）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class MiPhone extends Phone {
    /**
     * 构造方法 提醒用户必须传入一个具体实现的对象
     *
     * @param application 应用程序
     */
    public MiPhone(Application application) {
        super(application);
    }

    @Override
    public void voiceHelper() {
        System.out.println("你好，我是小爱，请说出需要打开的app名称：__");
        System.out.println("相机");
        super.voiceHelper();
    }
}

/**
 * 苹果手机（抽象类/桥接类的具体实现）
 *
 * @author YuJianHui
 * @date 2022/08/16
 */
public class iPhone extends Phone {
    /**
     * 构造方法 提醒用户必须传入一个具体实现的对象
     *
     * @param application 应用程序
     */
    public iPhone(Application application) {
        super(application);
    }

    @Override
    public void voiceHelper() {
        System.out.println("siri 打开音乐");
        super.voiceHelper();
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建应用程序为相机
        Application application = new Camera();
        // 创建小米手机
        Phone phone = new MiPhone(application);
        // 使用语音助手
        phone.voiceHelper();

        System.out.println("--------------------------------");
        // 创建新的应用程序
        application = new Music();
        // 创建苹果手机
        phone = new iPhone(application);
        // 使用语音助手
        phone.voiceHelper();
    }
}
------输出------
        你好，我是小爱，请说出需要打开的app名称：__
        相机
        相机已经打开
        --------------------------------
        siri 打开音乐
        音乐已播放
```

---

# 十一、组合模式

## 定义

将对象组合成树形结构以表示“部分-整体”的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。

## 针对问题

当发现需求中是体现部分与整体层次结构时，以及你希望用户可以忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象时，就应该考虑组合模式了。

## 实现步骤

1. 创建一个部分与整体的公共父类或接口，定义其需要提供的公共方法。
2. 创建部分类，继承或实现上述父类或接口。在部分类中，以部分类的视角，对公共方法重写或实现。
3. 创建整体类，继承或实现上述父类或接口。在整体类中，组合父类或接口的对象集合，以整体类的视角，对公共方法重写或实现。
4. 创建部分类对象和整体类对象，在整体类对象中，可以添加部分类。使用父类或接口提供的方法，操作部分对象或整体对象。

## UML类图

![组合模式类图](https://img-blog.csdnimg.cn/202377ff46524f0588397b38cb80bdf5.png#pic_center)

## 实现代码

```java
/**
 * 组件（抽象类 叶子类和分支类的共同父类）
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public abstract class Component {
    /**
     * 组件名
     */
    String name;

    /**
     * 添加子节点
     *
     * @param component 组件
     */
    void add(Component component) {
    }

    /**
     * 删除子节点
     *
     * @param component 组件
     */
    void remove(Component component) {
    }

    /**
     * 遍历节点
     */
    void each() {
    }
}

/**
 * 叶子节点（单体 没有子节点）
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super.name = name;
    }

    @Override
    void add(Component component) {
        // 不做任何事
    }

    @Override
    void remove(Component component) {
        // 不做任何事
    }

    @Override
    void each() {
        System.out.println(super.name + "被打印");
    }
}

/**
 * 组合类（复合体 可以有子节点）
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class Composite extends Component {
    List<Component> components = new ArrayList<Component>();

    public Composite(String name) {
        super.name = name;
    }

    @Override
    void add(Component component) {
        components.add(component);
    }

    @Override
    void remove(Component component) {
        components.remove(component);
    }

    @Override
    void each() {
        System.out.println(super.name + "被打印");
        for (Component component : components) {
            // 调用每个子节点的each 体现单体和组合体的使用方法一致性
            component.each();
        }
    }
}
```

```java
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
------输出------
        叶子1被打印
        --------------------------------
        根节点被打印
        左分支被打印
        叶子1被打印
        叶子2被打印
        右分支被打印
        叶子3被打印
```

---

# 十二、享元模式

## 定义

使用共享对象（元素）可有效地支持大量的细粒度的对象。

## 针对问题

在项目中，需要用到大量的某一类型的对象，且这些对象包含某写固定的特征（外部特征，如：ID），如果通过创建对象的方式来重复创建这些对象，那么很可能造成内存溢出现象。因此用池的概念对有重复特征的对象加以管理，可避免重复创建类似（内部特征可变）的对象，减少内存溢出风险。

## 实现步骤

1. 将一个类的属性进行划分，一部分为具有同一特征的属性（外部状态），另一部分为具有不同特诊的属性（内部状态）。
2. 创建一个抽象类（Flyweight），内部状态作为其属性，内部状态一般是可变的，提供变更方法。
3. 为上述抽象类创建具体实现类，外部状态作为其属性，因其外部状态应具有稳定性，因此不提供变更方法。
4. 创建一个享元工厂类，在类中维护一个HashMap池，一般将外部状态作为Map的Key，该工厂需要提供一个返回和创建享元对象的方法。
5. 通过享元工厂对象，根据外部状态的不同，获取或创建具体享元类的对象。

## 提醒

1. 为了便于理解，可以参考Java中的String对象的原理。
2. 也可以理解为不重复创建相同的对象，使用Hash算法管理对象（池概念）。
3. ***注意***：在多线程的情况下，共享同一对象需要注意线程安全问题。
4. ***注意***：外部状态应该具有稳定性（作为key），不应该随内部状态的变化而变化，因此不应该提供修改外部状态的方法。

## UML类图

![享元模式类图](https://img-blog.csdnimg.cn/be0dc78fb9404978806e7a641758a103.png#pic_center)

## 实现代码

```java
/**
 * 抽象享元类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public abstract class Flyweight {
    /**
     * 内部状态
     */
    private String intrinsic = "aaa";

    /**
     * 打印操作
     *
     * @return {@link String}
     */
    public abstract String print();

    /**
     * 获取内部状态
     *
     * @return {@link String}
     */
    public String getIntrinsic() {
        return intrinsic;
    }

    /**
     * 设置内部状态
     *
     * @param value 价值
     */
    public void setIntrinsic(String value) {
        this.intrinsic = value;
    }
}

/**
 * 具体享元类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class ConcreteFlyweight extends Flyweight {
    /**
     * 外部状态（具有稳定性 不应该被改变）
     */
    private final String id;

    /**
     * 提供构造方法 设定外部状态 外部状态设定后 不应该被改变
     *
     * @param id id
     */
    public ConcreteFlyweight(String id) {
        this.id = id;
    }

    @Override
    public String print() {
        return "外部状态：" + id + "，内部状态：" + getIntrinsic();
    }
}
```

```java
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
```

```java
public class TestClass {
    public static void main(String[] args) {
        Flyweight flyweight1 = FlyweightFactory.getFlyweight("A");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("B");
        Flyweight flyweight3 = FlyweightFactory.getFlyweight("A");

        System.out.println(flyweight1.print());
        System.out.println(flyweight2.print());
        System.out.println(flyweight3.print());
        System.out.println(flyweight1 == flyweight2);
        System.out.println(flyweight1 == flyweight3);
        flyweight1.setIntrinsic("bbb");
        System.out.println(flyweight1.print());
        System.out.println(flyweight2.print());
        System.out.println(flyweight3.print());

        System.out.println("池大小：" + FlyweightFactory.getPoolSize());
    }
}
------输出------
        外部状态：A，内部状态：aaa
        外部状态：B，内部状态：aaa
        外部状态：A，内部状态：aaa
        false
        true
        外部状态：A，内部状态：bbb
        外部状态：B，内部状态：aaa
        外部状态：A，内部状态：bbb
        池大小：2
```

---

# 十三、策略模式

## 定义

定义一组算法，将每个算法都封装起来，并且使它们之间可以互换。

## 针对问题

一个系统有很多类，这些类之间有很多相似的算法，区别仅仅是算法输出不同，如果是用条件判断语句来调用不同的类对象，那么代码将变得复杂，难以维护。因此将各种算法封装起来，提供相同的接口方法和环境变量，通过切换环境变量（或切换环境变量中的策略：环境变量提供切换策略方法），实现算法的切换。

## 实现步骤

1. 创建一个策略接口，提供算法使用方法。
2. 为策略接口创建不同的策略实现类，实现不同的算法。
3. 创建环境变量类，关联策略对象，提供策略使用方法。
4. 创建环境变量对象，调用策略使用方法。
5. 切换环境变量（或切换环境变量中的策略对象），实现策略切换。

## 优缺点

1. 优点：算法可以自由切换，避免过多的条件判断。扩展性好（面对接口的编程）。
2. 缺点：策略类数量增加。

## UML类图

![在这里插入图片描述](https://img-blog.csdnimg.cn/5f9f128ad04e4fc4b2770efa11c7f43c.png#pic_center)

## 实现代码

```java
/**
 * 策略接口
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public interface Strategy {
    /**
     * 计算方法
     *
     * @param num1 数值1
     * @param num2 数值2
     */
    void calculate(int num1, int num2);
}

/**
 * 加法策略
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class AddStrategy implements Strategy {
    @Override
    public void calculate(int num1, int num2) {
        System.out.println("加法运算结果：" + (num1 + num2));
    }
}

/**
 * 减法策略
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class SubStrategy implements Strategy {
    @Override
    public void calculate(int num1, int num2) {
        System.out.println("减法运算结果：" + (num1 - num2));
    }
}
```

```java
/**
 * 上下文环境类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class Context {
    /**
     * 策略
     */
    private Strategy strategy;

    /**
     * 构造方法
     *
     * @param strategy 策略
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 调用策略的方法
     *
     * @param num1 num1
     * @param num2 num2
     */
    public void call(int num1, int num2) {
        strategy.calculate(num1, num2);
    }

    /**
     * 改变策略方法（可以不提供）
     *
     * @param strategy 策略
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建环境对象并设置策略
        Context context = new Context(new AddStrategy());
        context.call(1, 2);

        //切换策略
        context.setStrategy(new SubStrategy());
        context.call(1, 2);
    }
}
------输出------
        加法运算结果：3
        减法运算结果：-1
```

---

# 十四、策略模式

## 定义

定义一个操作中算法的骨架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变算法的结构即可重定义该算法的某些特定步骤。

## 针对问题

做某件事时，有一个固定的步骤，但每个步骤的细节对于不同对象都有不同的实现方法，在定义某件事时，又不可能去细化每个步骤的实现方法，只能确定需要的步骤。因此，将细化步骤的方法下放到该事件的子类中去，父类则只负责确定步骤，细节让子类去实现。

## 实现步骤

1. 创建一个事件类，定义事件步骤，确定事件执行顺序（final 子类不可修改）。
2. 为事件类创建两个子类，实现事件步骤细节。
3. 实例化事件类，调用事件对象执行方法。

## UML类图

![模板模式类图](https://img-blog.csdnimg.cn/c3f1de51504f46b4bdd7bdc81237e4eb.png#pic_center)

## 实现代码

```java
/**
 * 抽象模板类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public abstract class Template {
    /**
     * 做某事方法
     */
    final void doSomething() {
        step1();
        step2();
        step3();
    }

    /**
     * 步骤1
     */
    protected abstract void step1();

    /**
     * 步骤2
     */
    protected abstract void step2();

    /**
     * 步骤3
     */
    protected abstract void step3();
}

/**
 * 去上学类
 *
 * @author YuJianHui
 * @date 2022/08/18
 */
public class GoToSchool extends Template {
    @Override
    public void step1() {
        System.out.println("穿校服");
    }

    @Override
    public void step2() {
        System.out.println("吃早餐");
    }

    @Override
    public void step3() {
        System.out.println("坐校车");
    }
}

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
```

```java
public class TestClass {
    public static void main(String[] args) {
        Template template1 = new GoToSchool();
        template1.doSomething();

        System.out.println("---------------------------");
        Template template2 = new GoHome();
        template2.doSomething();
    }
}
------输出------
        穿校服
        吃早餐
        坐校车
        ---------------------------
        收拾书包
        打扫卫生
        坐公交车
```

---

# 十五、观察者模式

## 定义

定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。

## 针对问题

一个对象发生改变，需要通知其他与之关联的对象做出反应，又不想一个个挑选是哪些对象与之关联，此时应使用观察者模式。此模式提供一个主题，订阅了该主题的对象，当主题发生变更时，都会收到通知。

## 实现步骤

1. 创建一个主题接口，提供添加、删除、通知订阅者和变更主题内容的方法。
2. 创建订阅者接口，提供接受通知的方法。
3. 实现主题接口，在该实现类中，维护一个订阅者集合，实现接口方法。在变更主题内容后，需调用通知订阅者方法。
4. 实现订阅者接口。
5. 创建主题对象，为其添加订阅者对象，变更主题内容，观察订阅者的响应。

## 优缺点

1. 优点：代码耦合度低，同时可以建立一套完善的通知机制。
2. 缺点：如果观察者较多，则通知时间会拉长。编写代码时，如果出现循环依赖（如观察者通知本类观察者，主题通知本类主题等），会导致循环通知，造成系统崩溃。

## UML类图

![观察者模式类图](https://img-blog.csdnimg.cn/187990d197aa46c9aedd4f6d93646677.png#pic_center)

## 实现代码

```java
/**
 * 主题接口（被观察者接口）
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Subject {
    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    void addObserver(Observer observer);

    /**
     * 删除观察者
     *
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();

    /**
     * 做某事
     *
     * @param message 消息
     */
    void doSomething(String message);
}

/**
 * 观察者接口
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Observer {
    /**
     * 更新
     * 接收被观察者发出的通知并更新的方法
     *
     * @param message 消息
     */
    void update(String message);
}
```

```java
/**
 * 具体主题类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class ConcreteSubject implements Subject {
    /**
     * 观察者对象集合
     */
    private final List<Observer> observers;

    /**
     * 消息
     */
    private String message;

    /**
     * 构造方法 初始化被观察者集合
     */
    public ConcreteSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        // 调用每一个观察者的更新方法
        for (Observer observer : observers) {
            observer.update(this.message);
        }
    }

    @Override
    public void doSomething(String message) {
        this.message = message;
        notifyObservers();
    }
}

/**
 * 具体观察者类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("接受到了新的消息：" + message);
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建主题
        Subject subject = new ConcreteSubject();
        // 创建观察者
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        Observer observer3 = new ConcreteObserver();

        // 添加观察者
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);
        // 变更主题内容
        subject.doSomething("这是第一条消息");

        System.out.println("------------------");
        // 移除一个观察者
        subject.removeObserver(observer2);
        // 变更主题内容
        subject.doSomething("这是第二条消息");
    }
}
------输出------
        接受到了新的消息：这是第一条消息
        接受到了新的消息：这是第一条消息
        接受到了新的消息：这是第一条消息
        ------------------
        接受到了新的消息：这是第二条消息
        接受到了新的消息：这是第二条消息
```

---

# 十六、迭代子模式

## 定义

提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示。

## 针对问题

自定义一种新的集合容器类，或对已有容器类（如List、Map等）进行遍历时，想自定义遍历方式，可以使用迭代器模式。

## 模式分类

1. 黑箱迭代子模式
2. 白箱迭代子模式

## 模式区别

1. 黑箱迭代子模式，在具体容器实现类种，将具体迭代器实现类作为其内部类，代码精简。
2. 白箱迭代子模式，具体容器实现类和具体迭代器实现类为两个独立的类，他们之间的关系是互相关联，代码稍微复杂。

## 注意

迭代器模式现在很少使用了，一般jdk提供的容器与自带的迭代器足够满足需求。非特殊需求，不建议使用迭代器模式，它会让代码变得更加复杂。

## 1、黑箱迭代子模式

### 实现步骤

1. 创建一种新的容器接口，提供获取迭代器的方法（正常项目中，还应提供更改容器内容的方法）。
2. 创建迭代器接口，提供重置游标位置、移动游标位置、判断游标是否到底、获取当前游标对象等方法。
3. 创建容器接口实现类，在其内部创建实现迭代器接口的实现类（体现黑箱），分别实现各自的方法。
4. 创建容器对象，获取迭代器对象，使用迭代器提供的方法，遍历容器对象。

### UML类图

![黑箱迭代子模式类图](https://img-blog.csdnimg.cn/f64569cf02604049b70a1bc1be9260e4.png#pic_center)

### 实现代码

```java
/**
 * 容器接口（为了演示方便 此接口不提供改变集合内容的方法 因此集合一旦初始化 大小不可改变）
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Container {
    /**
     * 创建迭代器对象
     *
     * @return {@link Iterator}
     */
    Iterator createIterator();
}

/**
 * 迭代器接口
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Iterator {
    /**
     * 将游标移动到第一个
     */
    void toFirst();

    /**
     * 将游标移动到下一个
     */
    void next();

    /**
     * 是否还有下一个
     *
     * @return boolean
     */
    boolean hasNext();

    /**
     * 返回当前游标指向的对象
     *
     * @return {@link Object}
     */
    Object currentItem();
}
```

```java
/**
 * 具体容器实现类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class ConcreteContainer implements Container {
    /**
     * 存放对象的容器（为了演示方便 此容器内容不可变 因此为final）
     */
    private final Object[] objArray;

    /**
     * 构造方法 初始话容器（一般情况下 需要提供修改objArray内容的方法 此处仅为演示代码 因此不提供）
     *
     * @param objArray obj数组
     */
    public ConcreteContainer(Object[] objArray) {
        this.objArray = objArray;
    }

    @Override
    public Iterator createIterator() {
        // 创建并返回内部类对象
        return new ConcreteIterator();
    }

    /**
     * 具体迭代器类（内部类 体现黑箱）
     *
     * @author YuJianHui
     * @date 2022/08/19
     */
    private class ConcreteIterator implements Iterator {
        /**
         * 当前游标位置
         */
        private int index;
        /**
         * 集合大小（为了演示方便 集合大小创建集合时的构造函数确定 不可改变 因此此字段为final）
         */
        private final int size;

        /**
         * 构造方法（设置游标位置 设置集合大小）
         */
        public ConcreteIterator() {
            size = objArray.length;
            index = 0;
        }

        @Override
        public void toFirst() {
            index = 0;
        }

        @Override
        public void next() {
            if (index < size) {
                index++;
            }
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object currentItem() {
            return objArray[index];
        }
    }
}
```

```java
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
------输出------
        1
        2
        3
        4
        5
        6
```

## 2、白箱迭代子模式

### 实现步骤

1. 创建一种新的容器接口，提供获取迭代器、获取容器大小、获取当前游标指向对象的方法（正常项目中，还应提供更改容器内容的方法）。
2. 创建迭代器接口，提供重置游标位置、移动游标位置、判断游标是否到底、获取当前游标对象等方法。
3. 创建容器接口实现类，注意在实现获取迭代器的方法中，将对象本身传递给迭代器实现类的构造方法（体现白箱）。
4. 创建迭代器接口实现类，通过其构造方法，初始化内部属性（如容器对象、游标位置、容器大小等）。
5. 创建容器对象，获取迭代器对象，使用迭代器提供的方法，遍历容器对象。

### UML类图

![白箱迭代子模式类图](https://img-blog.csdnimg.cn/d0898edfd1d14211b98dd4be0f1af145.png#pic_center)

### 实现代码

```java
/**
 * 容器接口（为了演示方便 此接口不提供改变集合内容的方法 因此集合一旦初始化 大小不可改变）
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Container {
    /**
     * 创建迭代器
     * 创建迭代器对象
     *
     * @return {@link Iterator}
     */
    Iterator createIterator();

    /**
     * 获取指定下标的对象
     *
     * @param index 指数
     * @return {@link Object}
     */
    Object getItem(int index);

    /**
     * 获取容器大小
     *
     * @return int
     */
    int size();
}

/**
 * 迭代器接口
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public interface Iterator {
    /**
     * 将游标移动到第一个
     */
    void toFirst();

    /**
     * 将游标移动到下一个
     */
    void next();

    /**
     * 是否还有下一个
     *
     * @return boolean
     */
    boolean hasNext();

    /**
     * 返回当前游标指向的对象
     *
     * @return {@link Object}
     */
    Object currentItem();
}
```

```java
/**
 * 具体容器实现类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class ConcreteContainer implements Container {
    /**
     * 存放对象的容器（为了演示方便 此容器内容不可变 因此为final）
     */
    private final Object[] objArray;

    /**
     * 构造方法 初始话容器（一般情况下 需要提供修改objArray内容的方法 此处仅为演示代码 因此不提供）
     *
     * @param objArray obj数组
     */
    public ConcreteContainer(Object[] objArray) {
        this.objArray = objArray;
    }

    @Override
    public Iterator createIterator() {
        // 传入当前容器类对象 体现白箱
        return new ConcreteIterator(this);
    }

    @Override
    public Object getItem(int index) {
        return objArray[index];
    }

    @Override
    public int size() {
        return objArray.length;
    }
}

/**
 * 具体迭代器类
 *
 * @author YuJianHui
 * @date 2022/08/19
 */
public class ConcreteIterator implements Iterator {
    /**
     * 容器对象
     */
    private final Container container;
    /**
     * 当前游标位置
     */
    private int index;
    /**
     * 集合大小（为了演示方便 集合大小创建集合时的构造函数确定 不可改变 因此此字段为final）
     */
    private final int size;

    /**
     * 构造方法（设置游标位置 设置集合大小 设置容器对象 体现白箱）
     */
    public ConcreteIterator(Container container) {
        this.container = container;
        size = container.size();
        index = 0;
    }

    @Override
    public void toFirst() {
        index = 0;
    }

    @Override
    public void next() {
        if (index < size) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Object currentItem() {
        return container.getItem(index);
    }
}
```

```java
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
------输出------
        A
        B
        C
        D
        E
        F
```

---

# 十七、责任链模式

## 定义

使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。

## 针对问题

责任链上的处理者负责处理请求，客户只需要将请求发送到责任链上即可，无须关心请求的处理细节和请求的传递，所以责任链将请求的发送者和请求的处理者解耦了。

## 实现步骤

1. 创建等级枚举类（Level），用于划分请求等级和处理者等级。
2. 创建请求类（Request），用于统一请求方式，包含获取请求等级的方法。
3. 创建响应类（Response），用于统一响应格式。
4. 创建责任链对象类（Handler）,聚合本类对象，关联处理等级、处理方法接口实现对象。提供设置下一个处理者（责任链对象）方法、处理请求方法（等级匹配判断和默认处理）。
5. 创建处理方法接口（HandlerMethod）,提供处理方法。
6. 创建具体处理类，继承责任链对象类，实现处理方法接口。（具体原因看注意事项2）
7. 创建具体责任链对象，设置责任链关系，调用责任链对象类提供的处理请求方法。

## 注意

1. 原则上，责任链对象类只应提供一个唯的处理请求方法handleRequest(Request request)，该方法负责处理等级匹配与请求处理方法调用。
2.
为什么不在Handler类中提供handle处理方法，而是通过接口的方式（解答实现步骤6）：因为java的protected关键字或默认的default关键字限定的方法，其不仅可以在子类中重写，还能在本包内使用，即具体处理类对象也会包含该方法，因此，如果具体处理类调用了handle方法，则跳过了其父类唯一提供的handleRequest方法，没有实现等级匹配则直接调用，容易产生不可预期的结果。因此，将方法独立成接口，具体处理类需要实现该接口。
3. 因上述2的原因，在Handler中，需要聚合HandlerMethod接口对象，在其构造方法中，需要初始化（强转）该接口对象。
4. 具体责任链对象类不仅需要继承Handler类，还要实现HandlerMethod接口，否则不能正常处理请求。
5. **不能出现首尾相连（泛指）**，否则出现死循环造成系统错误。

## 优缺点

1. 优点：请求和处理解耦。
2. 缺点：性能问题，如果责任链太长，需要依次判断处理等级，每个请求都是从责任链开端传递到末端。调试复杂。

## UML类图

![在这里插入图片描述](https://img-blog.csdnimg.cn/015f4cfba30142488c0b1039fcf90316.png#pic_center)

## 实现代码

```java
/**
 * 处理等级枚举类（用于责任链对象判断是否应该处理请求）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public enum Level {
    /**
     * 等级1
     */
    LEVEL1,

    /**
     * 等级2
     */
    LEVEL2,

    /**
     * 等级3
     */
    LEVEL3,

    /**
     * 等级4（当前演示中没有对应的处理器）
     */
    LEVEL4
}

/**
 * 请求类（为了统一处理方式 建议对请求进行封装）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class Request {
    /**
     * 每个请求都需要有一个等级 用于责任链对象判断是否应该处理该请求
     */
    private final Level level;

    /**
     * 构造方法（设置请求等级）
     *
     * @param level 等级
     */
    public Request(Level level) {
        this.level = level;
    }

    /**
     * 获取请求等级
     *
     * @return {@link Level}
     */
    public Level getLevel() {
        return level;
    }
}

/**
 * 响应 类（与请求类对应 每个请求需要对应一个响应 因演示用 因此忽略类中内容）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class Response {
}
```

```java
/**
 * 处理方法接口
 * （为什么不把handle方法写在Handler类中：因为在类中要让子类重写 那么用protected关键字后 外界可以调用Handler的handle方法 跳过了等级匹配）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public interface HandlerMethod {
    /**
     * 处理方法
     *
     * @param request 请求
     * @return {@link Response}
     */
    Response handle(Request request);
}

/**
 * 责任链对象（处理器对象）的父类
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public abstract class Handler {
    /**
     * 继任者（下一个处理者）
     */
    private Handler successor;
    /**
     * 处理着等级 匹配请求等级则处理
     */
    private final Level handlerLevel;
    /**
     * 处理者处理方法对象（为的是不让外界使用handle方法 如果在本类中有handle方法 则外界可以使用 会跳过责任链的等级匹配）
     */
    private final HandlerMethod handlerMethod;

    /**
     * 构造方法（初始化处理器等级和接口实现类）
     *
     * @param handlerLevel 处理等级
     */
    public Handler(Level handlerLevel) throws Exception {
        this.handlerLevel = handlerLevel;
        // 强转 因为Handler子类同时也是该接口的实现类
        if (this instanceof HandlerMethod) {
            this.handlerMethod = (HandlerMethod) this;
        } else {
            this.handlerMethod = null;
            throw new Exception("初始化错误");
        }
    }

    /**
     * 设置下一个处理者 关键方法（通常不用构造方法设置 因为构造方法不够灵活 不便于修改）
     *
     * @param successor 下一个处理者
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 处理请求方法 关键方法 唯一的暴露的处理请求方法（根据处理器等级与请求等级 判断是否处理或传给下一个处理器）
     * 使用final修饰 因此子类不可修改控制流程
     *
     * @param request 请求
     * @return {@link Response}
     */
    public final Response handleRequest(Request request) {
        Response response;
        // 判断该请求是否由本处理者处理
        if (getHandlerLevel().equals(request.getLevel())) {
            // 断言
            assert handlerMethod != null;
            // 调用接口实现类的处理方法
            response = handlerMethod.handle(request);
        } else {
            // 如果处理等级不匹配 且有下一个处理者
            if (successor != null) {
                // 传递请求给下一个处理者
                response = successor.handleRequest(request);
            } else {
                // 没有下一个处理者 默认返回一个相应
                System.out.println("责任链末端了，没有处理者！");
                response = new Response();
            }
        }
        return response;
    }

    /**
     * 获取当前处理器等级
     *
     * @return {@link Level}
     */
    Level getHandlerLevel() {
        return handlerLevel;
    }
}
```

```java
/**
 * 具体处理者类1 必须实现HandlerMethod接口 否则无法工作
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class ConcreteHandler1 extends Handler implements HandlerMethod {
    /**
     * 构造方法（初始化处理器等级）
     *
     * @param handlerLevel 处理等级
     */
    public ConcreteHandler1(Level handlerLevel) throws Exception {
        super(handlerLevel);
    }

    @Override
    public Response handle(Request request) {
        System.out.println("我是1号处理者，处理了该请求。");
        return null;
    }
}

/**
 * 具体处理者类2 必须实现HandlerMethod接口 否则无法工作
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class ConcreteHandler2 extends Handler implements HandlerMethod {
    /**
     * 构造方法（初始化处理器等级）
     *
     * @param handlerLevel 处理等级
     */
    public ConcreteHandler2(Level handlerLevel) throws Exception {
        super(handlerLevel);
    }

    @Override
    public Response handle(Request request) {
        System.out.println("我是2号处理者，处理了该请求。");
        return null;
    }
}

/**
 * 具体处理者类3 必须实现HandlerMethod接口 否则无法工作
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class ConcreteHandler3 extends Handler implements HandlerMethod {
    /**
     * 构造方法（初始化处理器等级）
     *
     * @param handlerLevel 处理等级
     */
    public ConcreteHandler3(Level handlerLevel) throws Exception {
        super(handlerLevel);
    }

    @Override
    public Response handle(Request request) {
        System.out.println("我是3号处理者，处理了该请求。");
        return null;
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        try {
            // 创建处理器
            Handler handler1 = new ConcreteHandler1(Level.LEVEL1);
            Handler handler2 = new ConcreteHandler2(Level.LEVEL2);
            Handler handler3 = new ConcreteHandler3(Level.LEVEL3);

            // 将处理器链接起来
            handler1.setSuccessor(handler2);
            handler2.setSuccessor(handler3);

            // 创建请求
            Request request = new Request(Level.LEVEL3);
            // 从处理器头传入请求
            handler1.handleRequest(request);

            // 创建不在处理器处理等级范围内的请求
            Request request2 = new Request(Level.LEVEL4);
            // 尝试处理 观察输出
            handler1.handleRequest(request2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
------输出------
        我是3号处理者，处理了该请求。
        责任链末端了，没有处理者！
```

---

# 十八、命令模式

## 定义

将一个请求封装为一个对象，使发出请求的任务和执行请求的任务分割开。这样两者之间通过命令对象进行沟通，这样方便将命令对象进行储存、传递、调用、增加与管理。

## 针对问题

需要对发送请求体和实现请求体解耦时，或是希望对请求进行记录、撤销、重做、排队等操作时，可以使用命令模式。

## 实现步骤

1. 创建命令接收类Receiver（MusicPlayer）,提供一些基础操作方法。
2. 创建命令接口（Command），提供命令执行方法execute()。
3. 为命令接口提供实现类，聚合接收类对象，实现命令执行方法execute()。
4. 创建命令调用者类Invoker（CommandPanel），聚合命令对象，提供设置命令方法和调用方法。
5. 创建命令接收者对象，创建命令对象并设置接收者，创建命令调用者对象，用该对象调用命令。

## 解析

1. 为什么需要有命令调用类：因为需要命令执行者和调用者解耦，符合单一职责原则。举例来说：音乐播放器是执行者，提供基础的切歌功能，而调用者是其对应的遥控器。试想如果没有遥控器，用户则需要知道遥控器的调制解调功能，命令格式等才能控制播放器。
2. 已经创建了命令接收者和命令，为什么不直接调用命令的执行功能：结合上一条解析，假如遥控器需要对命令进行调制解调，明码命令不能直接执行，那么就需要在遥控器内部进行编码解码，如果直接执行命令，则命令可能不被执行对象认可。

## 优缺点

1. 优点：调用者和执行者解耦，可单独变化，职责单一，便于扩展，体现封装性。
2. 缺点：命令较多时可能造成类的膨胀，代码较多。

## UML类图

![命令模式类图](https://img-blog.csdnimg.cn/251dbf8072454cfe8a61a6f5df5f5844.png#pic_center)

## 实现代码

```java
/**
 * 音乐播放器类（命令接收者Receiver）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class MusicPlayer {
    /**
     * 下一曲
     */
    public void next() {
        System.out.println("下一曲");
    }

    /**
     * 上一曲
     */
    public void previous() {
        System.out.println("上一曲");
    }
}
```

```java
/**
 * 命令接口
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public interface Command {
    /**
     * 执行方法
     */
    void execute();
}

/**
 * 下一曲命令
 *
 * @author YuJianHui
 * @date 2022/08/22
 */

public class NextCommand implements Command {
    /**
     * 命令接收者
     */
    private final MusicPlayer player;

    /**
     * 构造方法（初始化命令接收者）
     *
     * @param player 球员
     */
    public NextCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.next();
    }
}

/**
 * 上一曲命令
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class PreviousCommand implements Command {
    /**
     * 命令接收者
     */
    private final MusicPlayer player;

    /**
     * 构造方法（初始化命令接收者）
     *
     * @param player 球员
     */
    public PreviousCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.previous();
    }
}
```

```java
/**
 * 音乐播放器的遥控器类（调用者Invoker）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class ControlPanel {
    /**
     * 命令
     */
    private Command command;

    /**
     * 设置命令方法
     *
     * @param command 下一曲命令
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 点击按钮
     */
    public void action() {
        command.execute();
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建接收者Receiver
        MusicPlayer player = new MusicPlayer();

        // 创建命令Command并指定接收者
        Command nextCommand = new NextCommand(player);
        Command previousCommand = new PreviousCommand(player);

        // 创建调用者Invoker并设置命令
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setCommand(nextCommand);
        controlPanel.action();

        // 切换命令
        controlPanel.setCommand(previousCommand);
        controlPanel.action();
    }
}
------输出------
        下一曲
        上一曲
```

---

# 十九、状态模式

## 定义

当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类。

## 针对问题

代码中需要有很多关于状态变化的条件判断语句，且状态的变化会引起同一操作得到不同响应，可以把状态抽象出来作为状态类，使用环境变量对状态的切换与使用进行管理。

## 实现步骤

1. 创建状态接口，提供状态的操作方法。
2. 实现状态接口，根据不同的状态，实现对同一方法调用产生不同的响应。
3. 创建环境Context类(Light)，聚合环境接口对象，提供状态操作方法、当前状态获取方法。同时可提供状态的自动切换方法。
4. 创建具体状态实现对象，创建环境对象，设置环境对象的当前状态，调用环境类提供的方法，观察输出。

## 提示

当前演示为开关灯的操作，开灯状态下不能再开灯，同理关灯状态。

## 优缺点

1. 优点：封装了状态切换规则，枚举了可能的状态，减少条件判断语句。
2. 缺点：状态类膨胀，对”开闭原则“不友好。

## UML类图

![状态模式类图](https://img-blog.csdnimg.cn/d27a1cee433d4968843dd30b03b8cc82.png#pic_center)

## 实现代码

```java
/**
 * 状态接口
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public interface State {
    /**
     * 开灯方法
     */
    void open();

    /**
     * 关灯方法
     */
    void close();
}

/**
 * 开灯状态
 * 允许关灯 不允许开灯
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class OpenState implements State {
    @Override
    public void open() {
        throw new IllegalStateException("错误：灯已经是开启状态！");
    }

    @Override
    public void close() {
        System.out.println("关灯成功");
    }
}

/**
 * 关灯状态
 * 允许开灯 不允许关灯
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class CloseState implements State {
    @Override
    public void open() {
        System.out.println("开灯成功");
    }

    @Override
    public void close() {
        throw new IllegalStateException("错误：灯已经是关闭状态！");
    }
}
```

```java
/**
 * 灯类（环境类Context）
 *
 * @author YuJianHui
 * @date 2022/08/22
 */
public class Light {
    /**
     * 当前状态
     */
    State currentState;
    /**
     * 开灯状态
     */
    static final State OPEN_STATE = new OpenState();
    /**
     * 关灯状态
     */
    static final State CLOSE_STATE = new CloseState();

    /**
     * 构造方法 初始化当前状态
     *
     * @param currentState 当前状态
     */
    public Light(State currentState) {
        this.currentState = currentState;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    private void setState(State state) {
        this.currentState = state;
    }

    /**
     * 开灯方法
     */
    public void open() {
        try {
            currentState.open();
            // 成功则切换状态
            setState(OPEN_STATE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 关灯方法
     */
    public void close() {
        try {
            currentState.close();
            // 成功则切换状态
            setState(CLOSE_STATE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 获取当前状态
     *
     * @return {@link String}
     */
    public String getCurrentState() {
        return currentState.getClass().getName();
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建状态
        State state = new OpenState();
        // 为环境设置初始状态
        Light light = new Light(state);

        System.out.println("当前状态：" + light.getCurrentState());
        light.open();
        light.close();

        System.out.println("---------------------------");
        System.out.println("当前状态：" + light.getCurrentState());
        light.close();
        light.open();
    }
}
------输出------
        当前状态：cn.yjhroot.state.OpenState
        错误：灯已经是开启状态！
        关灯成功
        ---------------------------
        当前状态：cn.yjhroot.state.CloseState
        错误：灯已经是关闭状态！
        开灯成功
```

---

# 二十、备忘录模式

## 定义

在不破坏封装的前提下，捕获一个对象的内部状态，并在对象之外保存这个状态。

## 针对问题

需要保存一类对象某一时刻的状态，以便以后恢复或记录使用时，可以使用备忘录模式。

## 实现步骤

1. 创建发起人类（Originator），包含需要保存的状态信息，提供创建备忘录和根据备忘录恢复状态的方法。
2. 创建备忘录类（Memento），包含被保存的状态信息。
3. 创建管理者类（Caretaker），维护被存储的备忘录实例，提供获取备忘录实例和设置备忘录实例的方法。
4. 创建发起人实例，设置状态，创建管理者对象，存储发起人当前状态，改变状态后又根据备忘录恢复状态，观察输出。

## 优缺点

1. 优点：不破坏被存储类的封装性，将内部状态进行外部存储。
2. 缺点：存储较大对象时，比较耗费硬件资源。

## UML类图

![备忘录模式类图](https://img-blog.csdnimg.cn/a67b921f0a344c88b10412b65c5edf5d.png#pic_center)

## 实现代码

```java
/**
 * 备忘录类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class Memento {
    /**
     * 被保存的状态 与发起者内部状态对应
     */
    private final String state;

    /**
     * 构造方法
     *
     * @param state 被保存的状态
     */
    public Memento(String state) {
        this.state = state;
    }

    /**
     * 获取当前保存的状态信息
     *
     * @return {@link String}
     */
    public String getState() {
        return state;
    }
}

/**
 * 发起者类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class Originator {
    /**
     * 内部状态 希望被保存的内容
     */
    private String state;

    /**
     * 获取当前状态
     *
     * @return {@link String}
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 创建备忘录
     *
     * @return {@link Memento}
     */
    public Memento createMemento() {
        return new Memento(state);
    }

    /**
     * 恢复状态（为什么不直接调用设置状态方法：语义区分 形参区分）
     *
     * @param memento 纪念品
     */
    public void restoreMemento(Memento memento) {
        setState(memento.getState());
    }
}

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
```

```java
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
------输出------
        备忘录中存的状态：状态1
        发起者中的最新状态：状态2
        发起者恢复后的状态：状态1
```

---

# 二十一、访问者模式

## 定义

表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。

## 针对问题

需要将数据的结构和数据操作分离开来的情况下。比如，有一些相对固定的数据类，提供一些基础的数据获取方法，而再其他地方，需要组合不同的数据做处理，这时，如果想不改变数据类，而是把组合不同数据的方法分离出来，这时就可以使用访问者模式。

## 实现步骤

1. 创建元素接口Animal（Element）,提供基础数据访问方法eat()、sound(),和接收访问者方法accept(Visitor)。
2. 为其创建具体元素实现类Cat、Dog（ConcreteElement），实现上述方法，其中accept方法体的 **visitor.visit(this)** 是重点。
3. 创建访问者接口（Visitor）,提供接收**特定**元素的方法，重点是特定（具体元素实现类对象）。
4. 为访问者接口创建具体实现类EatVisitor、SoundVisitor（ConcreteVisitor）,根据访问者期望实现的不同功能，实现上述visit()方法。
5. 创建结构对象，维护一个元素容器，提供获取容器内容的方法。
6. 遍历上述容器对象，通过创建不同的具体访问对象，实现不同的数据访问。

## 解析

以演示示例来看，动物类提供吃饭方法eat和叫声方法sound，访问者提供吃饭EatVisitor访问类和叫声访问类SoundVisitor,如果这时我希望动物边吃饭边发出叫声，那么我只需再创建EatAndSoundVisitor访问类，在其visit方法中调用吃饭和叫声方法即可，而不用再改变动物类所提供的方法（体现数据结构和数据操作分开变化）。

## 优缺点

1. 优点：符合单一职责原则，有一定的扩展性（解耦）。
2. 缺点：不太符合开闭原则，因为添加一种具体元素，相应的访问者也需要类也需要修改。代码复杂，逻辑复杂。

## UML类图

![访问者模式类图](https://img-blog.csdnimg.cn/878e3f61d1374d24ae8599c03b762c45.png#pic_center)

## 实现代码

```java
/**
 * 动物类接口（元素接口Element）
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public interface Animal {
    /**
     * 接受访问者方法
     *
     * @param visitor 访问者
     */
    void accept(Visitor visitor);

    /**
     * 吃方法
     */
    void eat();

    /**
     * 叫声方法
     */
    void sound();
}

/**
 * 猫类（具体元素ConcreteElement）
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class Cat implements Animal {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void eat() {
        System.out.println("猫吃猫粮");
    }

    @Override
    public void sound() {
        System.out.println("喵喵喵");
    }
}

/**
 * 狗类（具体元素ConcreteElement）
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class Dog implements Animal {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void eat() {
        System.out.println("狗吃狗粮");
    }

    @Override
    public void sound() {
        System.out.println("汪汪汪");
    }
}
```

```java
/**
 * 访问者接口
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public interface Visitor {
    /**
     * 访问方法 接收具体能访问的元素ConcreteElement
     *
     * @param cat 猫
     */
    void visit(Cat cat);

    /**
     * 访问方法 接收具体能访问的元素ConcreteElement
     *
     * @param dog 狗
     */
    void visit(Dog dog);
}

/**
 * 吃东西方法的具体访问类 ConcreteVisitor
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class EatVisitor implements Visitor {
    @Override
    public void visit(Cat cat) {
        cat.eat();
    }

    @Override
    public void visit(Dog dog) {
        dog.eat();
    }
}

/**
 * 声音方法的具体访问类 ConcreteVisitor
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class SoundVisitor implements Visitor {
    @Override
    public void visit(Cat cat) {
        cat.sound();
    }

    @Override
    public void visit(Dog dog) {
        dog.sound();
    }
}
```

```java
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
```

```java
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
------输出------
        喂动物：
        猫吃猫粮
        狗吃狗粮
        听动物叫声
        喵喵喵
        汪汪汪
```

---

# 二十二、中介者模式

## 定义

中介者又叫做调停模式，是一种对象行为型模式，它降低了对象之间的耦合性，让对象易于被独立地调用，是迪米特法则（最少知道）的典型应用。

## 针对问题

类似于服务器转发两个客户端之间的消息场景，为了降低两个客户端之间的耦合性。试想，如果两个客户端需要发送消息，都需要直接调用对方提供的接收方法，那么耦合性就很高了，使用中介模式，可以降低耦合性。

## 实现步骤

1. 创建中介者接口Mediator，提供注册方法和转发方法。
2. 创建抽象同事类Colleague，提供接收和发送消息的方法，同时提供设置中介者的方法（注意：需要设置同一中介者，不同中介者维护的同事注册列表不一致）。
3. 为抽象同事类创建具体同事类ConcreteColleague1、ConcreteColleague2，实现父类的抽象方法。
4. 创建中介者对象，创建具体同事类对象，为具体同事类设置中介者对象，在中介者对象中注册同事对象，相互发送消息。

## 优缺点

1. 优点：避免同事类之间的过度耦合。
2. 缺点：同事类过多时，需要维护的注册列表信息会急剧膨胀，影响性能。

## UML类图

![中介者模式类图](https://img-blog.csdnimg.cn/844b8ac4ceb04d46b681f764b53cd8f3.png#pic_center)

## 实现代码

```java
/**
 * 中介者接口
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public interface Mediator {
    /**
     * 注册同事对象方法
     *
     * @param colleague 同事对象
     */
    void register(Colleague colleague);

    /**
     * 转发方法
     *
     * @param fromColleague 信息来源
     * @param targetId      目标id
     */
    void transmit(Colleague fromColleague, String targetId);
}

/**
 * 具体中介者类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class ConcreteMediator implements Mediator {
    private final Map<String, Colleague> colleagueMap = new HashMap<>();

    @Override
    public void register(Colleague colleague) {
        // 如果没注册过 则注册
        if (!colleagueMap.containsKey(colleague.getId())) {
            colleagueMap.put(colleague.getId(), colleague);
        }
    }

    @Override
    public void transmit(Colleague fromColleague, String targetId) {
        for (Map.Entry<String, Colleague> entry : colleagueMap.entrySet()) {
            // 如果目标同事已经注册 则调用其接收方法
            if (entry.getKey().equals(targetId)) {
                System.out.println("我是中介，收到来自" + fromColleague.getId() + "的信息，现在转发给id为:" + targetId + "的客户");
                entry.getValue().receive(fromColleague.getId());
            }
        }
    }
}
```

```java
/**
 * 抽象同事类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public abstract class Colleague {
    /**
     * 对象id
     */
    private final String id;
    /**
     * 使用的中介者对象
     */
    final Mediator mediator;

    public Colleague(String id, Mediator mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    /**
     * 获取id
     *
     * @return {@link String}
     */
    public String getId() {
        return id;
    }

    /**
     * 接收中介者转发信息的方法
     *
     * @param fromId 来源id
     */
    abstract void receive(String fromId);

    /**
     * 发送信息到中介者的方法
     *
     * @param targetId 目标id
     */
    abstract void send(String targetId);
}

/**
 * 具体同事类1
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(String id, Mediator mediator) {
        super(id, mediator);
    }

    @Override
    void receive(String fromId) {
        System.out.println("我的id是1，接收到来自id为:" + fromId + "发来的信息");
    }

    @Override
    void send(String targetId) {
        System.out.println("我的id是1，我要发送信息给id为：" + targetId + "的同事");
        mediator.transmit(this, targetId);
    }
}

/**
 * 具体同事类2
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(String id, Mediator mediator) {
        super(id, mediator);
    }

    @Override
    void receive(String fromId) {
        System.out.println("我的id是2，接收到来自id为:" + fromId + "发来的信息");
    }

    @Override
    void send(String targetId) {
        System.out.println("我的id是2，我要发送信息给id为：" + targetId + "的同事");
        mediator.transmit(this, targetId);
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建中介者对象
        Mediator mediator = new ConcreteMediator();

        // 创建同事对象 并使用同一个中介者对象
        Colleague colleague1 = new ConcreteColleague1("1", mediator);
        Colleague colleague2 = new ConcreteColleague2("2", mediator);

        // 注册同事对象
        mediator.register(colleague1);
        mediator.register(colleague2);

        // 互相发送消息
        colleague1.send("2");
        System.out.println("------------------");
        colleague2.send("1");
    }
}
------输出------
        我的id是1，我要发送信息给id为：2的同事
        我是中介，收到来自1的信息，现在转发给id为:2的客户
        我的id是2，接收到来自id为:1发来的信息
        ------------------
        我的id是2，我要发送信息给id为：1的同事
        我是中介，收到来自2的信息，现在转发给id为:1的客户
        我的id是1，接收到来自id为:2发来的信息
```

---

# 二十三、解释器模式

## 定义

给定一个语言，定义它的文法得一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。

## 针对问题

需要自定义一些描述语言并得到解释的场景下使用。比如：工作流的解释，通过自定义工作流图，根据工作节点类型，节点间的关系，解释程序应该怎样运行。

## 实现步骤

1. 创建上下文环境类Context，维护一些公共信息，如当前环境下某个符号代表什么含义，或提供一些公有操作方法等。
2. 创建表达式接口，提供解释方法。
3. 为上述接口提供两种不同的实现抽象类，分别是端点表达式抽象类和非端点表达式抽象类。端点表达式抽象类可看作叶子节点，存放一些值，非端点表达式抽象类用于链接多个端点表达式并指定之间的关系。
4. 为上述两个抽象类分别创建子类，实现父类接口方法。
5. 创建环境对象，设置当前环境下的一些语义文法等信息。
6. 调用环境对象提供的解释方法，实现某些语法在当前环境下的解释工作。

## 优缺点

1. 优点：能够自定义文法，比较灵活。
2. 缺点：实现复杂，执行效率低，逻辑复杂。现代编程环境中，除特殊需求外，很少使用。

## UML类图

![解释器模式类图](https://img-blog.csdnimg.cn/dcf72f27ed6047b3b69ade31a290ce7b.png#pic_center)

## 实现代码

```java
/**
 * 上下文类（存放当前环境下的一些公共信息
 * 当前demo中 存放的是端点表达式子类代表的意思 如”i“代表”我“
 * 也可以存放非端点表达式代表子类的一些信息 比如"."代表"爱" 此处为演示方便 没存
 * 同时 也可以放一些解释方法等）
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public class Context {
    /**
     * 端点表达式解释信息
     */
    private final Map<String, String> map = new HashMap<String, String>();

    /**
     * 设置表达式含义
     *
     * @param key   键
     * @param value 含义
     */
    public void setExpression(String key, String value) {
        map.put(key, value);
    }

    /**
     * 通过键 获取表达式含义
     *
     * @param key 关键
     * @return {@link String}
     */
    public String getValueByKey(String key) {
        return map.get(key);
    }

    /**
     * 翻译方法
     *
     * @param description 描述
     * @return {@link String} 根据描述得到的翻译
     */
    public String translate(String description) {
        // demo为了简化 直接解释了”.“用PointExpression类对象来解释 实际项目中 不同的表达式需要使用不同的表达式类来解释
        String[] strArray = description.split("\\.");
        Expression value1 = new ValueExpression(strArray[0]);
        Expression value2 = new ValueExpression(strArray[1]);
        return new PointExpression(value1, value2).interpreter(this);
    }
}
```

```java
/**
 * 表达式接口
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public interface Expression {
    /**
     * 解释方法
     *
     * @param context 上下文对象
     * @return {@link String}
     */
    String interpreter(Context context);
}

/**
 * 端点表达式抽象类
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public abstract class TerminalExpression implements Expression {
    /**
     * 键
     */
    final String key;

    /**
     * 构造方法（设置键 用于在Context中查找对应值）
     *
     * @param key 关键
     */
    public TerminalExpression(String key) {
        this.key = key.trim();
    }
}

/**
 * 非端点表达式抽象类
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public abstract class NonTerminalExpression implements Expression {
    /**
     * 端点表达式子类对象1
     */
    final Expression e1;
    /**
     * 端点表达式子类对象2
     */
    final Expression e2;

    /**
     * 构造方法（初始化端点表达式子类）
     *
     * @param e1 端点表达式子类对象1
     * @param e2 端点表达式子类对象2
     */
    protected NonTerminalExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
}

/**
 * 值表达式类
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public class ValueExpression extends TerminalExpression {
    /**
     * 构造方法
     *
     * @param key 键
     */
    public ValueExpression(String key) {
        super(key);
    }

    @Override
    public String interpreter(Context context) {
        return context.getValueByKey(key);
    }
}

/**
 * 点表达式类
 *
 * @author YuJianHui
 * @date 2022/09/02
 */
public class PointExpression extends NonTerminalExpression {
    /**
     * 构造方法
     *
     * @param e1 端点表达式对象1
     * @param e2 端点表达式对象2
     */
    protected PointExpression(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public String interpreter(Context context) {
        // 将”.“翻译成”爱“ 并链接两个端点表达式
        return e1.interpreter(context) + "爱" + e2.interpreter(context);
    }
}
```

```java
public class TestClass {
    public static void main(String[] args) {
        // 创建环境对象
        Context context = new Context();
        // 设置当前环境下 不同的符号代表的意思
        context.setExpression("i", "我");
        context.setExpression("you", "你");

        // 调用当前环境对语句进行解释
        System.out.println("i.you" + " 解释为=》 " + context.translate("i.you"));
    }
}
------输出------
        i.you 解释为=》 我爱你
```