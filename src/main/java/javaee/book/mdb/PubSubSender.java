package javaee.book.mdb;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PubSubSender {
    private static final Logger log = Logger.getLogger(PubSubSender.class.getName());
    private static final String DEFAULT_MESSAGE = "Welcome to JMS!";
    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "jms/queue/test";
    private static final String DEFAULT_MESSAGE_COUNT = "1";
    private static final String DEFAULT_USERNAME = "testJNDI";
    private static final String DEFAULT_PASSWORD = "123";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String PROVIDER_URL = "remote://localhost:4447";

    public static void main(String[] args) throws Exception {
        Context context = null;
        Connection connection = null;
        try {
            // 设置上下文
            System.out.println("设置JNDI访问环境信息也就是设置应用服务器的上下文信息!");
            final Properties env = new Properties();
            //初始化Context的工厂类
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            //Context服务提供者的URL
            env.put(Context.PROVIDER_URL, PROVIDER_URL);
            //应用用户的登录名,密码.
            env.put(Context.SECURITY_PRINCIPAL, DEFAULT_USERNAME);
            env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD);
            // 获取到InitialContext对象.
            context = new InitialContext(env);
            System.out.println("获取连接工厂!");
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);

            System.out.println("获取目的地!");
            Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);
            // 创建JMS连接、会话、生产者和消费者
            connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            connection.start();
            int count = Integer.parseInt(DEFAULT_MESSAGE_COUNT);
            // 发送特定数目的消息
            TextMessage message = null;
            for (int i = 0; i < count; i++) {
                message = session.createTextMessage(DEFAULT_MESSAGE);
                producer.send(message);
                System.out.println("message:" + message);
                System.out.println("message:" + DEFAULT_MESSAGE);
            }

            // 等待30秒退出
            CountDownLatch latch = new CountDownLatch(1);
            latch.await(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.severe(e.getMessage());
            throw e;
        } finally {
            if (context != null) {
                context.close();
            }
            // 关闭连接负责会话,生产商和消费者
            if (connection != null) {
                connection.close();
            }
        }
    }
}