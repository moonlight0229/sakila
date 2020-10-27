package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	// paramStats의 날짜를 받아와 방문자가 있었는지 확인하는 메소드
	// 있으면 날짜와 방문자 수를 Stats vo로 반환, 없으면 null을 반환
	public Stats selectDayStats(Connection conn, Stats stats) throws Exception {
		System.out.println("StatsDao/selectDayStats/debug : StatsDao selectDayStats 실행"); // 디버그
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_DAY_STATS);
		stmt.setString(1, stats.getDay());
		System.out.println("StatsDao/selectDayStats/debug : stmt=" + stmt); // 디버그
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCnt(rs.getLong("cnt"));
		}
		System.out.println("StatsDao/selectDayStats/debug : returnStats=" + returnStats); // 디버그
		
		return returnStats;
	}
	
	// 총 방문자 수를 조회하는 메소드
	public Stats selectTotalStats(Connection conn) throws Exception {
		System.out.println("StatsDao/selectTotalStats/debug : StatsDao selectTotalStats 실행"); // 디버그
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_TOTAL_STATS);
		
		ResultSet rs = stmt.executeQuery();
		System.out.println("StatsDao/selectTotalStats/debug : rs=" + rs); // 디버그
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setCnt(rs.getLong("sum(cnt)"));
		}
		System.out.println("StatsDao/selectTotalStats/debug : returnStats=" + returnStats); // 디버그
		
		return returnStats;
	}
	
	// paramStats으로 받아온 오늘 날짜가 없으므로 오늘 날짜를 테이블에 새로 입력하고 방문자 수 1부터 시작(cnt를 1부터 시작)하는 메소드
	public void insertStatsStart(Connection conn, Stats stats) throws Exception {
		System.out.println("StatsDao/insertStatsStart/debug : StatsDao insertStatsStart 실행"); // 디버그
		System.out.println("StatsDao/insertStatsStart/debug : stats=" + stats); // 디버그
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS_START);
		stmt.setString(1, stats.getDay());
		System.out.println("StatsDao/insertStatsStart/debug : stmt=" + stmt); // 디버그
		
		int updatedRow = stmt.executeUpdate();
		System.out.println("StatsDao/insertStatsStart/debug : updatedRow=" + updatedRow); // 디버그
	}
	
	// paramStats으로 받아온 오늘 날짜가 이미 있으므로 방문자 수 1 증가(cnt 증가)하는 메소드
	public void updateStatsAdd(Connection conn, Stats stats) throws Exception {
		System.out.println("StatsDao/updateStatsAdd/debug : StatsDao updateStatsAdd 실행"); // 디버그
		System.out.println("StatsDao/updateStatsAdd/debug : paramStats=" + stats); // 디버그
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS_ADD);
		stmt.setString(1, stats.getDay());
		System.out.println("StatsDao/updateStatsAdd/debug : stmt=" + stmt); // 디버그
		
		int updatedRow = stmt.executeUpdate();
		System.out.println("StatsDao/updateStatsAdd/debug : updatedRow=" + updatedRow); // 디버그
		
	}
}
