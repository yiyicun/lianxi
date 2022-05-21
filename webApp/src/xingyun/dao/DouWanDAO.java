package xingyun.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



import xingyun.model.DouWan;
import xingyun.model.DouWanResult;
import xingyun.model.Jndeb;


import xingyun.tools.ConnDB;

public class DouWanDAO {


    //添加数据
	public void addJiSuErba(List<DouWan> list) {
		ConnDB coonDB = new ConnDB();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = coonDB.getConnection();
			String sql = "insert into douwan(issue,time,r1,r2,r3,result) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			for (DouWan geibi : list) {
				ps.setLong(1, geibi.getIssue());
				ps.setTimestamp(2, geibi.getTime());
				ps.setByte(3,geibi.getR1());
				ps.setByte(4,geibi.getR2());
				ps.setByte(5,geibi.getR3());
				ps.setByte(6, geibi.getResult());
				ps.addBatch();
			}
			ps.executeBatch();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	
	
	 //添加数据
		public void addJndeb(List<Jndeb> list) {
			ConnDB coonDB = new ConnDB();
			Connection conn = coonDB.getConnection();
			PreparedStatement ps = null;
			try {

				String sql = "insert into jndeb(issue,time,r1,r2,r3,result) values(?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				for (Jndeb geibi : list) {

					ps.setLong(1, geibi.getIssue());
					ps.setTimestamp(2, geibi.getTime());
					ps.setByte(3,geibi.getR1());
					ps.setByte(4,geibi.getR2());
					ps.setByte(5,geibi.getR3());
					ps.setByte(6, geibi.getResult());
					ps.addBatch();
				}
				ps.executeBatch();

			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				try {
					
						ps.close();
						conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}



	//最大期数
	public long findMaxJiSuErbaerba() {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select issue from douwan order by time  desc limit 1 ;";
		long issue = 0l;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				issue = Long.valueOf(rs.getLong(1));
			}
			return issue;
		} catch (SQLException e) {
			e.printStackTrace();
			return issue;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return 0l;
			}
		}
	}
	
	
	//最大期数
		public long findMaxJnd28() {

			ConnDB coonDB = new ConnDB();
			Connection conn = coonDB.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select issue from jndeb order by time  desc limit 1 ;";
			long issue = 0l;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					issue = Long.valueOf(rs.getLong(1));
				}
				return issue;
			} catch (SQLException e) {
				e.printStackTrace();
				return issue;
			} finally {
				try {
						rs.close();
						stmt.close();
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0l;
				}
			}
		}
	
	
	//最大期数
	public long findMaxBJPK10() {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select MAX(issue) from bJPK10";
		long issue = 0l;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				issue = Long.valueOf(rs.getLong(1));
			}
			return issue;
		} catch (SQLException e) {
			e.printStackTrace();
			return issue;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return 0l;
			}
		}
	}
	
	
	public Timestamp findMaxTimeJiSuErbaerba() {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select MAX(time) from douwan";
		Timestamp time = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				time = rs.getTimestamp(1);
			}
			return time;
		} catch (SQLException e) {
			e.printStackTrace();
			return time;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return time;
			}
		}
	}
	
	public Timestamp findMaxTimeErba() {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select time from douwan order by id desc limit 1";
		Timestamp timestamp = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				timestamp = rs.getTimestamp(1);
			}
			return timestamp;
		} catch (SQLException e) {
			e.printStackTrace();
			return timestamp;
		} finally {
			
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	//找最近五期
	public DouWan[] findFive() {

	
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from douwan  order by id desc limit 5";
		DouWan[] sz = new DouWan[5];
		try {
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
				sz[i] = eb;
				i++;

			}
			return sz;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	
	public List<String[]> findAllResultFromTo(String time1, String time2) {

		String sString1 = '"' + time1 + '"';
		String sString2 = '"' + time2 + '"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		;
		ResultSet rs = null;
		;
		String sql = "select issue , result  from douwan where time > "
				+ sString1 + " and time < " + sString2;
		List<String[]> list = new ArrayList<String[]>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String a[] = new String[2];
				a[0] = String.valueOf(rs.getLong(1));
				a[1] = String.valueOf(rs.getInt(2));
				list.add(a);

			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}


	//整理结果   起始期数、大小差  单双差、中边差
	public List<DouWanResult> tidyJiSuErba(int startid, int totalstart,
			int totaloddeven, int zhongtotal) {
		List<DouWanResult> list = new ArrayList<DouWanResult>();
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		//每天分组
		String sql = (new StringBuilder(
				"select min(issue) as start ,max(issue) as end, Sum(if(result>13,1,0)) as da,Sum(if(result <14,1,0))"+
				"as xiao ,(Sum(if(result>13,1,0))-Sum(if(result<14,1,0))) as total,Sum(if(result%2,1,0)) as odd, "+
				"Sum(if(result%2,0,1)) as even,(Sum(if(result%2,1,0)) - Sum(if(result%2,0,1))) as oddeven,"+
				"Sum( if(result>9 and result<18,1,0) ) as zhong,Sum(if(result < 10 or result >17,1,0))"+
				"as bian ,(Sum(if(result>9  and  result<18,1,0)) - Sum(if(result < 10 or result >17,1,0)) * 1.272727 ) as zhongtotal,"+
				"Count(id) as cycle "+
				"From douwan where (id > ("))
				.append(startid).append("-1)) ").append("Group by date_format(time, '%y-%m-%d')").toString();
		
	
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWanResult 	jiSuErbaResult = new DouWanResult();
				//加上上期结果
				totalstart += rs.getInt("total");
				totaloddeven += rs.getInt("oddeven");
				zhongtotal +=rs.getInt("zhongtotal");
				//添加到结果表
				jiSuErbaResult.setStart(rs.getLong("start"));
				jiSuErbaResult.setEnd(rs.getLong("end"));
				jiSuErbaResult.setBigresult(rs.getInt("da"));
				jiSuErbaResult.setSmallresult(rs.getInt("xiao"));
				jiSuErbaResult.setTotalsize(totalstart);
				jiSuErbaResult.setCycle(rs.getInt("cycle"));
				jiSuErbaResult.setOddresult(rs.getInt("odd"));
				jiSuErbaResult.setEvenresult(rs.getInt("even"));
				jiSuErbaResult.setTotaloddeven(totaloddeven);
				jiSuErbaResult.setMiddle(rs.getInt("zhong"));
				jiSuErbaResult.setSide(rs.getInt("bian"));
				jiSuErbaResult.setTotal(zhongtotal);
				list.add(jiSuErbaResult);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



	public int findIdByIssue(Long issue) {
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int id = 0;
		String sql = "select id from douwan where issue=" + issue;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List findAllJiSuErba() {
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<DouWan> list = new ArrayList<DouWan>();
		String sql = "select issue ,result from douwan";
		try {
			stmt = conn.createStatement();
			DouWan pc;
			for (rs = stmt.executeQuery(sql); rs.next(); list.add(pc)) {
				pc = new DouWan();
				pc.setIssue(rs.getLong(1));
				pc.setResult(rs.getByte(2));
			}

			return list;

		}

		catch (SQLException e) {
			e.printStackTrace();
			return list;
		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	public List<String []> findAllResultByDate(String time1, String time2) {
		
		String sString1 = '"'+time1+'"';
		String sString2 ='"'+ time2+'%'+'"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
	    Statement stmt = null;;
	    ResultSet rs = null;;
	    String  sql = "select issue , result  from douwan where time > "+ sString1 +" and time like "+ sString2  ;
	    List<String []> list = new ArrayList<String []>();
	    try {
	    	stmt = conn.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while (rs.next()) {
	    		String a[] = new String[2];
	    		a[0] = String.valueOf(rs.getLong(1));
	    		a[1] = String.valueOf(rs.getInt(2));
	    		list.add(a);
	    		
	    	}
	        return list;
	   
	    } catch(SQLException e) {
	    
	        e.printStackTrace();
	        return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		
	}
	
	
	
public List<String []> findResultByIssue(String time) {
		
		String sString = '"'+time+'"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
	    List<String []> list = new ArrayList<String []>();
		String sql = "select date_format(time, '%m-%d') as issue, "+
		" result  from douwan where time >= "+ sString ;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String a[] = new String[2];
				a[0] = String.valueOf(rs.getString(1));
	
        		a[1] = String.valueOf(rs.getInt(2));
        		list.add(a);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<DouWan> findAllResultLast(String time) {

		String sString = '"' + time + '"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from douwan where time >= "+ sString;
		List<DouWan> list = new ArrayList<DouWan>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWan gb = new DouWan();
				gb.setId(rs.getInt(1));
				gb.setIssue(rs.getLong(2));
				gb.setTime(rs.getTimestamp(3));
				gb.setR1(rs.getByte(4));
				gb.setR2(rs.getByte(5));
				gb.setR3(rs.getByte(6));
				gb.setResult(rs.getByte(7));
				list.add(gb);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	public List<DouWan> findAllResultStart(String time) {

		String sString = '"' + time + '"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from douwan where time >= "+ sString;
		List<DouWan> list = new ArrayList<DouWan>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWan  dandan  = new DouWan();
				dandan.setId(rs.getInt(1));
				dandan.setIssue(rs.getLong(2));
				dandan.setTime(rs.getTimestamp(3));
				dandan.setR1(rs.getByte(4));
				dandan.setR2(rs.getByte(5));
				dandan.setR3(rs.getByte(6));
				dandan.setResult(rs.getByte(7));
				list.add(dandan);
			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	

	public List<String []> hourZhongResult(String time1) {
		
		String sString1 ='"'+ time1+'"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
	    Statement stmt = null;;
	    ResultSet rs = null;;
	    String  sql = "select date_format(time, '%m-%d %k:00~') as time ," +
	    		"Sum(if(result > 9 and result < 18,1,0)) as zhong, "+
	    		"Sum(if(result > 17 or result < 10,1,0)) as bian" +
	    		"from douwan where time >= "+ sString1 + "group by left(time, 13)";
	  
	  //select issue , result  from letu where time > "+ sString1 +" and time like "+ sString2
	    
	    List<String []> list = new ArrayList<String []>();
	    try {
	    	stmt = conn.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while (rs.next()) {
	    		String a[] = new String[3];
	    		a[0] = String.valueOf(rs.getString(1));
	    		a[1] = String.valueOf(rs.getInt(2));
	    		//a[2] = String.valueOf(rs.getInt(3));
	    		list.add(a);
	    		
	    	}
	    	
	        return list;
	   
	    } catch(SQLException e) {
	    
	        e.printStackTrace();
	        return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		
	}


	public List<String []> hourDaResult(String time1) {
		
		String sString1 ='"'+ time1+'"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
	    Statement stmt = null;;
	    ResultSet rs = null;;
	    String  sql = "select date_format(time, '%m-%d %k:00~') as time ,"
	    +" Sum(if(result > 13,1,0)) as da, Sum(if(result < 14,1,0)) as xiao"
	    +" from douwan where time >= "+ sString1 +" group by left(time, 13)";
	  

	    
	    List<String []> list = new ArrayList<String []>();
	    try {
	    	stmt = conn.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while (rs.next()) {
	    		String a[] = new String[3];
	    		a[0] = String.valueOf(rs.getString(1));
	    		a[1] = String.valueOf(rs.getInt(2));
	    		a[2] = String.valueOf(rs.getInt(3));
	    		list.add(a);
	    		
	    	}
	        return list;
	   
	    } catch(SQLException e) {
	    
	        e.printStackTrace();
	        return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		
	}


	public List<String []> hourdanResult(String time1) {
		
		String sString1 ='"'+ time1+'"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
	    Statement stmt = null;;
	    ResultSet rs = null;;
	    String  sql = "select date_format(time, '%m-%d %k:00~') as time ,"
	    +" Sum(if(result%2,1,0))as odd, Sum(if(result%2,0,1)) as even"
	    +" from douwan where time >= "+ sString1 +" group by left(time, 13)";
	  

	    
	    List<String []> list = new ArrayList<String []>();
	    try {
	    	stmt = conn.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while (rs.next()) {
	    		String a[] = new String[3];
	    		a[0] = String.valueOf(rs.getString(1));
	    		a[1] = String.valueOf(rs.getInt(2));
	    		a[2] = String.valueOf(rs.getInt(3));
	    		list.add(a);
	    		
	    	}
	        return list;
	   
	    } catch(SQLException e) {
	    
	        e.printStackTrace();
	        return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		
	}
		
public List<String []> hourda(String time1) {
		
		String sString1 ='"'+ time1+'"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
	    Statement stmt = null;;
	    ResultSet rs = null;;
	    String  sql = "select date_format(time, '%y-%m-%d %H') as t1 ,"
	    +" Sum(if(result>13,1,0))as da, Sum(if(result<14,1,0)) as xiao, (Sum(if(result>13,1,0))-Sum(if(result<14,1,0))) as cha, "
	    +" count(issue) as cishu  from douwan where time >= "+ sString1 +" group by date_format(time, '%y-%m-%d %H:') order by t1 ";
	  
	    List<String []> list = new ArrayList<String []>();
	    try {
	    	stmt = conn.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while (rs.next()) {
	    		String a[] = new String[5];
	    		a[0] = String.valueOf(rs.getString(1));
	    		a[1] = String.valueOf(rs.getInt(2));
	    		a[2] = String.valueOf(rs.getInt(3));
	    		a[3] = String.valueOf(rs.getInt(4));
	    		a[4] = String.valueOf(rs.getInt(5));
	    		list.add(a);	
	    	}
	        return list;
	   
	    } catch(SQLException e) {
	    
	        e.printStackTrace();
	        return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		
	}	
		
	
	public List<String []> hourji(String time1) {
	
		String sString1 ='"'+ time1+'"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;;
		ResultSet rs = null;;
		String  sql = "select date_format(time, '%y-%m-%d %H') as t1 ,"
			+" Sum(if(result%2=0,0,1))as ji, Sum(if(result%2=0,1,0)) as ou, (Sum(if(result%2=0,0,1))-Sum(if(result%2=0,1,0))) as cha, "
			+" count(issue) as cishu  from douwan where time >= "+ sString1 +" group by date_format(time, '%y-%m-%d %H:') order by t1 ";
  
		List<String []> list = new ArrayList<String []>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
    		String a[] = new String[5];
    		a[0] = String.valueOf(rs.getString(1));
    		a[1] = String.valueOf(rs.getInt(2));
    		a[2] = String.valueOf(rs.getInt(3));
    		a[3] = String.valueOf(rs.getInt(4));
    		a[4] = String.valueOf(rs.getInt(5));
    		list.add(a);	
    	}
			return list;
   
		} catch(SQLException e) {
    
			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
				rs.close();
				rs = null;
				}
				if (stmt != null) {
					stmt.close();
				stmt = null;
				}
				if (conn != null) {
				conn.close();
				conn = null;
				}
			} catch (SQLException e) {
			e.printStackTrace();

			}
		}
	
	}
	
	
	
	public List<DouWan> findResultLast(String time) {

		String sString = '"' + time + '"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select *  from douwan where time >= "+ sString;
	
		List<DouWan> list = new ArrayList<DouWan>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWan eb  = new DouWan();
				eb.setId(rs.getInt(1));
				eb.setIssue(rs.getLong(2));
				eb.setTime(rs.getTimestamp(3));
				eb.setR1(rs.getByte(4));
				eb.setR2(rs.getByte(5));
				eb.setR3(rs.getByte(6));
				eb.setResult(rs.getByte(7));
				list.add(eb);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	

	public List<String []> hourzhong(String time1) {
	
		String sString1 ='"'+ time1+'"';
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;;
		ResultSet rs = null;;
		String  sql = "select date_format(time, '%y-%m-%d %H') as t1 ,"
	    +" Sum(if(result > 9 and result < 18,1,0)) as zhong, Sum(if(result > 17 or result < 10,1,0)) as b, (Sum(if(result > 9 and result < 18,1,0))-Sum(if(result > 17 or result < 10,1,0))) as cha, "
	    +" count(issue) as cishu  from douwan where time >= "+ sString1 +" group by date_format(time, '%y-%m-%d %H:') order by t1 ";
  
		List<String []> list = new ArrayList<String []>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String a[] = new String[5];
	    		a[0] = String.valueOf(rs.getString(1));
	    		a[1] = String.valueOf(rs.getInt(2));
	    		a[2] = String.valueOf(rs.getInt(3));
	    		a[3] = String.valueOf(rs.getInt(4));
	    		a[4] = String.valueOf(rs.getInt(5));
	    		list.add(a);	
			}
			return list;
   
		} catch(SQLException e) {
    
			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	
	}
	
	public List<DouWan> findResultFrom(long issue) {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;	
		ResultSet rs = null;
		String sql = "select * from douwan where issue >= "
				+ issue;
		List<DouWan> list = new ArrayList<DouWan>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWan eeeb = new DouWan();
				eeeb.setId(rs.getInt(1));
				eeeb.setIssue(rs.getLong(2));
				eeeb.setTime(rs.getTimestamp(3));
				eeeb.setR1(rs.getByte(4));
				eeeb.setR1(rs.getByte(5));
				eeeb.setR1(rs.getByte(6));
				eeeb.setResult(rs.getByte(7));
				list.add(eeeb);

			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	
	public List<DouWan> findResultFrom(int id) {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;	
		ResultSet rs = null;
		String sql = "select * from douwan where id >= "
				+ id;
		List<DouWan> list = new ArrayList<DouWan>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWan eeeb = new DouWan();
				eeeb.setId(rs.getInt(1));
				eeeb.setIssue(rs.getLong(2));
				eeeb.setTime(rs.getTimestamp(3));
				eeeb.setR1(rs.getByte(4));
				eeeb.setR1(rs.getByte(5));
				eeeb.setR1(rs.getByte(6));
				eeeb.setResult(rs.getByte(7));
				list.add(eeeb);

			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}


	public List<DouWan> findResultFromByIssue(long issue) {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;	
		ResultSet rs = null;
		String sql = "select * from douwan where issue >= "
				+ issue +" limit 200";
		List<DouWan> list = new ArrayList<DouWan>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWan eeeb = new DouWan();
				eeeb.setId(rs.getInt(1));
				eeeb.setIssue(rs.getLong(2));
				eeeb.setTime(rs.getTimestamp(3));
				eeeb.setR1(rs.getByte(4));
				eeeb.setR1(rs.getByte(5));
				eeeb.setR1(rs.getByte(6));
				eeeb.setResult(rs.getByte(7));
				list.add(eeeb);

			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	public List<DouWan> findResultFromById(int id) {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;	
		ResultSet rs = null;
		String sql = "select * from douwan where id >= "
				+ id +" limit 200";
		List<DouWan> list = new ArrayList<DouWan>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWan eeeb = new DouWan();
				eeeb.setId(rs.getInt(1));
				eeeb.setIssue(rs.getLong(2));
				eeeb.setTime(rs.getTimestamp(3));
				eeeb.setR1(rs.getByte(4));
				eeeb.setR1(rs.getByte(5));
				eeeb.setR1(rs.getByte(6));
				eeeb.setResult(rs.getByte(7));
				list.add(eeeb);

			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	public long findIssueByTime(String time) {
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		long issue = 0;
		String sString = '"' + time + '"';
		String sql = "select issue from douwan where time=" +sString;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				issue = rs.getInt(1);
			}
			return issue;
		} catch (SQLException e) {
			e.printStackTrace();
			return issue;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public int findIdByTime(String time) {
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int id = 0;
		String sString = '"' + time + '"';
		String sql = "select id from douwan where time=" +sString;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public List<DouWan> findResultFromToByIssue(long issue1,long issue2) {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;	
		ResultSet rs = null;
		String sql = "select * from douwan where issue >= "
				+ issue1 +"  and  issue < "+issue2;
		List<DouWan> list = new ArrayList<DouWan>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWan eb = new DouWan();
				eb.setId(rs.getInt(1));
				eb.setIssue(rs.getLong(2));
				eb.setTime(rs.getTimestamp(3));
				eb.setResult(rs.getByte(7));
				list.add(eb);

			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	public List<DouWan> findResultFromToById(int id1,int id2) {

		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		Statement stmt = null;	
		ResultSet rs = null;
		String sql = "select * from douwan where id >= "
				+ id1 +"  and  id < "+id2;
		List<DouWan> list = new ArrayList<DouWan>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DouWan eb = new DouWan();
				eb.setId(rs.getInt(1));
				eb.setIssue(rs.getLong(2));
				eb.setTime(rs.getTimestamp(3));
				eb.setResult(rs.getByte(7));
				list.add(eb);

			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	
	public static void main(String args[]) throws ParseException {
		DouWanDAO dao = new DouWanDAO();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String ss = "2012-02-12";
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(sdf.parse(ss));
//		java.util.Date thisDate = cal.getTime();
//		java.util.Date date  = df.parse("2012-02-12 00:00:00");
//	    String time = df.format(date);
//	    Timestamp timestamp = Timestamp.valueOf(time);
//	    System.out.println(timestamp);
//	    int t =  timestamp.compareTo(thisDate);
//	    System.out.println(t);
//	    if ( t == 0){
//	    	System.out.println("~~~~~~~~~~~");
//	    	
//	    } else {
//	    	System.out.println("11111");
//	    }
		long list = dao.findMaxJiSuErbaerba();
	    System.out.println(list);	

	


	}
}
