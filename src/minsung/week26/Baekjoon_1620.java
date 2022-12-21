package minsung.week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pokemon = Integer.parseInt(st.nextToken());
        int problem = Integer.parseInt(st.nextToken());

        Map<Integer, String> intMap = new HashMap<>();
        Map<String, Integer> strMap = new HashMap<>();

        for (int i = 1; i <= pokemon; i++) {
            String name = br.readLine();
            intMap.put(i, name);
            strMap.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= problem; i++) {
            String tmp = br.readLine();
            if(isNum(tmp)){
                sb.append(intMap.get(Integer.parseInt(tmp)) + "\n");
            } else {
                sb.append(strMap.get(tmp) + "\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
