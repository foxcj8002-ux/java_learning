package week01;
import java.util.Scanner;
import java.util.Arrays;
public class Day07 {
    public static void main(String[] args) {
        //p1 BMI计算
        double height = 1.7;
        double weight = 55;
        double bmi = weight/(height*height);
        System.out.println("BMI指数为：" + bmi);

        //p2 成绩判断
        Scanner sc = new Scanner(System.in);
        System.out.print("输入成绩：");
        int score = sc.nextInt();
        if(score >= 89) {
            System.out.println("优秀");
        } else if(score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        //p3 1-100求和
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += i;
        }
        System.out.println(sum);

        //p4 成绩统计
        int[] scores = {78,79,90,67,89,20};
        Arrays.sort(scores);
        sum = 0;
        int num = 0;
        for(int i : scores) {
            sum += i;
            if(i >= 60) {
                num++;
            }
        }
        double average = (double)sum/(double)scores.length;
        System.out.println("最高分：" + scores[scores.length-1]);
        System.out.println("最低分：" + scores[0]);
        System.out.println("平均分：" + average);
        System.out.println("及格人数：" + num);

        //p4 学生管理系统
        String[] arg = {};
        stuManagementV2.main(arg);
    }
}
