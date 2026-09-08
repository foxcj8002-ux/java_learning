package week02;
import week01.Student;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Test5 {
    public static void printQualifiedStudentReport(Map<String, Student> studentMap, double minScore) {
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = Double.compare(o2.getScore(), o1.getScore());

                if (result != 0) {
                    return result;
                }

                return o1.getId().compareTo(o2.getId());
            }
        });
        for(Student student : studentMap.values()) {
            if(student.getScore() >= minScore) {
                students.add(student);
            }
        }
        if(students.isEmpty()){
            System.out.println("没有符合条件的学生");
            return;
        }
        for(Student student : students) {
            System.out.println(student.getId() + " " + student.getName() + " " + student.getScore()) ;
        }
        double maxScore = 0;
        for(Student student : students) {
            if(student.getScore() > maxScore) {
                maxScore = student.getScore();
            }
        }
        System.out.println("最高分：" + maxScore);
        double sum = 0;
        for(Student student : students) {
            sum += student.getScore();
        }
        double average = sum/students.size();
        System.out.println("平均分：" + average);
    }
    public static void main(String[] args) {
        Student s1 = new Student("001", "张三", 18,85.5);
        Student s2 = new Student("002", "李四",18,92.0);
        Student s3 = new Student("003", "王五", 18,76.5);
        Student s4 = new Student("004", "赵六", 18,92.0);
        Student s5 = new Student("005", "孙七", 18,88.0);
        Student s6 = new Student("006", "周八", 18,56.0);
        Student s7 = new Student("007", "吴九", 18,76.5);
        Student s8 = new Student("008", "郑十", 18,45.0);

        Map<String,Student> studentMap = new HashMap<>();
        studentMap.put("001",s1);
        studentMap.put("002",s2);
        studentMap.put("003",s3);
        studentMap.put("004",s4);
        studentMap.put("005",s5);
        studentMap.put("006",s6);
        studentMap.put("007",s7);
        studentMap.put("008",s8);

        printQualifiedStudentReport(studentMap,60);
    }
}
