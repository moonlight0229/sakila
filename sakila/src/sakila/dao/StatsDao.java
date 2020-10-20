package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	// paramStats의 날짜를 받아와 그 날에 접속자가 있었는지 판별하는 메소드
	// Stats VO에 접속자가 있으면 그 날의 접속자 수를 반환, 없으면 null을 반환함 
	public Stats selectStatsOne(Connection conn, Stats paramStats) throws Exception {
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_STATS_ONE);
		stmt.setString(1, paramStats.getDay());
		System.out.println("debug : stmt=" + stmt); // 디버그
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCnt(rs.getLong("cnt"));
		}
		System.out.println("debug : returnStats=" + returnStats); // 디버그
		
		return returnStats;
	}
	
	// 총 방문자 수를 출력하는 메소드
	public long selectStatsTotal(Connection conn) throws Exception {
		long totalCnt = 0;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_STATS_TOTAL);
		ResultSet rs = stmt.executeQuery();
		System.out.println("debug : stmt=" + stmt); // 디버그
		
		if(rs.next()) {
			totalCnt = rs.getLong("sum(cnt)");
		}
		System.out.println("debug : totalCnt=" + totalCnt); // 디버그
		
		return totalCnt;
	}
	
	// 오늘 날짜가 없으므로 오늘 날짜를 테이블에 새로 입력하고 cnt를 시작(1로 시작)
	public void insertStats(Connection conn, Stats paramStats) throws Exception {
		//INSERT_STATS
	}
	
	// 오늘 날짜가 이미 있으므로 cnt만 증가
	public void updateStatsPlusOne(Connection conn, Stats paramStats) throws Exception {
		//UPDATE_STATS
	}
}
