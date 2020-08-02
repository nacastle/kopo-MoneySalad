package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	public Connection getConnection(String url, String user, String password) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			
//			conn = DriverManager.getConnection(url, user, password);
			conn = getConnection(url, user, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
//	실행되는지 테스트
//	public static void main(String[] args) {
//		Connection conn = new ConnectionFactory().getConnection();
//		String url = "jdbc:oracle:thin:@172.16.88.120:1521:dink";
//		String user = "DA14";
//		String password = "1111";
//		Connection conn = new ConnectionFactory().getConnection(url, user, password);
//		System.out.println(conn);
//	}
}





