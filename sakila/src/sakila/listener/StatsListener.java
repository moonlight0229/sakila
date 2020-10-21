package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener {
	private StatsService statsService;
	public StatsListener() {}
	// 세션 생성시 방문자 수를 1 증가시키는 메소드
    public void sessionCreated(HttpSessionEvent se)  {
    	if(se.getSession().isNew()) { // 새로운 세션이 맞는지 확인
    		// 오늘 방문자 수를 1 증가 시키는 service 실행
    		statsService = new StatsService();
    		statsService.addStats();
    	}
    }

    public void sessionDestroyed(HttpSessionEvent se)  { // 세션 종료시 실행되는 메소드
    }
}