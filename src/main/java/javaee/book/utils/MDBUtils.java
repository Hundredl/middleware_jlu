package javaee.book.utils;

import java.io.*;

public class MDBUtils {
    public static void writeToFile(String path , String message)
    {
        String str="hello world!";
        FileWriter writer;
        try {
            File file = new File("E:/token.txt");
            if (!file.exists())
            {
                file.createNewFile();
            }
            writer = new FileWriter("E:/token.txt");
            writer.write(str);
            writer.flush();
            writer.close();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
