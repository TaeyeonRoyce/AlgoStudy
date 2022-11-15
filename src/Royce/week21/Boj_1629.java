package Royce.week21;

//2022.11.08
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1629

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ABC = br.readLine().split(" ");
		long A = Long.parseLong(ABC[0]);
		long B = Long.parseLong(ABC[1]);
		long C = Long.parseLong(ABC[2]);

		System.out.println(cal(A, B, C));
	}

	private static long cal(long A, long B, long C) {
		if (B == 0) {
			return 1;
		} else if (B == 1) {
			return A;
		} else if (B % 2 == 0) {
			long n = cal(A, B / 2, C) % C;
			return (n * n) % C;
		}

		long n = cal(A, B / 2, C) % C;
		return (((n * n) % C) * A) % C;
	}
}
