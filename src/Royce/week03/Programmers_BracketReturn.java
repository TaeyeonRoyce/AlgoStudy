package Royce.week03;

import java.util.Arrays;
import java.util.Stack;

public class Programmers_BracketReturn {
	public static void main(String[] args) {
		String TEST_STRING = ")()(()";
		String answer = solution(TEST_STRING);
		System.out.println(answer);
	}

	private static String solution(String v) {
		String u;
		if (v.equals("")) {
			return "";
		}

		char[] vArr = v.toCharArray();
		int leftWrapperCnt = 0;
		int rightWrapperCnt = 0;

		int cursor = 0;

		while (cursor < vArr.length) {
			if (leftWrapperCnt != 0 && leftWrapperCnt == rightWrapperCnt) {
				break;
			}

			if (vArr[cursor] == '(') {
				leftWrapperCnt++;
			} else if (vArr[cursor] == ')') {
				rightWrapperCnt++;
			}
			cursor++;
		}

		if (cursor == vArr.length) {
			u = v;
			v = "";
		} else {
			u = v.substring(0, cursor);
			v = v.substring(cursor, vArr.length);
		}

		if (isPerfectBracket(u)) {
			return u + solution(v);
		} else {
			return  "(" + ")" + solution(v) + handleLackBracket(u);
		}

	}

	private static boolean isPerfectBracket(String u) {
		char[] uArr = u.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < uArr.length; i++) {
			char bracket = uArr[i];
			if (bracket == ')') {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == ')') {
					return false;
				} else {
					stack.pop();
					continue;
				}
			} else {
				stack.add(bracket);
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private static String handleLackBracket(String u) {
		char[] cloneU = Arrays.copyOfRange(u.toCharArray(), 1, u.length() - 1);
		for (int i = 0; i < cloneU.length; i++) {
			if (cloneU[i] == ')') {
				cloneU[i] = '(';
			} else {
				cloneU[i] = ')';
			}
		}

		return String.valueOf(cloneU);
	}
}
