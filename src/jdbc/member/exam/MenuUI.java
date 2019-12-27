package jdbc.member.exam;

import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	MemberDAO dao = new MemberDAOImpl();

	public void insertMenu() {
		//�Ի����� ���ó�¥ - sysdata
		//point = 1000
		System.out.println("*******������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		System.out.print("����:");
		String name = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		System.out.print("�μ���ȣ:");
		int deptno = key.nextInt();
		
		MemberDTO user = new MemberDTO(id, pass, name, addr, deptno);
		int result =dao.insert(user);
		
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
		int result =dao.delete(id);
		if (result > 0) {
			System.out.println("�Խñ� ���� ����");
		} else {
			System.out.println("�Խñ� ���� ����");
		}
	}

	public void findByAddrMenu() {
		System.out.println("*******����˻�********");
		System.out.print("�ּ�:");
		String addr = key.next();
		// ���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
	}

	public void selectMenu() {
		System.out.println("*******�����ȸ********");
		// ���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ��� - ��ü�����ȸ
	}
}
