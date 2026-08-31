package week01;
import javax.swing.text.SimpleAttributeSet;
import java.util.Arrays;
public class gradeCollector {
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
    public static double getAverage(int[] arr) {
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        double average = (double)sum/(double) arr.length;
        return average;
    }
    public static int countPass(int[] arr) {
        int count = 0;
        for(int i : arr) {
            if(i >= 60) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] grades = {78,91,65,49,79,90};
        Arrays.sort(grades);
//        int length = grades.length;
//        int max = grades[length-1];
//        int min = grades[0];
//        int sum = 0,num = 0;
//        for(int i : grades) {
//            sum += i;
//            if(i >= 60) {
//                num++;
//            }
//        }
//        double average = (double)sum/(double)length;
        int max = getMax(grades);
        int min = getMin(grades);
        double average = getAverage(grades);
        int num = countPass(grades);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("平均分：" + average);
        System.out.println("及格人数：" + num);
    }
}
