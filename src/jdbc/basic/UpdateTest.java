package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql= "update tb_board ";
		sql = sql + "set id='kang' ";
		sql = sql + "where boardnum=2";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��ε� ����!!");
			Connection con = 
					DriverManager.getConnection(url, user, 
														password);
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"�� �� ��������");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹��ε� ����");
		}catch(SQLException e) {
			System.out.println("�������:");	
			e.printStackTrace();//��������
		}
	}
}










