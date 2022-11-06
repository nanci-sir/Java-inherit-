package Student;

import java.util.Random;

public class Util {
    //由于工具类无需创造对象，所以把其构造器私有化会显得很专业
    private Util(){

    }
    //工具类
    public static String crezteVerifyCode(int n) {
        //静态成员方法
        String code = "";
        String data = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            //获取随机索引，得到几个字符
            int index = r.nextInt(data.length());
            code += data.charAt(index);
        }
        return code;
    }
    }
