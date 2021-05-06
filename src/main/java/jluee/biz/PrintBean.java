package jluee.biz;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

@Stateless
@LocalBean
public class PrintBean {
    @Asynchronous
    public void printAndForget() {
        System.out.println("*** printAndForget ***");
    }

    @Asynchronous
    public Future<String> printAndCheckLater() {
        System.out.println("*** printAndCheckLater ***");
        return new AsyncResult<>("OK");
    }
}