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
		System.out.println("**************** �Խñ� ����*****************");
		System.out.print("������ ���̵� : ");
		String id = key.next();
		System.out.print("�Խñ� ��ȣ : ");
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
			System.out.println("����̹��ε� ����!!");
			con = DriverManager.getConnection(url, user, password);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setInt(2, boardnum);
			int result = ptmt.executeUpdate();
			System.out.println("result: "+result);

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
