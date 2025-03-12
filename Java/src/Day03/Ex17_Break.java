package Day03;

import java.util.Scanner;

public class Ex17_Break {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// angksfnvm
		// : 반드시 종료 조건을 추가해 주어야 한다.
		while (true) {
			System.out.print("입력 : ");
			String input = sc.nextLine();   // 문자열 한 줄 입력
			
			// 문자열.equals("비교문자열")
			// : 문자열이 비교문자열과 일치하는지 여부를 알려주는 메소드
			if( input.equals("STOP"))
				break;
			
			System.out.println(">> " + input);
		}
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}

}
