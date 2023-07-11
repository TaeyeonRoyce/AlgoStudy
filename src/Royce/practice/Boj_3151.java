package Royce.practice;

//2023.07.06
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/3151

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
10
2 -5 2 3 -4 7 -4 0 1 -6
 */
public class Boj_3151 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores);

        System.out.println(Arrays.toString(scores));
    }
}
