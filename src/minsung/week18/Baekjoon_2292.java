package minsung.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int cnt = 1;
        int num = 2;

        if(n == 1){
            result = 1;
        }else{
            while(num <= n){
                num = num + (6 * cnt);
                cnt++;
            }
            result = cnt;
        }

        System.out.println(result);
    }
}
