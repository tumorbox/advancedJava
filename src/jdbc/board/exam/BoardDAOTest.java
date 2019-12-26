package jdbc.board.exam;

import java.util.Scanner;

public class BoardDAOTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		BoardDAO dao= new BoardDAO();
		System.out.println("**************** 게시글 등록*****************");
		System.out.print( "아이디 : ");
		String id = key.next();
		System.out.print( "제목 : ");
		String title = key.next();
		System.out.print( "내용 : ");
		String content = key.next();
		dao.insert(id, title, content);
		
	System.out.println("**************** 아이디 수정*****************");
		int boardnum = key.nextInt();
		dao.update(id, boardnum);
		System.out.println("**************** 게시글 작제*****************");
		int boardnum1 = key.nextInt();
		dao.delete(boardnum1);
		dao.select();
	}
}
