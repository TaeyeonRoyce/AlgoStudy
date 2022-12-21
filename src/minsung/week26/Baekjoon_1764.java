package minsung.week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> users = new HashMap<>();

        for (int i = 0; i < n; i++) {
            users.put(br.readLine(), 1);
        }

        for (int i = 0; i < m; i++) {
            String userName = br.readLine();

            if (users.containsKey(userName)) {
                users.put(userName, users.get(userName) + 1);
            } else {
                users.put(userName, 1);
            }
        }

        ArrayList<String> userArrayList = new ArrayList<>();

        for (String user : users.keySet()) {
            if (users.get(user) == 2) {
                userArrayList.add(user);
            }
        }

        System.out.println(userArrayList.size());
        Collections.sort(userArrayList);

        for (String user : userArrayList) {
            System.out.println(user);
        }
    }
}
