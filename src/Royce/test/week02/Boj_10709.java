package Royce.test.week02;

//2023.07.08
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/10709

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10709 {
    /*
6 8
.c......
........
.ccc..c.
....c...
..c.cc..
....c...

     */
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer HW = new StringTokenizer(br.readLine());
        final int H = Integer.parseInt(HW.nextToken());
        final int W = Integer.parseInt(HW.nextToken());

        final boolean[][] cloudBoard = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            final String[] split = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                if (split[j].equals("c")) {
                    cloudBoard[i][j] = true;
                }
            }
        }

        final int answer[][] = new int[H][W];

        for (int i = 0; i < H; i++) {
            int times = -1;
            boolean flag = false;
            for (int j = 0; j < W; j++) {
                if (cloudBoard[i][j]) {
                    flag = true;
                    times = -1;
                }

                if (flag) {
                    times += 1;
                }

                answer[i][j] = times;
            }
        }
        for (final int[] ints : answer) {
            for (final int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
