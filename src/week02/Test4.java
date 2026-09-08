package week02;
import week01.Student;

import java.util.*;

public class Test4 {

    public static void removeFailedStudents(Map<String, Student> studentMap) {
//        Iterator<Map.Entry<String,Student>> iterator = studentMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            double score = iterator.next().getValue().getScore();
//            if(score < 60) {
//                iterator.remove();
//            }
//        }
        Iterator<Student> iterator = studentMap.values().iterator();
        while (iterator.hasNext()) {
            double score = iterator.next().getScore();
            if (score < 60) {
                iterator.remove();
            }
        }
    }

    public static Map<Double, Integer> countScores(Map<String, Student> studentMap) {
        Map<Double,Integer> scoreCount = new HashMap<>();
        for(Student student : studentMap.values()) {
            int count = scoreCount.getOrDefault(student.getScore(),0);
            scoreCount.put(student.getScore(),count+1);
        }
        return scoreCount;
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

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            double score = iterator.next().getScore();
            if(score < 60) {
                iterator.remove();
            }
        }
        for(Student s : students) {
            System.out.println(s);
        }


        Map<String,Student> studentMap = new HashMap<>();
        studentMap.put("001",s1);
        studentMap.put("002",s2);
        studentMap.put("003",s3);
        studentMap.put("004",s4);
        studentMap.put("005",s5);
        studentMap.put("006",s6);
        studentMap.put("007",s7);
        studentMap.put("008",s8);
        //removeFailedStudents(studentMap);

        for (Map.Entry<String,Student> entry : studentMap.entrySet()) {
            System.out.println("key->" + entry.getKey() + ",value->" + entry.getValue());
        }

        Map<Double,Integer> scoreCount = countScores(studentMap);
        for (Map.Entry<Double,Integer> entry : scoreCount.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}
