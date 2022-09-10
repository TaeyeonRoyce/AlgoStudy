package minsung.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1912 {
    static int n;
    static int[] arr;
    static StringTokenizer st;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        max = arr[0];

        find(n - 1);
        System.out.println(max);
    }

    public static int find(int n) {

        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 1) + arr[n], arr[n]);

            max = Math.max(dp[n], max);
        }

        return dp[n];
    }
}
