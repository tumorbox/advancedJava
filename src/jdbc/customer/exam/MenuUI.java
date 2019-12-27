package jdbc.customer.exam;

import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	CustomerDAO dao = new CustomerDAO();

	public void insertMenu() {
		// �Ի����� ���ó�¥ - sysdata
		// point = 1000
		System.out.println("*******������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		System.out.print("����:");
		String name = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		
		CustomerDTO user = new CustomerDTO(id, pass, name, addr);
		int result = dao.insert(user);

		if (result > 0) {
			System.out.println("�Խñ� ��� ����");
		} else {
			System.out.println("�� ��� ����");
		}

	}

	public void updateMenu() {
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		int result = dao.update(id, addr);
		if (result > 0) {
			System.out.println("�Խñ� ���� ����");
		} else {
			System.out.println("�Խñ� ���� ����");
		}
	}

	public void deleteMenu() {
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		int result = dao.delete(id);
		if (result > 0) {
			System.out.println("�Խñ� ���� ����");
		} else {
			System.out.println("�Խñ� ���� ����");
		}
	}
}
