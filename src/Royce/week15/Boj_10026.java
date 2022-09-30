package Royce.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_10026 {

	private static Character[][] board;
	private static boolean[][] visited;
	private static Integer[] dx = new Integer[] {0, 1, 0, -1};
	private static Integer[] dy = new Integer[] {-1, 0, 1, 0};
	private static Integer N;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		board = new Character[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		visited = new boolean[N][N];
		int normalArea = getNormalArea(N, true);
		visited = new boolean[N][N];
		int colorBlindnessArea = getNormalArea(N, false);

		System.out.println(normalArea);
		System.out.println(colorBlindnessArea);
	}

	private static int getNormalArea(int N, boolean isNormal) {
		int areaCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					continue;
				}
				bfs(i, j, isNormal);
				areaCount += 1;
			}
		}

		return areaCount;
	}

	private static void bfs(int startY, int startX, boolean isNormal) {
		Character areaLetter = board[startY][startX];
		if (isNormal && areaLetter == 'G') {
			board[startY][startX] = 'R';
		}

		Deque<Integer[]> deque = new ArrayDeque<>();
		deque.offer(new Integer[] {startY, startX});
		visited[startY][startX] = true;

		while (!deque.isEmpty()) {
			Integer[] poll = deque.poll();

			for (int i = 0; i < 4; i++) {
				int moveY = poll[0] + dy[i];
				int moveX = poll[1] + dx[i];

				if (moveX < 0 || moveX > N - 1
					|| moveY < 0 || moveY > N - 1) {
					continue;
				}

				if (visited[moveY][moveX]) {
					continue;
				}

				if (board[moveY][moveX] == areaLetter) {
					visited[moveY][moveX] = true;
					deque.offer(new Integer[] {moveY, moveX});

					if (isNormal && areaLetter == 'G') {
						board[moveY][moveX] = 'R';
					}
				}

			}
		}
	}
}
