package Student;
//完成数组工具类的设计

public class TestDemo {
    private TestDemo(){

    }
    //定义静态方法
    public static String toString(int[] arr){
        //1.一些校验
        if(arr == null){
            return  null;

        }
        //2.返回内容
        String result = "[";
        for (int i = 0; i <arr.length ; i++) {
            result +=(i == arr.length - 1? arr[i] : arr[i] +"," );


        }
        result +="]";
        return  result;

    }
}
