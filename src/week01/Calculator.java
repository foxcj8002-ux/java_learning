package week01;
import java.util.Scanner;
public class Calculator {
    public static double add(double num1,double num2){
        return num1 + num2;
    }
    public static double sub(double num1,double num2){
        return num1 - num2;
    }

    public static double mul(double num1,double num2){
        return num1*num2;
    }

    public static double div(double num1,double num2){
        return num1/num2;
    }
    public static void main(String[] args) {
        double num1,num2;
        String operator;
        Scanner sc = new Scanner(System.in);
        System.out.print("input your first number:");
        num1 = sc.nextDouble();
        System.out.print("input your second number:");
        num2 = sc.nextDouble();
        System.out.print("input your operator:");
        operator = sc.next();

        switch (operator){
            case "+":
                System.out.println(num1 + "+" + num2 + "=" + add(num1,num2));
                break;
            case "-":
                System.out.println(num1 + "-" + num2 + "=" + sub(num1,num2));
                break;
            case "*":
                System.out.println(num1 + "*" + num2 + "=" + mul(num1,num2));
                break;
            case "/":
                System.out.println(num1 + "/" + num2 + "=" + div(num1,num2));
                break;
            default:
                System.out.println("无效操作符");
                break;
        }
    }


}
