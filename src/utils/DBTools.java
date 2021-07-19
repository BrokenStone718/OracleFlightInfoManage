package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTools {
	static Connection conn = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;
	private static String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static String DB_USER = "scott";
	private static String DB_PWD = "tiger";
	public static Connection getConncetion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
		} catch (Exception e) {
			System.out.println("¼ÓÔØÇý¶¯Ê§°Ü");
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conncetion,PreparedStatement preparedStatement,ResultSet resultSet) {
		if(resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conncetion!=null) {
			try {
				conncetion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
	}

}
