package sakila.query;

// StatsDao 기능구현에 필요한 쿼리문들을 따로 분리함
public class StatsQuery {
	// 변경할 일이 없으므로 final로, 매번 객체를 생성할 필요가 없으므로 static(정적변수)으로 작성함
	public static final String SELECT_STATS_ONE = "SELECT day FROM stats WHERE day = ?";
	public static final String SELECT_STATS_TOTAL = "SELECT SUM(cnt) FROM stats";
	public static final String INSERT_STATS = "INSERT INTO stats(day, cnt) VALUE(?, 1)";
	public static final String UPDATE_STATS = "UPDATE stats SET cnt = cnt + 1 WHERE day = ?";
}
// 일별 접속자 카운트 select cnt from stats where day = ? // 총 접속자 카운트 select sum(cnt) from stats