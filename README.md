# Java-inherit-
面向对象三大特征之二：继承
## 1 继承概述、使用继承的好处

#### 1.1 什么是继承？

Java中提供一个关键字extends，用这个关键字，我们可以让一个类和另一个类建立起父子关系。

Student称为子类（派生类），People称为父类(基类 或超类)。
作用：当子类继承父类后，就可以直接使用父类公共的属性和方法了

继承的优点： 可以提高代码的复用性。

#### 1.2 什么是继承? 继承的好处是啥？

继承就是java允许我们用extends关键字，让一个类和另一个类建立起一种父子关系。
提高代码复用性，减少代码冗余，增强类的功能扩展性。
继承的格式 子类 extends父类

#### 1.3继承后子类的特点？

子类 继承父类，子类可以得到父类的属性和行为，子类可以使用。
Java中子类更强大

## 2 继承的设计规范、内存运行原理

#### 2.1 继承设计规范：

子类们相同特征（共性属性，共性方法）放在父类中定义，子类独有的的属性和行为应该定义在子类自己里面。

#### 2.2 为什么？ 

如果子类的独有属性、行为定义在父类中，会导致其它子类也会得到这些属性和行为，这不符合面向对象逻辑。

#### 2.3**需求：**

 在传智教育的tlias教学资源管理系统中，存在学生、老师角色会进入系统。

```java
package exends;

import org.w3c.dom.ls.LSOutput;

public class People {
    //人类，父类
    private String name;
    private int age;
    public void  queryCourse(){
        System.out.println(name + "在查看课表");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

```java
package exends;

public class Student extends  People {
    //独有行为 子类
    public void  writeInfo(){
        System.out.println(getName() + "写了语法好happy");


    }
}
```

```java
package exends;

public class Test1 {
    public static void main(String[] args) {
        Student s = new Student();
            s.setName("张三");
            s.setAge(12);
        System.out.println(s.getName());
        System.out.println(s.getAge());
        s.queryCourse();
        s.writeInfo();
    }
    }
```

继承需要满足什么样的设计规范？
子类们相同特征（共性属性，共性方法）放在父类中定义。
子类独有的的属性和行为应该定义在子类自己里面。 

## 3 继承的特点

#### 3.1 继承的特点

子类可以继承父类的属性和行为，但是子类不能继承父类的构造器。
Java是单继承模式：一个类只能继承一个直接父类。
Java不支持多继承、但是支持多层继承。
Java中所有的类都是Object类的子类。

#### 3.2 子类是否可以继承父类的构造器？

不可以的，子类有自己的构造器，父类构造器用于初始化父类对象。

#### 3.3 子类是否可以继承父类的私有成员？

可以的，只是不能直接访问。

#### 3.4子类是否可以继承父类的静态成员？

有争议的知识点。
子类可以直接使用父类的静态成员（共享）
但个人认为：子类不能继承父类的静态成员。（共享并非继承）

```java
package exends;

public class Test2 {
    //理解继承特点
  //  子类是否可以继承父类的私有成员？
    //可以的只是不能直接访问
    public static void main(String[] args) {
        Dog d = new Dog();
        //t.eat();
        //子类是否可以继承父类的静态成员？
        //有争议的知识点。
        //子类可以直接使用父类的静态成员（共享）
        //但个人认为：子类不能继承父类的静态成员。（共享并非继承）
        System.out.println(Dog.location);
    }

}
class Animai{
    private  void eat(){
        System.out.println("动物要吃东西***");

    }
    //静态成员
    public static String location = "动物园";
}
class  Dog extends Animai{


}
```

Java只支持单继承，不支持多继承。(反证法)   Java支持多层继承

#### 3.5 Object特点：

Java中所有类，要么直接继承了Object , 要么默认继承了Object , 要么间接继承了Object, Object是祖宗类。

#### 3.6继承有哪些特点？

子类可以继承父类的属性和行为，但是子类不能继承父类的构造器。
Java是单继承模式：一个类只能继承一个直接父类。
Java不支持多继承、但是支持多层继承。
Java中所有的类都是Object类的子类。

## 4 继承后：成员变量、成员方法的访问特点

#### 4.1 在子类方法中访问成员（成员变量、成员方法）满足：就近原则

先子类局部范围找
然后子类成员范围找
然后父类成员范围找，如果父类范围还没有找到则报错。

如果子父类中，出现了重名的成员，会优先使用子类的，此时如果一定要在子类中使用父类的怎么办？
可以通过super关键字，指定访问父类的成员。

在子类方法中访问成员（成员变量、成员方法）满足：
就近原则，子类没有找子类、子类没有找父类、父类没有就报错！

#### 4.2如果子父类中出现了重名的成员，此时如果一定要在子类中使用父类的怎么办？

格式：super.父类成员变量/父类成员方法格式：

this.子类成员变量/子类成员方法

```java
package exends;

