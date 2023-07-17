package Royce.test.week02;

//2023.07.08
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/2493

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_2493 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        final Deque<Top> topStack = new ArrayDeque<>();

        final int[] answer = new int[N];
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int initHeight = Integer.parseInt(st.nextToken());
        topStack.push(new Top(initHeight, 1));

        for (int i = 1; i < N; i++) {
            final int height = Integer.parseInt(st.nextToken());
            final Top newTop = new Top(height, i + 1);
            while (!topStack.isEmpty()) {
                final Top lastTop = topStack.peek();

                if (lastTop.height >= height) {
                    answer[i] = lastTop.index;
                    break;
                }

                topStack.pop();
            }

            topStack.push(newTop);
        }

        for (final int i : answer) {
            System.out.print(i + " ");
        }
    }

    private static class Top {
        private final int height;
        private final int index;

        public Top(final int height, final int index) {
            this.height = height;
            this.index = index;
        }
    }
}
