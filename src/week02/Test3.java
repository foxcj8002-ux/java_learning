package week02;
import week01.Student;

import java.util.*;


public class Test3 {
    public static boolean put(Map<String,Student> studentMap,String id ,Student s) {
        if (studentMap.containsKey(id)) {
            System.out.println("学号已存在");
            return false;
        } else {
            studentMap.put(id,s);
            return true;
        }
    }
    public static void get(Map<String,Student> studentMap,String id) {
        Student s = studentMap.get(id);
        if(s != null) {
            System.out.println("查询结果：" + s);
        } else {
            System.out.println("未找到该学生");
        }
    }

    public static void printStudentsAboveScore(Map<String,Student> studentMap,double minScore) {
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getScore() != o2.getScore()) {
                    return Double.compare(o2.getScore(),o1.getScore());
                }
                return o1.getId().compareTo(o2.getId());
            }
        });
        for(Student s : studentMap.values()) {
            if(s.getScore() >= minScore) {
                students.add(s);
            }
        }
        if(students.isEmpty()) {
            System.out.println("没有符合条件的学生");
        } else {
            for(Student s : students) {
                System.out.println(s.getName() + " " + s.getScore());
            }
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("001", "张三", 18,85.5);
        Student s2 = new Student("002", "李四",18,92.0);
        Student s3 = new Student("003", "王五", 18,76.5);
        Student s4 = new Student("004", "赵六", 18,92.0);
        Student s5 = new Student("005", "孙七", 18,88.0);
        Student s6 = new Student("002", "重复李四", 18,60.0);
        Map<String,Student> studentMap = new HashMap<>();
        put(studentMap,"001",s1);
        put(studentMap,"002",s2);
        put(studentMap,"003",s3);
        put(studentMap,"004",s4);
        put(studentMap,"005",s5);
        put(studentMap,"002",s6);
        get(studentMap,"003");

        TreeSet<Student> studentTreeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getScore() != o2.getScore()) {
                    return Double.compare(o1.getScore(),o2.getScore());
                }
                return o1.getId().compareTo(o2.getId());
            }
        });
        //studentTreeSet.addAll(studentMap.values());
        for(Student s : studentMap.values()) {
            studentTreeSet.add(s);
        }
        for(Student s : studentTreeSet) {
            System.out.println(s);
        }

//        Student maxStudent = null;
//
//        for (Student s : studentMap.values()) {
//            if (maxStudent == null ||
//                    Double.compare(s.getScore(), maxStudent.getScore()) > 0) {
//                maxStudent = s;
//            }
//        }
//
//        if (maxStudent != null) {
//            System.out.println(maxStudent.getName() + "  " + maxStudent.getScore());
//        }
        Student maxStudent = null;
        List<Student> maxStudents = new ArrayList<>();
        for (Student s : studentMap.values()) {
            if (maxStudent == null || Double.compare(s.getScore(), maxStudent.getScore()) > 0) {
                maxStudents.clear();
                maxStudent = s;
                maxStudents.add(s);
            } else if (Double.compare(s.getScore(), maxStudent.getScore()) == 0) {
                maxStudents.add(s);
            }
        }
        for(Student s : maxStudents) {
            System.out.println(s.getName() + " " + s.getScore());
        }

        Map<String, List<Student>> scoreGroups = new LinkedHashMap<>();
        scoreGroups.put("90分及以上", new ArrayList<>());
        scoreGroups.put("80~89.9", new ArrayList<>());
        scoreGroups.put("60~79.9", new ArrayList<>());
        scoreGroups.put("60分以下", new ArrayList<>());
        for(Student s : studentMap.values()) {
            if(s.getScore() >= 90) {
                scoreGroups.get("90分及以上").add(s);
            } else if (s.getScore()>=80 && s.getScore()<=89.9) {
                scoreGroups.get("80~89.9").add(s);
            } else if(s.getScore()>=60 && s.getScore()<=79.9) {
                scoreGroups.get("60~79.9").add(s);
            } else {
                scoreGroups.get("60分以下").add(s);
            }
        }
        for(Map.Entry<String, List<Student>> entry : scoreGroups.entrySet()) {
            System.out.println(entry.getKey() + ":");
            if(entry.getValue().isEmpty()) {
                System.out.println("无");
            }
            for(Student s : entry.getValue()) {
                System.out.println(s.getName() + " " + s.getScore());
            }
            System.out.println();
        }

        for(Map.Entry<String, List<Student>> entry : scoreGroups.entrySet()) {
            System.out.print(entry.getKey() + ":");
            if(entry.getValue().isEmpty()) {
                System.out.println("0人");
            } else {
                int count = entry.getValue().size();
                double sum = 0;
                for(Student s : entry.getValue()){
                    sum += s.getScore();
                }
                double average = sum/count;
                System.out.println(count + "人" + ",平均分" + average);
            }

            printStudentsAboveScore(studentMap, 85);
            printStudentsAboveScore(studentMap, 95);
        }
    }

}
