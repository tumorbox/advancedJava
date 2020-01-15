package api.io;

import java.io.InputStreamReader;
import java.io.PrintStream;

//InputStream을 이용해서 키보드로 입력받는 문자열을 읽기 
// - Scanner 클래스의 next메소드의 기능을 구현
public class InputStreamReaderTest {

	public static void main(String[] args) {
		InputStreamReader in = 	new InputStreamReader(System.in);
		PrintStream out = System.out;
		
		while(true) {
			//1. 스트림의 데이터를 1byte읽기
			try {
				int data = in.read();
				//엔터를 누르고띄는 것도 바이트로 취급하기 때문에 13으로 엔터누르면 브릭되게 한다.
				
				if(data==13) {
					break;
				}
				out.print((char)data);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
