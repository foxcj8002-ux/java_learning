package week03;

import week01.Student;

import javax.sound.midi.Soundbank;
import java.awt.event.ItemEvent;
import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentDataManagement {
    public static Map<String, Student> loadStudents(String filePath)
            throws IOException {
        // 自己实现
        Map<String, Student> map = new HashMap<>();
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split(",");
//                Student student = new Student(data[0],data[1],Integer.parseInt(data[2]),Double.parseDouble(data[3]));
//                map.put(data[0],student);
//            }

            map = reader.lines()
                    .map(line->{
                        String[] data = line.split(",");
                        Student student = new Student(data[0],data[1],Integer.parseInt(data[2]),Double.parseDouble(data[3]));
                        return student;
                    })
                    .collect(Collectors.toMap(Student::getId,student -> student,(oldStudent, newStudent) -> oldStudent));


        }
        return map;
    }
    public static void saveStudents(
            String filePath,
            Map<String, Student> studentMap)
            throws IOException {
        try(BufferedWriter writer =
                    new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : studentMap.values()) {
                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getScore()
                );
                writer.newLine();
            }
        }
    }
    public static Student findStudent(
            Map<String, Student> studentMap,
            String id) {
        //
        return studentMap.get(id);

    }
    public static boolean addStudent(
            Map<String, Student> studentMap,
            Student student) {
        // ...
        if(studentMap.containsKey(student.getId())) {
            return false;
        } else {
            studentMap.put(student.getId(),student);
            return true;
        }
    }
    public static boolean removeStudent(
            Map<String, Student> studentMap,
            String id) {
        // ...
        return studentMap.remove(id) != null;
    }
    public static boolean updateStudent(
            Map<String, Student> studentMap,
            String id,
            String newName,
            int newAge,
            double newScore) {
        // ...
        Student s = new Student(id,newName,newAge,newScore);
        return  studentMap.replace(id,s) != null;
    }
    public static double getAverageScore(
            Map<String, Student> studentMap) {
        // ...
        return studentMap.values().stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0.0);
    }
    public static Student getTopStudent(
            Map<String, Student> studentMap) {
        // ...
        return studentMap.values().stream()
                .max((a, b) -> Double.compare(a.getScore(), b.getScore()))
                .orElse(null);
    }
    public static void writeLog(
            String logPath,
            String message) throws IOException {
        // ...
        try(FileWriter writer =
                    new FileWriter(logPath,true)) {
            writer.write(message);
            writer.write(System.lineSeparator());

        }
    }
    public static boolean addStudentAndSave(
            Map<String, Student> studentMap,
            Student student,
            String dataPath,
            String logPath) throws IOException {
        // ...
        if(!addStudent(studentMap,student)) {
            writeLog(logPath,"ADD_FAILED " + student.getId());
            return false;
        }
        saveStudents(dataPath,studentMap);
        writeLog(logPath,"ADD " + student.getId());
        return true;
    }
    public static boolean removeStudentAndSave(
            Map<String, Student> studentMap,
            String id,
            String dataPath,
            String logPath) throws IOException {
        if(!removeStudent(studentMap,id)) {
            writeLog(logPath,"DELETE_FAILED " + id);
            return false;
        }
        saveStudents(dataPath,studentMap);
        writeLog(logPath,"DELETE " + id);
        return true;
    }
    public static boolean updateStudentAndSave(
            Map<String, Student> studentMap,
            String id,
            String newName,
            int newAge,
            double newScore,
            String dataPath,
            String logPath) throws IOException {
        // ...
        if(!updateStudent(studentMap,id,newName,newAge,newScore)) {
            writeLog(logPath,"UPDATE_FAILED " + id);
            return false;
        }
        saveStudents(dataPath,studentMap);
        writeLog(logPath,"UPDATE " + id);
        return true;
    }
    public static Student findStudentAndLog(
            Map<String, Student> studentMap,
            String id,
            String logPath) throws IOException {

        Student student = findStudent(studentMap, id);

        if (student != null) {
            writeLog(logPath, "QUERY " + id);
            return student;
        }

        writeLog(logPath, "QUERY_FAILED " + id);
        return null;
    }

    public static void main(String[] args) {
        String filePath = "D:\\Workspace\\java_learning\\students.txt";
        String logPath = "operation.log";
        try{
            Map<String,Student> stuMap = loadStudents(filePath);
            Scanner sc = new Scanner(System.in);
            System.out.println("欢迎使用学生管理系统v2");
            System.out.println("1. 查询学生\n" +
                    "2. 添加学生\n" +
                    "3. 删除学生\n" +
                    "4. 修改学生\n" +
                    "5. 显示全部学生\n" +
                    "6. 查看平均分\n" +
                    "7. 查看最高分学生\n" +
                    "8. 退出");
            first:
            while (true) {
                String id,name;
                int age;
                double score;
                System.out.print("请输入你想使用的功能：");
                int opt = sc.nextInt();
                sc.nextLine();
                switch (opt) {
                    case 1:
                        System.out.println("请输入你想查询的学生学号：");
                        id = sc.nextLine();
                        Student s = findStudentAndLog(stuMap,id,logPath);
                        if(s == null) {
                            System.out.println("学生不存在");
                        } else {
                            System.out.println(s);
                        }
                        break;
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
                        Student stu = new Student(id, name, age, score);
                        if(addStudentAndSave(stuMap,stu,filePath,logPath)) {
                            System.out.println("添加成功");
                        } else {
                            System.out.println("添加失败");
                        }
                        break;
                    case 3:
                        System.out.println("请输入你想删除的学生学号：");
                        id = sc.nextLine();
                        if (removeStudentAndSave(stuMap,id,filePath,logPath)) {
                            System.out.println("删除成功");
                        } else {
                            System.out.println("删除失败");
                        }
                        break;
                    case 4:
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

                        if (updateStudentAndSave(stuMap,id,name,age,score,filePath,logPath)) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                        break;
                    case 5:
                        for (Student student : stuMap.values()) {
                            System.out.println(
                                    student.getId() + "," +
                                            student.getName() + "," +
                                            student.getAge() + "," +
                                            student.getScore()
                            );
                        }
                        break;
                    case 6:
                        System.out.println("平均分为：" + getAverageScore(stuMap));
                        break;
                    case 7:
                        Student topStudent = getTopStudent(stuMap);
                        if (topStudent == null) {
                            System.out.println("当前没有学生数据");
                        } else {
                            System.out.println("最高分学生为：" + topStudent.getName()
                                    + "，成绩：" + topStudent.getScore());
                        }
                        break;
                    case 8:
                        break first;
                    default:
                        System.out.println("请重新输入");
                        break;
                }

            }
        } catch (FileNotFoundException e1) {
            System.out.println("FileNotFoundException => " + e1.getMessage());
        } catch (NumberFormatException e2) {
            System.out.println("NumberFormatException => " + e2.getMessage());
        } catch (IOException e3) {
            System.out.println("IOException => " + e3.getMessage());
        }

    }
}
