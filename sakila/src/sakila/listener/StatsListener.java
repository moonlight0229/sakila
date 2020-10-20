package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener {
	private StatsService statsService;
	public StatsListener() {}
    public void sessionCreated(HttpSessionEvent se)  { // 세션 생성시 실행되는 메소드
    	if(se.getSession().isNew()) { // 새로운 세션이 생성되면 카운트
    		statsService = new StatsService();
    		statsService.countStats();
    	}
    }

    public void sessionDestroyed(HttpSessionEvent se)  { // 세션 종료시 실행되는 메소드
    }
}