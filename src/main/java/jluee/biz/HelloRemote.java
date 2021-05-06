package jluee.biz;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
    public String sayHelloFromRemote(String name);
}
