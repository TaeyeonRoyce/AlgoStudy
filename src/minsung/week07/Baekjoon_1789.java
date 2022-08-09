package minsung.week07;

// 2022.08.05 minsung
// 백준_1789 - 수들의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(getMaxK(n));
    }

    public static int getMaxK(long targetNum){
        long sum = 0;
        int cnt = 0;

        while(true){
            if(sum + cnt+1 > targetNum){
                break;
            }
            sum += cnt+1;
            cnt ++;
        }

        return cnt;
    }
}
