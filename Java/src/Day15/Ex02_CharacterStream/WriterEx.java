package Day15.Ex02_CharacterStream;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriterEx {

	public static void main(String[] args) {
		// 파일 경로
		String filePath = "sample.txt";
		
		try (
			// FileWriter 객체를 사용하여, 문자 단위로 데이터 출력
			FileWriter fw = new FileWriter(filePath);
			// BufferedWriter 객체를 사용하여, 데이터 출력 성능 향상
			BufferedWriter bw = new BufferedWriter(fw);
			){
			bw.write("Hello Java~! \n");
			bw.write("This is Bae Eun Ju \n");
			bw.write("동해물과백두산이마르고닳도록하느님이보우하사우리나라만세무궁화삼천리화려강산대한사람대한으로길이보전하세 \n");
			// \n은 엔터(개행) 이스케이프 문자

			System.out.println("sample.txt 파일을 저장하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
