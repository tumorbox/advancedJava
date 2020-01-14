package api.util;

import java.util.HashSet;
import java.util.Set;

public class HashSetExm {
	public static void main(String[] args) {
		// ������ ���� ���������� HashSet��ü 2�� �ۼ��ϱ�
		// set1 -> 1���� 10������ ����
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int i = 1; i <= 10; i++) {
			set1.add(i);
		}
		// set2 -> 5���� 15������ ����
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int i = 5; i <= 15; i++) {
			set2.add(i);

		}
		
		System.out.println("set1�� �� : " + set1);
		System.out.println("set2�� �� : " + set2);
		// set1�� set2������ ����ϱ�
		
		HashSet<Integer> hap = new HashSet<Integer>(set1);
		hap.addAll(set2);
		System.out.println("set1�� set2�� ������: " + hap);

		// set1�� set2������ ����ϱ�
		set1.retainAll(set2);
		System.out.println("set1�� set2�� ������ : " + set1);
	}

}
