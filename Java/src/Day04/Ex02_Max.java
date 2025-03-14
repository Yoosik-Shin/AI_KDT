package Day04;

import java.util.Scanner;

public class Ex02_Max {

	public static void main(String[] args) {
		// 첫번째 줄에 입력할 개수 N을 입력받고
		// 둘째 줄에 N개의 정수를 공백을 두고 입력 받으시오.
		// N개의 정수 중, 최댓값을 구하시오.
		// (입력)
		// 5
		// 90 60 70 100 55
		// (출력)
		// 최댓값 : 100

		/**
		 * 순서도 
		 * 1. 정수 하나를 입력받아서 N에 대입 
		 * 2. N개 요소를 갖는 배열 arr 선언 및 생성 
		 * 3. N번 반복하면서 정수를 입력받아서 배열 arr에 순서대로 대입 
		 * 4. 배열을 반복해서 최댓값 max를 배열 i번째 요소랑 비교 
		 * 5. 두 요소 중에서 더 큰 요소를 max에 대입 
		 * 6. 반복이 끝나고, max를 출력
		 */

		// 1. 정수 하나를 입력받아서 N에 대입
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int N = sc.nextInt();

		// 2. N개 요소를 갖는 배열 arr 선언 및 생성
		int arr[] = new int[N];

		// 3. N번 반복하면서 정수를 입력받아서 배열 arr에 순서대로 대입
		// N : 5
		// i : 0 1 2 3 4
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 4. 배열을 반복해서 최댓값 max를 배열 i번째 요소랑 비교
		int max = Integer.MIN_VALUE; // Integer.MIN_VALUE< int범위에서의 최저값
		for (int i = 0; i < arr.length; i++) {
			// 5. 두 요소 중에서 더 큰 요소를 max에 대입
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		// 6. 반복이 끝나고, max를 출력
		System.out.print("최댓값 : " + max);
		sc.close();
	}

}
