package minsung.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1003 {
    // dp[n] : n번째 피보나치 수를 구하기 위해 호출되는 fibo() 함수의 수
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            int n = Integer.parseInt(br.readLine());

            getFunctionCnt(n);
            sb.append(dp[n][0] + " " + dp[n][1] + "\n");
        }
        System.out.println(sb);
    }

    public static Integer[] getFunctionCnt(int n) {

        if(dp[n][0] == null || dp[n][1] == null){
            dp[n][0] = getFunctionCnt(n-1)[0] + getFunctionCnt(n-2)[0];
            dp[n][1] = getFunctionCnt(n-1)[1] + getFunctionCnt(n-2)[1];
        }

        return dp[n];
    }
}
