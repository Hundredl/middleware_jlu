package jluee.biz;

import javax.ejb.Singleton;

/**
 * @author 吴非凡
 */
@Singleton
public class SimpleSingletonBean implements SimpleSingletonRemote {
    int i = 0;

    public SimpleSingletonBean() {
    }

    @Override
    public void change01() {
        if (i == 0) {
            i = 1;
        } else {
            i = 0;
        }
    }

    @Override
    public int getValue() {
        return i;
    }
}
