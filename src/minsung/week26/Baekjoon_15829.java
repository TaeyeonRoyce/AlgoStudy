package minsung.week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long result = 0;
        long pow = 1;

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for (int i = 0; i < l; i++) {
            result += (str.charAt(i) - 96) * pow;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(result % 1234567891);
    }
}
