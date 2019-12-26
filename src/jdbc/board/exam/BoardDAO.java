package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board테이블을 엑세스하는 기능이 정의된 클래스
public class BoardDAO {

	// insert 메소드
	public void insert(String id, String title, String content) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";

		try {
			con = DBUtil.getConnect(); // DBMS연결
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			int result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삽입성공");
		} catch (SQLException e) {
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

	// 업데이트 메소드
	public void update(String id, int boardnum) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "update tb_board set id = ? where boardnum= ?";

		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setInt(2, boardnum);
			int result = ptmt.executeUpdate();
			System.out.println("result: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	// 삭제 메소드
	public void delete(int boardnum) {
		StringBuffer sql = new StringBuffer();
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		sql.append("delete tb_board ");
		sql.append("where boardnum=?");
		try {

			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setInt(1, boardnum);
			int result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삭제성공");
		} catch (SQLException e) {
			System.out.println("연결실패:");
			e.printStackTrace();
		} finally {
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
	// select 메소드
	public void select() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select id,title,content from tb_board";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3) + "\t");
				System.out.println(rs.getString("content") + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
