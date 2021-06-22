package javaee.book.mdb;

import javaee.book.service.OrderService;
import javaee.book.utils.GlobalVar;
import javaee.book.utils.MDBUtils;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//设置消息驱动Bean监听的目的类型为Topic、目的地址为topic/test、可持久性存储消息以及用户ID
@MessageDriven(activationConfig =  {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "clientID", propertyValue = "consumer")
})
public class PubSubMDB implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;
    @EJB
    private OrderService orderService;
    public PubSubMDB() {
    }
    public void onMessage(Message inMessage) {
        TextMessage msg;
        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                //System.out.println("PubSub消息驱动Bean 1 接收到的消息:" + msg.getText());
                orderService.writeToFile(GlobalVar.orderOutPath,msg.getText());
            }
            else {
                System.out.println("消息的类型不正确： " + inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }

    }
}
