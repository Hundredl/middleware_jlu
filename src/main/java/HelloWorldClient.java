import bookIsbnVerify.IsbnVerifyService;
import mypackage.HelloWorldService;

public class HelloWorldClient {
  public static void main(String[] argv) {
      bookIsbnVerify.IsbnVerify service = new IsbnVerifyService().getIsbnVerifyPort();
      //invoke business method
      System.out.println(service.isbnVerify("test"));
  }
}
