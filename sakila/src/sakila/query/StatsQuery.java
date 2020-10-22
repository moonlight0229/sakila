package sakila.query;

// StatsDao 기능구현에 필요한 쿼리문들을 따로 분리한 메소드
public class StatsQuery {
	// 변경할 일이 없으므로 final로 작성함
	// 매번 객체를 생성할 필요가 없으므로 static(정적변수)으로 작성함
	
	// 오늘 날짜의 방문자 수를 조회하는 쿼리문
	public static final String SELECT_DAY_STATS = "SELECT day, cnt FROM stats WHERE day = ?";
	// 총 방문자 수를 조회하는 쿼리문
	public static final String SELECT_TOTAL_STATS = "SELECT SUM(cnt) FROM stats";
	// DB에 오늘 날짜를 입력하고 방문자 수를 1로 입력하는 쿼리문
	public static final String INSERT_STATS_START = "INSERT INTO stats(day, cnt) VALUE(?, 1)";
	// 오늘 날짜로 방문자 수를 1 증가 시키는 쿼리문
	public static final String UPDATE_STATS_ADD = "UPDATE stats SET cnt = cnt + 1 WHERE day = ?";
}