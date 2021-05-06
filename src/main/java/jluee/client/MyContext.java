package jluee.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import java.util.Properties;

/**
 * @author 吴非凡
 */
public class MyContext {

    private static Context context = null;

    public static Context getContext() {
        if (context == null) {
            try {
                context = new InitialContext();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return context;
    }

}
