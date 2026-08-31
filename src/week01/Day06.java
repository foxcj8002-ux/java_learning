package week01;
import java.util.Scanner;
public class Day06 {
    public static int deleteStu(String name,String[] names,double[] scores,int count) {
        int i = 0;
        for(;i < count;i++) {
            if(names[i].equals(name)) {
                break;
            }
        }
        if(i == count) {
            System.out.println("学生不存在");
        } else {
            for(int j = i;j < count-1;j++) {
                names[j] = names[j+1];
                scores[j] = scores[j+1];
            }
            count--;
            System.out.println("删除成功");
        }

        return count;
    }
    public static void getStu(String name,String[] names,double[] scores,int count) {
        for(int i = 0;i < count;i++) {
            if(names[i].equals(name)) {
                System.out.println(name + "的成绩为" + scores[i]);
                return;
            }
        }
        System.out.println("学生不存在");
        return;
    }
    public static double getAve(double[] scores,int count) {
        double sum = 0;
        for(double score : scores) {
            sum += score;
        }
        double average = sum/(double)count;
        return average;
    }
    public static void main(String[] args) {
        String[] names = new String[10];
        double[] scores = new double[10];

        names[0] = "张三";
        scores[0] = 85;

        names[1] = "李四";
        scores[1] = 92;

        names[2] = "王五";
        scores[2] = 78;

        names[3] = "赵六";
        scores[3] = 47;

        int count = 4;
        String name;
        Scanner sc =  new Scanner(System.in);
        System.out.println("欢迎使用学生管理系统v1");
        System.out.println("1. 查看所有学生\n" +
                "2. 添加学生\n" +
                "3. 删除学生\n" +
                "4. 查询学生\n" +
                "5. 计算平均分\n" +
                "6. 退出");
        first:
        while(true) {
            System.out.print("请输入你想使用的功能：");
            int n = sc.nextInt();
            sc.nextLine();//吃掉换行符
            switch (n) {
                case 1:
                    System.out.println("所有学生信息如下：");
                    for (int i = 0; i < count; i++) {
                        System.out.println(names[i] + ":" + scores[i]);

                    }
                    break;
                case 2:
                    System.out.print("请输入学生姓名：");
                    names[count] = sc.nextLine();
                    System.out.print("请输入学生成绩：");
                    scores[count] = sc.nextDouble();
                    count++;
                    System.out.println("添加成功");
                    break;
                case 3:
                    System.out.print("请输入想删除的学生姓名：");
                    name = sc.nextLine();
                    count = deleteStu(name,names,scores,count);
                    break;
                case 4:
                    System.out.print("请输入想查询的学生姓名：");
                    name = sc.nextLine();
                    getStu(name,names,scores,count);
                    break;
                case 5:
                    double ave = getAve(scores,count);
                    System.out.println("所有学生平均分为：" + ave);
                    break;
                case 6:
                    System.out.println("退出成功！");
                    break first;
                default:
                    System.out.println("无效指令");
                    System.out.println();
                    break;
            }

        }

    }
}
