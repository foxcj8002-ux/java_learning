package week02;

import java.util.ArrayList;
import java.util.Iterator;

import week01.Student;


public class Day01 {
    public static void main(String[] args) {
        Student s1 =new Student("1","张三",18,90);
        Student s2 =new Student("1","李四",19,98);
        Student s3 =new Student("2","王五",18,90);
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));

        }
        for(Student student : students) {
            System.out.println(student);
        }

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("s1.equals(s2)?" + s1.equals(s2));
        System.out.println("s1.equals(s3)?" + s1.equals(s3));
        System.out.println("s1==s2?" + (s1==s2));
        System.out.println("s1.hashCode()==s2.hashCode()?" + (s1.hashCode()==s2.hashCode()));
        System.out.println("s1.hashCode()==s3.hashCode()?" + (s1.hashCode()==s3.hashCode()));
        System.out.println(s1);
    }


}
