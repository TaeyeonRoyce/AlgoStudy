package minsung.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int cnt = 1;

        while (b != a) {
            String bStr = b + "";
            int bLen = bStr.length();

            if (b < a) {
                cnt = -1;
                break;
            }

            if (bStr.charAt(bLen - 1) != '1' && b % 2 != 0) {
                cnt = -1;
                break;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else {
                bStr = bStr.substring(0, bLen - 1);
                b = Long.parseLong(bStr);
            }
            cnt++;
        }

        System.out.println(cnt);

    }
}
