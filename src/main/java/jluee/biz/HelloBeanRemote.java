package jluee.biz;
import javax.ejb.Remote;

/**
 * @author 吴非凡
 */
@Remote
public interface HelloBeanRemote {
    /**
     * 远程接口
     * @param name name
     * @return result
     */
    public String sayHello(String name);
}

