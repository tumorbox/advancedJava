package api.io;

import java.io.File;

//������ ���θ� Ž��
public class FileTest02_answer {
	public static void main(String[] args) {
		//c:\iot\iotest������ ���� ���� �� ������ ���
		//[�������]
		//a -------------[����]
		//b -------------[����]
		//ArrayTest01.java -----------[����:(������ ������ ���)]
		//.
		//.
		//.
		File file = new File("c:/iot/iotest");
		File[] filelist = file.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isDirectory()) {
				System.out.println(filelist[i].getName()
						+"-----------------[����]");
			}else {
				System.out.println(filelist[i].getName()
						+"-----------------[����:("+
						filelist[i].length()+")]");
			}
		}
	}
}














