package Arrr2;

public class Teacher extends People {
    public  Teacher(String name,int age){
        //调用父类构造器,初始化父类数据
        //通过调用父类有参数构造器来初始化继承自父类的数据
        super(name, age);
    }
}
