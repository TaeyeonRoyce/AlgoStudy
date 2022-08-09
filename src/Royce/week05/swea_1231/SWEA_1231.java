package Royce.week05.swea_1231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2022.07.20
//Created by TaeyeonRoyce

//Link - https://swexpertacademy.com/main/solvingProblem/solvingProblem.do

public class SWEA_1231 {

	private static String answer = "";
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			solution(br);
			System.out.printf("#%d %s\n", test_case, answer);
		}
	}

	private static void solution(BufferedReader br) throws IOException {
		answer = "";
		int N = Integer.parseInt(br.readLine());
		Node[] nodeArr = new Node[101];

		for (int i = 1; i <= N; i++) {
			String[] nodeInfos = br.readLine().split(" ");
			int index = Integer.parseInt(nodeInfos[0]);
			char letter = nodeInfos[1].charAt(0);

			nodeArr[index] = new Node(letter);
			if (nodeInfos.length > 2) {
				int leftSubIndex = Integer.parseInt(nodeInfos[2]);
				nodeArr[index].leftSubIndex = leftSubIndex;
			}

			if (nodeInfos.length > 3) {
				int rightSubIndex = Integer.parseInt(nodeInfos[3]);
				nodeArr[index].rightSubIndex = rightSubIndex;
			}
		}

		for (int i = 1; i <= nodeArr.length; i++) {
			Node node = nodeArr[i];
			if (node == null) {
				break;
			}

			if (node.leftSubIndex != -1) {
				node.leftSub = nodeArr[node.leftSubIndex];
			}

			if (node.rightSubIndex != -1) {
				node.rightSub = nodeArr[node.rightSubIndex];
			}
		}

		infixExpression(nodeArr[1]);
	}

	private static void infixExpression(Node node) {
		if (node == null) {
			return;
		}

		infixExpression(node.leftSub);
		answer += node.getLetter();
		infixExpression(node.rightSub);
	}


}

class Node {
	char letter;
	Node leftSub = null;
	Node rightSub = null;


	int leftSubIndex = -1;
	int rightSubIndex = -1;

	public Node(char letter) {
		this.letter = letter;
	}

	public char getLetter() {
		return letter;
	}
}
