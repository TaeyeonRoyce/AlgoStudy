package Royce.practice;

//2023.06.29
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/12911?language=java

public class Programmers_12911 {

    public static void main(final String[] args) {
        for (final TestCase testCase : TestCase.values()) {
            final int result = solution(testCase.number);
            System.out.println(result);
        }
    }

    private static int solution(int number) {
        final int amountOfOne = countNumberOfOne(number);
        while (true) {
            number += 1;
            if (countNumberOfOne(number) == amountOfOne) {
                return number;
            }
        }
    }

    private static int countNumberOfOne(final int number) {
        final char[] binaryString = Integer.toBinaryString(number).toCharArray();
        int count = 0;
        for (final char c : binaryString) {
            if (c == '1') {
                count += 1;
            }
        }

        return count;
    }

    private enum TestCase {
        FIRST(78),
        SECOND(15);

        private final int number;

        TestCase(final int number) {
            this.number = number;
        }
    }
}
