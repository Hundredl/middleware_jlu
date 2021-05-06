package jluee.control;

import jluee.client.MyContext;
import jluee.jms.producer.JMSProducer;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author 吴非凡
 */
@WebServlet(name = "MessageReceiverServlet", value = "/receiver")
public class MessageReceiverServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(JMSProducer.class.getName());
    private static final String DEFAULT_MESSAGE = "Welcome to JMS!";
    private static final String DEFAULT_CONNECTION_FACTORY = "java:/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "java:/queue/test";
    private static final String DEFAULT_MESSAGE_COUNT = "1";
    private static final String DEFAULT_USERNAME = "testJNDI";
    private static final String DEFAULT_PASSWORD = "123";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String PROVIDER_URL = "remote://localhost:4447";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //调用printAndForget方法
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Message Receiver</title>");

        Context context = MyContext.getContext();
        Connection connection = null;
        try {
            out.println("<h3>获取连接工厂!</h3>");
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);

            out.println("<h3>获取目的地!</h3>");
            Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);
            // 创建JMS连接、会话、生产者和消费者
            connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();

            CountDownLatch latch = new CountDownLatch(1);
            TextMessage msg = null;
            while (msg == null) {
                out.println("<h3>开始从JBOSS端接收信息-----</h3>");
                msg = (TextMessage) consumer.receive(5000);
                latch.await(1, TimeUnit.SECONDS);
                out.println("<h3>" + msg.getText() + "</h3>");
            }

        } catch (NamingException | JMSException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
