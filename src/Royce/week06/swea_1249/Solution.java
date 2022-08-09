package Royce.week06.swea_1249;

//2022.07.28
//Created by TaeyeonRoyce
//Link - https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD#none

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	private static int[][] board;
	private static int[][] priceBoard;
	private static boolean[][] visited;
	private static int answer;
	private static int[] xDirection = new int[] {1, 0, -1, 0};
	private static int[] yDirection = new int[] {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			solution(br);
			System.out.printf("#%d %d", test_case, answer);
			System.out.println();
		}
	}

	private static void solution(BufferedReader br) throws IOException {
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		priceBoard = new int[N][N];
		answer = Integer.MAX_VALUE;
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}

		bfs(0, 0, N);
	}

	private static void bfs(int startY, int startX, int N) {
		PriorityQueue<Direction> q = new PriorityQueue<>();

		q.offer(new Direction(0, 0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Direction direction = q.poll();
			int currentX = direction.X;
			int currentY = direction.Y;
			int time = direction.time;

			if (currentX == N - 1 && currentY == N - 1) {
				if (time < answer) {
					answer = time;
				}
			}

			if (answer <= time)
				continue;
			for (int i = 0; i < 4; i++) {
				int dx = currentX + xDirection[i];
				int dy = currentY + yDirection[i];

				if (dx < 0 || dy < 0 || dy >= N || dx >= N) {
					continue;
				}
				int dTime = time + board[dx][dy];
				if (!visited[dy][dx] || dTime < priceBoard[dy][dx]) {
					visited[dy][dx] = true;
					priceBoard[dy][dx] = dTime;

					q.offer(new Direction(dx, dy, dTime));
				}
			}
		}
	}

}

class Direction implements Comparable<Direction> {
	int X;
	int Y;
	int time;

	Direction(int X, int Y, int time) {
		this.X = X;
		this.Y = Y;
		this.time = time;
	}

	@Override
	public int compareTo(Direction p) {
		if (this.time > p.time) {
			return 1;
		} else if (this.time < p.time) {
			return -1;
		}
		return 0;
	}
}