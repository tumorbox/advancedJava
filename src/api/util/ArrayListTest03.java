package api.util;

import java.util.ArrayList;

public class ArrayListTest03 {
	public static void main(String[] args) {
		String[] arr = {"java","oracle","jdbc","html5","css"};
		ArrayList<String> list = changeData(arr);
		//��ȯ�Ǿ� ���ϵ� ArrayList�� ����� ���� ������ ����ϱ�
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	//�迭�� ArrayList�� ��ȯ�ؼ� �����ϴ� �޼ҵ�
	public static ArrayList<String> changeData(String[] arr){
		ArrayList<String> list = new ArrayList<String>();
		//�Ű������� ���޵� �迭���� �����͸� ������ ArrayList�� �����ϴ� �ڵ�
		
		
		
		return list;
		
	}

}
