package algorithms.week05;

//2022.07.24
//Created by TaeyeonRoyce
//Link - https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOHEx66kIDFAWr


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = solution(br);
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static int solution(BufferedReader br) throws IOException {
		String[] s = br.readLine().split(" ");
		char[] to = s[0].toCharArray();
		char[] from = s[1].toCharArray();
		int answer = 0;
		int[][] memo = new int[to.length + 1][from.length + 1];

		for (int i = 0; i < to.length + 1; i++) {
			for (int j = 0; j < from.length + 1; j++) {
				if (i == 0 || j == 0) {
					memo[i][j] = 0;
					continue;
				}

				if (to[i - 1] == from[j - 1]) {
					memo[i][j] = memo[i - 1][j - 1] + 1;
				} else {
					if (memo[i - 1][j] > memo[i][j - 1]) {
						memo[i][j] = memo[i - 1][j];
					} else {
						memo[i][j] = memo[i][j - 1];
					}
				}

				if (memo[i][j] > answer) {
					answer = memo[i][j];
				}
			}
		}

		return answer;
	}
}
