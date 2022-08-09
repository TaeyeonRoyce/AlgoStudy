package Royce.week05;

//2022.07.25
//Created by TaeyeonRoyce
//Link - https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PsIl6AXIDFAUq

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SWEA_1970 {

	private static int[] moneyUnit = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	private static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int cost = Integer.parseInt(br.readLine());
			solution(cost);
			System.out.printf("#%d\n", test_case);
			for (int i = 0; i < 8; i++) {
				if (i == 7) {
					System.out.printf("%d\n", answer[i]);
				} else {
					System.out.printf("%d ", answer[i]);
				}
			}
		}
	}

	private static void solution(int cost) {
		int moneyUnitCursor = 0;
		answer = new int[8];

		while (cost != 0 && moneyUnitCursor < 8) {
			if (cost >= moneyUnit[moneyUnitCursor]) {
				answer[moneyUnitCursor] += 1;
				cost -= moneyUnit[moneyUnitCursor];
			} else {
				moneyUnitCursor++;
			}
		}
	}
}
