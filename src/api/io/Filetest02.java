package api.io;

import java.io.File;
import java.text.SimpleDateFormat;

//������ ���θ� Ž��
public class Filetest02 {
	public static void main(String[] args) {
		// c:\iot\iotest������ ���� ���� �� ���� ���
		// [��� ����]
		// a-----------------[����]
		// b-----------------[����]
		// ArrayTest01.java-------------[����:(������ ������ ���)]
		// .
		// .
		// .
		// .
		//������ ������ ��¥�� �� �� ���� �������� ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		
		File file1 = new File("c:/iot/iotest");
		for (File info : file1.listFiles()) {
			if (info.isDirectory()) {
				System.out.println(info.getName()+"--------------[����]");
			}
			if (info.isFile()) {
				System.out.println(info.getName() + "--------------[���� ������ : " + info.length()+"]  [���� ��¥ : "+
								sdf.format(info.lastModified())+"]");
			}
		}
	}

}
