package week02;

import java.util.*;

import week01.Student;
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num%2 == 0) {
                iterator.remove();
            }
        }

        Student s1 = new Student("003", "张三", 18,90);
        Student s2 = new Student("001", "李四", 17,95);
        Student s3 = new Student("004", "王五", 18,90);
        Student s4 = new Student("002", "赵六", 18,80);
        TreeSet<Student> students =new TreeSet<>(
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if (o1.getScore() != o2.getScore()) {
                            return Double.compare(o2.getScore(), o1.getScore());
                        }
                        return o1.getId().compareTo(o2.getId());
                    }
                }
        );
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        for(Student student : students) {
            System.out.println(student);
        }

        Map<String,Student> studentMap = new HashMap<>();
        studentMap.put("003",s1);
        studentMap.put("001",s2);
        studentMap.put("004",s3);
        studentMap.put("002",s4);

        if(studentMap.containsKey("001")) {
            System.out.println(studentMap.get("001"));
        }
        if(studentMap.containsKey("004")) {
            System.out.println("学生已存在");
        } else {
            System.out.println("学生不存在");
        }
        for (String key : studentMap.keySet()) {
            System.out.println(key);
        }
        for (Student value : studentMap.values()) {
            System.out.println(value);
        }
        for(Map.Entry<String,Student> entry : studentMap.entrySet()) {
            System.out.println("key->" + entry.getKey() + ",value->" + entry.getValue());
        }
    }
}

