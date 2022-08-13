package minsung.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();

        String word = br.readLine();
        String boom = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            st.push(word.charAt(i));

            if (st.size() >= boom.length()) {
                boolean isBoom = true;

                for (int j = 0; j < boom.length(); j++) {
                    if (st.get(st.size() - boom.length() + j) != boom.charAt(j)) {
                        isBoom = false;
                        break;
                    }
                }
                if (isBoom) {
                    for (int j = 0; j < boom.length(); j++) {
                        st.pop();
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (Character data : st) {
            sb.append(data);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
