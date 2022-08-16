package minsung.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String str[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for(int i=0; i<str.length; i++){
            if(word.contains(str[i])){
                word = word.replace(str[i],"0");
            }
        }

        System.out.println(word.length());
    }
}
