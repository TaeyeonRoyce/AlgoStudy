package Royce.week21;

//2022.11.14
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/13549

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Boj_13549 {
    private static final int MAX = 2 * 100_000 + 1;
    private static int K;
    private static int[] minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);

        K = Integer.parseInt(NK[1]);
        minTime = new int[MAX];
        Arrays.fill(minTime, MAX);
        dfs(N);

        if (N == K) {
            System.out.println(0);
            return;
        }

        System.out.println(minTime[K]);
    }

    private static void dfs(int startAt) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{startAt, 0});

        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int at = poll[0];
            int time = poll[1];

            if (time >= minTime[K]) {
                continue;
            }

            if (at * 2 <= MAX
                    && time < minTime[at * 2]) {
                minTime[at * 2] = time;
                deque.offer(new int[]{at * 2, time});
            }

            if (at + 1 < MAX
                    && time + 1 < minTime[at + 1]) {
                minTime[at + 1] = time + 1;
                deque.offer(new int[]{at + 1, time + 1});
            }

            if (at > 0
                    && time + 1 < minTime[at - 1]) {
                minTime[at - 1] = time + 1;
                deque.offer(new int[]{at - 1, time + 1});
            }
        }
    }
}
