package week02;
import week01.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagerTest {
    public static void main(String[] args) {
        Student s1 = new Student("001", "张三", 18,85.5);
        Student s2 = new Student("002", "李四",18,92.0);
        Student s3 = new Student("003", "王五", 18,76.5);
        Student s4 = new Student("004", "赵六", 18,92.0);
        Student s5 = new Student("005", "孙七", 18,88.0);
        Student s6 = new Student("006", "周八", 18,56.0);

        Map<String,Student> studentMap = new HashMap<>();
        studentMap.put("001",s1);
        studentMap.put("002",s2);
        studentMap.put("003",s3);
        studentMap.put("004",s4);
        studentMap.put("005",s5);
        studentMap.put("006",s6);

        Scanner sc =new Scanner(System.in);
        String id,name;
        int age;
        double score;
        System.out.println("欢迎使用学生管理系统v2");
        System.out.println("1. 添加学生\n" +
                "2. 删除学生\n" +
                "3. 修改学生\n" +
                "4. 按学号查询\n" +
                "5. 显示全部学生\n" +
                "6.按成绩排序\n" +
                "7. 退出");
        first:
        while (true) {
            System.out.print("请输入你想使用的功能：");
            int opt = sc.nextInt();
            sc.nextLine();
            second:
            switch (opt) {
                case 1:
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
                    Student stu = new Student(id, name, age, score);
                    StudentManagerV2.put(studentMap,stu);
                    break;
                case 2:
                    System.out.print("请输入想要删除的学生的ID：");
                    id = sc.nextLine();
                    StudentManagerV2.remove(studentMap,id);
                    break;
                case 3:
                    System.out.print("请输入想要修改的学生的ID：");
                    id = sc.nextLine();
                    System.out.print("请输入修改后的学生姓名:");
                    name = sc.nextLine();
                    System.out.print("请输入修改后的学生年龄:");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("请输入修改后的学生成绩:");
                    score = sc.nextDouble();
                    sc.nextLine();
                    Student stu1 = new Student(id, name, age, score);
                    if (StudentManagerV2.change(studentMap, id, stu1)) {
                        System.out.println("修改成功");
                    } else {
                        System.out.println("学生不存在，修改失败");
                    }
                    break;
                case 4:
                    System.out.print("请输入想要查询的学生的ID：");
                    id = sc.nextLine();
                    if(studentMap.containsKey(id)) {
                        System.out.println(studentMap.get(id));
                    } else {
                        System.out.println("学生不存在！");
                    }
                    break;
                case 5:
                    System.out.println("所有学生信息如下：");
                    StudentManagerV2.showAll(studentMap);
                    break;
                case 6:
                    System.out.println("排序结果如下");
                    StudentManagerV2.showByScore(studentMap);
                    break;
                case 7:
                    System.out.println("退出成功！");
                    break first;
                default:
                    System.out.println("无效指令！");
                    break;
            }
        }
    }
}
