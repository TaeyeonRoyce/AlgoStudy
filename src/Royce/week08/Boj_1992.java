package Royce.week08;

//2022.08.17
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1992

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1992 {
	private static int[][] board;
	private static String answer = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}

		dfs(0, 0, N);
		System.out.println(answer);
	}

	private static void dfs(int startY, int startX, int N) {
		if (N <= 0) {
			return;
		}

		boolean flag = true;
		int initNum = board[startY][startX];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[startY + i][startX + j] != initNum) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
		}

		if (!flag) {
			answer += "(";
			int halfN = N / 2;
			dfs(startY, startX, halfN);
			dfs(startY, startX + halfN, halfN);
			dfs(startY + halfN, startX, halfN);
			dfs(startY + halfN, startX + halfN, halfN);
			answer += ")";
			return;
		}

		answer += String.valueOf(initNum);
	}
}
