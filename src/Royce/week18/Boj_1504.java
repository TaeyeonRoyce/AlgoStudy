package Royce.week18;

//2022.10.23
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1504

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Boj_1504 {

	private static int N;
	private static int E;
	private static int[] distance;
	private static List<Node>[] nodes;
	private static final int MAX_WEIGHT = 200000 * 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NE = br.readLine().split(" ");
		N = Integer.parseInt(NE[0]);
		E = Integer.parseInt(NE[1]);
		distance = new int[N + 1];

		nodes = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			String[] abc = br.readLine().split(" ");
			int a = Integer.parseInt(abc[0]);
			int b = Integer.parseInt(abc[1]);
			int c = Integer.parseInt(abc[2]);

			Node nodeAtoB = new Node(b, c);
			Node nodeBtoA = new Node(a, c);
			nodes[a].add(nodeAtoB);
			nodes[b].add(nodeBtoA);
		}

		String[] v1v2 = br.readLine().split(" ");
		int v1 = Integer.parseInt(v1v2[0]);
		int v2 = Integer.parseInt(v1v2[1]);

		int resultA = 0;
		resultA += dijkstra(1, v1);
		resultA += dijkstra(v1, v2);
		resultA += dijkstra(v2, N);

		int resultB = 0;
		resultB += dijkstra(1, v2);
		resultB += dijkstra(v2, v1);
		resultB += dijkstra(v1, N);

		if (resultA >= MAX_WEIGHT || resultB >= MAX_WEIGHT) {
			System.out.println(-1);
		} else if (resultA > resultB) {
			System.out.println(resultB);
		} else if (resultA < resultB) {
			System.out.println(resultA);
		}
	}

	private static int dijkstra(int from, int to) {
		Arrays.fill(distance, MAX_WEIGHT);
		boolean[] check = new boolean[N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(from, 0));
		distance[from] = 0;

		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			int curNode = poll.to;

			if (!check[curNode]) {
				check[curNode] = true;

				for (Node toNode : nodes[curNode]) {
					if (!check[toNode.to]
							&& distance[toNode.to] > distance[curNode] + toNode.weight) {
						distance[toNode.to] = distance[curNode] + toNode.weight;
						pq.add(new Node(toNode.to, distance[toNode.to]));
					}
				}
			}
		}

		return distance[to];
	}
}

class Node implements Comparable<Node> {
	int to;
	int weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}