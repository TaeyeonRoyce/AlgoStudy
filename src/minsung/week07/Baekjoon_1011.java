package minsung.week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] arr = br.readLine().split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            int distance = y-x;
            int k = getMaxK(distance / 2)[0];
            int sumK = getMaxK(distance / 2)[1];
            int result = 0;

            // 전체 거리가 짝수일 때
            if(distance%2 == 0){
                if((distance/2 - sumK) * 2 > k+1){
                    result = 2 * k + 2;

                }else if(distance/2 - sumK == 0){
                    result = 2 * k;
                } else{
                    result = 2 * k + 1;
                }
                // 전체 거리가 홀수일 때
            }else{
                if((distance/2 - sumK) * 2 + 1 > k+1){
                    // k+1 거리만큼
                    result = 2 * k + 2; // (k+1) 거리만큼 간거랑 (((distance/2 - sumK) * 2) - (k+1)) 거리만큼 간거 두개 더해줌
                }else{
                    result = 2 * k + 1;
                }
            }
            System.out.println(result);
        }
    }

    public static int[] getMaxK(int targetNum){
        // 1부터 k까지의 합이 targetNum보다 작거나 같은 최댓값일 때, {k, 1~k 합} 반환
        int sum = 0;
        int cnt = 0;
        int[] result = new int[2];

        while(true){
            if(sum + cnt+1 > targetNum){
                break;
            }
            sum += cnt+1;
            cnt ++;
        }

        result[0] = cnt;
        result[1] = sum;

        return result;
    }
}