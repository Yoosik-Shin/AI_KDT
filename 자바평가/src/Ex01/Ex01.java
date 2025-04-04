package Ex01;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];
		
		for (int i = 0; i < 5; i++) {
			score[i] = sc.nextInt();
//			System.out.print(score[i] + " ");
		}
		
		for (int i = 0; i < score.length-1; i++) {
			for (int j = i+1; j < score.length; j++) {
				if (score[i] > score[j]) {
					int temp = score[i];
					score[i] = score[j];
					score[j] = temp;
					System.out.print(score[i] + " ");
				}
			}
		}
	}
}
