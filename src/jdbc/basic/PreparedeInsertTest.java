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
		System.out.println("**************** 게시글 등록*****************");
		System.out.print( "아이디 : ");
		String id = key.next();
		System.out.print( "제목 : ");
		String title = key.next();
		System.out.print( "내용 : ");
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
		//잘 사용하지 않음...
		/*String sql = "insert into tb_board values(board_seq.nextval,'"+id+"','"
					+ ""+title+"','"+content+"',sysdate,0)";*/
		
		//동적sql 외부에서 입력받을 값들은 ?으로 표시
		String sql ="insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공!!");

			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공:" + con);

			// 1. PreparedStatement생성
			ptmt = con.prepareStatement(sql);

			// 2. ?에 값 전달하기
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			
			// 3. 실행하기
			//int result = ptmt.executeUpdate(sql);  위에서 sql파싱했으므로 sql 없어져야함.
			int result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삽입성공");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결실패:");
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
