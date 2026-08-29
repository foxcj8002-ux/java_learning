package week01;
import java.util.Scanner;
public class scoreJudge {
    public static void main(String[] args) {
        System.out.println("请输入你的分数：");
        Scanner sc = new Scanner(System.in);
        int score =sc.nextInt();
        if(score>=0 && score<=100) {
            if(score>=90) {
                System.out.println("优秀");
            } else if(score>=60) {
                System.out.println("及格");
            } else {
                System.out.println("不及格");
            }
        } else {
            System.out.println("无效成绩");
        }
    }
}
