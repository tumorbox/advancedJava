package jdbc.board.exam;

import java.util.ArrayList;

public interface BoardDAO {
	int insert(BoardDTO board);//�Խñ۵��-C
	int insert(String id, String title,String content);//�Խñ۵��
	int update(String id, int boardnum);//�Խñ� ���� - U
	int delete(int boardnum);//�Խñ� ���� - D
	ArrayList<BoardDTO> select() ;//��ü �Խñ� ��ȸ - L
	BoardDTO read(int boardnum);//�Խñ� ��ȸ - R
	ArrayList<BoardDTO> findByTitle(String title);//�Խñ� �˻� - 
}












