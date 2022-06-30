package algorithms.week02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_FriendsColoringBook {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int m = 6;
		int n = 6;
		int[][] picture = {
			{1, 1, 1, 0, 0, 0},
			{1, 2, 2, 0, 0, 0},
			{1, 0, 0, 1, 1, 1},
			{0, 0, 0, 1, 1, 1},
			{0, 0, 0, 3, 3, 1},
			{0, 0, 0, 3, 1, 1}
		};
		int[] answer = sol.solution(m, n, picture);

		System.out.println(Arrays.toString(answer));
	}
}

class Solution {

	private int[] dx; // 위, 오른, 아래, 위 방향
	private int[] dy; // 위, 오른, 아래, 위 방향
	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		this.dx = new int[]{-1, 0, 1, 0};
		this.dy = new int[]{0, 1, 0, -1};

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int colorNum = picture[i][j];
				if (colorNum == 0) {
					continue;
				}
				int areaSize = searchArea(i, j, picture, colorNum);
				if (maxSizeOfOneArea < areaSize) {
					maxSizeOfOneArea = areaSize;
				}

				numberOfArea++;
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private int searchArea(int startY, int startX, int[][] picture, int colorNum) {
		Queue<Direction> queue = new LinkedList<>();
		int xLimit = picture[0].length;
		int yLimit = picture.length;

		queue.add(new Direction(startX, startY));

		int areaSize = 1;
		picture[startY][startX] = 0;

		while (!queue.isEmpty()) {
			Direction d = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = d.getX() + this.dx[i];
				int dy = d.getY() + this.dy[i];

				if (dx < 0 || dy < 0 || dx >= xLimit || dy >= yLimit) {
					continue;
				}

				if (picture[dy][dx] == colorNum) {
					areaSize++;
					picture[dy][dx] = 0;
					queue.add(new Direction(dx, dy));
				}
			}
		}

		return areaSize;
	}

	class Direction {
		private int x;
		private int y;

		public Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
}