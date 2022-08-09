package Royce.week07.swea_11446;

//2022.08.04
//Created by TaeyeonRoyce
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXdHxTNqC2IDFAS5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			long answer = solution(br);
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static long solution(BufferedReader br) throws IOException {
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		long M = Long.parseLong(NM[1]);
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] nums = new long[N];

		long max = 0;
		long min = 1;

		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			nums[i] = num;
			if (num > max) {
				max = num;
			}
		}

		long mid = 0;
		long cnt = 0;
		while (min <= max) {
			mid = (min + max) / 2;
			cnt = 0;
			for (long num : nums) {
				cnt += (num / mid);
			}

			if (cnt < M) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		return max;
	}
}
