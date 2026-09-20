package week03;

import week01.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = List.of(10,30,40,28,50);

        list.stream()
                .sorted((a,b)->Integer.compare(b,a))
                .forEach(System.out::println);

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

        Optional<Double> score = students.stream()
                .filter(student -> student.getScore()>=60)
                .sorted((a,b)->Double.compare(b.getScore(),a.getScore()))
                .map(Student::getScore)
                .findFirst();

        List<String> names = students.stream()
                .filter(student -> student.getScore()>=60)
                .sorted((a,b)->Double.compare(b.getScore(), a.getScore()))
                .limit(3)
                .map(Student::getName)
                //.toList();//返回不可变列表
                .collect(Collectors.toList());

        names.add("hh");

        double total = students.stream()
                .map(s -> s.getScore())
                .reduce(0.0, (a, b) -> a + b);

        double average = students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0.0);



    }
}
