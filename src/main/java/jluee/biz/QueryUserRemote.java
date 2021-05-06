package jluee.biz;
import jluee.entity.User;

import javax.ejb.Remote;
import java.io.IOException;

/**
 * @author 吴非凡
 */
@Remote
public interface QueryUserRemote {
    /**
     * 远程接口
     * @param name name
     * @return result
     */
    public byte[] queryUser(String username);
}

