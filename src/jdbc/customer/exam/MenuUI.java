package jdbc.customer.exam;

import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	CustomerDAO dao = new CustomerDAO();

	public void insertMenu() {
		// 입사일은 오늘날짜 - sysdata
		// point = 1000
		System.out.println("*******사원등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		System.out.print("성명:");
		String name = key.next();
		System.out.print("주소:");
		String addr = key.next();
		
		CustomerDTO user = new CustomerDTO(id, pass, name, addr);
		int result = dao.insert(user);

		if (result > 0) {
			System.out.println("게시글 등록 성공");
		} else {
			System.out.println("글 등록 실패");
		}

	}

	public void updateMenu() {
		System.out.println("*******사원수정********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("주소:");
		String addr = key.next();
		int result = dao.update(id, addr);
		if (result > 0) {
			System.out.println("게시글 수정 성공");
		} else {
			System.out.println("게시글 수정 실패");
		}
	}

	public void deleteMenu() {
		System.out.println("*******사원삭제********");
		System.out.print("아이디:");
		String id = key.next();
		int result = dao.delete(id);
		if (result > 0) {
			System.out.println("게시글 삭제 성공");
		} else {
			System.out.println("게시글 삭제 실패");
		}
	}
}
