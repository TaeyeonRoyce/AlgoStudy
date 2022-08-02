package algorithms.week06.swea_3000;

//2022.07.28
//Created by TaeyeonRoyce
//Link - https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-fO0s6ARoDFAXT


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

	private static final int DIVIDER = 20171109;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = solution(br);
			System.out.printf("#%d %d\n", test_case, ans);
		}
	}

	private static int solution(BufferedReader br) throws IOException {
		int answer = 0;
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int mid = Integer.parseInt(info[1]);

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int a = 0;
		int b = 0;
		for (int i = 0; i < N; i++) {
			String[] ab = br.readLine().split(" ");
			a = Integer.parseInt(ab[0]);
			b = Integer.parseInt(ab[1]);
			if (a > mid) {
				minHeap.add(a);
			} else {
				maxHeap.add(a);
			}

			if (b > mid) {
				minHeap.add(b);
			} else {
				maxHeap.add(b);
			}

			while (maxHeap.size() > minHeap.size()) {
				minHeap.add(mid);
				mid = maxHeap.poll();
			}
			while (minHeap.size() > maxHeap.size()) {
				maxHeap.add(mid);
				mid = minHeap.poll();
			}

			answer = (answer + mid) % DIVIDER;
		}
		return answer;
	}

}
