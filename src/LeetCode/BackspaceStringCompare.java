package LeetCode;

import java.util.Stack;

/**
 * Created by Kevin.Z on 2018/6/7.
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        System.out.println();
    }

    private boolean backspaceCompare(String s, String t){
        int indexS;
        while(true){
            if((indexS = s.indexOf("#")) != -1){
                String tempS = "";
                if(indexS > 1) {
                    tempS += s.substring(0, indexS - 1);
                }
                s = tempS + s.substring(indexS + 1, s.length());
            } else {
                break;
            }
        }

        int indexT;
        while(true){
            if((indexT = t.indexOf("#")) != -1){
                String tempT = "";
                if(indexT > 1){
                    tempT += t.substring(0,indexT - 1);
                } else if(indexT == 1){
                    tempT = "";
                }
                t = tempT + t.substring(indexT + 1, t.length());
            } else {
                break;
            }
        }
        System.out.println(s);
        System.out.println(t);
        return s.equals(t);
    }

    private Stack<Character> stack(String s){
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c != '#'){
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        Stack<Character> c = new Stack<>();
        stack.equals(c);
        return stack;
    }
}
