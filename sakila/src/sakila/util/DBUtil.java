package sakila.util;

import java.sql.Connection;
import java.sql.DriverManager;

// DB접속에 필요한 코드들을 분리하여 작성
public class DBUtil {
	//DB에 연결하는 메소드
	public Connection getConnection() throws Exception {
		final String URL = "jdbc:mariadb://localhost:3306/sakila";
		final String USER = "root";
		final String PASSWORD = "java1004";
		System.out.println("debug : URL=" + URL); // 디버그
		System.out.println("debug : USER=" + USER); // 디버그
		System.out.println("debug : PASSWORD=" + PASSWORD); // 디버그

		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		conn.setAutoCommit(false);
		return conn;
	}
}
