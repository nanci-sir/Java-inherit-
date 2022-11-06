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
