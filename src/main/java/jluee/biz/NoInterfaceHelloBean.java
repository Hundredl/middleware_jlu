package jluee.biz;

import javax.ejb.Stateless;

/**
 * @author 吴非凡
 */
@Stateless
public class NoInterfaceHelloBean {
    public NoInterfaceHelloBean() {
    }

    public String sayHello(String s) {
        String message = "hello: " + s;
        return message;
    }
}
