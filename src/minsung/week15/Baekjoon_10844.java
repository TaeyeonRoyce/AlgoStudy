package minsung.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10844 {
    static Long[][] dp;
    static long cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Long[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1L;
        }

        for (int i = 1; i <= 9; i++) {
            cnt += setDp(n - 1, i);
        }

        System.out.println(cnt % 1000000000);

    }

    public static long setDp(int n, int k) {

        if(n == 0){
            return dp[n][k];
        }

        if (dp[n][k] == null) {
            if (k == 0) {
                dp[n][k] = setDp(n - 1, k + 1);
            } else if (k == 9) {
                dp[n][k] = setDp(n - 1, k - 1);
            } else {
                dp[n][k] = setDp(n - 1, k - 1) + setDp(n - 1, k + 1);
            }
        }
        return dp[n][k] % 1000000000;
    }
}
