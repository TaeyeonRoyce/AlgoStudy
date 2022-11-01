package Royce.week19;
//2022.10.27
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1167

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1167 {

	private static List<edge>[] treeNodes;
	private static int maxWeight = 0;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		treeNodes = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			treeNodes[i] = new ArrayList<>();
		}


		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nodeKey = Integer.parseInt(st.nextToken());
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) {
					break;
				}

				int weight = Integer.parseInt(st.nextToken());

				treeNodes[nodeKey].add(new edge(to, weight));
				treeNodes[to].add(new edge(nodeKey, weight));
			}
		}

		int maxDistanceNodeKey = getMaxDistanceNodeKey(1, V);
		getMaxDistanceNodeKey(maxDistanceNodeKey, V);

		System.out.println(maxWeight);
	}

	private static int getMaxDistanceNodeKey(int startNodeKey, int sizeOfTree) {
		maxWeight = 0;
		boolean[] visited = new boolean[sizeOfTree + 1];
		int maxDistanceNodeKey = startNodeKey;

		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(new int[] {startNodeKey, 0});
		visited[startNodeKey] = true;
		while (!deque.isEmpty()) {
			int[] poll = deque.poll();
			int nodeKey = poll[0];
			int weight = poll[1];

			if (weight > maxWeight) {
				maxWeight = weight;
				maxDistanceNodeKey = nodeKey;
			}

			for (edge edge : treeNodes[nodeKey]) {
				if (visited[edge.to]) {
					continue;
				}

				deque.add(new int[] {edge.to, weight + edge.weight});
				visited[edge.to] = true;
			}
		}

		return maxDistanceNodeKey;
	}
}

class edge {
	int to;
	int weight;

	public edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}
