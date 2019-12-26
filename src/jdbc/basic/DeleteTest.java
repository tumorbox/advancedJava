package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sql = new StringBuffer();
		sql.append("delete tb_board ");
		sql.append("where boardnum=3");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공!!");
			Connection con = 
					DriverManager.getConnection(url, user, 
														password);
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql.toString());
			System.out.println(result+"개 행 삭제성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패");
		}catch(SQLException e) {
			System.out.println("연결실패:");	
			e.printStackTrace();//오류추적
		}
	}
}










