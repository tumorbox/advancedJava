package api.io;

import java.io.InputStreamReader;
import java.io.PrintStream;

//InputStream�� �̿��ؼ� Ű����� �Է¹޴� ���ڿ��� �б� 
// - Scanner Ŭ������ next�޼ҵ��� ����� ����
public class InputStreamReaderTest {

	public static void main(String[] args) {
		InputStreamReader in = 	new InputStreamReader(System.in);
		PrintStream out = System.out;
		
		while(true) {
			//1. ��Ʈ���� �����͸� 1byte�б�
			try {
				int data = in.read();
				//���͸� �������� �͵� ����Ʈ�� ����ϱ� ������ 13���� ���ʹ����� �긯�ǰ� �Ѵ�.
				
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
