![licence](https://img.shields.io/badge/licence-BY--NC--ND%204.0-blue.svg)
![Language](https://img.shields.io/badge/Language-%E4%B8%AD%E6%96%87-red.svg)

# 设计模式

> 设计模式代表了一系列编程中重复出现的问题的最佳解决方案。

## 六大原则

- **开闭原则（Open Close Principle）**：对扩展开放，对修改关闭。软件工程应该通过扩展的方法增加其规模，而不是通过不断地修改已有的代码。
- **里氏替换原则（Liskov Substitution Principle）**：任何基类可以出现的地方，子类一定可以出现。只有当子类可以替换掉基类，且软件的该功能不受到影响时，基类才能真正被复用，而子类也能够在基类的基础上增加新的行为。这一条算是开闭原则极其重要的补充。
- **依赖倒置原则（Dependence Inversion Principle）**：针对接口编程，而不是针对行为。针对抽象编程，而不是针对具体。这一条是上一条里氏替换原则的重要补充。
- **接口隔离原则（Interface Segregation Principle）**：顾名思义，将接口之间尽量隔离，拒绝聚合在一起，以职责隔离以角色分等等都好，总之不要将没有关系的接口拼合在一起，显得臃肿。
- **迪米特法则（Demeter Principle）**：官方解释为一个软件实体应当尽可能少的与其他实体发生相互作用。其实意思就是尽量减少模块与模块之间相互的依赖关系，从而达到降低耦合的效果，避免牵一发而动全身。
- **合成复用原则（Composite Reuse Principle）**：尽量使用组合的方式，而不是使用继承。组合优于继承。

  从上面的六大法则我们可以看出，所谓的设计模式其实就是强调降低耦合，降低依赖，提高复用。这六大法则只是给了我们一个方向，让我们有更好的实践指南，避免迷茫。但切忌过犹不及，过度优化过度设计都不是什么好事。

## 三大分类

### 创建型模式

> 创建模式旨在提供一种最佳的对象创建方式，使得对象的创建更加符合应用场景。

- 单例模式
  - [双重检查懒汉单例模式](./singleton/LazyDoubleCheckSingleton.java)
  - [内部静态类单例模式](./singleton/StaticInnerClassSingleton.java)
  - [内部静态类单例模式](./singleton/HungrySingleton.java)
  - [枚举单例模式](./singleton/EnumSingleton.java)

### 结构性模式

> 结构模式更加关注如何将编程模型进行更好的组合以得到更高的复用率。

### 行为型模式

> 行为型模式相对前两者，关注的重点在于对象之间彼此的各种行为。

## :mortar_board: 版权
所有文章遵循[知识共享 署名 - 非商业性使用 - 禁止演绎 4.0 国际许可协议](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh)，欢迎转载，尊重版权。
