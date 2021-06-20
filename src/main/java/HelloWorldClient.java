import mypackage.HelloWorldService;

public class HelloWorldClient {
  public static void main(String[] argv) {
      mypackage.HelloWorld service = new HelloWorldService().getHelloWorldPort();
      //invoke business method
      service.sayHelloWorldFrom("hello");
      System.out.println(service.sayHelloWorldFrom("appp"));
  }
}
