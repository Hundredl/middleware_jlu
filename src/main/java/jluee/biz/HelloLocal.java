package jluee.biz;

import javax.ejb.Local;

@Local
public interface HelloLocal {
    public String sayHelloFromLocal(String name);
}
