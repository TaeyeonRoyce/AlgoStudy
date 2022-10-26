package minsung.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String sentence = br.readLine();
            if(sentence.equals(".")){
                break;
            }

            int len = sentence.length();
            boolean isBalanced = true;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < len; i++) {
                if(sentence.charAt(i) == '('){
                    stack.add(sentence.charAt(i));
                } else if(sentence.charAt(i) == '['){
                    stack.add(sentence.charAt(i));
                } else if( sentence.charAt(i) == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        isBalanced = false;
                        break;
                    }
                } else if(sentence.charAt(i) == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        isBalanced = false;
                        break;
                    }
                }
            }

            if(stack.isEmpty() && isBalanced){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
