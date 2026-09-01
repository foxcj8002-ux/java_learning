package week01;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class stuManagementV2 {
    public static void main(String[] args) {
        Student s1 = new Student("1","张三",17,80);
        Student s2 = new Student("2","李四",18,90);
        Student s3 = new Student("3","王五",16,59);
        Student s4 = new Student("4","赵六",17,87);
        //初始化学生列表
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(s1,s2,s3,s4));

        Scanner sc =new Scanner(System.in);
        String id,name;
        int age;
        double score;

        System.out.println("欢迎使用学生管理系统v1");
        System.out.println("1. 查看所有学生\n" +
                "2. 添加学生\n" +
                "3. 删除学生\n" +
                "4. 查询学生\n" +
                "5. 计算平均分\n" +
                "6. 退出");
        first:
        while (true) {
            System.out.print("请输入你想使用的功能：");
            int opt = sc.nextInt();
            sc.nextLine();
            second:
            switch (opt) {
                case 1:
                    System.out.println("所有学生信息如下：");
                    System.out.println("ID" + "\t" + "姓名" + "\t" + "年龄" + "\t" + "成绩");
                    for(Student s : students) {
                        System.out.println(s.getId() + "\t" +s.getName() + "\t" +s.getAge() + "\t" + s.getScore());
                    }
                    break ;
                case 2:
                    System.out.print("请输入学生ID:");
                    id = sc.nextLine();
                    System.out.print("请输入学生姓名:");
                    name = sc.nextLine();
                    System.out.print("请输入学生年龄:");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("请输入学生成绩:");
                    score = sc.nextDouble();
                    sc.nextLine();
                    Student stu = new Student(id,name,age,score);
                    students.add(stu);
                    System.out.println("添加成功！");
                    break ;
                case 3:
                    System.out.print("请输入想要删除的学生的名字：");
                    name = sc.nextLine();
                    int i = 0;
                    for(Student s : students){
                        if(s.getName().equals(name)) {
                            students.remove(i);
                            System.out.println("删除成功！");
                            break second;
                        }
                        i++;
                    }
                    System.out.println("学生不存在！");
                    break;
                case 4:
                    System.out.print("请输入想要查询的学生的名字：");
                    name = sc.nextLine();
                    int j = 0;
                    for(Student s : students){
                        if(s.getName().equals(name)) {
                            System.out.println("ID" + "\t" + "姓名" + "\t" + "年龄" + "\t" + "成绩");
                            System.out.println(s.getId() + "\t" +s.getName() + "\t" +s.getAge() + "\t" + s.getScore());
                            break second;
                        }
                        j++;
                    }
                    System.out.println("学生不存在！");
                    break;
                case 5:
                    double sum = 0;
                    for(Student s : students) {
                        sum += s.getScore();
                    }
                    double average = sum/(double) students.size();
                    System.out.println("学生平均分为：" + average);
                    break;
                case 6:
                    System.out.println("退出成功！");
                    break first;
                default:
                    System.out.println("无效指令！");
                    break ;
            }
        }
    }


}
