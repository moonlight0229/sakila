package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	public Staff selectStaffByKey(Connection conn, Staff staff) throws Exception {
		Staff returnStaff = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setString(1, staff.getEmail());
		stmt.setString(2, staff.getPassword());
			
		ResultSet rs = stmt.executeQuery();
		System.out.println("StaffDao/selectStaffByKey/debug : rs=" + rs); // 디버그
		
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setEmail(rs.getString("email"));
			returnStaff.setPassword(rs.getString("username"));
			System.out.println("StaffDao/selectStaffByKey/debug : email=" + rs.getString("email")); // 디버그
			System.out.println("StaffDao/selectStaffByKey/debug : username=" + rs.getString("username")); // 디버그
		}
		
		return returnStaff;
	}
}
