package algorithms.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_13415 {

	private static Integer[] numArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		numArr = new Integer[N];
		String nums = br.readLine();
		StringTokenizer st = new StringTokenizer(nums);

		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		int K = Integer.parseInt(br.readLine());
		int[] ascending = new int[K];
		int[] descending = new int[K];
		for (int i = 0; i < K; i++) {
			StringTokenizer rangeSet = new StringTokenizer(br.readLine());
			ascending[i] = Integer.parseInt(rangeSet.nextToken());
			descending[i] = Integer.parseInt(rangeSet.nextToken());
		}

		for (int i = 0; i < K; i++) {
			if (ascending[i] <= descending[i]) {
				Arrays.sort(numArr, 0, descending[i]);
				continue;
			}

			Arrays.sort(numArr, 0, ascending[i]);
			Arrays.sort(numArr, 0, descending[i], Comparator.reverseOrder());
		}

		for (Integer integer : numArr) {
			System.out.printf("%d ", integer);
		}

	}
}
