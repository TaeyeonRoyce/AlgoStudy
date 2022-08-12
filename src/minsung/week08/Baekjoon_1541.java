package minsung.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String formula = br.readLine();
        StringTokenizer st = new StringTokenizer(formula, "-");
        int result = getSum(st.nextToken());

        while (st.hasMoreTokens()) {
            result -= getSum(st.nextToken());
        }

        System.out.println(result);
    }

    public static int getSum(String formula) {
        int sum = 0;
        StringTokenizer st2 = new StringTokenizer(formula, "+");
        while (st2.hasMoreTokens()) {
            sum += Integer.parseInt((st2.nextToken()));
        }
        return sum;
    }
}
