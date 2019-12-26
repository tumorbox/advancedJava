package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedUpdateTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedUpdateTest obj = new PreparedUpdateTest();
		System.out.println("**************** 게시글 수정*****************");
		System.out.print("변경할 아이디 : ");
		String id = key.next();
		System.out.print("게시글 번호 : ");
		int boardnum = key.nextInt();
		obj.update(id, boardnum);
	}

	public void update(String id, int boardnum) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "update tb_board set id = ? where boardnum= ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공!!");
			con = DriverManager.getConnection(url, user, password);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setInt(2, boardnum);
			int result = ptmt.executeUpdate();
			System.out.println("result: "+result);

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
