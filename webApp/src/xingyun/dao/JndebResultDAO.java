package xingyun.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import xingyun.model.JndebResult;
import xingyun.tools.ConnDB;

public class JndebResultDAO {


	//获取最后期数，大小差结果，单双差结果
	public Long[] getMaxReslut() {
		ConnDB coonDB = new ConnDB();
		Statement stmt = null;
		String sql = "select start,(select totalsize from jndebresult "+
		"ORDER BY id DESC limit 1,1) as totalsize,(select totaloddeven "+
		"from jndebresult ORDER BY id DESC limit 1,1) as totaloddeven ,"+
		"(select total from jndebresult ORDER BY id DESC limit 1,1) as total "+
		"from jndebresult ORDER BY id DESC limit 1";
		
//		String sql = "select start, totalsize, totaloddeven, total from jndebresult ORDER BY id DESC limit 1";
		
		ResultSet rs = null;
		Long a[] = new Long[4];
		Connection conn= null;
		try {
			 conn = coonDB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				a[0] = Long.valueOf(rs.getLong("start"));
				a[1] = Long.valueOf(rs.getInt("totalsize"));
				a[2] = Long.valueOf(rs.getInt("totaloddeven"));
				a[3] = Long.valueOf(rs.getInt("total"));
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}	
		
		}
		return null;
	}

	//增加整理结果数据
	public void addJndebresult(List<JndebResult> list) {
		ConnDB coonDB = new ConnDB();
		System.out.println("jinruaddresult");
		Connection conn = coonDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "insert into jndebresult(start,end,bigresult,smallresult,totalsize,oddresult,evenresult,totaloddeven,cycle,middle,side,total) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			for (JndebResult result : list) {
				ps.setLong(1, result.getStart());
				ps.setLong(2, result.getEnd());
				ps.setInt(3, result.getBigresult());
				ps.setInt(4, result.getSmallresult());
				ps.setInt(5, result.getTotalsize());
				ps.setInt(6, result.getOddresult());
				ps.setInt(7, result.getEvenresult());
				ps.setInt(8, result.getTotaloddeven());
				ps.setInt(9, result.getCycle());
				ps.setInt(10, result.getMiddle());
				ps.setInt(11, result.getSide());
				ps.setInt(12, result.getTotal());
				ps.addBatch();
			}

			int rows[] = ps.executeBatch();
			int row = rows.length;
			System.out.println("成功添加了"+ row +"条记录");

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
	
    //更新结果数据
	public void updateJndebresult(int id, JndebResult result) {
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
		int rs = 0;
		Statement stmt = null;
		Long start = Long.valueOf(result.getStart());
		Long end = Long.valueOf(result.getEnd());
		int big = result.getBigresult();
		int small = result.getSmallresult();
		int total = result.getTotalsize();
		int cycle = result.getCycle();
		int odd = result.getOddresult();
		int even = result.getEvenresult();
		int totaloddeven = result.getTotaloddeven();
		int middle = result.getMiddle();
		int side = result.getSide();
		int zhongtotal = result.getTotal();
		String sql = "update jndebresult set start="+ start +" ,end="+ end + ","
			+ "bigresult="+ big +",smallresult="+ small +",totalsize="+ total +","
			+ "oddresult="+ odd +",evenresult="+ even +",cycle="+ cycle+ ","
			+ "totaloddeven="+ totaloddeven +",middle="+ middle +",side="+ side +","
			+ "total="+zhongtotal+" where id=" +id;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeUpdate(sql);
			System.out.println("成功更新了"+ rs +"条记录");

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				
					stmt.close();
				
					conn.close();
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delectJndebresult(int i) {
	}

	public int findIdByStart(Long start)
    {
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
        Statement stmt = null;
        ResultSet rs  = null;;
        int id = 0;
        String sql = "select id from jndebresult where start ="+ start;
        try{
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
        
       
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return id;
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
	
	
	public List<JndebResult> findAllByStart(long start) {
		ConnDB coonDB = new ConnDB();
		Connection conn = coonDB.getConnection();
        Statement stmt = null;
        ResultSet rs  = null;;
       
        String sql = "select * from jndebresult where start >= "+ start;
        List<JndebResult> list = new ArrayList<JndebResult>();
        try{
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
       
        while (rs.next()) {
        	JndebResult result = new JndebResult();
        	result.setId(Integer.valueOf(rs.getInt(1)));
        	result.setStart(Long.valueOf(rs.getLong(2)));
        	result.setEnd(Long.valueOf(rs.getLong(3)));
        	result.setBigresult(Integer.valueOf(rs.getInt(4)));
        	result.setSmallresult(Integer.valueOf(rs.getInt(5)));
        	result.setTotalsize(Integer.valueOf(rs.getInt(6)));
        	result.setOddresult(Integer.valueOf(rs.getInt(7)));
        	result.setEvenresult(Integer.valueOf(rs.getInt(8)));
        	result.setTotaloddeven(Integer.valueOf(rs.getInt(9)));
        	result.setCycle(Integer.valueOf(rs.getInt(10)));
        	result.setMiddle(Integer.valueOf(rs.getInt(11)));
        	result.setSide(Integer.valueOf(rs.getInt(12)));
        	result.setTotal(Integer.valueOf(rs.getInt(13)));
        	list.add(result);
        }
        return list;
        
        }
        catch(SQLException e) {
            e.printStackTrace();
            return list;
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

	public List findletu() {
		return null;
	}

	public static void main(String args[]) {
		JndebResultDAO ld = new JndebResultDAO();
		Long a[] = ld.getMaxReslut();
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		
		
	}
}
