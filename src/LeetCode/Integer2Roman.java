package LeetCode;

/**
 * Created by Kevin.Z on 2018/7/4.
 */
public class Integer2Roman {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(new Integer2Roman().solution(num));
    }

    public String solution(int num) {
        StringBuilder result = new StringBuilder();
        int times = 0;

        times = num / 1000;
        num = num % 1000;
        for (int i = 0; i < times; i++) {
            result.append("M");
        }

        times = num / 100;
        num = num % 100;
        result.append(function1(times,"CM","D","CD","C"));

        times = num / 10;
        num %= 10;
        result.append(function1(times,"XC","L","XL","X"));
        result.append(function1(num,"IX","V","IV","I"));

        return result.toString();
    }

    private String function1(int times, String nine, String five, String four,String one) {
        StringBuilder result = new StringBuilder("");
        if (times == 9) {
            result.append(nine);
        } else if (times >= 5) {
            result.append(five);
            times -= 5;
            for (int i = 0; i < times; i++) {
                result.append(one);
            }
        } else if (times == 4) {
            result.append(four);
        } else {
            for (int i = 0; i < times; i++) {
                result.append(one);
            }
        }

        return result.toString();
    }
}
