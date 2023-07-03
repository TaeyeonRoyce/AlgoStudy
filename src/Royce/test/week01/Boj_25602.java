package Royce.test.week01;

//2023.07.02
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/23757

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_25602 {

    private static int[] cansCount;
    private static int[][] R;
    private static int[][] M;
    private static int K;
    private static int N;

    private static int answer = 0;
    private static int currentFulfillment = 0;

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer NK = new StringTokenizer(br.readLine());
        N = Integer.parseInt(NK.nextToken());
        K = Integer.parseInt(NK.nextToken());

        cansCount = new int[N];
        R = new int[K][N];
        M = new int[K][N];
        final StringTokenizer canSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cansCount[i] = Integer.parseInt(canSt.nextToken());
        }

        for (int i = 0; i < K; i++) {
            final StringTokenizer RSt = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(RSt.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            final StringTokenizer MSt = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(MSt.nextToken());
            }
        }

        dayStart(0, true);
        System.out.println(answer);
    }

    private static void dayStart(final int day, final boolean isR) {
        if (isR) {
            for (int i = 0; i < N; i++) {
                final int fulfillment = R[day][i];
                if (cansCount[i] <= 0) {
                    continue;
                }
                currentFulfillment += fulfillment;
                cansCount[i] -= 1;

                dayStart(day, false);

                cansCount[i] += 1;
                currentFulfillment -= fulfillment;
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            final int fulfillment = M[day][i];
            if (cansCount[i] <= 0) {
                continue;
            }

            currentFulfillment += fulfillment;
            cansCount[i] -= 1;

            if (day == K - 1) {
                if (currentFulfillment > answer) {
                    answer = currentFulfillment;
                }

                cansCount[i] += 1;
                currentFulfillment -= fulfillment;
                continue;
            }
            dayStart(day + 1, true);

            cansCount[i] += 1;
            currentFulfillment -= fulfillment;
        }
    }


}
