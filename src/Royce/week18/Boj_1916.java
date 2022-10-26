package Royce.week18;

//2022.10.23
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1916

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1916 {

	private static final int MAX_DISTANCE = 1000 * 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Bus>[] buses = new ArrayList[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, MAX_DISTANCE);

		for (int i = 1; i < N + 1; i++) {
			buses[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			Bus bus = new Bus(from, to, weight);
			buses[from].add(bus);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());


		PriorityQueue<Bus> priorityQueue = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		priorityQueue.offer(new Bus(start, 0));
		distance[start] = 0;

		while (!priorityQueue.isEmpty()) {
			Bus poll = priorityQueue.poll();
			int currentStop = poll.to;

			if (!visited[currentStop]) {
				visited[currentStop] = true;

				for (Bus busToNext : buses[currentStop]) {
					if (!visited[busToNext.to] // 방문 완료되지 않았고
						&& distance[busToNext.to] > distance[currentStop] + busToNext.weight) { // 이전 거리 + 가중치가 최소 거리인 경우
						distance[busToNext.to] = distance[currentStop] + busToNext.weight;
						priorityQueue.add(new Bus(busToNext.to, distance[busToNext.to]));
					}
				}
			}
		}

		System.out.println(distance[end]);
	}
}

class Bus implements Comparable<Bus> {
	int from;
	int to;
	int weight;

	public Bus(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public Bus(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Bus o) {
		return this.weight - o.weight;
	}
}
