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
		System.out.println("**************** �Խñ� ����*****************");
		System.out.print("�Խñ� ��ȣ : ");
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
			System.out.println("����̹��ε� ����!!");
			con = DriverManager.getConnection(url, user, password);
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setInt(1, boardnum);
			int result = ptmt.executeUpdate();
			System.out.println(result + "�� �� ��������");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��ε� ����");
		} catch (SQLException e) {
			System.out.println("�������:");
			e.printStackTrace();
		} finally { // exception�� �߻����� �ʰų� �߻��ϰų� ������ ������ ��ɹ��� ����
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
