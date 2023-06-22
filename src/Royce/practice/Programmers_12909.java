package Royce.practice;

//2023.06.19
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java

public class Programmers_12909 {

    public static void main(final String[] args) {

        for (final TestCase testCase : TestCase.values()) {
            final boolean result = solution(testCase.string);
            System.out.println(testCase.string + " " + result);
        }
    }

    private static boolean solution(final String s) {
        final char[] chars = s.toCharArray();
        int openBracketSize = 0;
        for (final char singleLetter : chars) {
            if (singleLetter == '(') {
                openBracketSize += 1;
                continue;
            }

            if (openBracketSize == 0) {
                return false;
            }

            openBracketSize -= 1;
        }

        return openBracketSize == 0;
    }

    private enum TestCase {
        FIRST("()()", true),
        SECOND("(())()", true),
        THIRD(")()(", false),
        FOURTH("(()(", false),
        ;

        private final String string;
        private final boolean result;

        TestCase(final String string, final boolean result) {
            this.string = string;
            this.result = result;
        }
    }
}
