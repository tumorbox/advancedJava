package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board���̺��� �������ϴ� ����� ���ǵ� Ŭ����
public class BoardDAOImpl implements BoardDAO {
	
	public int insert(BoardDTO board) {
		System.out.println("dto��� �޼ҵ� : "+board);
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0;	//�޼ҵ� �������� ������ ����
		try {
			con = DBUtil.getConnect(); // DBMS����
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, board.getId());
			ptmt.setString(2, board.getTitle());
			ptmt.setString(3, board.getContent());
			result = ptmt.executeUpdate();
			
			
			System.out.println(result + "�� �� ���Լ���");
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
		return result;
	}

	// insert �޼ҵ�
	public int insert(String id, String title, String content) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";

		try {
			con = DBUtil.getConnect(); // DBMS����
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			result = ptmt.executeUpdate();
			System.out.println(result + "�� �� ���Լ���");
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
		return result;
	}

	// ������Ʈ �޼ҵ�
	public int update(String id, int boardNum) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "update tb_board set id = ? where boardnum= ?";

		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setInt(2, boardNum);
			result = ptmt.executeUpdate();
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
		return result;
	}

	// ���� �޼ҵ�
	public int delete(int boardNum) {
		StringBuffer sql = new StringBuffer();
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int result = 0;
		sql.append("delete tb_board ");
		sql.append("where boardnum=?");
		try {

			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setInt(1, boardNum);
			result = ptmt.executeUpdate();
			System.out.println(result + "�� �� ��������");
		} catch (SQLException e) {
			System.out.println("�������:");
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
		return result;
	}
	// select �޼ҵ�
	public void select() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select id,title,content from tb_board";
		try {
			con = DBUtil.getConnect();
			//select���� ����
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {					// => ���ڵ带 ��ȸ�ϱ� ���ؼ��� ���ڵ尡 �� ���� �ݵ�� Ŀ���� �̵����Ѿ� �Ѵ�.
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
