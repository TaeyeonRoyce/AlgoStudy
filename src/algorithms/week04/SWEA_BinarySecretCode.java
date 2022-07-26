package algorithms.week04;

import java.util.Scanner;

public class SWEA_BinarySecretCode {

	private static final int[] NUMBER_CODE = new int[] {13, 25, 19, 61, 35, 49, 47, 59, 55, 11};

	private static int[] codeArr;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			boolean answer = solution(N, M, sc);
			if (answer) {
				System.out.println("#" + test_case + " " + getSum());
			} else {

				System.out.println("#" + test_case + " 0");
			}

		}
	}

	private static boolean solution(int N, int M, Scanner sc) {
		String[] board = new String[N];
		codeArr = new int[8];

		for (int i = 0; i < N; i++) {
			String singleLine = sc.next();
			board[i] = singleLine;
		}

		String singleLine = "";
		for (int i = N - 1; i >= 0; i--) {
			singleLine = board[i];
			for (int j = M - 1; j >= 0; j--) {
				if (singleLine.charAt(j) == '1' && isCorrectRows(board, i, j)) {
					return checkCode(board, i, j);
				}
			}
		}

		return false;
	}

	private static boolean isCorrectRows(String[] board, int startY, int startX) {

		String singleLine = board[startY].substring(startX - 56, startX + 1);
		for (int i = 1; i < 5; i++) {
			if (!singleLine.equals(board[startY - i].substring(startX - 56, startX + 1))) {
				return false;
			}
		}

		return true;
	}

	private static boolean checkCode(String[] board, int startY, int startX) {
		String singleNumber = "";

		String singleLine = "";
		for (int i = 7; i >= 0; i--) {
			singleLine = board[startY];
			for (int j = 6; j >= 0; j--) {
				singleNumber += String.valueOf(singleLine.charAt(startX - j));
			}

			codeArr[i] = findRealNumberByString(singleNumber);
			startX -= 7;
			singleNumber = "";
		}

		int sum = 0;
		int sumOfEven = 0;
		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) {
				sumOfEven += codeArr[i];
			} else {
				sum += codeArr[i];
			}
		}
		sum += (sumOfEven * 3);

		return sum % 10 == 0;
	}

	private static int getSum() {
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			sum += codeArr[i];
		}
		return sum;
	}

	private static int findRealNumberByString(String singleNumber) {
		int number = Integer.parseInt(singleNumber,2);
		for (int i = 0; i <= 9; i++) {
			if (number == NUMBER_CODE[i]) {
				return i;
			}
		}

		return -1;
	}
}
