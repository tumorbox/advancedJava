package api.util;

import java.util.Vector;

// vector를 만들고 사용하는 방법
public class VectorTest01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();

		/*초기에는 여러타입이 그냥 다 들어갔었음. 정확히 타입을 표시하는 것이 좋다.
		 * <>에 타입을 넣어서 들어갈 데이터 타입을 정함.
		v.add("java");
		v.add(10);*/
		
	    //v.add("java");
		v.add(10);
											//vector는 api이기 때문에 요소의 콜 형식으로 해야한다.
		System.out.println("Vector의 용량: " + v.capacity());		//총사이즈
		System.out.println("Vector에 저장된 요소의 갯수 : " + v.size());
		System.out.println("==================================");
		
		for(int i=1;i<=10;i++) {
			v.add(i);
		}
		System.out.println("Vector의 용량: " + v.capacity());		
		System.out.println("Vector에 저장된 요소의 갯수 : " + v.size());
	System.out.println("==================================");
		
		for(int i=1;i<=20;i++) {
			v.add(i);
		}
		System.out.println("Vector의 용량: " + v.capacity());		
		System.out.println("Vector에 저장된 요소의 갯수 : " + v.size());
	}

}
