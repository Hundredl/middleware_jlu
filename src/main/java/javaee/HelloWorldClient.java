package javaee;

/*import book.IsbnVerify;
import book.IsbnVerifyProxy;
import javaee.bigws.HelloWS;
import javaee.bigws.HelloWSProxy;*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

public class HelloWorldClient {
  public static void main(String[] argv) {
      //bookIsbnVerify.IsbnVerify service = new IsbnVerifyService().getIsbnVerifyPort();
      //invoke business method
      //System.out.println(service.isbnVerify("test"));
      /*try {
          HelloWS service = new HelloWSProxy();
          System.out.println(service.sayHelloWS("a teacher!!!!"));
      } catch (RemoteException e) {
          e.printStackTrace();
      }*/
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
