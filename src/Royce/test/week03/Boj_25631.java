package Royce.test.week03;

//2023.07.17
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/25631

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_25631 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        final Deque<Integer> deque = new ArrayDeque<>();

        for (final int number : numbers) {
            if (deque.isEmpty()) {
                deque.offer(number);
                continue;
            }

            if (deque.peekFirst() < number) {
                deque.pollFirst();
            }
            deque.offerLast(number);
        }

        System.out.println(deque.size());
    }
}
