package jluee.biz;

import javax.ejb.Remote;

@Remote
public interface MulBy2Remote {
    public int mul();

    public void cancel();
}
