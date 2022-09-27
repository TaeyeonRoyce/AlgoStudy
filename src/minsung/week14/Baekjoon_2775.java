package minsung.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2775 {
    static int testCase;
    static int k;
    static int n;
    static Integer[][] apartment = new Integer[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 15; i++) {
            apartment[0][i] = i;
            apartment[i][0] = 0;
        }

        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            System.out.println(getPeopleNum(k, n));
        }
    }

    public static int getPeopleNum(int k, int n){
        if(apartment[k][n] == null){
            apartment[k][n] = 0;
            for (int i = 1; i <= n; i++) {
                apartment[k][n] += getPeopleNum(k-1, i);
            }
        }
        return apartment[k][n];
    }
}
