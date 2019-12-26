package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedDeleteTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedDeleteTest obj = new PreparedDeleteTest();
		System.out.println("**************** 게시글 삭제*****************");
		System.out.print("게시글 번호 : ");
		int boardnum = key.nextInt();
		obj.delete(boardnum);
	}
	
	public void delete(int boardnum) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sql = new StringBuffer();
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		sql.append("delete tb_board ");
		sql.append("where boardnum=?");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공!!");
			con = DriverManager.getConnection(url, user, password);
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setInt(1, boardnum);
			int result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삭제성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패");
		} catch (SQLException e) {
			System.out.println("연결실패:");
			e.printStackTrace();
		} finally { // exception이 발생하지 않거나 발생하거나 무조건 실행할 명령문을 정의
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
