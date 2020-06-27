package com.utils;

/**
 * @author GUO
 * @Classname MyContextListener
 * @Description TODO
 * @Date 2020/6/24 0:32
 */
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("webService start");
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
//        System.out.println("webService stop");
        try {
            while(DriverManager.getDrivers().hasMoreElements()) {
                DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            }
//            System.out.println("jdbc Driver close");
            AbandonedConnectionCleanupThread.checkedShutdown();
//            System.out.println("clean thread success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
