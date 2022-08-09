package Royce.week07.swea_7701;

//2022.08.04
//Created by TaeyeonRoyce
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWqU0zh6rssDFARG#none
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.printf("#%d\n", test_case);
			solution(br);
		}
	}

	private static void solution(BufferedReader br) throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<CustomString> heap = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			heap.add(new CustomString(br.readLine()));
		}

		String buffer = "";
		while (!heap.isEmpty()) {
			String buffer1 = heap.poll().data;
			if (buffer.equals(buffer1)) {
				continue;
			}
			System.out.println(buffer1);
			buffer = buffer1;
		}

	}
}

class CustomString implements Comparable<CustomString> {
	String data;
	int dataLength;

	public CustomString(String data) {
		this.data = data;
		this.dataLength = data.length();
	}

	@Override
	public int compareTo(CustomString o) {
		if (o.dataLength == dataLength) {
			return data.compareTo(o.data);
		}

		return dataLength - o.dataLength;
	}
}
