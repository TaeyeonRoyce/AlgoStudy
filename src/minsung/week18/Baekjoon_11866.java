package minsung.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] result = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        while(!dq.isEmpty()){
            for (int i = 0; i < k - 1; i++) {
                dq.add(dq.pop());
            }
            sb.append(dq.pop() + ", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        System.out.println("<" + sb + ">");
    }
}
