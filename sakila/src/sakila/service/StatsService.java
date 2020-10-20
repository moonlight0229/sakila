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
	// 여러 개의 값을 불러로기 위해 Map을 사용
	public Map<String, Object> getStats() {
		statsDao = new StatsDao();
		
		Connection conn = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();

		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			Stats stats = new Stats();
			paramStats.setDay(this.getFormattedToday());
			System.out.println("debug : paramStats=" + paramStats);
						
			Stats todayStats = statsDao.selectStatsOne(conn, paramStats);
			Stats totalStats = statsDao.selectStatsTotal(conn);
			conn.commit();
			
			System.out.println("debug : todayStats=" + todayStats);
			System.out.println("debug : totalStats=" + totalStats);
			
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
		return returnStats;
	}

	// 방문자 수를 세는 메소드
	public void countStats() {
		statsDao = new StatsDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			Stats paramStats = new Stats();
			paramStats.setDay(this.getFormattedToday());
			System.out.println("debug : paramStats=" + paramStats);
			Stats todayStats = statsDao.selectStatsOne(conn, paramStats);
			System.out.println("debug : todayStats=" + todayStats);
			
			if(todayStats != null) {
				// 오늘 날짜에 방문자가 이미 있다면 기존 방문자 수에 1을 더함
				statsDao.updateStatsPlusOne(conn, todayStats);
			} else {
				// 오늘 날짜에 첫 방문자라면 오늘 날짜로 테이블 행을 생성하고 1로 시작
				statsDao.insertStats(conn, paramStats);
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
	// yyyy-mm-dd 형식으로 오늘 날짜를 출력하는 메소드
	private String getFormattedToday() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-mm-dd");
		String formattedDate = dateFormater.format(today.getTime());
		
		return formattedDate;
	}
}
