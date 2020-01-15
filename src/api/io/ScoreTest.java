package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * ScoreTest.java작성
	- BufferReader를 사용
	- 파일을 읽어서 아래와 같은 형식으로 출력
	- 항상 두 컬럼으로 고정
	- 힌트 : 한 줄 읽오, 를 기준으로 분리
	[출력형태]
			이민호의 점수는 100점
			현빈의 점수는 98점
			김범룡의 점수는 99점
			총점 :
			평균 :
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
				System.out.println(data2[0]+"의 점수는 "+data2[1]+"점" );
				
				count++;
				sum += Integer.parseInt(data2[1]);
				
				System.out.println();
			}
			System.out.println("총점 : " + sum);
			System.out.println("평균 : " + (double)(sum / count));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
