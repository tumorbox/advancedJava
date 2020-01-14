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
		System.out.println("********����*************");
		System.out.print("���̵� :");
		String id = key.next();
		System.out.print("��ȣ :");
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
			System.out.println("����̹� �ε� ����");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("���Ἲ��"+con);
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setInt(2, boardnum);
			int result = stmt.executeUpdate();
			System.out.println(result+"�� ���� ����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();//��������
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
