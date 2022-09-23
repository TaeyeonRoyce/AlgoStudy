package Royce.week14;

//2022.09.23
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/6064

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int answer = solution(br);
			System.out.println(answer);
		}
	}

	private static int solution(BufferedReader br) throws IOException {
		String[] MNxy = br.readLine().split(" ");
		int M = Integer.parseInt(MNxy[0]);
		int N = Integer.parseInt(MNxy[1]);
		int x = Integer.parseInt(MNxy[2]);
		int y = Integer.parseInt(MNxy[3]);

		int i = x;
		while (i <= N * M) {
			if (i < 0) {
				return -1;
			}
			if ((i - y) % N == 0) {
				return i;
			}
			i += M;
		}

		return -1;
	}
}
