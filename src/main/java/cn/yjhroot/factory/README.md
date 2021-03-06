# 工厂模式

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

## 详细信息

1. [简单工厂模式](./simplefactory)
2. [工厂方法模式](./factory)
3. [抽象工厂模式](./abstractfactory)
