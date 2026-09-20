package week03;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class IoPractice1 {
    public static void writeLog(String message) throws IOException{
        try(FileWriter fileWriter =
                    new FileWriter("app.log",true)) {
            fileWriter.write(message + System.lineSeparator());
        }
    }
    public static void copyFile(String source, String target) throws IOException{
        try(FileInputStream fis =
                    new FileInputStream(source);
            FileOutputStream fos =
                    new FileOutputStream(target)) {
            byte[] buffer = new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        }
    }
    public static void printErrors(String filePath) throws IOException {
        try(BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(filePath))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                if(data.contains("ERROR")) {
                    System.out.println(data);
                }
            }
        }
    }
    public static void createDirectories(String path) {
        File file = new File(path);

        if (file.exists()) {
            System.out.println("目录已经存在");
        } else if (file.mkdirs()) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }
    }
    public static void copyByFiles(String source, String target) throws IOException{
        Files.copy(Path.of(source),Path.of(target), StandardCopyOption.REPLACE_EXISTING);
    }
    public static void main(String[] args) throws IOException {
        try(FileWriter fileWriter =
                    new FileWriter("students.txt");
            ){
            fileWriter.write("1001,张三,85\n" +
                    "1002,李四,92\n" +
                    "1003,王五,76");

        }
        try(BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("students.txt"))) {
            String data;
            while ((data=bufferedReader.readLine())!=null) {
                System.out.println(data);
            }
        }
    }
}
