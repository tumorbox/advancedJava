package api.util;

import java.util.HashSet;
import java.util.Iterator;

//HashSet����ϱ� - ������ �����ϰ� ����� ������ ������
//����, �ߺ��� ������� �ʴ´�.
public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("java");
		set.add("jdbc");
		set.add("oracle");
		set.add("html");
		set.add("css");
		set.add("java");
		System.out.println("������=>"+set.size());
		
		//set�� ����� ����� ����
		//1. HashSet�����͸� ǥ�� �������̽�
		//(��� �ڷᱸ���� ��� �����͸� ��ȭ�ؼ� ���� ���ֵ��� �����Ǵ� �������� �������̽�) Iterator�� ��ȯ
		Iterator<String> it = set.iterator();
		//2. ��ȯ�� �� ����
		//boolean�� �����ϹǷ�
		while(it.hasNext()) {	//Iterator�ȿ� ������ ��Ұ� �ִ��� Ȯ�� - boolean����
			String data = it.next();	//Iterator�� ����� ��Ҹ� �ϳ� ������ ��ȯ
			System.out.println("���� ��� : "+data);
			
		}
		for (String string : set) {
			System.out.println("set�� ����ȿ�� : "+string);
			
		}

	}

}
