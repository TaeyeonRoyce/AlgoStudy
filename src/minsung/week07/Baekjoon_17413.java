package minsung.week07;

// 2022.08.04 minsung
// 백준_17413 - 단어 뒤집기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isTag = false;

        for (int i = 0; i < inputString.length(); i++) {
           if(inputString.charAt(i) == '<'){
               while(!stack.isEmpty()){
                   sb.append(stack.pop());
               }
               isTag = true;
           } else if (inputString.charAt(i) == '>') {
               isTag = false;
               sb.append(inputString.charAt(i));
               continue;
           }

            if (isTag) {
                sb.append(inputString.charAt(i));
            }else{
                if (inputString.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                }else{
                    stack.push(inputString.charAt(i));
                }
            }

            if(i == inputString.length() - 1){
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb);
    }

}
