package week03;

import java.io.*;

public class IOTest {
    public static void main (String[] args) throws IOException {
        //读取
        try(FileReader fileReader =
                    new FileReader("D:\\Workspace\\java_learning\\file.txt");){
            int data = fileReader.read();
            while(data != -1) {
                System.out.println((char)data);
                data = fileReader.read();
            }
        }
        //写入
        try (FileWriter writer =
                     new FileWriter("D:\\Workspace\\java_learning\\file.txt")) {

            writer.write("Hello Java");
        }
        //追加
        try(FileWriter writer =
                    new FileWriter("D:\\Workspace\\java_learning\\file.txt",true)) {
            writer.write("Hello Java");
        }

        //复制
        try(FileInputStream input =
                    new FileInputStream("D:\\Workspace\\java_learning\\file.txt");
            FileOutputStream output =
                    new FileOutputStream("D:\\Workspace\\java_learning\\file1.txt")
            ) {
            byte[] buffer = new byte[8];
            int len;
            while ((len=input.read(buffer)) != -1) {
                output.write(buffer,0,len);
            }
        }


    }
}
