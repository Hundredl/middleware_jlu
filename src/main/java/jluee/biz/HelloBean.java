//创建实现远程接口Bean类
package jluee.biz;

import javax.ejb.Stateless;

/**
 * @author 吴非凡
 */
@Stateless
public class HelloBean implements HelloBeanRemote {

    public HelloBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String sayHello(String name) {

        return "Hello " + name + "!";

    }
}
