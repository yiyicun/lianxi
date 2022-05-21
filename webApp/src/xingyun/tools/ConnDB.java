package xingyun.tools;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import xingyun.model.DouWan;

public class ConnDB {

	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	private static String dbUrl = "jdbc:mysql://localhost:3306/lucky";
	private static String dbUser = "root";
	private static String dbPwd = "mysql";

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
		connDB.getConnection();
		String sql = "select * from douwan where time > '2016-12-31' ";
		Statement stmt = connDB.getConnection().createStatement();
		 ResultSet rs = stmt.executeQuery(sql) ; 
		 ArrayList<DouWan> list = new ArrayList<DouWan>();
		 while(rs.next()){  
			 DouWan douWan= new DouWan();
		     int id = rs.getInt("id") ;   
		     douWan.setId(id);
		     Timestamp pass = rs.getTimestamp("time") ; // 此方法比较高效
			    douWan.setTime(pass);	
		   
		     String time = sdf2.format(pass.getTime());
		     if(time.contains("2017") && time.contains("12-31")){
		    	 list.add(douWan);
		     }
		  }       
		 for (DouWan douWan : list) {
			//System.out.println(douWan.getId()+","+douWan.getTime());
			String tString = sdf2.format(douWan.getTime());
			tString = tString.replace("2017", "2016");
			try {
				douWan.setTime(new Timestamp(sdf2.parse(tString).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(douWan.getId()+","+douWan.getTime());
		 }	
		 
		 Statement stmt2 = connDB.getConnection().createStatement();
		 for (int i = 0; i < list.size(); i++) {
			    int id = list.get(i).getId();
			    Timestamp timestamp = list.get(i).getTime();
				String sql3 = "update douwan set time = '"+timestamp+"' where id = '"+id+"' ";
				System.out.println(sql3);
				int a = stmt2.executeUpdate(sql3);
		 }
		 stmt.close();
		 stmt2.close();
		 connDB.clone();
		 
	}

}