package minsung.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon_1181 {

    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2){
                if(str1.length() == str2.length()){
                    return str1.compareTo(str2);
                } else{
                    return str1.length() - str2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        sb.append(words[0]).append('\n');

        for (int i = 1; i < n; i++) {
            if(!words[i].equals(words[i-1])){
                sb.append(words[i]).append('\n');
            }
        }

        System.out.println(sb);
    }

}
