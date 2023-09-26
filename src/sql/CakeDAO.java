package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CakeDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	CakeVO vo = null;
	
	
	public CakeDAO() {
		String url = "jdbc:mysql://localhost:3306/javaproject12";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패 " + e.getMessage());
		}catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패 " + e.getMessage());
		}
	}
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	public void pstmtClose() {
		try {
			if(pstmt != null)
			pstmt.close();
		} catch (SQLException e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			pstmtClose();
		} catch (Exception e) {}
	}
	
	//예약정보저장
	
	
	
//회원명 검색
	public CakeVO getIdSearch(String mid) {
		vo = new CakeVO();
		try {
			sql = "select * from cakeshop where mid =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setPhonenumber(rs.getString("phonenumber"));
//				vo.setRsvdate(rs.getString("rsvdate"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}finally {
			rsClose();
		}
		return vo;
	}		
//	
//	//회원가입 처리
	public int setJoin(CakeVO vo) {
		int res = 0;
		try {
			sql = "insert into cakeshop (mid,pwd,name,phonenumber) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhonenumber());
//			pstmt.setString(4, vo.getRsvdate());
			
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}finally {
			pstmtClose();
		}
		return res;
	}
	
	//예약 리스트 가져오기
	public Vector getReservation() {
		Vector vData = new Vector<>();
		try {
			sql = "select * from cakeshop order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getString("mid"));
				vo.add(rs.getString("name"));
//				vo.add(rs.getString("rsvdate"));
				vData.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}finally {
			rsClose();
		}
		return vData;
	}
}

