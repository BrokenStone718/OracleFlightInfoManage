package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import User.Flight;
import User.Userinfo;
import utils.DBTools;
import utils.jdbc_utils;

public class UserDAO {

	public static int userlogin(String username, String pwd) {
		String sql = "select * from user_info where \"USERNAME\" = ? and \"PASSWORD\" = ? ";
		int i = jdbc_utils.executeUpdate(sql,username,pwd);
		return i;
	}
	public static int adminlogin(String username, String pwd) {
		String sql = "select * from admin_info where \"USERNAME\" = ? and \"PASSWORD\" = ? ";
		int i = jdbc_utils.executeUpdate(sql,username,pwd);
		return i;
	}
	public static int reg(String username, String pwd) {
		String sql = "insert into user_info(\"USERNAME\",\"PASSWORD\") values(?,?)";
		int i = jdbc_utils.executeUpdate(sql, username,pwd);
		return i;
	}
	public static int insert(String hB, String hJ, String hZ, String jZ, String yW, String sC, String eC, String sD) {
		String sql = "insert into flight_info(\"HBH\",\"HZL\",\"JZXM\",\"SFYW\",\"YJFXSJ\",\"SFCS\",\"MDD\",\"HJT\") values (?,?,?,?,?,?,?,?)";
		int i = jdbc_utils.executeUpdate(sql, hB,hZ,jZ,yW,sD,sC,eC,hJ);
		return i;
	}
	public static List<Flight> getHBHList(String hbh) {
		String sql = "select * from flight_info where \"HBH\" = ?";
		ResultSet rs = jdbc_utils.executeQueryRS(sql, hbh);
		List<Flight> list = new ArrayList<Flight>();
		try {
			while(rs.next()) {
				String HBH = rs.getString("HBH");
				String HZL = rs.getString("HZL");
				String JZXM = rs.getString("JZXM");
				String SFYW = rs.getString("SFYW");
				String SFCS = rs.getString("SFCS");
				String MDD = rs.getString("MDD");
				String HJT = rs.getString("HJT");
				String YJFXSJ = rs.getString("YJFXSJ");
				Flight flight = new Flight(HBH,HZL,HJT,JZXM,SFYW,YJFXSJ,SFCS, MDD);
				list.add(flight);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBTools.close(null, null, rs);
		}
		
		return list;
	}
	public static List<Flight> getECList(String ec) {
		
		String sql = "select * from flight_info where \"MDD\" = ?";
		ResultSet rs = jdbc_utils.executeQueryRS(sql, ec);
		List<Flight> list = new ArrayList<Flight>();
		try {
			while(rs.next()) {
				String HBH = rs.getString("HBH");
				String HZL = rs.getString("HZL");
				String JZXM = rs.getString("JZXM");
				String SFYW = rs.getString("SFYW");
				String SFCS = rs.getString("SFCS");
				String MDD = rs.getString("MDD");
				String HJT = rs.getString("HJT");
				String YJFXSJ = rs.getString("YJFXSJ");
				Flight flight = new Flight(HBH,HZL,HJT,JZXM,SFYW,YJFXSJ,SFCS, MDD);
				list.add(flight);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBTools.close(null, null, rs);
		}
		
		return list;
	}
	public static List<Flight> getDATEList(String dt) {
		String sql = "select * from flight_info where \"YJFXSJ\" = ?";
		ResultSet rs = jdbc_utils.executeQueryRS(sql, dt);
		List<Flight> list = new ArrayList<Flight>();
		try {
			while(rs.next()) {
				String HBH = rs.getString("HBH");
				String HZL = rs.getString("HZL");
				String JZXM = rs.getString("JZXM");
				String SFYW = rs.getString("SFYW");
				String SFCS = rs.getString("SFCS");
				String MDD = rs.getString("MDD");
				String HJT = rs.getString("HJT");
				String YJFXSJ = rs.getString("YJFXSJ");
				Flight flight = new Flight(HBH,HZL,HJT,JZXM,SFYW,YJFXSJ,SFCS, MDD);
				list.add(flight);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBTools.close(null, null, rs);
		}
		
		return list;
	}
	public static List<Flight> getList() {
		String sql = "select * from flight_info";
		ResultSet rs = jdbc_utils.executeQueryRS(sql, null);
		List<Flight> list = new ArrayList<Flight>();
		try {
			while(rs.next()) {
				String HBH = rs.getString("HBH");
				String HZL = rs.getString("HZL");
				String JZXM = rs.getString("JZXM");
				String SFYW = rs.getString("SFYW");
				String SFCS = rs.getString("SFCS");
				String MDD = rs.getString("MDD");
				String HJT = rs.getString("HJT");
				String YJFXSJ = rs.getString("YJFXSJ");
				Flight flight = new Flight(HBH,HZL,HJT,JZXM,SFYW,YJFXSJ,SFCS, MDD);
				list.add(flight);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBTools.close(null, null, rs);
		}
		
		return list;
		
	}
	public static int delete(String hBH, String hZL, String hJT, String jZXM, String yJFXSJ, String sFYW, String sFCS,
			String mDD) {
		String sql = "delete from flight_info where \"HBH\"= ? and \"HZL\"= ? and \"HJT\"= ? and \"JZXM\" = ? and \"SFYW\" = ? and \"YJFXSJ\" = ? and \"SFCS\" = ? and \"MDD\" = ? ";
		int i = jdbc_utils.executeUpdate(sql, hBH,hZL,hJT,jZXM,sFYW,yJFXSJ,sFCS,mDD);
		return i;
	}

	public static int update(String hBH, String hZL, String hJT, String jZXM, String yJFXSJ, String sFYW, String sFCS,
			String mDD) {
		String sql = "update flight_info set \"HZL\"= ? , \"HJT\"= ? , \"JZXM\" = ? , \"SFYW\" = ? , \"YJFXSJ\" = ? , \"SFCS\" = ? , \"MDD\" = ? where \"HBH\" = ?";
		int i = jdbc_utils.executeUpdate(sql,hZL,hJT,jZXM,sFYW,yJFXSJ,sFCS,mDD,hBH);
		return i;
	}
	public static List<Userinfo> getUserList() {
		String sql = "select * from user_info order by \"ID\"";
		ResultSet rs = jdbc_utils.executeQueryRS(sql, null);
		List<Userinfo> list = new ArrayList<Userinfo>();
		try {
			while(rs.next()) {
				String USERNAME = rs.getString("USERNAME");
				String PASSWORD = rs.getString("PASSWORD");
				String ID = rs.getString("ID");
				Userinfo ui = new Userinfo(USERNAME,PASSWORD,ID);
				list.add(ui);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBTools.close(null, null, rs);
		}
		return list;
	}

	public static int updateUserinfo(String username, String newpwd) {
		String sql = "update user_info set \"PASSWORD\" = ? where \"USERNAME\"=?";
		int i = jdbc_utils.executeUpdate(sql, newpwd,username);
		return i;
	}

	public static int confirm(String username, String oldpwd) {
		String sql = "select * from user_info where \"USERNAME\"= ? and \"PASSWORD\" = ?";
		int j = jdbc_utils.executeUpdate(sql, username,oldpwd);
		return j;
	}
	public static int deleteUserInfo(String username, String pwd) {
		String sql = "delete from user_info where \"USERNAME\" = ? and \"PASSWORD\" = ?";
		int i = jdbc_utils.executeUpdate(sql, username,pwd);
		return i;
	}
	public static int insertUserInfo(String username, String pwd) {
		String sql = "insert into user_info (\"USERNAME\",\"PASSWORD\") values (?,?)";
		int i = jdbc_utils.executeUpdate(sql, username,pwd);
		return i;
	}
	public static int updateUserInfo(String username, String pwd,String id) {
		String sql = "update user_info set \"USERNAME\" = ?,\"PASSWORD\" = ? where \"ID\" = ?";
		int i = jdbc_utils.executeUpdate(sql, username,pwd,id);
		return i;
	}
}
