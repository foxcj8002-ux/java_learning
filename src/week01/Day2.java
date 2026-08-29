package week01;

public class Day2 {
    public static void main(String[] args) {
        double number1 = 12.5, number2 = 3.5, result;

        //使用加法运算符
        result = number1 + number2;
        System.out.println("number1 + number2 = " + result);

        //使用减法运算符
        result = number1 - number2;
        System.out.println("number1 - number2 = " + result);

        //使用乘法运算符
        result = number1 * number2;
        System.out.println("number1 * number2 = " + result);

        //使用除法运算符
        result = number1 / number2;
        System.out.println("number1 / number2 = " + result);

        // 使用余数运算符
        result = number1 % number2;
        System.out.println("number1 % number2 = " + result);

        int a = 3;//定义一个变量；
        int b = ++a;//自增运算
        int c = 3;
        int d = --c;//自减运算
        System.out.println("进行自增运算后的值等于"+b);
        System.out.println("进行自减运算后的值等于"+d);
        int x = 2*++a;
        int y = 2*b++;
        System.out.println("自增运算符前缀运算后a="+a+",x="+x);
        System.out.println("自增运算符后缀运算后b="+b+",y="+y);
    }
}
