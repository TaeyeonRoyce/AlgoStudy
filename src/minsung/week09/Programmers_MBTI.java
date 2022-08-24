package minsung.week09;

import java.util.Arrays;

public class Programmers_MBTI {
    public static void main(String[] args) {
        // 예제 1
        String[] arr1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] arr2 = {5,3,2,7,5};

        // 예제 2
        String[] arr3 = {"TR", "RT", "TR"};
        int[] arr4 = {7,1,3};

        System.out.println(solution(arr3,arr4));
    }

    public static String solution(String[] survey, int[] choices) {
        int len = survey.length;
        int[] ScoreArr = {0, 0, 0, 0};
        String[] arr = {"RT", "CF", "JM", "AN"};
        for (int i = 0; i < len; i++) {
            int[] tmp = getScore(survey[i], choices[i]);
            int idx = tmp[0];
            int score = tmp[1];

            ScoreArr[idx] += score;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (ScoreArr[i] > 0) {
                sb.append(arr[i].charAt(0));
            } else if (ScoreArr[i] < 0) {
                sb.append(arr[i].charAt(1));
            } else {
                if(arr[i].charAt(0) < arr[i].charAt(1)){
                    sb.append(arr[i].charAt(0));
                }else{
                    sb.append(arr[i].charAt(1));
                }
            }
        }

        return sb.toString();

    }

    public static int[] getScore(String str, int choice) {
        int[] returnArr = new int[2];

        String[] arr = {"RT", "TR", "CF", "FC", "JM", "MJ", "AN", "NA"};
        int[] score = {3, 2, 1, 0, 1, 2, 3};

        int idx = Arrays.asList(arr).indexOf(str);

        if (idx % 2 == 0) {
            if(choice <= 3){
                returnArr[1] = score[choice - 1];
            }else if(choice >= 5){
                returnArr[1] = score[choice - 1] * -1;
            }
        } else {
            if(choice <= 3){
                returnArr[1] = score[choice - 1] * -1;
            }else if(choice >= 5){
                returnArr[1] = score[choice - 1];
            }
        }
        returnArr[0] = idx / 2;

        return returnArr;
    }
}
