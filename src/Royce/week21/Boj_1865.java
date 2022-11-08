package Royce.week21;

//2022.11.09
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1865

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1865 {
	private static int S;
	private static int E;
	private static int T;
	private static int[] dist;
	private static final int INF = 500 * 2500 * 2;

	private static List<Road>[] roads;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String answer = solution(br);
			System.out.println(answer);
		}
	}

	private static String solution(BufferedReader br) throws IOException {
		String[] SET = br.readLine().split(" ");
		S = Integer.parseInt(SET[0]);
		E = Integer.parseInt(SET[1]);
		T = Integer.parseInt(SET[2]);

		dist = new int[S + 1];
		roads = new ArrayList[S + 1];
		for (int i = 1; i < S + 1; i++) {
			roads[i] = new ArrayList<>();
		}

		for (int i = 1; i < E + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			roads[from].add(new Road(from, to, weight));
			roads[to].add(new Road(to, from, weight));
		}

		for (int i = 1; i < T + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			Road road = new Road(from, to, weight * (-1));
			roads[from].add(road);
		}

		if (bellmanFord()) {
			return "YES";
		}

		return "NO";
	}

	private static boolean bellmanFord() {
		Arrays.fill(dist, INF);
		dist[1] = 0;
		boolean update = false;

		for (int i = 1; i < S; i++) {
			update = false;
			for (int j = 1; j <= S; j++) {
				for (Road road : roads[j]) {
					if (dist[road.to] > dist[j] + road.weight) {
						dist[road.to] = dist[j] + road.weight;
						update = true;
					}
				}
			}

			// 업데이트가 일어나지 않으면 종료
			if (!update) {
				break;
			}
		}

		// 음수 사이클 체크
		if (update) {
			for (int i = 1; i <= S; i++) {
				for (Road road : roads[i]) {
					if (dist[road.to] > dist[i] + road.weight) {
						return true;
					}
				}
			}
		}

		return false;
	}
}

class Road {
	int from;
	int to;
	int weight;

	public Road(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

