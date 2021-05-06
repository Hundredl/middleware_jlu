package jluee.biz;

import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

@Stateful
public class MulBy2Bean implements MulBy2Remote {
    int i = 1;

    public MulBy2Bean() {
    }

    @Override
    public int mul() {
        i = i * 2;
        return i;
    }

    @Override
    public void cancel() {
        i = 0;
        System.out.println("重置i=" + i);
    }

    @PreDestroy
    public void endEJB() {
        System.out.println("predestroy is called");
    }

}
