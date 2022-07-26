package algorithms.week05.swea_1248;

//2022.07.21
//Created by TaeyeonRoyce
//Link - https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1248 {

	private static Stack<Node> childAParents;
	private static Stack<Node> childBParents;
	private static int sizeOfSubTree;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = solution(br);
			System.out.printf("#%d %d %d\n", test_case, answer, sizeOfSubTree);
		}
	}

	private static int solution(BufferedReader br) throws IOException {

		String[] infos = br.readLine().split(" ");
		int V = Integer.parseInt(infos[0]);
		int E = Integer.parseInt(infos[1]);
		int childA = Integer.parseInt(infos[2]);
		int childB = Integer.parseInt(infos[3]);
		Node[] nodeArr = new Node[V + 1];
		childAParents = new Stack<>();
		childBParents = new Stack<>();
		sizeOfSubTree = 0;

		for (int i = 1; i <= V; i++) {
			nodeArr[i] = new Node(i);
		}

		String EInfo = br.readLine();
		StringTokenizer st = new StringTokenizer(EInfo);

		for (int i = 0; i < E; i++) {
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			nodeArr[from].setSubNode(nodeArr[to]);
		}

		findAParent(nodeArr[childA]);
		findBParent(nodeArr[childB]);

		Node coParent = findCoParent();
		prefixExpression(coParent);

		return coParent.data;
	}
	private static void prefixExpression(Node node) {
		if (node == null) {
			return;
		}
		sizeOfSubTree++;
		prefixExpression(node.leftSub);
		prefixExpression(node.rightSub);
	}

	private static void findAParent(Node node) {
		while (node.parent != null) {
			childAParents.add(node.parent);
			node = node.parent;
		}
	}

	private static void findBParent(Node node) {
		while (node.parent != null) {
			childBParents.add(node.parent);
			node = node.parent;
		}
	}

	private static Node findCoParent() {
		while (true) {
			Node AParent = childAParents.pop();
			Node BParent = childBParents.pop();

			if (childAParents.isEmpty()) {
				return AParent;
			} else if (childBParents.isEmpty()) {
				return BParent;
			}

			if (childAParents.peek() != childBParents.peek()) {
				return AParent;
			}
		}
	}
}

class Node {
	int data;
	Node leftSub = null;
	Node rightSub = null;
	Node parent = null;

	public Node(int data) {
		this.data = data;
	}

	public void setSubNode(Node node) {
		node.parent = this;
		if (leftSub == null) {
			leftSub = node;
		} else {
			rightSub = node;
		}
	}
}

