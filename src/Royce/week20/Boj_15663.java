package Royce.week20;

//2022.11.02
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/15663

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_15663 {

	private static int N;
	private static int M;
	private static int[] memo;
	private static int[] result;
	private static boolean[] visit;
	private static Set<String> numberSet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		memo = new int[N];
		result = new int[M];
		visit = new boolean[N + 1];
		numberSet = new LinkedHashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memo[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(memo);

		dfs(0);
		for (String number : numberSet) {
			System.out.println(number);
		}
	}

	private static void dfs(int depth) {
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			numberSet.add(sb.toString());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[depth] = memo[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}