public class Test3 {
    public static void main(String[] args) {
        //成员方法
xiaomi x = new xiaomi();
x.run2();;//便宜
x.run();//5G
        x.showName();
    }
}
class iphone{
//父类
    public void run(){
        System.out.println("4G");
    }
    public String name = "爸爸";
}


class xiaomi   extends  iphone{
    //子类
    public String name = "儿子";
    public void  run2(){
        System.out.println("便宜");

    }
    public  void showName(){
        String name ="局部名";
        System.out.println(name);
        System.out.println(this.name);//找子类
        System.out.println(super.name);//找父类
        super.run();
    }
    public  void run(){
        System.out.println("5G");
    }
}
```

## 5 继承后：方法重写

#### 5.1 什么是方法重写？

在继承体系中，子类出现了和父类中一模一样的方法声明，我们就称子类这个方法是重写的方法。
方法重写的应用场景
当子类需要父类的功能，但父类的该功能不完全满足自己的需求时。
子类可以重写父类中的方法。

#### 5.2 案例演示：

旧手机的功能只能是基本的打电话，发信息
新手机的功能需要能够：基本的打电话下支持视频通话。基本的发信息下支持发送语音和图片

```java
package exends;

public class Teat4 {
    //认识方法重写
    public static void main(String[] args) {
        NewPhone hw = new NewPhone();
        hw.call();//打电话 视频通话
        hw.sendMsg();//发短信 发图片
    }
}
class Phone{
    public void call(){
        System.out.println("打电话");
    }
    public void sendMsg(){
        System.out.println("发短信");
    }
}
class NewPhone extends Phone{
    @Override
    public void call(){
        super.call();
        System.out.println("视频通话");
    }
    //重写的方法 校验注解 提高程序的可读性
    @Override
    public void sendMsg(){
        super.sendMsg();
        System.out.println("发图片");
    }
}
```

#### 5.3 @Override重写注解

@Override是放在重写后的方法上，作为重写是否正确的校验注解。
加上该注解后如果重写错误，编译阶段会出现错误提示。
**建议重写方法都加@Override注解，代码安全，优雅！**

#### 5.4 方法重写注意事项和要求

**重写方法的名称、形参列表必须与被重写方法的名称和参数列表一致。**
私有方法不能被重写。
子类重写父类方法时，访问权限必须大于或者等于父类 （暂时了解 ：缺省 < protected < public）
子类不能重方法重写是什么样的？
子类写一个与父类申明一样的方法覆盖父类的方法。
方法重写建议加上哪个注解，有什么好处？
@Override注解可以校验重写是否正确，同时可读性好。
重写方法有哪些基本要求？
重写方法的名称和形参列表应该与被重写方法一致。
私有方法不能被重写。
子类重写父类方法时，访问权限必须大于或者等于父类被重写的方法的权限。写父类的静态方法，如果重写会报错的。



## 6 继承后：子类构造器的特点

#### 6.1 子类继承父类后构造器的特点：

子类中所有的构造器默认都会先访问父类中无参的构造器，再执行自己。

#### 6.2 为什么？

子类在初始化的时候，有可能会使用到父类中的数据，如果父类没有完成初始化，子类将无法使用父类的数据。
子类初始化之前，一定要调用父类构造器先完成父类数据空间的初始化。

#### 6.3怎么调用父类构造器的？

子类构造器的第一行语句默认都是：super()，不写也存在。

```java
package Arr;

