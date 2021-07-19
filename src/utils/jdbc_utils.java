package utils;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class jdbc_utils {
	private static int affectedLine = 0;
	private static Connection conn = null;
	private static PreparedStatement pt = null;
	private static ResultSet rs = null;
	public static int executeUpdate(String sql,Object... params) {
		
		try {
			conn = DBTools.getConncetion();
			pt = conn.prepareStatement(sql);
			if(params != null) {
				for(int i = 0;i<params.length;i++) {
					pt.setObject(i+1, params[i]);				
					
				}
			}
			affectedLine = pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBTools.close(conn, pt, null);
		}
		return affectedLine;
		
	}
	public static ResultSet executeQueryRS(String sql,Object... params) {
		try {
			conn = DBTools.getConncetion();
			pt = conn.prepareStatement(sql);
			if(params != null) {
				for(int i = 0;i<params.length;i++) {
					pt.setObject(i+1, params[i]);				
					
				}
			}
			rs = pt.executeQuery();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
		
		
	}
	
//	public static ArrayList<Object> excuteQuery(String sql,Object... params){
//		ResultSet rs = executeQueryRS(sql,params);
//		//创建ResultSetMetaData对象
//		ResultSetMetaData rsmd = null;
//		int columnCount = 0;//结果集列数
//		try {
//			rsmd = rs.getMetaData();
//			columnCount = rsmd.getColumnCount();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		ArrayList<Object> list = new ArrayList<Object>();
//		try {
//			while(rs.next()) {
//				Map<String,Object> map = new HashMap<String,Object>();
//				for(int i = 1;i<=columnCount;i++) {
//					map.put(rsmd.getColumnLabel(i), rs.getObject(i));
//				}
//				list.add(map);
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBTools.close(conn, pt, rs);
//		}
//		return list;
//	}
	

}
