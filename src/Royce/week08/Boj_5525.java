package Royce.week08;

//2022.08.17
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/5525

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> sizes = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		int cursor = 2;
		while (cursor < M) {
			int size = 0;
			if (S.charAt(cursor - 2) == 'I'
				&& S.charAt(cursor - 1) == 'O'
				&& S.charAt(cursor) == 'I') {
				size = 1;
				while (cursor < M - 2
					&& S.charAt(cursor + 1) == 'O'
					&& S.charAt(cursor + 2) == 'I') {

					size += 1;
					cursor += 2;
				}
			}
			cursor += 1;
			sizes.add(size);
		}

		int answer = 0;
		for (int size : sizes) {
			if (size >= N) {
				answer = answer + size - N + 1;
			}
		}

		System.out.println(answer);
	}
}
