package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedeInsertTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedeInsertTest obj = new PreparedeInsertTest();
		System.out.println("**************** �Խñ� ���*****************");
		System.out.print( "���̵� : ");
		String id = key.next();
		System.out.print( "���� : ");
		String title = key.next();
		System.out.print( "���� : ");
		String content = key.next();
		obj.insert(id, title, content);
	}

	public void insert(String id, String title, String content) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		//�� ������� ����...
		/*String sql = "insert into tb_board values(board_seq.nextval,'"+id+"','"
					+ ""+title+"','"+content+"',sysdate,0)";*/
		
		//����sql �ܺο��� �Է¹��� ������ ?���� ǥ��
		String sql ="insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��ε� ����!!");

			con = DriverManager.getConnection(url, user, password);
			System.out.println("���Ἲ��:" + con);

			// 1. PreparedStatement����
			ptmt = con.prepareStatement(sql);

			// 2. ?�� �� �����ϱ�
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			
			// 3. �����ϱ�
			//int result = ptmt.executeUpdate(sql);  ������ sql�Ľ������Ƿ� sql ����������.
			int result = ptmt.executeUpdate();
			System.out.println(result + "�� �� ���Լ���");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("�������:");
			e.printStackTrace();
		} finally {
			try {
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
