package Royce.week16;

//2022.10.04
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/16236

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_16236 {
	private static final int SHARK_INFO = 9;
	private static final int EMPTY_INFO = 0;
	private static int N;

	private static Feed[][] board;

	private static int[] dx = new int[] {0, -1, 1, 0};
	private static int[] dy = new int[] {-1, 0, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new Feed[N][N];
		Shark shark = null;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int info = Integer.parseInt(st.nextToken());

				if (info == EMPTY_INFO) {
					board[i][j] = new Feed(i, j, 0, true);
					continue;
				} else if (info == SHARK_INFO) {
					shark = new Shark(i, j, 2);
					board[i][j] = new Feed(i, j, 0, true);
					continue;
				}

				board[i][j] = new Feed(i, j, info, false);
			}
		}

		assert shark != null;
		while (true) {
			int beforeY = shark.y;
			int beforeX = shark.x;

			exploreFeed(shark);
			if (!isSharkMoved(beforeY, beforeX, shark)) {
				break;
			}
		}

		System.out.println(shark.steps);
	}

	private static boolean isSharkMoved(int beforeY, int beforeX, Shark shark) {
		if (beforeX == shark.x && beforeY == shark.y) {
			return false;
		}
		return true;
	}

	private static void exploreFeed(Shark shark) {
		boolean[][] visited = new boolean[N][N];

		PriorityQueue<Direction> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(new Direction(shark.y, shark.x, 0));

		visited[shark.y][shark.x] = true;

		while (!priorityQueue.isEmpty()) {
			Direction poll = priorityQueue.poll();

			if (shark.isEdibleFeed(board[poll.y][poll.x])) {
				shark.eatFeed(board[poll.y][poll.x], poll.distance);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int currentY = poll.y + dy[i];
				int currentX = poll.x + dx[i];
				int distance = poll.distance;

				if (currentX < 0 || currentX > N - 1
					|| currentY < 0 || currentY > N - 1
					|| visited[currentY][currentX]) {
					continue;
				}

				if (board[currentY][currentX].level > shark.level) {
					continue;
				}

				priorityQueue.offer(new Direction(currentY, currentX, distance + 1));
				visited[currentY][currentX] = true;
			}
		}
	}
}

class BoardPiece {
	int y;
	int x;
	int level;

	public BoardPiece(int y, int x, int level) {
		this.y = y;
		this.x = x;
		this.level = level;
	}
}

class Feed extends BoardPiece {

	boolean eaten;

	public Feed(int y, int x, int level, boolean eaten) {
		super(y, x, level);
		this.eaten = eaten;
	}
}

class Shark extends BoardPiece {
	int mealCount;
	int steps;

	public Shark(int y, int x, int level) {
		super(y, x, level);
		this.mealCount = 0;
		this.steps = 0;
	}

	public boolean isEdibleFeed(Feed feed) {
		if (feed.eaten) {
			return false;
		}

		if (feed.level >= this.level) {
			return false;
		}

		return true;
	}

	public void eatFeed(Feed feed, int distance) {
		feed.eaten = true;
		this.x = feed.x;
		this.y = feed.y;
		steps += distance;
		mealCount += 1;

		if (mealCount == level) {
			mealCount = 0;
			level += 1;
		}
	}

}

class Direction implements Comparable<Direction> {
	int y;
	int x;
	int distance;

	public Direction(int y, int x, int distance) {
		this.y = y;
		this.x = x;
		this.distance = distance;
	}

	@Override
	public int compareTo(Direction o) {
		if (distance == o.distance) {
			if (y == o.y) {
				return this.x - o.x;
			}

			return this.y - o.y;
		}

		return this.distance - o.distance;
	}
}
