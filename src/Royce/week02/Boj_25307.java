package Royce.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_25307 {
	private static int[][] board;

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	private static int N;
	private static int M;
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NMK = br.readLine();
		StringTokenizer st = new StringTokenizer(NMK);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		int startY = 0;
		int startX = 0;

		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer nums = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(nums.nextToken());
				if (num == 4) {
					startY = i;
					startX = j;
				}
				board[i][j] = num;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 3) {
					fillUnreachable(i, j, board);
				}
			}
		}

		int answer = moveOn(startY, startX, board);

		System.out.println(answer * (-1));

	}

	public static void fillUnreachable(int y, int x, int[][] board) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[]{y, x});

		board[y][x] = 1;

		while (!queue.isEmpty()) {
			int[] searchPoint = queue.poll();
			int startX = searchPoint[1];
			int startY = searchPoint[0];

			for (int i = 0; i < 4; i++) {
				int currentX = startX + dx[i];
				int currentY = startY + dy[i];

				if (currentX < 0 || currentY < 0 || currentX >= M || currentY >= N) {
					continue;
				}

				if (board[currentY][currentX] == 4 || board[currentY][currentX] == 1) {
					continue;
				}

				if (Math.abs(y - currentY) + Math.abs(x - currentX) > K) {
					continue;
				}

				board[currentY][currentX] = 1;
				queue.add(new int[]{currentY, currentX});
			}
		}
	}

	public static int moveOn(int y, int x, int[][] board) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{y, x, 0});

		board[y][x] = -1;

		while (!queue.isEmpty()) {
			int[] movePoint = queue.poll();
			int startX = movePoint[1];
			int startY = movePoint[0];
			int distanceFromStart = movePoint[2] - 1;

			for (int i = 0; i < 4; i++) {
				int currentX = startX + dx[i];
				int currentY = startY + dy[i];

				if (currentX < 0 || currentY < 0 || currentX >= M || currentY >= N) {
					continue;
				}

				if (board[currentY][currentX] == 2) {
					return distanceFromStart;
				}

				if (board[currentY][currentX] == 0) {
					board[currentY][currentX] = distanceFromStart;
					queue.add(new int[]{currentY, currentX, distanceFromStart});
					continue;
				}
			}
		}

		return 1;
	}
}
