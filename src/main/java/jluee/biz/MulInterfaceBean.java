package jluee.biz;

import javax.ejb.EJB;

public class MulInterfaceBean implements HelloRemote, HelloLocal, MulBy2Remote {
    int value = 1;

    //生成本地接口实例
    @EJB
    HelloLocal hello;

    public MulInterfaceBean() {
    }

    public String sayHelloFromLocal(String name) {
        return " Hello " + name + " from local!";
    }

    public String sayHelloFromRemote(String name) {
        String result = null;
        result = hello.sayHelloFromLocal(name);
        return result;
    }

    public int mul() {
        value = value * 2;
        return value;
    }

    @Override
    public void cancel() {

    }
}


