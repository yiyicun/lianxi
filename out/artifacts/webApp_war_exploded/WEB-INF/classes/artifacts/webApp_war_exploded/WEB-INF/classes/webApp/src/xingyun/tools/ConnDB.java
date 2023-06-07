package xingyun.tools;

import java.sql.*;
import java.text.SimpleDateFormat;


import xingyun.model.DouWan;

public class ConnDB {

	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/lucky?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
	private static String dbUser = "root";
	private static String dbPwd = "111111";

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		} catch (ClassNotFoundException ee) {
			ee.printStackTrace();
			System.out
					.println("\u83B7\u5F97\u6570\u636E\u5E93\u94FE\u63A5\u5931\u8D25");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("\u83B7\u5F97\u6570\u636E\u5E93\u94FE\u63A5\u5931\u8D25");
		}
	
		return conn;
	}

	public ResultSet findall() {
		String sql = null;
		try {
			conn = getConnection();
			sql = "select * from letu";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return rs;
	}

	public int executeUpdate(String sql) {
		int result = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement(1004, 1007);
			result = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			result = 0;
		}
		return result;
	}

	public int executeUpdate_id(String sql) {
		int result = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement(1004, 1007);
			result = stmt.executeUpdate(sql);
			String ID = "select @@IDENTITY as id";
			rs = stmt.executeQuery(ID);
			if (rs.next()) {
				int autoID = rs.getInt("id");
				result = autoID;
			}
		} catch (SQLException ex) {
			result = 0;
		}
		return result;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public static void main(String args[]) throws SQLException, CloneNotSupportedException {

		ConnDB connDB = new ConnDB();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Connection conn = connDB.getConnection();

		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from jndeb  order by id desc limit 5";

		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);

		int i = 0;
		while (rs.next()) {
			DouWan eb= new DouWan();
			eb.setId(rs.getInt(1));
			eb.setIssue(rs.getLong(2));
			eb.setTime(rs.getTimestamp(3));
			eb.setR1(rs.getByte(4));
			eb.setR2(rs.getByte(5));
			eb.setR3(rs.getByte(6));
			eb.setResult(rs.getByte(7));
			i++;
			System.out.println(eb.getResult());

		}

		 
	}

}