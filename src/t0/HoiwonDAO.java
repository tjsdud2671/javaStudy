package t0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoiwonDAO {
	Connection conn =  null;
	public HoiwonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공");
			
			String url = "jdbc:mysql://localhost:3306/javaproject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연동 성공");
		
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		}catch(SQLException e) {
			System.out.println("데이터 연동 실패");
		}
	}
		
	public void connclose() {
		try {
			conn.close();
			System.out.println("conn객체 close");
		} catch (Exception e) {}
	}
	
	/*
	 데이터베이스 접속 conn객체
	 실행하는 객체 statement
	 레코드를 처리하는 객체 ResultSet(rs) 
	 기본적으로 위 세개를 생성해야함.
	 */
	public void getList() {
		try {
			Statement stmt = conn.createStatement(); 
			//statement 객체는 statement 인터페이스를 구현한 객체를 connection 클래스의
			String sql = "select * from hoiwon";
			ResultSet rs = stmt.executeQuery(sql);
		  //createStatement() 메소드를 호출함으로써 얻어진다.
		  //ResultSet은 SELECT문의 결과를 저장하는 객체	
			
			
			System.out.println("\t\t**주 소 록 **");
			System.out.println("=".repeat(40)); //String 메서드 중 하나로 String 문자열을 파라미터의 주어진 횟수만큼 반복
			System.out.println("번호\t성명\t나이\t주소\t성별");
			System.out.println("-".repeat(40));
			while(rs.next()) {
				System.out.println(rs.getInt("idx")+"\t");
				System.out.println(rs.getString("name")+"\t");
				System.out.println(rs.getInt("age")+"\t");
				System.out.println(rs.getString("address")+"\t");
				System.out.println(rs.getString("gender")+"\t");
				System.out.println();
			}
			System.out.println("-".repeat(40));
	
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}
	}
}
