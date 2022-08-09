package Royce.week04;

//2022.07.13
//Created by TaeyeonRoyce

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Programmers_KeepDistance {

	private static int STANDARD_SIZE = 5;
	private static int PERSON_CODE = 1;
	private static int DESK_CODE = 0;
	private static int BLOCKED_CODE = 2;
	private static int MINIMUM_DISTANCE = 2;

	public static void main(String[] args) {
		int[] answer = solution(new String[][] {
			{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		});
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[STANDARD_SIZE];
		for (int i = 0; i < STANDARD_SIZE; i++) {
			answer[i] = checkDistance(places[i]);
		}
		return answer;
	}

	private static int checkDistance(String[] singleCase) {
		int[][] singleBoard = new int[STANDARD_SIZE][STANDARD_SIZE];
		for (int i = 0; i < STANDARD_SIZE; i++) {
			for (int j = 0; j < STANDARD_SIZE; j++) {
				char seatInfo = singleCase[i].charAt(j);
				if (seatInfo == 'P') {
					singleBoard[i][j] = PERSON_CODE;
				} else if (seatInfo == 'O') {
					singleBoard[i][j] = DESK_CODE;
				} else {
					singleBoard[i][j] = BLOCKED_CODE;
				}
			}
		}

		for (int i = 0; i < STANDARD_SIZE; i++) {
			for (int j = 0; j < STANDARD_SIZE; j++) {
				if (singleBoard[i][j] == PERSON_CODE) {
					if (!isSafeBoard(i, j, singleBoard)) {
						return 0;
					}
				}
			}
		}

		return 1;
	}

	private static boolean isSafeBoard(int startY, int startX, int[][] singleBoard) {
		int[] dx = new int[] {-1, 0, 1, 0};
		int[] dy = new int[] {0, -1, 0, 1};
		boolean[][] visited = new boolean[STANDARD_SIZE][STANDARD_SIZE];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {startY, startX});
		visited[startY][startX] = true;

		while (!queue.isEmpty()) {
			int[] currentLoc = queue.poll();
			for (int i = 0; i < 4; i++) {
				int currentY = currentLoc[0] + dy[i];
				int currentX = currentLoc[1] + dx[i];

				if ((currentX < 0 || currentY < 0 || currentX >= STANDARD_SIZE || currentY >= STANDARD_SIZE)
					|| (visited[currentY][currentX])
					|| (singleBoard[currentY][currentX] == BLOCKED_CODE)
					|| (Math.abs(startY - currentY) + Math.abs(startX - currentX) > 2)) {
					continue;
				}

				if (singleBoard[currentY][currentX] == PERSON_CODE) {
					return false;
				}

				visited[currentY][currentX] = true;
				queue.add(new int[]{currentY, currentX});
			}
		}

		return true;
	}
}
