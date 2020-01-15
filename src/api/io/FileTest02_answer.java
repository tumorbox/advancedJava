package api.io;

import java.io.File;

//폴더의 내부를 탐색
public class FileTest02_answer {
	public static void main(String[] args) {
		//c:\iot\iotest폴더의 하위 폴더 및 파일을 출력
		//[출력형태]
		//a -------------[폴더]
		//b -------------[폴더]
		//ArrayTest01.java -----------[파일:(파일의 사이즈 출력)]
		//.
		//.
		//.
		File file = new File("c:/iot/iotest");
		File[] filelist = file.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isDirectory()) {
				System.out.println(filelist[i].getName()
						+"-----------------[폴더]");
			}else {
				System.out.println(filelist[i].getName()
						+"-----------------[파일:("+
						filelist[i].length()+")]");
			}
		}
	}
}















