package Royce.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2022.06.28
//Created by TaeyeonRoyce

public class Boj_1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		//Test Case만큼 진행
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
		//mC1 = m 이므로
		memo[1] = M;

		//mCn 구하기
		for (int i = 2; i <= N; i++) {
			//mC(n-1) 과 mCn과의 관계
			memo[i] = (memo[i - 1]) * (M - i + 1) / i;
		}
		return memo[N];
	}
}
