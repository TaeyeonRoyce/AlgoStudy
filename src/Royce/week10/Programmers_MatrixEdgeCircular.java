package Royce.week10;

//2022.08.28
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/77485

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Programmers_MatrixEdgeCircular {
	public static void main(String[] args) {
		MatrixEdgeCircularSolution solution = new MatrixEdgeCircularSolution();

		int[] solution1 = solution.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
		System.out.println(Arrays.toString(solution1));
	}
}

class MatrixEdgeCircularSolution {
	private int[][] board;

	public int[] solution(int rows, int columns, int[][] queries) {
		int N = queries.length;
		int[] answer = new int[N];

		board = new int[rows][columns];

		fillBoard(rows, columns);
		for (int i = 0; i < N; i++) {
			int[] query = queries[i];
			int minNumber = rotateMatrixEdge(query);
			answer[i] = minNumber;
		}

		return answer;
	}

	private void fillBoard(int rows, int columns) {
		int number = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = ++number;
			}
		}
	}

	private int rotateMatrixEdge(int[] query) {

		Deque<Integer> deque = collectNumbers(query);
		int minNumber = spreadDeque(deque, query);
		return minNumber;
	}

	private Deque<Integer> collectNumbers(int[] query) {
		Deque<Integer> deque = new ArrayDeque<>();
		int leftTopY = query[0] - 1;
		int leftTopX = query[1] - 1;
		int rightBottomY = query[2] - 1;
		int rightBottomX = query[3] - 1;

		// right way
		for (int i = leftTopX; i <= rightBottomX; i++) {
			deque.add(board[leftTopY][i]);
		}

		// down way
		for (int i = leftTopY + 1; i <= rightBottomY; i++) {
			deque.add(board[i][rightBottomX]);
		}

		// left way
		for (int i = rightBottomX - 1; i >= leftTopX; i--) {
			deque.add(board[rightBottomY][i]);
		}

		// up way
		for (int i = rightBottomY - 1; i > leftTopY; i--) { // 중복 제거
			deque.add(board[i][leftTopX]);
		}

		return deque;
	}

	private int spreadDeque(Deque<Integer> deque, int[] query) {
		int minNumber = Integer.MAX_VALUE;

		deque.addFirst(deque.pollLast()); // ex) 1, 2, 3, 4 ---> 4, 1, 2, 3

		int leftTopY = query[0] - 1;
		int leftTopX = query[1] - 1;
		int rightBottomY = query[2] - 1;
		int rightBottomX = query[3] - 1;

		// right way
		for (int i = leftTopX; i <= rightBottomX; i++) {
			Integer poll = deque.poll();
			if (poll < minNumber) {
				minNumber = poll;
			}
			board[leftTopY][i] = poll;
		}

		// bottom way
		for (int i = leftTopY + 1; i <= rightBottomY; i++) {
			Integer poll = deque.poll();
			if (poll < minNumber) {
				minNumber = poll;
			}
			board[i][rightBottomX] = poll;
		}

		// left way
		for (int i = rightBottomX - 1; i >= leftTopX; i--) {
			Integer poll = deque.poll();
			if (poll < minNumber) {
				minNumber = poll;
			}
			board[rightBottomY][i] = poll;
		}

		// right way
		for (int i = rightBottomY - 1; i > leftTopY; i--) { // 중복 제거
			Integer poll = deque.poll();
			if (poll < minNumber) {
				minNumber = poll;
			}
			board[i][leftTopX] = poll;
		}

		return minNumber;
	}
}