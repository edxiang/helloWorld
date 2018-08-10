package LeetCode;


/**
 * Created by Kevin.Z on 2018/7/4.
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "     the sky is   blue         ";
        System.out.println(new ReverseWordsInAString().solution(s));
    }

    public String solution(String s){
        s = s.trim();
        String ss[] = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = ss.length - 1; i >= 0; i--) {
            if(!ss[i].equals(""))
                sb.append(ss[i] + " ");
        }
        return sb.toString().trim();
    }
}
