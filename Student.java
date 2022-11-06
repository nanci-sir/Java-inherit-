package Student;

public class Student {
    //实例成员变量，属于对象
    private  String name;

    //静态成员变量方法，有static修饰，用类和对象都能被访问
    public  static int getMax(int age1, int age2){
        return age1 > age2 ? age1 :age2;

    }
    //实例成员变量属于对象，只能被对象触发访问
    public void study(){
        System.out.println(name + "在好好学习天天向上！");

    }

    public static void main(String[] args) {

        //1.静态成员方法
        System.out.println(Student.getMax(10, 3));//10
        System.out.println(getMax(10, 3));//10

        //2.对象，实例方法
        Student s = new Student();
        s.name = "张三";
        s.study();//张三在好好学习天天向上！

        //3.对象也可以访问静态方法（不推荐）
        System.out.println(s.getMax(13,2));//13

    }

}
