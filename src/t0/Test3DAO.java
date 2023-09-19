package t0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test3DAO {
	Connection conn = null;
	public Test3DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이브 검색 성공");
			
			String url = "jdbc:mysql://localhost:3306/javaproject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
					
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 검색 실패");
		} catch(SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}
	}
	public void connclose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	//전체 회원 조회하기
	public void getList() {
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from hoiwon";
			ResultSet rs = stmt.executeQuery(sql);
			
	
			while(rs.next()) {
				System.out.print(rs.getInt("idx")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getInt("age")+"\t");
				System.out.print(rs.getString("address")+"\t");
				System.out.print(rs.getString("gender")+"\t");
				System.out.println();
			}
			System.out.println("=".repeat(38));
	
		} catch (SQLException e) {
			System.out.println("SQL 오류");
		}
	}
	//개별회원 조회
	public void getSearch(String name) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from hoiwon where name ='"+name+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("번호 : " + rs.getInt("idx"));
				System.out.println("성명 : " + rs.getString("name"));
				System.out.println("나이 : " + rs.getInt("age"));
				System.out.println("주소 : " + rs.getString("address"));
				System.out.println("성별 : " + rs.getString("gender"));
			}
			else {
				System.out.println(name + "님은 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 " + e.getMessage());
		}
	}
}
