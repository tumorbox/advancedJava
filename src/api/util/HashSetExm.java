package api.util;

import java.util.HashSet;
import java.util.Set;

public class HashSetExm {
	public static void main(String[] args) {
		// 다음과 같은 변수명으로 HashSet객체 2개 작성하기
		// set1 -> 1부터 10까지의 정수
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int i = 1; i <= 10; i++) {
			set1.add(i);
		}
		// set2 -> 5부터 15까지의 정수
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int i = 5; i <= 15; i++) {
			set2.add(i);

		}
		
		System.out.println("set1의 값 : " + set1);
		System.out.println("set2의 값 : " + set2);
		// set1과 set2합집합 출력하기
		
		HashSet<Integer> hap = new HashSet<Integer>(set1);
		hap.addAll(set2);
		System.out.println("set1과 set2의 합집합: " + hap);

		// set1과 set2교집합 출력하기
		set1.retainAll(set2);
		System.out.println("set1과 set2의 교집합 : " + set1);
	}

}
