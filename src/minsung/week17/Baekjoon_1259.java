package minsung.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }

            if(isPalindromeNum(n)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

    public static boolean isPalindromeNum(int n){
        String strNum = String.valueOf(n);
        int len = strNum.length();

        for (int i = 0; i < len/2; i++) {
            if(strNum.charAt(i) != strNum.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }
}
