package Ex01;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] grade = new int[5];
		

		for (int i = 0; i < grade.length; i++) {
			grade[i] = sc.nextInt();
		}
		// 오름차순
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < grade.length-1-i; j++) {
				if (grade[j] > grade[j+1]) {
					int temp = grade[j];
					grade[j] = grade[j+1];
					grade[j+1] = temp;
				}
			}
		}
		for (int result : grade) {
			System.out.print(result + " ");
		}
		System.out.println();
		
		// 내림차순
		for (int i = 0; i < grade.length-1; i++) {
			for (int j = 0; j < grade.length-1-i; j++) {
				if (grade[j] < grade[j+1]) {
					int temp = grade[j];
					grade[j] = grade[j+1];
					grade[j+1] = temp;
				}
			}
		}
		for (int result : grade) {
			System.out.print(result + " ");
		}
		sc.close();
	}
	
}
