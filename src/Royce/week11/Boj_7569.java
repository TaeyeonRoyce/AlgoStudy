package Royce.week11;

//2022.08.28
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/7569

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_7569 {

	private static int[] dx = new int[] {0, 1, 0, -1, 0, 0};
	private static int[] dy = new int[] {-1, 0, 1, 0, 0, 0};
	private static int[] dz = new int[] {0, 0, 0, 0, 1, -1};
	private static int[][][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMH = br.readLine().split(" ");
		int N = Integer.parseInt(NMH[0]); // 가로
		int M = Integer.parseInt(NMH[1]); // 세로
		int H = Integer.parseInt(NMH[2]); // 높이

		board = new int[H][M][N];

		int rawTomatoCount = 0;

		Deque<Position> deque = new ArrayDeque<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					int boardInfo = Integer.parseInt(st.nextToken());
					if (boardInfo == 1) {
						deque.add(new Position(i, j, k, 0));
					} else if (boardInfo == 0) {
						rawTomatoCount += 1;
					}

					board[i][j][k] = boardInfo;
				}
			}
		}

		if (rawTomatoCount == 0) {
			System.out.println(0);
			return;
		}

		int maxDay = 0;

		while (!deque.isEmpty()) {
			Position standardPosition = deque.poll();

			for (int i = 0; i < 6; i++) {
				Position currentPosition = new Position(
					standardPosition.z + dz[i],
					standardPosition.y + dy[i],
					standardPosition.x + dx[i],
					standardPosition.day + 1
				);

				if (currentPosition.x < 0 || currentPosition.x >= N
					|| currentPosition.y < 0 || currentPosition.y >= M
					|| currentPosition.z < 0 || currentPosition.z >= H) {
					continue;
				}

				if (getBoardInfoByPosition(currentPosition) == 0) {
					if (currentPosition.day > maxDay) {
						maxDay = currentPosition.day;
					}
					setBoardToRipeTomato(currentPosition);
					rawTomatoCount -= 1;
					deque.add(new Position(
						currentPosition.z,
						currentPosition.y,
						currentPosition.x,
						currentPosition.day
					));

				}
			}
		}

		if (rawTomatoCount != 0) {
			System.out.println(-1);
			return;
		}

		System.out.println(maxDay);
	}

	private static int getBoardInfoByPosition(Position position) {
		return board[position.z][position.y][position.x];
	}
	private static void setBoardToRipeTomato(Position position) {
		board[position.z][position.y][position.x] = 1;
	}

}

class Position {
	int z;
	int y;
	int x;
	int day;

	public Position(int z, int y, int x, int day) {
		this.z = z;
		this.y = y;
		this.x = x;
		this.day = day;
	}
}
