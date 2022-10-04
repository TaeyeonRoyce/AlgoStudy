package minsung.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1932 {
    static int[][] triangle;
    static int[][] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = triangle[0][0];

        for (int i = 0; i < n; i++) {
            setDp(n-1, i);
            if (dp[n-1][i] > max) {
                max = dp[n-1][i];
            }
        }

        System.out.println(max);
    }

    public static int setDp(int n, int k) {
        if (dp[n][k] == -1) {
            if (k == n) {
                dp[n][k] = setDp(n - 1, k - 1) + triangle[n][k];
            } else if(k == 0){
                dp[n][k] = setDp(n - 1, k) + triangle[n][k];
            } else if (n == 1) {
                dp[n][k] = dp[0][0] + triangle[n][k];
            } else {
                dp[n][k] = Math.max(setDp(n - 1, k - 1), setDp(n - 1, k)) + triangle[n][k];
            }
        }

        return dp[n][k];
    }
}
