package jdbc.board.exam;

import java.util.Scanner;

public class BoardDAOTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		BoardDAO dao= new BoardDAO();
		System.out.println("**************** �Խñ� ���*****************");
		System.out.print( "���̵� : ");
		String id = key.next();
		System.out.print( "���� : ");
		String title = key.next();
		System.out.print( "���� : ");
		String content = key.next();
		dao.insert(id, title, content);
		
	System.out.println("**************** ���̵� ����*****************");
		int boardnum = key.nextInt();
		dao.update(id, boardnum);
		System.out.println("**************** �Խñ� ����*****************");
		int boardnum1 = key.nextInt();
		dao.delete(boardnum1);
		dao.select();
	}
}
