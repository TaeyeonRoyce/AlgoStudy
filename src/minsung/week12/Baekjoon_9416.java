package minsung.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9416 {
    static long[] dp = new long[101];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(find(n));
        }
    }

    public static long find(int n) {
        if (dp[n] == 0) {
            dp[n] = find(n - 5) + find(n - 1);
        }

        return dp[n];
    }
}
