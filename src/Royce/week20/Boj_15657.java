package Royce.week20;

//2022.11.02
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/15657

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15657 {

	private static int N;
	private static int M;
	private static int[] memo;
	private static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		memo = new int[N];
		result = new int[M];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memo[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(memo);

		dfs(0);
	}

	private static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (depth < 1) {
				result[depth] = memo[i];
				dfs(depth + 1);
				continue;
			}

			if (result[depth - 1] <=  memo[i]) {
				result[depth] = memo[i];
				dfs(depth + 1);
			}
		}
	}
}
