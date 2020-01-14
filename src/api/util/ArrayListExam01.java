package api.util;

import java.util.ArrayList;

public class ArrayListExam01 {
	public static void main(String[] args) {
		//79,55,100,98,99¸¦ ArrayList¿¡ ´ã°í ÃÑÁ¡°ú Æò±ÕÀ» Ãâ·ÂÇÏ¼¼¿ä.
		//[Ãâ·ÂÇüÅÂ]
		//ÃÑÁ¡:____
		//Æò±Õ:____
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(79);
		list.add(55);
		list.add(100);
		list.add(98);
		list.add(99);
		int sum = 0;
		int size = list.size();
		for(int i=0;i<size;i++) {
			sum = sum+list.get(i);
		}
		System.out.println("ÃÑÁ¡:"+sum);
		System.out.println("Æò±Õ:"+(sum/size));
	}
}










