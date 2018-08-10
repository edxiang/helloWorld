package LeetCode;


/**
 * Created by Kevin.Z on 2018/6/15.
 */
public class StringToInteger {
    public static void main(String[] args) {
        String str = "   -42";
        System.out.println(new StringToInteger().myAtoi(str));
    }

    private int myAtoi(String str) {
        // +:43, -:45, 0-9:48-57
        int index = 1;
        int mark = 1;
        boolean flag = false;
        str = str.trim();
        if (str.equals(""))
            return 0;
        if (str.charAt(0) == 43) {
            mark = 1;
            flag = true;
        } else if (str.charAt(0) == 45) {
            mark = -1;
            flag = true;
        } else if (str.charAt(0) > 57 || str.charAt(0) < 48) {
            return 0;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) <= 57 && str.charAt(i) >= 48)
                index++;
            else
                break;
        }
        if (index == 1 && !flag) {
            return Integer.parseInt(str.charAt(0) + "");
        } else if (index == 1)
            return 0;

        String atoi = str.substring(1, index);
        int q = 0;
        try {
            if (flag) {
                q = Integer.parseInt(atoi) * mark;
            } else {
                q = Integer.parseInt(str.charAt(0) + atoi);
            }
        } catch (Exception e) {
            if (mark == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }

        return q;
    }
}
