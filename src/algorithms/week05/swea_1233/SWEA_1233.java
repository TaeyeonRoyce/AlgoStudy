package algorithms.week05.swea_1233;

//2022.07.21
//Created by TaeyeonRoyce

//Link https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1233 {

	private static boolean flag;
	private static boolean isOperator;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = solution(br);
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static int solution(BufferedReader br) throws IOException {

		int N = Integer.parseInt(br.readLine());
		Node[] nodeArr = new Node[201];

		for (int i = 1; i <= N; i++) {
			String[] nodeInfos = br.readLine().split(" ");
			int index = Integer.parseInt(nodeInfos[0]);
			String letter = nodeInfos[1];

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

		//flag == false 0
		flag = true;

		//처음 출력은 무조건 숫자가 나와야 하므로
		//비교하기 위해선 연산자가 True인걸로 설정
		isOperator = true;

		infixExpression(nodeArr[1]);

		if (flag) {
			return 1;
		}

		return 0;
	}

	private static void infixExpression(Node node) {
		if (node == null || !flag) {
			return;
		}

		infixExpression(node.leftSub);
		String letter = node.getLetter();
		boolean operator = isOperator(letter);

		// 중위 표현 중 이전
		// 숫자-숫자 조합이거나
		// 연산자-연산자 조합인 경우 return
		if (isOperator == operator) {
			flag = false;
			return;
		} else {
			isOperator = isOperator(letter);
		}

		infixExpression(node.rightSub);
	}

	private static boolean isOperator(String letter) {
		if (letter.equals("*")
			|| letter.equals("/")
			|| letter.equals("+")
			|| letter.equals("-")) {
			return true;
		}

		return false;
	}

}


class Node {
	String letter;
	Node leftSub = null;
	Node rightSub = null;

	int leftSubIndex = -1;
	int rightSubIndex = -1;

	public Node(String letter) {
		this.letter = letter;
	}

	public String getLetter() {
		return letter;
	}
}

