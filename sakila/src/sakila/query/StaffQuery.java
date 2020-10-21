package sakila.query;

public class StaffQuery {
	public final static String SELECT_STAFF_BY_KEY = "SELECT staff_id, username FROM staff WHERE staff_id = ? AND PASSWORD = PASSWORD(?)";
}
