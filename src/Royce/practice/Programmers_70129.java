package Royce.practice;

//2023.06.21
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=java

import java.util.Arrays;

public class Programmers_70129 {

    public static void main(final String[] args) {
        final TestCase testCase = TestCase.SECOND;

        final int[] result = solution(testCase.inputString);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(String inputSting) {
        int count = 0;
        int removedZeroCountSum = 0;
        final int[] result = new int[2];
        while (!inputSting.equals("1")) {
            final int lengthBefore = inputSting.length();
            inputSting = inputSting.replaceAll("0", "");

            final int shrinkLength = inputSting.length();
            removedZeroCountSum += lengthBefore - shrinkLength;
            inputSting = Integer.toBinaryString(shrinkLength);
            count += 1;
        }

        result[0] = count;
        result[1] = removedZeroCountSum;
        return result;
    }

    private enum TestCase {
        FIRST("110010101001"),
        SECOND("01110"),
        THIRD("1111111"),
        ;

        private final String inputString;

        TestCase(final String inputString) {
            this.inputString = inputString;
        }
    }
}
