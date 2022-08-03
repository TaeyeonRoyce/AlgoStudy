package algorithms.week06.swea_4038;

//2022.07.28
//Created by TaeyeonRoyce
//단어가 등장하는 횟수 -> KMP 알고리즘
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = solution(br);
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static int solution(BufferedReader br) throws IOException {
		String B = br.readLine();
		String S = br.readLine();
		int[] table = new int[B.length()];
		int j = 0;
		for (int i = 1; i < S.length(); i++) {
			while (j > 0 && S.charAt(i) != S.charAt(j)) {
				j = table[j - 1];
			}
			if (S.charAt(i) == S.charAt(j)) {
				table[i] = ++j;
			}
		}

		int count = 0;
		j = 0;
		for (int i = 0; i < B.length(); i++) {
			while (j > 0 && B.charAt(i) != S.charAt(j)) {
				j = table[j - 1];
			}
			if (B.charAt(i) == S.charAt(j)) {
				if (j == S.length() - 1) {
					count++;
					j = table[j];
				} else {
					j++;
				}
			}
		}

		return count;
	}
}
