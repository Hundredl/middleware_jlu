package javaee.book.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Stateless
public class OrderService {
    public void writeToFile(String path , String message)
    {
        //long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间 有8小时时差
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 8);// 24小时制 , 加8小时
        date = cal.getTime();
        String filename = "order "+sdf.format(date);//String.valueOf(date);
        FileWriter writer;
        try {
            File file = new File(path+filename);
            if (!file.getParentFile().exists())
            {
                file.getParentFile().mkdir();
            }
            if (!file.exists())
            {
                if (!file.createNewFile())//如果没有创建成功就return
                {
                    return;
                }
            }
            writer = new FileWriter(path+filename);
            writer.write(message);
            writer.flush();
            writer.close();
            //System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
