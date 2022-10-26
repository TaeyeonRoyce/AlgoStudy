package minsung.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 1000000; i++) {
            if(getSum(i) == n){
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    public static int getSum(int k){
        String strNum = String.valueOf(k);
        int len = strNum.length();
        int sum = k;

        for (int i = 0; i < len; i++) {
            sum += strNum.charAt(i) - 48;
        }
        return sum;
    }
}
