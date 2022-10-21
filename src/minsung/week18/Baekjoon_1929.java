package minsung.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = n; i <= m; i++) {
            if(isPrimeNum(i)){
                System.out.println(i);
            }
        }
    }


    public static boolean isPrimeNum(int n){
        if(n == 1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}

