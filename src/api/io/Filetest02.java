package api.io;

import java.io.File;
import java.text.SimpleDateFormat;

//폴더의 내부를 탐색
public class Filetest02 {
	public static void main(String[] args) {
		// c:\iot\iotest폴더의 하위 폴더 및 파일 출력
		// [출력 형태]
		// a-----------------[폴더]
		// b-----------------[폴더]
		// ArrayTest01.java-------------[파일:(파일의 사이즈 출력)]
		// .
		// .
		// .
		// .
		//마지막 접속한 날짜를 년 월 일의 형식으로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		File file1 = new File("c:/iot/iotest");
		for (File info : file1.listFiles()) {
			if (info.isDirectory()) {
				System.out.println(info.getName()+"--------------[폴더]");
			}
			if (info.isFile()) {
				System.out.println(info.getName() + "--------------[파일 사이즈 : " + info.length()+"]  [수정 날짜 : "+
								sdf.format(info.lastModified())+"]");
			}
		}
	}

}
