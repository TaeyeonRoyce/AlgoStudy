package Royce.week02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_13415 {
	private static Integer[] numArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		numArr = new Integer[N];
		int[] answer = new int[N];
		String nums = br.readLine();
		StringTokenizer st = new StringTokenizer(nums);

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			numArr[i] = num;
			answer[i] = num;
		}

		int K = Integer.parseInt(br.readLine());
		Deque<SortInfo> sortDeque = new ArrayDeque<>();

		for (int i = 0; i < K; i++) {
			StringTokenizer rangeSet = new StringTokenizer(br.readLine());
			int ascendingEndRange = Integer.parseInt(rangeSet.nextToken());
			int descendingEndRange = Integer.parseInt(rangeSet.nextToken());

			while (!sortDeque.isEmpty() &&
				sortDeque.getLast().endRange < ascendingEndRange) {
				sortDeque.removeLast();
			}
			sortDeque.add(new SortInfo(ascendingEndRange, true));

			while (!sortDeque.isEmpty() &&
				sortDeque.getLast().endRange < descendingEndRange) {
				sortDeque.removeLast();
			}
			sortDeque.add(new SortInfo(descendingEndRange, false));
		}

		SortInfo initSortInfo = sortDeque.removeFirst();
		int endPoint = initSortInfo.endRange;
		boolean isAscending = initSortInfo.isAscending;

		int ascendingIndex = endPoint - 1;
		int descendingIndex = 0;

		Arrays.sort(numArr, 0, endPoint);

		sortDeque.add(new SortInfo(0, true));
		while (!sortDeque.isEmpty()) {
			SortInfo nextSortInfo = sortDeque.removeFirst();
			int startRange = nextSortInfo.endRange;

			if (isAscending) {
				for (int i = endPoint; i > startRange; i--) {
					answer[i - 1] = numArr[ascendingIndex];
					ascendingIndex--;
				}
			} else {
				for (int i = endPoint; i > startRange; i--) {
					answer[i - 1] = numArr[descendingIndex];
					descendingIndex++;
				}
			}

			isAscending = nextSortInfo.isAscending;
			endPoint = nextSortInfo.endRange;
		}

		for (Integer num : answer) {
			bw.write(num + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	private static class SortInfo {
		int endRange;
		boolean isAscending;

		public SortInfo(int endRange, boolean isAscending) {
			this.endRange = endRange;
			this.isAscending = isAscending;
		}
	}
}
