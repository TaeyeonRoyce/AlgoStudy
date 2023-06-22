package Royce.practice;

//2023.06.18
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=java

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Programmers_12939 {

    public static void main(final String[] args) {
        final TestCase testCase = TestCase.SECOND;

        final String result = solution(testCase.string);
        System.out.println(result);
    }

    private static String solution(final String s) {
        final List<Integer> numbers = Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        return numbers.get(0) + " " + numbers.get(numbers.size() - 1);
    }

    private enum TestCase {
        FIRST("1 2 3 4"),
        SECOND("-1 -2 -3 -4"),
        THIRD("-1 -1"),
        ;

        private final String string;

        TestCase(final String string) {
            this.string = string;
        }
    }
}
