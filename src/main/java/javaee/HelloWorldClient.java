package javaee;

import book.IsbnVerify;
import book.IsbnVerifyProxy;

import java.rmi.RemoteException;

public class HelloWorldClient {
  public static void main(String[] argv) {
      //bookIsbnVerify.IsbnVerify service = new IsbnVerifyService().getIsbnVerifyPort();
      //invoke business method
      //System.out.println(service.isbnVerify("test"));
      try {
          IsbnVerify service = new IsbnVerifyProxy();
          System.out.println(service.isbnVerify("a teacher"));
      } catch (RemoteException e) {
          e.printStackTrace();
      }
  }
}
