package Royce.week19;

//2022.10.26
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/5639

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5639 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node root = new Node(Integer.parseInt(br.readLine()));

		while (true) {
			String info = br.readLine();
			if (info == null || info.isEmpty()) {
				break;
			}
			int key = Integer.parseInt(info);

			root.add(key);
		}

		printPostOrder(root);

	}

	private static void printPostOrder(Node node) {
		if (node == null) {
			return;
		}

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.key);
	}
}

class Node {
	int key;
	Node left = null;
	Node right = null;

	public Node(int key) {
		this.key = key;
	}

	public void add(int key) {
		if (key < this.key) {
			if (this.left == null) {
				this.left = new Node(key);
				return;
			}

			left.add(key);
		} else if (key > this.key) {
			if (this.right == null) {
				this.right = new Node(key);
				return;
			}

			right.add(key);
		}
	}


}
