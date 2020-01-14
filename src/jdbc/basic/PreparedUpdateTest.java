package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedUpdateTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedUpdateTest obj = new PreparedUpdateTest();
		System.out.println("********변경*************");
		System.out.print("아이디 :");
		String id = key.next();
		System.out.print("번호 :");
		int boardnum = key.nextInt();
		System.out.println();
		obj.Update(id, boardnum);
	}
	public void Update(String id, int boardnum) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_board ");
		sql.append("set id = ? ");
		sql.append("where boardnum = ?");
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공"+con);
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setInt(2, boardnum);
			int result = stmt.executeUpdate();
			System.out.println(result+"개 수정 성공");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();//오류추적
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
				if(rs!=null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
