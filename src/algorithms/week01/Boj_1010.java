package algorithms.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			long answer = getAnswer(br);
			System.out.println(answer);
		}
	}

	private static long getAnswer(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] memo = new long[M + 1];
		memo[1] = M;
		//mCn
		for (int i = 2; i <= N; i++) {
			memo[i] = (memo[i - 1]) * (M - i + 1) / i;
		}
		return memo[N];
	}
}
