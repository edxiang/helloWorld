package LeetCode;

/**
 * Created by Kevin.Z on 2018/6/15.
 */
public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        int numerator = 2;
        int denominator = 3;
        new FractionToRecurringDecimal().fractionalToDecimal(numerator,denominator);
    }

    private String fractionalToDecimal(int numerator, int denominator){
        String result = numerator * 1.0 / denominator + "";
        String rec = result.split("\\.")[1];
        return null;
    }
}
