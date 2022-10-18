package Royce.week17;

//2022.10.13
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/2407

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj_2407 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		BigInteger[] memo = new BigInteger[N + 1];
		memo[0] = BigInteger.ONE;
		memo[1] = BigInteger.valueOf(N);

		if (M > N / 2) {
			M = N - M;
		}
		for (int i = 2; i <= M; i++) {
			memo[i] = (memo[i - 1]).multiply(BigInteger.valueOf(N - i + 1)).divide(BigInteger.valueOf(i));
		}

		System.out.println(memo[M]);
	}
}
