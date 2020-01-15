package api.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//���ڴ����� �о ���� input�ϱ�
public class FileReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;

		try {
			// 1. ���� �����ϱ�
			fr = new FileReader("src/api/io/FileTest01.java");

			// 2. ���� �׼���
			int count=0;
			long start = System.nanoTime();
			while (true) {
				int data = fr.read();
				if (data == -1) {
					break;
				}
				count++;
				System.out.print((char)data);
			}
			long end = System.nanoTime();
			System.out.println("����Ƚ�� => "+count);
			System.out.println("����ð� => "+(end-start));
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 3. ���� �ݱ�
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
