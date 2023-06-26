package Royce.practice;

//2023.06.23
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/10814

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj_10814 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        final List<Member> members = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int age = Integer.parseInt(st.nextToken());
            final String name = st.nextToken();
            members.add(new Member(age, name));
        }

        final List<Member> sortedMembers = members.stream()
                .sorted(Comparator.comparingInt(o -> o.age))
                .collect(Collectors.toList());
        for (final Member member : sortedMembers) {
            System.out.println(member.age + " " + member.name);
        }
    }

    private static class Member {
        private final int age;
        private final String name;

        public Member(final int age, final String name) {
            this.age = age;
            this.name = name;
        }
    }
}

