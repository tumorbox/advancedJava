package api.util;

import java.util.Vector;

// vector�� ����� ����ϴ� ���
public class VectorTest01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();

		/*�ʱ⿡�� ����Ÿ���� �׳� �� ������. ��Ȯ�� Ÿ���� ǥ���ϴ� ���� ����.
		 * <>�� Ÿ���� �־ �� ������ Ÿ���� ����.
		v.add("java");
		v.add(10);*/
		
	    //v.add("java");
		v.add(10);
											//vector�� api�̱� ������ ����� �� �������� �ؾ��Ѵ�.
		System.out.println("Vector�� �뷮: " + v.capacity());		//�ѻ�����
		System.out.println("Vector�� ����� ����� ���� : " + v.size());
		System.out.println("==================================");
		
		for(int i=1;i<=10;i++) {
			v.add(i);
		}
		System.out.println("Vector�� �뷮: " + v.capacity());		
		System.out.println("Vector�� ����� ����� ���� : " + v.size());
	System.out.println("==================================");
		
		for(int i=1;i<=20;i++) {
			v.add(i);
		}
		System.out.println("Vector�� �뷮: " + v.capacity());		
		System.out.println("Vector�� ����� ����� ���� : " + v.size());
	}

}
