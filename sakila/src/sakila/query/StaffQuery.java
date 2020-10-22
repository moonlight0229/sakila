package sakila.query;

public class StaffQuery {
	// 로그인 쿼리
	public final static String SELECT_STAFF_BY_KEY = "SELECT email, username FROM staff WHERE email = ? AND PASSWORD = PASSWORD(?)";
}
