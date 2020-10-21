package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;

import sakila.dao.StaffDao;
import sakila.util.DBUtil;
import sakila.vo.Staff;

public class StaffService {
	private StaffDao staffDao; // StaffDao 객체 선언
	
	public Staff getStaffByKey(Staff staff) {
		Staff returnStaff = null;
		
		staffDao = new StaffDao(); // 메소드를 호출하기 위해 객체 생성
		Connection conn = null; // Connection 객체 메소드 전역 선언
		
		try {
			DBUtil dbUtil = new DBUtil(); // DB 정보가 담긴 객체 생성
			conn = dbUtil.getConnection(); // DB 접속
			
			// 트랜잭션 실행
			returnStaff = staffDao.selectStaffByKey(conn, staff);
			
			// 트랜잭션 성공 시 commit 수행
			conn.commit();			
		} catch (Exception e) {
			try {
				conn.rollback(); // 트랜잭션 실패 시 rollback
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // DB 접속을 종료
			} catch (SQLException e) {
				e.printStackTrace(); // 오류가 발생해도 오류 메세지 출력
			}
		}
		
		return returnStaff;
	}
}
