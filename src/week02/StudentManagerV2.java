package week02;
import week01.Student;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class StudentManagerV2 {
    public static boolean put(Map<String,Student> studentMap,Student student) {
        if(studentMap.containsKey(student.getId())) {
            System.out.println("学号已存在，添加失败");
            return false;
        } else {
            studentMap.put(student.getId(),student);
            System.out.println("添加成功");
            return true;
        }
    }
    public static boolean remove(Map<String,Student> studentMap,String Id) {
        if(studentMap.containsKey(Id)) {
            studentMap.remove(Id);
            System.out.println("删除成功");
            return true;
        } else {
            System.out.println("学生不存在");
            return false;
        }
    }
    public static boolean change(Map<String,Student> studentMap,String Id,Student student) {
        if (!Id.equals(student.getId())) {
            return false;
        }
        if(studentMap.containsKey(Id)) {
            studentMap.replace(Id,student);
            return true;
        } else {
            return false;
        }
    }
    public static void showAll(Map<String,Student> studentMap) {
        for(Student student : studentMap.values()) {
            System.out.println(student);
        }
    }
    public static void showByScore(Map<String,Student> studentMap) {
        TreeSet<Student> studentTreeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = Double.compare(o2.getScore(),o1.getScore());
                if(result != 0) {
                    return result;
                }else {
                    return o1.getId().compareTo(o2.getId());
                }

            }
        });
        studentTreeSet.addAll(studentMap.values());
        for (Student student : studentTreeSet) {
            System.out.println(student);
        }
    }




}
