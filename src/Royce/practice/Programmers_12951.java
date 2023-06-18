package Royce.practice;

//2023.06.17
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/12951?language=java

public class Programmers_12951 {

    public static void main(final String[] args) {
        final TestCase testCase = TestCase.FIRST;

        final String result = solution(testCase.string);
        System.out.println(result);
    }

    private static String solution(final String s) {

        final String[] splitString = s.split(" ", -1);
        if (splitString.length == 0) {
            return s;
        }

        final StringBuilder answer = new StringBuilder();

        for (final String s1 : splitString) {
            if (s1.isEmpty()) {
                answer.append(" ");
                continue;
            }
            final char[] chars = s1.toLowerCase().toCharArray();
            final int firstChar = chars[0];
            if (firstChar >= 97 && firstChar <= 122) {
                chars[0] = (char) (firstChar - 32);
            }

            answer.append(new String(chars))
                    .append(" ");
        }

        final String answerString = answer.toString();
        return answerString.substring(0, answerString.length() - 1);
    }

    private enum TestCase {
        FIRST("3people    unFollowed me "),
        SECOND("for    the last week"),
        THIRD("     "),
        ;

        private final String string;

        TestCase(final String string) {
            this.string = string;
        }
    }
}
