package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import sakila.dao.StatsDao;
import sakila.vo.Stats;
import sakila.util.DBUtil;

public class StatsService {
	private StatsDao statsDao;
	
	// 오늘 방문자 수를 조회 + 총 방문자 수를 조회하는 메소드
	/* 
	 * 여러 값을 불러오기 위해 Map을 사용
	 * "todayStats" 키에 오늘 날짜와 오눌 방문자 수가 담긴 Stats 객체를 반환
	 * "totalCount" 키에 총 방문자 수가 담긴 Long 객체(long 타입 래퍼 클래스)를 반환
	 */ 
	public Map<String, Object> getStats() {
		statsDao = new StatsDao();
		
		Connection conn = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();

		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			Stats paramStats = new Stats();
			paramStats.setDay(this.getFormattedToday());
			System.out.println("StatsService/getStats/debug : paramStats=" + paramStats);
						
			Stats todayStats = statsDao.selectDayStats(conn, paramStats);
			Stats totalStats = statsDao.selectTotalStats(conn);
			conn.commit();
			
			System.out.println("StatsService/getStats/debug : todayStats=" + todayStats); // 디버그
			System.out.println("StatsService/getStats/debug : totalStats=" + totalStats); // 디버그
			
			returnMap.put("todayStats", todayStats);
			returnMap.put("totalStats", todayStats.getCnt());
			
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return returnMap;
	}

	// 방문자 수를 1씩 증가시키는 메소드
	public void addStats() {
		statsDao = new StatsDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			Stats paramStats = new Stats();
			paramStats.setDay(this.getFormattedToday());
			Stats todayStats = statsDao.selectDayStats(conn, paramStats);
			System.out.println("StatsService/addStats/debug : paramStats=" + paramStats); // 디버그
			System.out.println("StatsService/addStats/debug : todayStats=" + todayStats); // 디버그
			
			if(todayStats != null) {
				// 오늘 날짜에 방문자가 이미 있다면 기존 방문자 수에 1을 더함
				statsDao.updateStatsAdd(conn, todayStats);
			} else {
				// 오늘 날짜에 첫 방문자라면 오늘 날짜로 테이블 행을 생성하고 1로 시작
				statsDao.insertStatsStart(conn, paramStats);
			}
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// yyyy-MM-dd 형식으로 오늘 날짜를 출력하는 메소드
	private String getFormattedToday() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormater.format(today.getTime());
		System.out.println("StatsService/getFormattedToday/debug : formattedDate=" + formattedDate); // 디버그
		return formattedDate;
	}
}
