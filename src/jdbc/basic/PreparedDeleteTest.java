package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedDeleteTest {

	public static void main(String[] args) {	
		Scanner key = new Scanner(System.in);
		PreparedDeleteTest obj = new PreparedDeleteTest();
		System.out.println("********삭제*************");
		System.out.print("번호 :");
		int boardnum = key.nextInt();
		System.out.println();
		obj.delete(boardnum);
	}
	public void delete(int boardnum) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//String sql = "delete from tb_board where boardnum = 24";
		StringBuffer sql = new StringBuffer();
		sql.append("delete tb_board ");
		sql.append("where boardnum = ?");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			 con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공"+con);
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, boardnum);
			int result = stmt.executeUpdate();
			System.out.println(result+"개 행이 삭제됐습니다.");
			
		}catch(ClassNotFoundException e){
			 e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
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

