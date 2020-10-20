package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {
    public DBListener() {}
    public void contextDestroyed(ServletContextEvent arg0) {}
    public void contextInitialized(ServletContextEvent arg0) { 
    	System.out.println("debug : DBListener.contextInitialized() 실행"); // 디버그
    	try {
    		Class.forName("org.mariadb.jdbc.Driver");
    		System.out.println("debug : mariadb 드라이브로딩 성공"); // 디버그
    	} catch (ClassNotFoundException e) {
    		System.out.println("debug : Class.forName() 실행 실패!"); // 디버그
    		e.printStackTrace();
    	}
    }
}