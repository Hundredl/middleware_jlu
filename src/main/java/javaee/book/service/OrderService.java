package javaee.book.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Stateless
public class OrderService {
    public void writeToFile(String path , String message)
    {
        FileWriter writer;
        try {
            File file = new File("E:/token.txt");
            if (!file.exists())
            {
                file.createNewFile();
            }
            writer = new FileWriter("E:/token.txt");
            writer.write(message);
            writer.flush();
            writer.close();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
