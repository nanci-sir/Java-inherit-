package Student;

public class test {
    //静态成员
    public  static int onLineNumber = 10;
    public static  void  test2(){
        System.out.println("===test2===");
    }
    //实例成员
    private String name;
    public  void run(){
        System.out.println(name + "跑的快");
    }
    //ststic访问相关语法
    //3.静态方法中是不可以出现this关键字的，
    public static void test3(){
       // System.out.println(name);

    }

    //2.实例方法可以访问静态的成员，也可以访问实例成员。
    public  void go(){
        System.out.println(test.onLineNumber);
        System.out.println(onLineNumber);
        test();
        System.out.println(name);
        run();//对象触发
        //this可以出现在实例
        System.out.println(this.name);
        System.out.println(this);
    }

    public  static  void  test(){
        //1. 静态方法只能访问静态的成员，不可以直接访问实例成员。
        System.out.println(test.onLineNumber);
        System.out.println(onLineNumber);
        test();
        // System.out.println(name);不可以直接访问实例成员
    }
    public static void main(String[] args) {
    }
}
