package algorithms.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2022.07.13
//Created by TaeyeonRoyce

public class Boj_11663 {
	private static int[] dotNums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		dotNums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dotNums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(dotNums);
		int startPoint, endPoint;
		int answer;

		for (int i = 0; i < M; i++) {
			String startEnd = br.readLine();
			startPoint = Integer.parseInt(startEnd.split(" ")[0]);
			endPoint = Integer.parseInt(startEnd.split(" ")[1]);

			answer = findIndexByNumber(startPoint, endPoint);
			System.out.println(answer);
		}
	}

	private static int findIndexByNumber(int startPoint, int endPoint) {
		int leftIndex = 0;
		int rightIndex = dotNums.length - 1;

		int midIndex;

		while (leftIndex <= rightIndex) {
			midIndex = (leftIndex + rightIndex) / 2;

			if (dotNums[midIndex] > endPoint) {
				rightIndex = midIndex - 1;
			} else {
				leftIndex = midIndex + 1;
			}
		}

		int endIndex = rightIndex + 1;

		leftIndex = 0;
		rightIndex = dotNums.length - 1;

		while (leftIndex <= rightIndex) {
			midIndex = (leftIndex + rightIndex) / 2;
			if (dotNums[midIndex] < startPoint) {
				leftIndex = midIndex + 1;
			}
			else {
				rightIndex = midIndex - 1;
			}
		}

		int startIndex = leftIndex;

		return endIndex - startIndex;
	}
}
