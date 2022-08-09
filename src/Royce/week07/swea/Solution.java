package Royce.week07.swea;

//2022.08.04
//Created by TaeyeonRoyce
//https://swexpertacademy.com/main/learn/course/lectureProblemViewer.do

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int[] wears;
	private static int[] dataSizes;
	private static final int WEAR_LEVEL_MAX = 200000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = solution(br);
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static int solution(BufferedReader br) throws IOException {
		String[] infos = br.readLine().split(" ");
		int N = Integer.parseInt(infos[0]);
		int K = Integer.parseInt(infos[1]);

		wears = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			wears[i] = Integer.parseInt(st.nextToken());
		}

		dataSizes = new int[K];
		StringTokenizer dataSt = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			dataSizes[i] = Integer.parseInt(dataSt.nextToken());
		}

		int min = 1;
		int max = WEAR_LEVEL_MAX;

		int answer = 0;

		while (min < max) {
			int mid = (max + min) / 2;

			if (isPossibleWearLevel(mid)) {
				max = mid;
				answer = mid;
			} else {
				min = mid + 1;
			}
		}

		return answer;
	}

	private static boolean isPossibleWearLevel(int wearLevel) {
		int dataIndex = 0;
		int dataSize = dataSizes[dataIndex];
		int cnt = 0;

		for (int wear : wears) {
			if (wear <= wearLevel) {
				cnt += 1;
			} else {
				cnt = 0;
			}

			if (cnt == dataSize) {
				dataIndex += 1;
				if (dataIndex >= dataSizes.length) {
					return true;
				}
				dataSize = dataSizes[dataIndex];
				cnt = 0;
			}


		}

		return false;
	}
}
