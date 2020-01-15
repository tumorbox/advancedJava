package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * ScoreTest.java�ۼ�
	- BufferReader�� ���
	- ������ �о �Ʒ��� ���� �������� ���
	- �׻� �� �÷����� ����
	- ��Ʈ : �� �� �п�, �� �������� �и�
	[�������]
			�̹�ȣ�� ������ 100��
			������ ������ 98��
			������� ������ 99��
			���� :
			��� :
			*/
				
public class ScoreTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/data/score.txt"));
			int sum=0;
			int count=0;
			
			while (true) {
				String data = br.readLine();
				if (data == null) {
					break;
				}
				String[] data2 = data.split(",");
				System.out.println(data2[0]+"�� ������ "+data2[1]+"��" );
				
				count++;
				sum += Integer.parseInt(data2[1]);
				
				System.out.println();
			}
			System.out.println("���� : " + sum);
			System.out.println("��� : " + (double)(sum / count));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
