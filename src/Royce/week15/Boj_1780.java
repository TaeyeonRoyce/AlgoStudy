package Royce.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1780 {

	private static int[][] board;

	private static Map<Integer, Integer> counts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		counts = new HashMap<>();
		counts.put(-1, 0);
		counts.put(0, 0);
		counts.put(1, 0);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0,0,N, N);

		System.out.println(counts.get(-1));
		System.out.println(counts.get(0));
		System.out.println(counts.get(1));

	}

	private static void dfs(int startY, int startX, int endY, int endX) {
		int standard = board[startY][startX];
		for (int i = startY; i < endY; i++) {
			for (int j = startX; j < endX; j++) {
				if (board[i][j] != standard) {
					int unit = (endY - startY) / 3;
					dfs(startY, startX, startY + unit, startX + unit);
					dfs(startY, startX + unit, startY + unit, startX + unit * 2);
					dfs(startY, startX + unit * 2, startY + unit, startX + unit * 3);

					dfs(startY + unit, startX, startY + unit * 2, startX + unit);
					dfs(startY + unit, startX + unit, startY + unit * 2, startX + unit * 2);
					dfs(startY + unit, startX + unit * 2, startY + unit * 2, startX + unit * 3);


					dfs(startY + unit * 2, startX, startY + unit * 3, startX + unit);
					dfs(startY + unit * 2, startX + unit, startY + unit * 3, startX + unit * 2);
					dfs(startY + unit * 2, startX + unit * 2, startY + unit * 3, startX + unit * 3);
					return;
				}
			}
		}

		counts.put(standard, counts.get(standard) + 1);
	}
}
