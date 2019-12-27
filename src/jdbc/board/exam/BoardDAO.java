package jdbc.board.exam;

public interface BoardDAO {
	//한꺼번에 받아서 작업하겠다
	int insert(BoardDTO board);
	
	int insert(String id, String title, String content);
	int update(String id, int boardNum);
	int delete(int boardNum);
	void select();
}
