package jluee.biz;

import javax.ejb.Remote;

@Remote
public interface SimpleSingletonRemote {
    public void change01();

    public int getValue();
}
