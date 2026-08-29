package week01;
import java.util.Scanner;


public class Day01 {
    //常量
    public static final double PI = 3.14;
    public static void main(String[] args) {
        //p1
        String name = "foxcj";
        int age = 18;
        double height = 170.5;
        boolean graduateStudent = false;

        System.out.println(name);
        System.out.println(age);
        System.out.println(height);
        System.out.println("graduateStudent:" + graduateStudent);

        //p2
        Scanner input = new Scanner(System.in);
        System.out.println("输入姓名：");
        name = input.next();
        System.out.println("输入身高(米)：");
        height = input.nextDouble();
        System.out.println("输入体重(kg)：");
        double weight = input.nextDouble();

        System.out.println(name + "的BMI指数为：" + weight/(height*height));

        input.close();
    }
}
