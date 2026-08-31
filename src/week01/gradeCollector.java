package week01;
import java.util.Arrays;
public class gradeCollector {
    public static void main(String[] args) {
        int[] grades = {78,91,65,49,79,90};
        Arrays.sort(grades);
        int length = grades.length;
        int max = grades[length-1];
        int min = grades[0];
        int sum = 0,num = 0;
        for(int i : grades) {
            sum += i;
            if(i >= 60) {
                num++;
            }
        }
        double average = (double)sum/(double)length;

        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("平均分：" + average);
        System.out.println("及格人数：" + num);
    }
}
