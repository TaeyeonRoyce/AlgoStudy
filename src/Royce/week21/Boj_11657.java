package Royce.week21;

//2022.11.10
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/11657

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11657 {
	private static int N;
	private static int M;
	private static List<Bus>[] buses;
	private static long[] dist;
	private static final int INF = 500 * 6000 * 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		buses = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			buses[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			buses[from].add(new Bus(to, weight));
		}

		dist = new long[N + 1];

		boolean valid = bellmanFord();
		if (!valid) {
			System.out.println(-1);
			return;
		}

		for (int i = 2; i < dist.length; i++) {
			if (dist[i] == INF) {
				System.out.println(-1);
				continue;
			}

			System.out.println(dist[i]);
		}
	}

	private static boolean bellmanFord() {
		Arrays.fill(dist, INF);
		dist[1] = 0;
		boolean update = false;

		for (int i = 1; i < N; i++) {
			update = false;
			for (int j = 1; j <= N; j++) {
				for (Bus bus : buses[j]) {
					if (dist[j] == INF) {
						continue;
					}

					if (dist[bus.to] > dist[j] + bus.weight) {
						dist[bus.to] = dist[j] + bus.weight;
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
			for (int i = 1; i <= N; i++) {
				for (Bus bus : buses[i]) {
					if (dist[bus.to] > dist[i] + bus.weight) {
						return false;
					}
				}
			}
		}

		return true;
	}
}

class Bus {
	int to;
	int weight;

	public Bus(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}
