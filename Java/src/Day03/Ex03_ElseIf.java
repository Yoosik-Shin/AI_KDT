package Day03;

import java.util.Scanner;

public class Ex03_ElseIf {

	public static void main(String[] args) {
		// 성적을 입력받아서, 성적에 따른 학점 A~F를 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("성적 : ");
		int score = sc.nextInt();
		char grade = 'F';
		
		// if
		// 90점 이상, A
		// 80점 이상, B
		// 70점 이상, C
		// 60점 이상, D
		// 60점 미만, F
		
		//1
//		if( score >= 90 && score <= 100 ) {
//			System.out.println("A 입니다.");
//		} if (score >= 80 && score < 90) {
//			System.out.println("B 입니다.");
//		} if (score >= 70 && score < 80) {
//			System.out.println("C 입니다.");
//		} if (score >= 60 && score < 70) {
//			System.out.println("D 입니다.");
//		} if (score < 60 && score >= 0 ){
//			System.out.println("F 입니다.");
//		} else System.out.print("잘못된 점수 입니다.");
//		
//		//2
//		if( score >= 90 && score <= 100 ) grade = 'A';
//		if (score >= 80 && score < 90) grade = 'B';
//		if (score >= 70 && score < 80) grade = 'C';
//		if (score >= 60 && score < 70) grade = 'D';
//		if (score < 60 && score >= 0 ) grade = 'F';
//		System.out.print("학점 : " + grade);
		
		//3 - 이렇게하면 실수로 100을 넘기는 숫자입력시에
		 //   첫째조건은 만족하지않고 둘째조건은 만족
		if( score >= 90 && score <= 100 ) grade = 'A';
		else if (score >= 80 ) grade = 'B';
		else if (score >= 70 ) grade = 'C';
		else if (score >= 60 ) grade = 'D';
		else grade = 'F';
		System.out.print("학점 : " + grade);
		
		sc.close();
				
	}

}
