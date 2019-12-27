package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAOImpl implements MemberDAO{


	@Override
	public int insert(MemberDTO user) {
		System.out.println("dto사용 메소드 : "+user);
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "insert into member values(?,?,?,?,?,sysdate,1000)";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getId());
			ptmt.setString(2, user.getPass());
			ptmt.setString(3, user.getName());
			ptmt.setString(4, user.getAddr());
			ptmt.setInt(5, user.getDeptno());
			result = ptmt.executeUpdate();
			
			System.out.println(result + "개의 행 입력 성공");
		} catch(SQLException e) {
			e.printStackTrace();
		}	finally {
			try {
				if(ptmt != null)
					ptmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql ="update member set addr = ? where id = ?";
		try {
			con = DBUtil.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, addr);
			ptmt.setString(2, id);
			result = ptmt.executeUpdate();
			System.out.println("result: " + result);
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

	@Override
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql="delete member where id =?";
		
		try {
			con = DBUtil.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삭제 성공");
		}  catch (SQLException e) {
			System.out.println("연결실패");
			e.printStackTrace();
		} finally {
			try {
				if(ptmt!=null) 
					ptmt.close();
				if(con!=null)	
					con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
