package Royce.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1080 {

	private static int[][] matA;
	private static int[][] matB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NM = br.readLine();
		int N = Integer.parseInt(NM.split(" ")[0]);
		int M = Integer.parseInt(NM.split(" ")[1]);

		matA = new int[N][M];
		matB = new int[N][M];

		//MatA 입력
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				matA[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
			}
		}

		//MatB 입력
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				matB[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
			}
		}
		if (N < 3 || M < 3) {
			if (isSameMatrix(N, M)) {
				System.out.println("0");
			} else {
				System.out.println("-1");
			}
			return;
		}

		int answer = 0;

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (matA[i][j] != matB[i][j]) {
					changeSquareBoard(i, j);
					answer++;
				}
			}
		}

		if (!isSameMatrix(N, M)) {
			answer = -1;
		}

		System.out.println(answer);
	}

	private static boolean isSameMatrix(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matA[i][j] != matB[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void changeSquareBoard(int startY, int startX) {
		for (int i = startY; i < startY + 3; i++) {
			for (int j = startX; j < startX + 3; j++) {
				if (matA[i][j] == 1) {
					matA[i][j] = 0;
				} else {
					matA[i][j] = 1;
				}
			}
		}
	}

}
