package minsung.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2156 {
    static Integer[] dp;
    static int[] wine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];
        wine = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = wine[1];
        if(n >= 2){
            dp[2] = wine[1] + wine[2];
        }

        System.out.println(setDp(n));

    }

    public static int setDp(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(setDp(n-1), Math.max(setDp(n-3) + wine[n-1], setDp(n-2)) + wine[n]);
        }

        return dp[n];
    }
}