public class Animals {
    public  Animals(){
        System.out.println("父类Animal无参数构造器");
    }

}
```

```java
package Arr;

public class Dog extends Animals{
    public Dog(){
        System.out.println("子类Dog无参数构造器");

    }
    public Dog(String name){
        System.out.println("父类有参数构造器");

    }


}
```

```java
package Arr;

public class Test {
    public static void main(String[] args) {
        Dog d1 =new Dog();
        System.out.println(d1);
        System.out.println("*********");
        Dog d2 = new Dog("金毛");
        System.out.println(d2);
        //父类Animal无参数构造器
        //子类Dog无参数构造器
        //Arr.Dog@16b98e56
        //*********
        //父类Animal无参数构造器
        //父类有参数构造器
        //Arr.Dog@7ef20235
    }
}
```

#### 6.4 子类继承父类后构造器的特点是什么样的？

子类中所有的构造器默认都会先访问父类中无参的构造器，再执行自己。

## 7 继承后：子类构造器访问父类有参构造器

#### 7.1 super调用父类有参数构造器的作用：

 初始化继承自父类的数据。

如果父类中没有无参数构造器，只有有参构造器，会出现什么现象呢？
会报错。因为子类默认是调用父类无参构造器的。

#### 7.2 如何解决？

子类构造器中可以通过书写 super(…)，手动调用父类的有参数构造器

```java
package Arrr2;

public class People {
private String name;
private  int age;

public People() {
}

public People(String name, int age) {
    this.name = name;
    this.age = age;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}
}
```

```java
package Arrr2;

public class Teacher extends People {
    public  Teacher(String name,int age){
        //调用父类构造器,初始化父类数据
        //通过调用父类有参数构造器来初始化继承自父类的数据
        super(name, age);
    }
}
```

```java
package Arrr2;

public class Test {
    public static void main(String[] args) {


        Teacher t = new Teacher("张三", 12);
        System.out.println(t.getAge());
        System.out.println(t.getName());
    }
    }
```

1、super调用父类构造器的作用是什么？
通过调用父类有参数构造器来初始化继承自父类的数据

## 8 this、super使用总结

#### 8.1 this和super详情

this：代表本类对象的引用；super：代表父类存储空间的标识。

| **关键字** | **访问成员变量**                 | **访问成员方法**                    | **访问构造方法**              |
| ---------- | -------------------------------- | ----------------------------------- | ----------------------------- |
| **this**   | this.成员变量  访问本类成员变量  | this.成员方法(…)  访问本类成员方法  | **this(…)**  **访问本类构器** |
| **super**  | super.成员变量  访问父类成员变量 | super.成员方法(…)  访问父类成员方法 | super(…)  访问父类构造器      |

```java
package Arrr2;

public class Student {
    private String name;
private String schoolName;

public Student() {
}
public Student(String name){
    this(name,"西安外事学院");
}

public Student(String name, String schoolName) {
    this.name = name;
    this.schoolName = schoolName;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getSchoolName() {
    return schoolName;
}

public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
}
}
```


```java
package Arrr2;

public class Test2 {
    public static void main(String[] args) {
        //this访问兄弟构造器
        Student s1 =new Student("张三","北京大学");
        System.out.println(s1.getName());
        System.out.println(s1.getSchoolName());

        Student s2 = new Student("南辞");
        System.out.println(s2.getName());
        System.out.println(s2.getSchoolName());
           //张三
        //北京大学
        //南辞
        //西安外事学院

    }
}
```
